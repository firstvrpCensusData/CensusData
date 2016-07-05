package com.firstvrp.censusdata;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.dd.CircularProgressButton;
import com.firstvrp.censusdata.Entity.BasUserEntity;
import com.firstvrp.censusdata.Entity.LoginInfoEntity;
import com.firstvrp.censusdata.Http.TwitterRestClient;
import com.firstvrp.censusdata.Main.MainActionActivity;
import com.firstvrp.censusdata.Main.MainLeaderActivity;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import Utils.GlobalParams;
import Utils.PromptManager;

/**
 * 登陆页
 * Created by chenyuan on 16/5/26.
 */
public class LoginActivity extends SherlockActivity implements View.OnClickListener {

    private MyApplication application;
    private SharedPreferences sharedPreferences;
    private static final int LOGINSUCCESS = 0X13;
    private static final int USERISEXIST = 0X11;
    private static final int ERRO = 0X12;
    private static final int USERNO = 0X14;
    private static final int PASSWORDERRO = 0X15;

    private EditText et_activity_login_username, et_activity_login_password;

    private TextView tv_activity_login_sign_in, tv_activity_login_forget_password;

    private CheckBox login_auto;
    private CircularProgressButton et_activity_login_probutton;
    LoginInfoEntity baseEntity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        controlInit();
        init();
    }

    private void init() {
        sharedPreferences = this.getSharedPreferences("configUser", Context.MODE_PRIVATE);
        if (sharedPreferences.getString("userAccount", null) != null) {
            String sp_userName = sharedPreferences.getString("userAccount", "");
            String sp_passWord = sharedPreferences.getString("userPass", "");

            boolean autoLogin = sharedPreferences.getBoolean("autoLogin", false);

            if (autoLogin) {
                et_activity_login_username.setText(sp_userName);
                et_activity_login_password.setText(sp_passWord);

                login_auto.setChecked(true);
            } else {

                login_auto.setChecked(false);
            }


        }

    }

    private void controlInit() {
        et_activity_login_username = (EditText) findViewById(R.id.et_activity_login_username);
        et_activity_login_password = (EditText) findViewById(R.id.et_activity_login_password);
        tv_activity_login_sign_in = (TextView) findViewById(R.id.tv_activity_login_sign_in);
        tv_activity_login_forget_password = (TextView) findViewById(R.id.tv_activity_login_forget_password);
        et_activity_login_probutton = (CircularProgressButton) findViewById(R.id.et_activity_login_probutton);

        login_auto = (CheckBox) findViewById(R.id.login_auto);

        tv_activity_login_forget_password.setOnClickListener(this);
        tv_activity_login_sign_in.setOnClickListener(this);
        et_activity_login_probutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        handler.sendEmptyMessage(LOGINSUCCESS);
        Intent intent;
        switch (v.getId()) {
            case R.id.tv_activity_login_forget_password://忘记密码
                intent = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_activity_login_sign_in://注册
                intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;

            case R.id.et_activity_login_probutton://登陆按钮
                if (et_activity_login_username.getText().toString().isEmpty() || et_activity_login_password.getText().toString().isEmpty()) {
                    PromptManager.showToast(this, getString(R.string.error_invalid_null));
                    return;
                }
                et_activity_login_probutton.setEnabled(false);

                et_activity_login_probutton.setIndeterminateProgressMode(true);
                et_activity_login_probutton.setProgress(0);

//                if (NetUtil.checkNet(this)) {
                String url = String.format(getString(R.string.url_login_isexist), et_activity_login_username.getText().toString());

                TwitterRestClient.get(url, null, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        if (new String(responseBody).equals("null"))
                            handler.sendEmptyMessageDelayed(USERNO, 10);
                        else
                            handler.sendEmptyMessageDelayed(USERISEXIST, 10);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        handler.sendEmptyMessageDelayed(ERRO, 10);
                    }
                });
//                } else {
//                    PromptManager.showNoNetWork(this);
//                }

                break;

        }
    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case USERNO:
                    PromptManager.showToast(LoginActivity.this, getString(R.string.error_incorrect_no));
                    handler.sendEmptyMessageDelayed(3, 1000);
                    break;
                case ERRO:
                    et_activity_login_probutton.setProgress(-1);
                    handler.sendEmptyMessageDelayed(3, 1000);
                    break;
                case USERISEXIST:
                    et_activity_login_probutton.setEnabled(true);
                    et_activity_login_probutton.setProgress(20);
                    getUserInfo();
                    break;
                case LOGINSUCCESS:
                    et_activity_login_probutton.setProgress(100);
                    Intent intent;
                    if(baseEntity.getUser().getUser_type()==1) {
                        intent = new Intent(LoginActivity.this, MainActionActivity.class);
                    }else {
                        intent = new Intent(LoginActivity.this, MainLeaderActivity.class);
                    }
                    startActivity(intent);
                    break;
                case 3:
                    et_activity_login_probutton.setProgress(0);
                    et_activity_login_probutton.setEnabled(true);
                    break;
                case PASSWORDERRO:
                    et_activity_login_probutton.setProgress(-1);
                    handler.sendEmptyMessageDelayed(3, 1000);
                    PromptManager.showToast(LoginActivity.this, getString(R.string.error_invalid_password));
                    break;
            }
        }
    };

    private void getUserInfo() {
        et_activity_login_probutton.setProgress(35);
//        if (NetUtil.checkNet(this)) {
        String url = String.format(getString(R.string.url_login), et_activity_login_username.getText().toString(),
                et_activity_login_password.getText().toString());

        TwitterRestClient.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                baseEntity = gson.fromJson(new String(responseBody), LoginInfoEntity.class);
                if (baseEntity.isSuccess()) {
                    application = (MyApplication) getApplication();
                    application.setBasUserEntity(baseEntity.getUser());
                    if (application.getBasUserEntity() == null) {
                        handler.sendEmptyMessageDelayed(ERRO, 50);
                    } else {
                        GlobalParams.userID = baseEntity.getUser().getId();
                        GlobalParams.username = baseEntity.getUser().getUser_name();
                        GlobalParams.userTel = baseEntity.getUser().getMobile();
                        GlobalParams.userAccount = baseEntity.getUser().getUser_account();

                        SaveSpUserInfo(baseEntity.getUser());

                        handler.sendEmptyMessageDelayed(LOGINSUCCESS, 50);
                    }
                } else {
                    handler.sendEmptyMessageDelayed(PASSWORDERRO, 50);
                }
                Log.v("base", baseEntity.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                handler.sendEmptyMessageDelayed(ERRO, 50);
            }
        });
    }

    private void SaveSpUserInfo(BasUserEntity basUserEntity) {
        sharedPreferences = this.getSharedPreferences("configUser", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (login_auto.isChecked()) {
            editor.putBoolean("autoLogin", true);
        } else {
            editor.putBoolean("autoLogin", false);
        }

        editor.putString("userID",basUserEntity.getId());
        editor.putString("userTel",basUserEntity.getMobile());
        editor.putString("userName",basUserEntity.getUser_account());
        editor.putString("userAccount", et_activity_login_username.getText().toString());
        editor.putString("userPass", et_activity_login_password.getText().toString());
        editor.apply();
    }

}
