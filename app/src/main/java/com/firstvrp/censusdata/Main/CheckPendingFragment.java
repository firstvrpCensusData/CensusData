package com.firstvrp.censusdata.Main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.firstvrp.censusdata.Adapter.ExAdapter;
import com.firstvrp.censusdata.Entity.BigPlaceInfoEntity;
import com.firstvrp.censusdata.Entity.ChailPlaceInfoEntity;
import com.firstvrp.censusdata.Entity.PlaceInfoEntity;
import com.firstvrp.censusdata.Entity.UnitsInfoEntity;
import com.firstvrp.censusdata.GetUserInfo;
import com.firstvrp.censusdata.Http.TwitterRestClient;
import com.firstvrp.censusdata.LoginActivity;
import com.firstvrp.censusdata.MyApplication;
import com.firstvrp.censusdata.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Utils.PromptManager;

/**
 * 待审核页面
 */
public class CheckPendingFragment extends Fragment {
    private static final int SUCCESS = 0X11;
    private static final int FAILURE = 0X12;
    private static final int NULL = 0X13;
    private static final int GETCHILDDATA = 0X14;
    static final int BIN = 2;
    static final int YI = 1;
    private static final int BIGSUCCESS = 0X15;
    MyApplication application;
    ExpandableListView exList;
    private TextView checkending_text;
    List<UnitsInfoEntity> groupData;
    List<List<ChailPlaceInfoEntity>> childData;
    Map<String, String> map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkpending, null);
        exList = (ExpandableListView) view.findViewById(R.id.checkending_exlist);
        checkending_text = (TextView) view.findViewById(R.id.checkending_text);
        application = (MyApplication) getActivity().getApplication();
        init();
        return view;
    }

    private void init() {
        GetUserInfo getUserInfo = new GetUserInfo(getActivity());
        map = getUserInfo.getUserSp();
        getCheckedUnitsInfoList();
    }

    List<UnitsInfoEntity> unitsInfoEntities;

    private void getCheckedUnitsInfoList() {
        String url;
        if (map != null) {
            url = String.format(getString(R.string.url_get_unitsinfo), 1, 1000, "", "", map.get("userID"), 0);
        } else {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            return;
        }

        TwitterRestClient.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                unitsInfoEntities = gson.fromJson(new String(responseBody), new TypeToken<List<UnitsInfoEntity>>() {
                }.getType());
                if (unitsInfoEntities != null) {
                    handler.sendEmptyMessage(GETCHILDDATA);
                } else {
                    handler.sendEmptyMessage(NULL);
                    checkending_text.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.v("onFailure", new String(responseBody));
            }
        });
    }

    private void toData() {

        groupData = unitsInfoEntities;
        childData = new ArrayList<List<ChailPlaceInfoEntity>>();
        for (int i = 0; i < unitsInfoEntities.size(); i++) {
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

        ExAdapter adapter = new ExAdapter(getActivity(), groupData, childData, application);

        exList.setAdapter(adapter);
        exList.setGroupIndicator(null);
        exList.setDivider(null);
    }


//    页码：page
//    页面大小：rows
//    所属普查单位ID：units_id（选填）
//    场地代码：place_code（选填）
//    场地名称：place_name（选填）

    List<PlaceInfoEntity> placeInfoEntities;

    private void getChildData() {
        String url;

        if (map != null) {
            url = String.format(getString(R.string.url_get_placeinfo), 1, 1000, "", "", "", 0, map.get("userID"));
        } else {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            return;
        }
        TwitterRestClient.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();

                placeInfoEntities = gson.fromJson(new String(responseBody), new TypeToken<List<PlaceInfoEntity>>() {
                }.getType());
                handler.sendEmptyMessage(SUCCESS);
                if (statusCode == 200 && placeInfoEntities != null) {
//                    handler.sendEmptyMessage(SUCCESS);
                } else {
                    handler.sendEmptyMessage(NULL);
//                    checkending_text.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.v("getChildDataonFailure", new String(responseBody));
                handler.sendEmptyMessage(FAILURE);
            }
        });
    }

    List<BigPlaceInfoEntity> bigPlaceInfoEntities;

    private void getBinData() {
        String url;
        if (map != null) {
            url = String.format(getString(R.string.url_get_bigplaceinfo), 1, 50, "", "", "", 0, map.get("userID"));
        } else {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            return;
        }

        TwitterRestClient.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                bigPlaceInfoEntities = gson.fromJson(new String(responseBody), new TypeToken<List<BigPlaceInfoEntity>>() {
                }.getType());
                handler.sendEmptyMessage(BIGSUCCESS);
                if (statusCode == 200 && bigPlaceInfoEntities != null) {

                } else {

                }
                Log.v("getBigDataonSuccess", new String(responseBody));

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                Log.v("getBigDataonFailure", new String(responseBody));

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
                    getBinData();
                    break;
                case FAILURE:
                    PromptManager.showToast(getActivity(), "数据获取失败，请稍后再试");
                    break;
                case NULL:
                    PromptManager.showToast(getActivity(), "无数据");
                    break;
                case GETCHILDDATA:
                    getChildData();
                    break;
                case BIGSUCCESS:
                    toData();
                    break;
            }
        }
    };

}
