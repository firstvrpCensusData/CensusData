package com.firstvrp.censusdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.dd.CircularProgressButton;
import com.firstvrp.censusdata.Entity.ForgetPasswordEntity;
import com.firstvrp.censusdata.Http.TwitterRestClient;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import Utils.PromptManager;

public class ForgetPasswordActivity extends Activity implements View.OnClickListener {

    private static final int USERNO = 0x11;
    private static final int USERISEXIST = 0x12;
    private EditText forget_password_useraccount, forget_password_username, forget_password_phone,
            forget_password_invite, forget_password_new_password,
            forget_password_password;

    private CircularProgressButton forget_password_probutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        init();
    }

    private void init() {
        forget_password_useraccount = (EditText) findViewById(R.id.forget_password_useraccount);
        forget_password_username = (EditText) findViewById(R.id.forget_password_username);
        forget_password_phone = (EditText) findViewById(R.id.forget_password_phone);
        forget_password_invite = (EditText) findViewById(R.id.forget_password_invite);
        forget_password_new_password = (EditText) findViewById(R.id.forget_password_new_password);
        forget_password_password = (EditText) findViewById(R.id.forget_password_password);

        forget_password_probutton = (CircularProgressButton) findViewById(R.id.forget_password_probutton);
        forget_password_probutton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_forget_password, menu);
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

    @Override
    public void onClick(View v) {

        if (forget_password_useraccount.getText().toString().isEmpty()) {
            PromptManager.showToast(this, "用户名不能为空");
            return;
        }
        if (forget_password_username.getText().toString().isEmpty()) {
            PromptManager.showToast(this, "真实姓名不能为空");
            return;
        }
        if (forget_password_phone.getText().toString().isEmpty()) {
            PromptManager.showToast(this, "电话不能为空");
            return;
        }
        if (forget_password_invite.getText().toString().isEmpty()) {
            PromptManager.showToast(this, "邀请码不能为空");
            return;
        }
        if (forget_password_new_password.getText().toString().isEmpty()) {
            PromptManager.showToast(this, "密码不能为空");
            return;
        }
        if (forget_password_password.getText().toString().isEmpty()) {
            PromptManager.showToast(this, "验证密码不能为空");
            return;
        }

        if (!forget_password_new_password.getText().toString().equals(forget_password_password.getText().toString())) {
            PromptManager.showToast(this, "两次密码输入不一致");
            return;
        }
        String url = String.format(getString(R.string.url_get_forgetpass), forget_password_useraccount.getText().toString(), forget_password_username.getText().toString(),
                forget_password_phone.getText().toString(), forget_password_invite.getText().toString(), forget_password_new_password.getText().toString());
        TwitterRestClient.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                ForgetPasswordEntity forgetPasswordEntity = gson.fromJson(new String(responseBody), ForgetPasswordEntity.class);
                if (forgetPasswordEntity.isSuccess()) {
                    handler.sendEmptyMessage(USERISEXIST);
                    PromptManager.showToast(ForgetPasswordActivity.this, forgetPasswordEntity.getMsg());
                } else {
                    handler.sendEmptyMessage(USERNO);
                    PromptManager.showToast(ForgetPasswordActivity.this, forgetPasswordEntity.getMsg());
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.v("onFailure", new String(responseBody));
                PromptManager.showToast(ForgetPasswordActivity.this, "修改密码失败");
            }
        });

    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case USERNO:
                    break;
                case USERISEXIST:
                    Intent intent = new Intent(ForgetPasswordActivity.this,LoginActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
