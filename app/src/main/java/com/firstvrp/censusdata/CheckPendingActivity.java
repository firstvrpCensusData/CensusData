package com.firstvrp.censusdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Spinner;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Utils.PromptManager;

/**
 * Created by arthur on 2016/7/4.
 */
public class CheckPendingActivity extends Activity {
    private static final int SUCCESS = 0X11;
    private static final int FAILURE = 0X12;
    private static final int NULL = 0X13;
    private static final int GETCHILDDATA = 0X14;
    static final int BIN = 2;
    static final int YI = 1;
    private static final int BIGSUCCESS = 0X15;
    MyApplication application;
    List<List<ChailPlaceInfoEntity>> childData;
    Map<String, String> map;
    List<UnitsInfoEntity> unitsInfoEntities;
    List<PlaceInfoEntity> placeInfoEntities;
    List<Map<String, Object>> mlist = new ArrayList<Map<String, Object>>();
    private ListView mListView;
    private Button   mButton;
    private Spinner  mPreparerSpinner;
    private Spinner  mCheckeTypeSpinner;
    private FrameLayout mPassFragment;
    private FrameLayout mNoPassFragment;
    private FrameLayout mDeleteFragment;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_checkpending);
        initView();
        initDate();
    }

    private void initDate() {
        GetUserInfo getUserInfo = new GetUserInfo(this);
        map = getUserInfo.getUserSp();
        getCheckedUnitsInfoList();
    }

    public void getCheckedUnitsInfoList() {
        String url;
        if (map != null) {
           // url = String.format(getString(R.string.url_get_unitsinfo), 1, 1000, "", "", "", 0);
            url = "api/UnitsInfo";       
        } else {
            Intent intent = new Intent(CheckPendingActivity.this, LoginActivity.class);
            startActivity(intent);
            CheckPendingActivity.this.finish();
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
                    //checkending_text.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.v("onFailure", new String(responseBody));
            }
        });
    }
    private void getChildData() {
        String url;
        if (map != null) {
            url = String.format(getString(R.string.url_get_placeinfo), 1, 1000, "", "", "", 0, map.get("userID"));
        } else {
            Intent intent = new Intent(CheckPendingActivity.this, LoginActivity.class);
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
            Intent intent = new Intent(CheckPendingActivity.this, LoginActivity.class);
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

    private void toData() {
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

            Map<String, Object> mMap = new HashMap<String, Object>();
            mMap.put("id", unitsInfoEntities.get(i).getId());
            mMap.put("units_name", unitsInfoEntities.get(i).getUnits_name());
            mMap.put("audit_state",unitsInfoEntities.get(i).getAudit_state());
            mMap.put("fill_people", unitsInfoEntities.get(i).getFill_people());
            mMap.put("yb_counts",  unitsInfoEntities.get(i).getYb_counts());
            mlist.add(mMap);
            
        }
        
        
        //SimpleAdapter mAdapter = new SimpleAdapter(CheckPendingActivity.this,unitsInfoEntities,R.layout.activity_check_item,new String);
//无用代码 
       // ExAdapter adapter = new ExAdapter(CheckPendingActivity.this, groupData, childData, application);
        //exList.setAdapter(adapter);
       // exList.setGroupIndicator(null);
       // exList.setDivider(null);
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
                    PromptManager.showToast(CheckPendingActivity.this, "数据获取失败，请稍后再试");
                    break;
                case NULL:
                    PromptManager.showToast(CheckPendingActivity.this, "无数据");
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


    private void initView() {
        mListView = (ListView) findViewById(R.id.checkpending_listview);
        mButton = (Button) findViewById(R.id.select_but);
        mPreparerSpinner= (Spinner) findViewById(R.id.select_spinner_preparer);
        mCheckeTypeSpinner= (Spinner) findViewById(R.id.select_spinner_checke_type);
        mPassFragment= (FrameLayout) findViewById(R.id.checkpending_pass_framelayout);
        mNoPassFragment= (FrameLayout) findViewById(R.id.checkpending_no_pass_framelayout);
        mDeleteFragment= (FrameLayout) findViewById(R.id.checkpending_delete_framelayoutd);
    }
}
