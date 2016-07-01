package com.firstvrp.censusdata;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.dd.CircularProgressButton;
import com.firstvrp.censusdata.CompanyInformation.CompanyInfomationActivity;
import com.firstvrp.censusdata.Dialog.HelpDialog;
import com.firstvrp.censusdata.Entity.SaveStyleEnum;
import com.firstvrp.censusdata.Entity.UnitsInfoEntity;
import com.firstvrp.censusdata.Http.TwitterRestClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import java.util.List;

import Utils.PromptManager;

/**
 * 组织机构代码填写页
 */
public class OrganizationCodeActivity extends SherlockActivity implements
        View.OnClickListener {

    private static final int SUCCESS = 0X11;
    private static final int ERRO = 0X12;
    private static final int SUCCESSORG = 0X13;
    private static final int AUTOSUCCESS = 0X14;
    private AutoCompleteTextView et_organization_code;
    private CircularProgressButton btn_organization_code;
    private ImageView iv_delete_history, organization_note1;
    private TextView tv_organization_no;
    MyApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_code);
        application = (MyApplication) getApplication();
        controlInit();
        init();
    }

    private void controlInit() {
        et_organization_code = (AutoCompleteTextView) findViewById(R.id.et_organization_code);
        btn_organization_code = (CircularProgressButton) findViewById(R.id.btn_organization_code);
        organization_note1 = (ImageView) findViewById(R.id.organization_note1);
        tv_organization_no = (TextView) findViewById(R.id.tv_organization_no);

        iv_delete_history = (ImageView) findViewById(R.id.iv_delete_history);
        btn_organization_code.setOnClickListener(this);
        iv_delete_history.setOnClickListener(this);
        organization_note1.setOnClickListener(this);
        tv_organization_no.setOnClickListener(this);
    }


    private void init() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setTitle(R.string.organization_code_writing);
        initAutoComplete("history", et_organization_code);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.menu_search, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                Intent intent = new Intent(this, SearchActivity.class);
                startActivity(intent);
                break;
            case android.R.id.home:
                this.finish();
                break;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initAutoComplete(String field, AutoCompleteTextView auto) {
        SharedPreferences sp = getSharedPreferences("search_history", 0);
        sp.edit();

        String longhistory = sp.getString(field, "nothing");
        String[] hisArrays = new String[0];
        if (longhistory != null) {
            hisArrays = longhistory.split(",");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, hisArrays);
        //只保留最近的50条的记录
        if (hisArrays.length > 50) {
            String[] newArrays = new String[50];
            System.arraycopy(hisArrays, 0, newArrays, 0, 50);
            adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_dropdown_item_1line, newArrays);
        }
        auto.setAdapter(adapter);
        auto.setDropDownHeight(450);
        auto.setThreshold(1);
        auto.setCompletionHint("下拉显示更多");
        auto.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                AutoCompleteTextView view = (AutoCompleteTextView) v;
                if (hasFocus) {
                    view.showDropDown();
                }
            }
        });
    }

    List<UnitsInfoEntity> unitsInfoEntities;

    private void getInfo() {
        String url = String.format(getString(R.string.url_get_unitsinfo), 1, 1, et_organization_code.getText().toString(), "", "", 0);

        TwitterRestClient.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//                Log.v("onSuccess", statusCode + "::::" + new String(responseBody));

                Gson gson = new Gson();
                unitsInfoEntities = gson.fromJson(new String(responseBody), new TypeToken<List<UnitsInfoEntity>>() {
                }.getType());

                if (statusCode == 200)
                    if (unitsInfoEntities == null || unitsInfoEntities.size() < 1) {

                        application.setSavestyle(SaveStyleEnum.ADD);

                        application.setUnitsInfoEntity(null);
                        handler.sendEmptyMessage(SUCCESS);

                    } else {

                        application.setSavestyle(SaveStyleEnum.ADD);

                        handler.sendEmptyMessage(SUCCESS);
                        application.setUnitsInfoEntity(unitsInfoEntities.get(0));
                        application.setUnitsID(unitsInfoEntities.get(0).getId());
                    }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.v("onFailure", new String(responseBody));
                handler.sendEmptyMessage(ERRO);

            }
        });
    }

    //清除搜索记录
    public void cleanHistory(View v) {
        SharedPreferences sp = getSharedPreferences("search_history", 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.apply();
        Toast.makeText(this, "清除成功", Toast.LENGTH_SHORT).show();
    }

    /**
     * 把指定AutoCompleteTextView中内容保存到sharedPreference中指定的字符段
     *
     * @param field 保存在sharedPreference中的字段名
     * @param auto  要操作的AutoCompleteTextView
     */
    private void saveHistory(String field, AutoCompleteTextView auto) {
        String text = auto.getText().toString();
        SharedPreferences sp = getSharedPreferences("search_history", 0);
        String longhistory = sp.getString(field, "nothing");
        if (!longhistory.contains(text + ",")) {
            StringBuilder sb = new StringBuilder(longhistory);
            sb.insert(0, text + ",");
            sp.edit().putString(field, sb.toString()).commit();
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_organization_code:
//                判断组织机构代码为空
                if (et_organization_code.getText().toString().isEmpty()) {
                    PromptManager.showToast(this, getResources().getString(R.string.organization_code_null));
                    return;
                }
                String txt = et_organization_code.getText().toString();
                //判断组织机构代码为9位
                if (et_organization_code.getText().toString().length() < 9) {
                    PromptManager.showToast(this, getResources().getString(R.string.organization_code_length));
                    return;
                }

                //组织机构代码最后一位为数字或X
//                Pattern p = Pattern.compile("[0-9]*");
//                Matcher m = p.matcher(txt.substring(8).isEmpty() ? "E" : txt);
//                if (!m.matches() && !txt.equals("X")) {
//                    PromptManager.showToast(this, getResources().getString(R.string.organization_code_err));
//                    return;
//                }

                btn_organization_code.setEnabled(false);
                btn_organization_code.setIndeterminateProgressMode(true);
                btn_organization_code.setProgress(0);
//                handler.sendEmptyMessageDelayed(1, 500);
                saveHistory("history", et_organization_code);
                getInfo();
                break;

            case R.id.iv_delete_history:
                cleanHistory(v);
                break;

            case R.id.organization_note1:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(getString(R.string.help_unit_1));
                stringBuilder.append("\r\n");
                new HelpDialog(this, stringBuilder.toString());
                break;

            case R.id.tv_organization_no:
                organizationAuto();
                break;
        }

//        //判断组织机构代码为空
//        if (et_organization_code.getText().toString().isEmpty()) {
//            toast(getResources().getString(R.string.organization_code_null));
//            return;
//        }
//        String txt = et_organization_code.getText().toString();
//        //判断组织机构代码为9位
//        if (et_organization_code.getText().toString().length() < 9) {
//            toast(getResources().getString(R.string.organization_code_length));
//            return;
//        }
//
//        //组织机构代码最后一位为数字或X
//        Pattern p = Pattern.compile("[0-9]*");
//        Matcher m = p.matcher(txt.substring(8).isEmpty() ? "E" : txt);
//        if (!m.matches() && !txt.equals("X")) {
//            toast(getResources().getString(R.string.organization_code_err));
//            return;
//        }
//        String orgCod = et_organization_code.getText().toString();
//        bundle.putString("organizationCode", orgCod);
//        //填写正确保存到本地
//        saveHistory("history", et_organization_code);
//        switch (v.getId()) {
//            case R.id.btn_organization_code:
//                Intent intent = new Intent(OrganizationCodeActivity.this, UnitInformationActivity.class);
//                intent.putExtra("organizationCode", bundle);
//                startActivity(intent);
//                break;
//        }
    }

    String re;

    private void organizationAuto() {
        String url = "api/generateorgcode";

        TwitterRestClient.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    re = new String(responseBody).isEmpty() ? "" : new String(responseBody);
                    handler.sendEmptyMessage(AUTOSUCCESS);
                }
                Log.v("re", new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.v("re", error.toString());
            }
        });
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 1:
                    btn_organization_code.setEnabled(true);
                    btn_organization_code.setProgress(1);
                    handler.sendEmptyMessageDelayed(2, 500);
                    break;
                case 2:
                    btn_organization_code.setProgress(50);
                    handler.sendEmptyMessageDelayed(3, 500);
                    break;
                case 3:
                    btn_organization_code.setProgress(100);
                    handler.sendEmptyMessageDelayed(4, 300);
                    break;
                case SUCCESS:
                    btn_organization_code.setProgress(0);
                    btn_organization_code.setEnabled(true);
                    Intent intent = new Intent(OrganizationCodeActivity.this, CompanyInfomationActivity.class);

                    application.setSavestyle(SaveStyleEnum.ADD);

                    intent.putExtra("organizationCode", et_organization_code.getText().toString());
                    intent.putExtra("type", "companyinfo");
                    startActivity(intent);
                    break;
                case ERRO:
                    Bundle bundle = new Bundle();
                    intent = new Intent(OrganizationCodeActivity.this, CompanyInfomationActivity.class);
                    intent.putExtra("organizationCode", bundle);
                    intent.putExtra("type", "companyinfo");
                    startActivity(intent);
                    PromptManager.showToast(OrganizationCodeActivity.this, "查询错误");
                    break;
                case AUTOSUCCESS:
                    et_organization_code.setText(re.replaceAll("\"", ""));
                    break;
            }
        }
    };
}
