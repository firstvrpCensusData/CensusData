package com.firstvrp.censusdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.firstvrp.censusdata.Adapter.CheakSimpleAdapter;
import com.firstvrp.censusdata.CompanyInformation.CompanyInfomationActivity;
import com.firstvrp.censusdata.Entity.AuditStateEntity;
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
public class CheckPendingActivity extends Activity implements AdapterView.OnItemClickListener, View.OnClickListener, AdapterView.OnItemLongClickListener {
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
    AuditStateEntity mAuditStateEntity = new AuditStateEntity();
    List list ;
    private ListView mListView;
    private Button   mButton;
    private Spinner  mPreparerSpinner;
    private Spinner  mCheckeTypeSpinner;
    private FrameLayout mPassFragment;
    private FrameLayout mNoPassFragment;
    private FrameLayout mDeleteFragment;
    private CheckBox mCheckBox;
    private boolean isShow =false;
    CheakSimpleAdapter mCheakSimpleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkpending);
        initView();
        initDate();
        initEvent();
        initSpinnerEcent();
    }

    private void initSpinnerEcent() {
        mPreparerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        list = new ArrayList<String>();
        list.add(mAuditStateEntity.AUDITSTATE_CHECKPENDING);
        list.add(mAuditStateEntity.AUDITSTATE_CHECKED);
        list.add(mAuditStateEntity.AUDITSTATE_UNCHECK);
        ArrayAdapter mArrayAdapte = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        mArrayAdapte.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mCheckeTypeSpinner.setAdapter(mArrayAdapte);
        mCheckeTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mCheckeTypeSpinner.setTextAlignment(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initEvent() {
        //1,设置数据源
        mListView.setOnItemClickListener(this);
        mListView.setOnItemLongClickListener(this);
        mButton.setOnClickListener(this);
        mPassFragment.setOnClickListener(this);
        mNoPassFragment.setOnClickListener(this);
        mDeleteFragment.setOnClickListener(this);
    }

    private void initDate() {
        GetUserInfo getUserInfo = new GetUserInfo(this);
        map = getUserInfo.getUserSp();
        getCheckedUnitsInfoList();
    }

    public void getCheckedUnitsInfoList() {
        String url;
        if (map != null) {
           url = String.format(getString(R.string.url_get_unitsinfo), 1, 1000, "", "", "", 0);
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
            if (unitsInfoEntities.get(i).getAudit_state() == 2)
                mMap.put("audit_state",mAuditStateEntity.AUDITSTATE_UNCHECK);
            if (unitsInfoEntities.get(i).getAudit_state() == 1)
                mMap.put("audit_state",mAuditStateEntity.AUDITSTATE_CHECKED);
            if (unitsInfoEntities.get(i).getAudit_state() == 0)
                mMap.put("audit_state",mAuditStateEntity.AUDITSTATE_CHECKPENDING);
            mMap.put("fill_people", unitsInfoEntities.get(i).getFill_people());
            mMap.put("yb_counts",  unitsInfoEntities.get(i).getYb_counts());
            mlist.add(mMap);
        }
        
      /*  SimpleAdapter mAdapter = new SimpleAdapter(CheckPendingActivity.this,mlist,R.layout.activity_check_item,new String[]{
                "id", "units_name","audit_state","fill_people","yb_counts"},new int[] {R.id.check_units_id,R.id.check_units_name,R.id.item_check_type,R.id.item_preparer,R.id.b_table_number});
       mListView.setAdapter(mAdapter);
       */
        mCheakSimpleAdapter = new CheakSimpleAdapter(CheckPendingActivity.this,mlist,R.layout.activity_check_item,new String[]{
                "id", "units_name","audit_state","fill_people","yb_counts"},new int[] {R.id.check_units_id,R.id.check_units_name,R.id.item_check_type,R.id.item_preparer,R.id.b_table_number});
        mListView.setAdapter(mCheakSimpleAdapter);
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
        mListView.setTag(1);
        mButton = (Button) findViewById(R.id.select_but);
        mButton.setTag(2);
        mPreparerSpinner= (Spinner) findViewById(R.id.select_spinner_preparer);
        mPreparerSpinner.setTag(3);
        mCheckeTypeSpinner= (Spinner) findViewById(R.id.select_spinner_checke_type);
        mCheckeTypeSpinner.setTag(4);
        mPassFragment= (FrameLayout) findViewById(R.id.checkpending_pass_framelayout);
        mPassFragment.setTag(5);
        mNoPassFragment= (FrameLayout) findViewById(R.id.checkpending_no_pass_framelayout);
        mNoPassFragment.setTag(6);
        mDeleteFragment= (FrameLayout) findViewById(R.id.checkpending_delete_framelayoutd);
        mDeleteFragment.setTag(7);
        //mCheckBox = (CheckBox) findViewById(R.id.checkBox);
        //mCheckBox.setTag(8);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String itemid = parent.getItemAtPosition(position).toString();
        Toast.makeText(CheckPendingActivity.this,parent.getItemAtPosition(position).toString()+"短时间点击",Toast.LENGTH_SHORT).show();
        Log.i("text", itemid+"");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String itemid = parent.getItemAtPosition(position).toString();
        Toast.makeText(this,parent.getItemAtPosition(position).toString()+"长时间点击",Toast.LENGTH_SHORT).show();
        Log.i("text", itemid+"");
        UnitsInfoEntity unitsInfoEntity = unitsInfoEntities.get(position);
        /*Intent intent = new Intent(this, CompanyInfomationActivity.class);
        intent.putExtra("unitsInfoEntity", unitsInfoEntity);
        this.startActivity(intent);*/

        Intent intent = new Intent(this, CompanyInfomationActivity.class);
        intent.putExtra("organizationCode", unitsInfoEntity.getOrg_code());
        intent.putExtra("type", "companyinfo");
        this.startActivity(intent);
        return true;
    }
    
    @Override
    public void onClick(View v) {
        int tag = (int) v.getTag();
        switch(tag) {
            case 2:
                mCheakSimpleAdapter.toggle();
                /*if(isShow){
                    HideCheckBox();
                }else{
                    ShowCheckBox();
                }*/
                break;
            case 5:
                
                break;
            case 6:
                
                break;
            case 7:
                
                break;
            default:
                break;
        }
    }

    private void ShowCheckBox() {
        if(isShow)return;
        mCheckBox.setVisibility(View.VISIBLE);
        isShow = true;
    }
    private void HideCheckBox() {
        if(!isShow)return;
        mCheckBox.setVisibility(View.GONE);
        isShow = false;
    }

}
