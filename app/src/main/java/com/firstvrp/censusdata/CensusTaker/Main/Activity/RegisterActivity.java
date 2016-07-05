package com.firstvrp.censusdata.CensusTaker.Main.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.dd.CircularProgressButton;
import com.firstvrp.censusdata.Entity.LoginInfoEntity;
import com.firstvrp.censusdata.Entity.RegisterActivityEntity;
import com.firstvrp.censusdata.Http.TwitterRestClient;
import com.firstvrp.censusdata.CensusTaker.Main.MainActionActivity;
import com.firstvrp.censusdata.MyApplication;
import com.firstvrp.censusdata.R;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;

import Utils.PromptManager;

public class RegisterActivity extends Activity implements OnClickListener {

    private EditText register_username, register_realname,
            register_mobile, invitation_code,
            register_password, register_confirm_password;
    private CircularProgressButton register_probutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();

    }

    private void init() {
        register_username = (EditText) findViewById(R.id.register_username);
        register_realname = (EditText) findViewById(R.id.register_realname);
        register_mobile = (EditText) findViewById(R.id.register_mobile);
        invitation_code = (EditText) findViewById(R.id.invitation_code);
        register_password = (EditText) findViewById(R.id.register_password);
        register_confirm_password = (EditText) findViewById(R.id.register_confirm_password);

        register_probutton = (CircularProgressButton) findViewById(R.id.register_probutton);

        register_probutton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    RegisterActivityEntity registerActivityEntity;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_probutton:
                register_probutton.setEnabled(false);

                register_probutton.setIndeterminateProgressMode(true);
                register_probutton.setProgress(0);
                if (register_username.getText().toString().isEmpty()) {
                    PromptManager.showToast(this, "用户名不能为空");
                    handler.sendEmptyMessageDelayed(5, 1000);
                    return;
                }
                if (register_realname.getText().toString().isEmpty()) {
                    PromptManager.showToast(this, "用户名不能为空");
                    handler.sendEmptyMessageDelayed(5, 1000);
                    return;
                }
                if (register_mobile.getText().toString().isEmpty()) {
                    PromptManager.showToast(this, "手机号码不能为空");
                    handler.sendEmptyMessageDelayed(5, 1000);
                    return;
                }
                if (invitation_code.getText().toString().isEmpty()) {
                    PromptManager.showToast(this, "邀请码不能为空");
                    handler.sendEmptyMessageDelayed(5, 1000);
                    return;
                }
                if (register_password.getText().toString().isEmpty()) {
                    PromptManager.showToast(this, "密码不能为空");
                    handler.sendEmptyMessageDelayed(5, 1000);
                    return;
                }
                if (register_confirm_password.getText().toString().isEmpty()) {
                    PromptManager.showToast(this, "密码不能为空");
                    handler.sendEmptyMessageDelayed(5, 1000);
                    return;
                }

                String reg_password = register_password.getText().toString();
                String reg_con_password = register_confirm_password.getText().toString();
                if (!reg_password.equals(reg_con_password)) {
                    PromptManager.showToast(this, "密码输入不一致");
                    handler.sendEmptyMessageDelayed(5, 1000);
                    return;
                }

                RequestParams params = new RequestParams();
                params.put("user_account", register_username.getText().toString());
                params.put("user_name", register_realname.getText().toString());
                params.put("mobile", register_mobile.getText().toString());
                params.put("password", register_confirm_password.getText().toString());
                params.put("invite_code", invitation_code.getText().toString());

//                final RegisterEntity registerEntity = new RegisterEntity();
//                registerEntity.setUser_account(register_username.getText().toString());
//                registerEntity.setUser_name(register_realname.getText().toString());
//                registerEntity.setMobile(register_mobile.getText().toString());
//                registerEntity.setPassword(register_confirm_password.getText().toString());
//                registerEntity.setInvite_code(invitation_code.getText().toString());


//                new Thread() {
//
//                    public void run() {
//                        Gson gson = new Gson();
//
//                        String string = gson.toJson(registerEntity);
//
//                        TwitterRestClient.HttpURLConnection_Post(getString(R.string.url_register), string);
//                    }
//                }.start();

                TwitterRestClient.post(getString(R.string.url_register), params, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        Gson gson = new Gson();

                        registerActivityEntity = gson.fromJson(new String(responseBody), RegisterActivityEntity.class);

                        if (registerActivityEntity.isSuccess())
                            handler.sendEmptyMessage(0);
                        else
                            handler.sendEmptyMessage(1);

                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        handler.sendEmptyMessage(2);
                    }
                });
                break;
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    getUserInfo();
                    break;
                case 1:
                    register_probutton.setProgress(-1);
                    PromptManager.showToast(RegisterActivity.this, registerActivityEntity.getMsg());
                    handler.sendEmptyMessageDelayed(5, 2000);
                    break;
                case 2:
                    register_probutton.setProgress(-1);
                    PromptManager.showToast(RegisterActivity.this, "注册失败");
                    handler.sendEmptyMessageDelayed(5, 2000);
                    break;
                case 3:
                    register_probutton.setProgress(100);
                    handler.sendEmptyMessageDelayed(5, 2000);
                    break;
                case 4:
                    register_probutton.setProgress(-1);
                    handler.sendEmptyMessageDelayed(5, 2000);
                    break;
                case 5:
                    register_probutton.setEnabled(true);
                    register_probutton.setProgress(0);
                    break;
            }
        }
    };

    MyApplication application;

    private void getUserInfo() {
        register_probutton.setProgress(25);
        String url = String.format(getString(R.string.url_login), register_username.getText().toString(),
                register_confirm_password.getText().toString());

        TwitterRestClient.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                LoginInfoEntity baseEntity = gson.fromJson(new String(responseBody), LoginInfoEntity.class);
                if (baseEntity.isSuccess()) {
                    handler.sendEmptyMessageDelayed(3, 50);
                    application = (MyApplication) getApplication();

                    application.setBasUserEntity(baseEntity.getUser());

                    PromptManager.showToast(RegisterActivity.this, baseEntity.getMsg());
                    Intent intent = new Intent(RegisterActivity.this, MainActionActivity.class);
                    startActivity(intent);
                } else {
                    PromptManager.showToast(RegisterActivity.this, baseEntity.getMsg());
                    handler.sendEmptyMessageDelayed(4, 50);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                handler.sendEmptyMessageDelayed(4, 50);
            }
        });
    }
}
