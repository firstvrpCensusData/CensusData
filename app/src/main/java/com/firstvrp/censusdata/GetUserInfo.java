package com.firstvrp.censusdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.util.ArrayMap;

import com.firstvrp.censusdata.Entity.BasUserEntity;
import com.firstvrp.censusdata.Entity.LoginInfoEntity;
import com.firstvrp.censusdata.Http.TwitterRestClient;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import java.util.Map;

import Utils.GlobalParams;

/**
 * Created by chenyuan on 16/6/23.
 */
public class GetUserInfo {
    private MyApplication application;
    private Context context;

    public GetUserInfo(Context context) {
        this.context = context;
        this.application = (MyApplication) context.getApplicationContext();
    }

    public Map<String ,String> getUserSp(){
        Map<String,String> map = new ArrayMap<>();

        if (application.getBasUserEntity() != null) {
            BasUserEntity basUserEntity = application.getBasUserEntity();
            map.put("userID",basUserEntity.getId());
            map.put("userAccount", basUserEntity.getUser_account());
            map.put("userName", basUserEntity.getUser_name());
            map.put("userTel", basUserEntity.getMobile());
            map.put("userType", basUserEntity.getUser_type()+"");
          } else if (GlobalParams.userID != null) {
            map.put("userID",GlobalParams.userID);
            map.put("userAccount", GlobalParams.userAccount);
            map.put("userName", GlobalParams.username);
            map.put("userTel", GlobalParams.userTel);
         }else {
            SharedPreferences sharedPreferences = context.getSharedPreferences("configUser", Context.MODE_PRIVATE);

            String sp_userAccount = sharedPreferences.getString("userAccount", "");
            String sp_userName = sharedPreferences.getString("userName", "");
            String sp_userTel = sharedPreferences.getString("userTel", "");
            String sp_userID = sharedPreferences.getString("userID","");
            String sp_userPassWord = sharedPreferences.getString("userPass","");

            map.put("userID",sp_userID);
            map.put("userAccount", sp_userAccount);
            map.put("userName", sp_userName);
            map.put("userTel", sp_userTel);

            String url = String.format(context.getString(R.string.url_login),sp_userAccount ,
                    sp_userPassWord);

            TwitterRestClient.get(url, null, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    Gson gson =new Gson();
                    LoginInfoEntity baseEntity = gson.fromJson(new String(responseBody), LoginInfoEntity.class);
                    if (baseEntity.isSuccess()) {
                        application = (MyApplication) context.getApplicationContext();
                        application.setBasUserEntity(baseEntity.getUser());
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                }
            });
        }

        return map;
    }


}
