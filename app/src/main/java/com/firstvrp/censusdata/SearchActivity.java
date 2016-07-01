package com.firstvrp.censusdata;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.firstvrp.censusdata.Adapter.ExCheckedAdapter;
import com.firstvrp.censusdata.Adapter.SearchListAdapter;
import com.firstvrp.censusdata.Entity.BigPlaceInfoEntity;
import com.firstvrp.censusdata.Entity.ChailPlaceInfoEntity;
import com.firstvrp.censusdata.Entity.PlaceInfoEntity;
import com.firstvrp.censusdata.Entity.UnitsInfoEntity;
import com.firstvrp.censusdata.Http.TwitterRestClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Utils.PromptManager;


public class SearchActivity extends Activity implements View.OnClickListener {
    private static final int SUCCESS = 0X11;
    private static final int FAILURE = 0X12;
    private static final int NULL = 0X13;
    private static final int GETCHILDDATA = 0X14;

    private static final int BIGSUCCESS = 0X15;
    static final int BIN = 2;
    static final int YI = 1;
    MyApplication application;
    ExpandableListView search_exlist;
    private TextView search_nothing_text, search_ok;
    List<UnitsInfoEntity> groupData;
    List<List<ChailPlaceInfoEntity>> childData;
    String urlChild;
    String urlGroup;
    EditText search_edit;

    ListView lv_search;

    Spinner search_spinner;
    Map<String, String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init();
        search_exlist = (ExpandableListView) findViewById(R.id.search_exlist);
        lv_search = (ListView) findViewById(R.id.lv_search);

        search_nothing_text = (TextView) findViewById(R.id.search_nothing_text);
        application = (MyApplication) getApplication();
        search_spinner = (Spinner) findViewById(R.id.search_spinner);
        search_ok = (TextView) findViewById(R.id.search_ok);
        search_edit = (EditText) findViewById(R.id.search_edit);
        search_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (search_spinner.getSelectedItemPosition() == 1) {
//                    urlGroup = String.format(getString(R.string.url_get_unitsinfo), 1, 1000, search_edit.getText().toString(), "", map.get("userID"), 0);
//                    String urlGroup1 = String.format(getString(R.string.url_get_unitsinfo), 1, 1000, search_edit.getText().toString(), "", map.get("userID"), 1);
//                    getCheckedUnitsInfoList(urlGroup, urlGroup1);
//                }
                if (search_spinner.getSelectedItemPosition() == 1) {
                    urlGroup = String.format(getString(R.string.url_get_unitsinfo), 1, 1000, "", search_edit.getText().toString(), map.get("userID"), 0);
                    String urlGroup1 = String.format(getString(R.string.url_get_unitsinfo), 1, 1000, "", search_edit.getText().toString(), map.get("userID"), 1);
                    getCheckedUnitsInfoList(urlGroup, urlGroup1);
                }
                if (search_spinner.getSelectedItemPosition() == 0) {
                    urlChild = String.format(getString(R.string.url_get_placeinfo), 1, 1000, "", "", search_edit.getText().toString(), 0, map.get("userID"));
                    String urlGroup1 = String.format(getString(R.string.url_get_placeinfo), 1, 1000, "", "", search_edit.getText().toString(), 1, map.get("userID"));
                    getChildData(urlChild, urlGroup1);
                }

            }
        });

    }


    private void init() {
        GetUserInfo getUserInfo = new GetUserInfo(this);
        map = getUserInfo.getUserSp();
    }

    List<UnitsInfoEntity> unitsInfoEntities;

    private void getCheckedUnitsInfoList(final String urlGroup, final String urlGroup1) {
        TwitterRestClient.get(urlGroup, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                final List<UnitsInfoEntity> unitsInfoEntities1 = gson.fromJson(new String(responseBody), new TypeToken<List<UnitsInfoEntity>>() {
                }.getType());

                TwitterRestClient.get(urlGroup1, null, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        Gson gson = new Gson();
                        unitsInfoEntities = gson.fromJson(new String(responseBody), new TypeToken<List<UnitsInfoEntity>>() {
                        }.getType());

                        if (unitsInfoEntities1 != null) {
                            for (UnitsInfoEntity u : unitsInfoEntities1) {
                                unitsInfoEntities.add(u);
                            }
                            if (unitsInfoEntities != null) {
                                handler.sendEmptyMessage(GETCHILDDATA);
                                Log.v("onSuccess", unitsInfoEntities.toString());
                            } else {
                                search_nothing_text.setVisibility(View.VISIBLE);
                            }
                        } else {
                            if (unitsInfoEntities != null) {
                                handler.sendEmptyMessage(GETCHILDDATA);
                                Log.v("onSuccess", unitsInfoEntities.toString());
                            } else {
                                search_nothing_text.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Log.v("onFailure", new String(responseBody));
                    }
                });

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.v("onFailure", new String(responseBody));
            }
        });
    }

    private void toData() {
        if (search_spinner.getSelectedItemPosition() != 0) {
            search_exlist.setVisibility(View.VISIBLE);
            lv_search.setVisibility(View.GONE);
            groupData = new ArrayList<UnitsInfoEntity>();
            childData = new ArrayList<List<ChailPlaceInfoEntity>>();


            for (int i = 0; i < unitsInfoEntities.size(); i++) {
//            groupData.add(unitsInfoEntities.get(i).getUnits_name());

                List<ChailPlaceInfoEntity> curChildMap = new ArrayList<ChailPlaceInfoEntity>();

                if (placeInfoEntities != null) {
                    for (int j = 0; j < placeInfoEntities.size(); j++) {
                        if (unitsInfoEntities.get(i).getId().equals(placeInfoEntities.get(j).getUnits_id())) {
                            ChailPlaceInfoEntity chailPlaceInfoEntity = new ChailPlaceInfoEntity();
                            chailPlaceInfoEntity.setPlaceId(placeInfoEntities.get(j).getId());
                            chailPlaceInfoEntity.setPlaceName(placeInfoEntities.get(j).getPlace_name());
                            chailPlaceInfoEntity.setType(YI);
                            chailPlaceInfoEntity.setUnitsID(placeInfoEntities.get(j).getUnits_id());
                            curChildMap.add(chailPlaceInfoEntity);
                        }
//                childData.add(curChildMap);
                    }
                }
                if (bigPlaceInfoEntities != null) {
                    for (int z = 0; z < bigPlaceInfoEntities.size(); z++) {
                        if (unitsInfoEntities.get(i).getId().equals(bigPlaceInfoEntities.get(z).getUnits_id())) {
                            ChailPlaceInfoEntity chailPlaceInfoEntity = new ChailPlaceInfoEntity();

                            chailPlaceInfoEntity.setUnitsID(bigPlaceInfoEntities.get(z).getUnits_id());
                            chailPlaceInfoEntity.setPlaceId(bigPlaceInfoEntities.get(z).getId());
                            chailPlaceInfoEntity.setType(BIN);
                            chailPlaceInfoEntity.setPlaceName(bigPlaceInfoEntities.get(z).getPlace_name());
                            curChildMap.add(chailPlaceInfoEntity);
                        }
                    }
                }
                childData.add(curChildMap);
            }

            ExCheckedAdapter adapter = new ExCheckedAdapter(this, unitsInfoEntities, childData, application);

            search_exlist.setAdapter(adapter);
            search_exlist.setGroupIndicator(null);
            search_exlist.setDivider(null);
        } else {
            search_exlist.setVisibility(View.GONE);
            lv_search.setVisibility(View.VISIBLE);
            SearchListAdapter searchListAdapter = new SearchListAdapter(this, placeInfoEntities, application);
            lv_search.setAdapter(searchListAdapter);
        }
    }

    List<PlaceInfoEntity> placeInfoEntities;

    private void getChildData(final String urlChild, final String urlChild1) {

        TwitterRestClient.get(urlChild, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();

                final List<PlaceInfoEntity> placeInfoEntities1 = gson.fromJson(new String(responseBody), new TypeToken<List<PlaceInfoEntity>>() {
                }.getType());

                TwitterRestClient.get(urlChild1, null, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        Gson gson = new Gson();

                        placeInfoEntities = gson.fromJson(new String(responseBody), new TypeToken<List<PlaceInfoEntity>>() {
                        }.getType());

                        if (placeInfoEntities != null) {
                            for (PlaceInfoEntity p : placeInfoEntities1)
                                placeInfoEntities.add(p);
                            handler.sendEmptyMessage(SUCCESS);

//                            handler.sendEmptyMessage(NULL);
//                            search_nothing_text.setVisibility(View.VISIBLE);

                        } else {
                            placeInfoEntities = placeInfoEntities1;
                            handler.sendEmptyMessage(SUCCESS);

//                            handler.sendEmptyMessage(NULL);
//                            search_nothing_text.setVisibility(View.VISIBLE);

                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Log.v("getChildDataonFailure", new String(responseBody));
                        handler.sendEmptyMessage(FAILURE);
                    }
                });
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.v("getChildDataonFailure", new String(responseBody));
                handler.sendEmptyMessage(FAILURE);
            }
        });
    }


    List<BigPlaceInfoEntity> bigPlaceInfoEntities;

    private void getBinData(final String urlBin, final String urlBin1) {
        TwitterRestClient.get(urlBin, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                final List<BigPlaceInfoEntity> bigPlaceInfoEntities1 = gson.fromJson(new String(responseBody), new TypeToken<List<BigPlaceInfoEntity>>() {
                }.getType());

                Log.v("getBigDataonSuccess", new String(responseBody));
                TwitterRestClient.get(urlBin1, null, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        Gson gson = new Gson();
                        bigPlaceInfoEntities = gson.fromJson(new String(responseBody), new TypeToken<List<BigPlaceInfoEntity>>() {
                        }.getType());


                        if (bigPlaceInfoEntities1 != null) {
                            for (BigPlaceInfoEntity b : bigPlaceInfoEntities) {
                                bigPlaceInfoEntities.add(b);
                            }
                            handler.sendEmptyMessage(BIGSUCCESS);
                            if (statusCode == 200 && bigPlaceInfoEntities != null) {

                            } else {

                            }
                            Log.v("getBigDataonSuccess", new String(responseBody));
                        } else {
                            handler.sendEmptyMessage(BIGSUCCESS);
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Log.v("getBigDataonFailure", new String(responseBody));

                        handler.sendEmptyMessage(FAILURE);
                    }
                });
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.v("getBigDataonFailure", new String(responseBody));

                handler.sendEmptyMessage(FAILURE);
            }
        });
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SUCCESS:
                    String urlBin = String.format(getString(R.string.url_get_bigplaceinfo), 1, 50, "", "", "", 1, map.get("userID"));
                    String urlBin1 = String.format(getString(R.string.url_get_bigplaceinfo), 1, 50, "", "", "", 1, map.get("userID"));
                    getBinData(urlBin, urlBin1);
                    break;
                case FAILURE:
                    PromptManager.showToast(SearchActivity.this, "数据获取失败，请稍后再试");
                    break;
                case NULL:
                    PromptManager.showToast(SearchActivity.this, "无数据");
                    break;
                case GETCHILDDATA:
                    urlChild = String.format(getString(R.string.url_get_placeinfo), 1, 1000, "", "", search_edit.getText().toString(), 0, map.get("userID"));
                    String urlGroup1 = String.format(getString(R.string.url_get_placeinfo), 1, 1000, "", "", search_edit.getText().toString(), 1, map.get("userID"));
                    getChildData(urlChild, urlGroup1);
                    break;
                case BIGSUCCESS:
                    toData();
                    break;
            }
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_ok:


                break;
        }
    }
}
