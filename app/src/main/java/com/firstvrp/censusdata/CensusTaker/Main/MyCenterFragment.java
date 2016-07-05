package com.firstvrp.censusdata.CensusTaker.Main;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.firstvrp.censusdata.Entity.BasUserEntity;
import com.firstvrp.censusdata.Entity.BigPlaceInfoEntity;
import com.firstvrp.censusdata.Entity.MyCenterUpDataPassEntity;
import com.firstvrp.censusdata.Entity.PlaceInfoEntity;
import com.firstvrp.censusdata.Entity.UnitsInfoEntity;
import com.firstvrp.censusdata.Entity.UpdataUserInfoEntity;
import com.firstvrp.censusdata.GetUserInfo;
import com.firstvrp.censusdata.Http.TwitterRestClient;
import com.firstvrp.censusdata.MyApplication;
import com.firstvrp.censusdata.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import Utils.GlobalParams;
import Utils.PromptManager;

/**
 * 个人中心页面
 */
public class MyCenterFragment extends Fragment implements View.OnClickListener {
    private static final int SUCCESS_PASSWORD = 0X11;
    private static final int SUCCESS_USERINFO = 0X12;
    private EditText cet_fragment_mycenter_username, cet_fragment_mycenter_name,
            cet_fragment_mycenter_phone,
            cet_fragment_updata_passw, cet_fragment_updata_passwt,
            cet_fragment_updata_passO;
    private ImageView iv_fragment_mycenter_phone_click, iv_fragment_mycenter_name_click, iv_fragment_mycenter_username_click, iv_fragment_mycenter_pass_click;

    View view;
    private BasUserEntity basUserEntity;
    private TextView mycenter_jia, mycenter_yi, mycenter_bin;

    private Button mycenter_save, mycenter_save_pw;

    private MyApplication application;

    Map<String, String> map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mycenter, null);
        application = (MyApplication) getActivity().getApplication();
        init();
        return view;
    }

    private void init() {

        GetUserInfo getUserInfo = new GetUserInfo(getActivity());
        map = getUserInfo.getUserSp();

        this.basUserEntity = application.getBasUserEntity();
        cet_fragment_mycenter_username = (EditText) view.findViewById(R.id.cet_fragment_mycenter_username);
        cet_fragment_mycenter_name = (EditText) view.findViewById(R.id.cet_fragment_mycenter_name);
        cet_fragment_mycenter_phone = (EditText) view.findViewById(R.id.cet_fragment_mycenter_phone);
        cet_fragment_updata_passw = (EditText) view.findViewById(R.id.cet_fragment_updata_passw);
        cet_fragment_updata_passwt = (EditText) view.findViewById(R.id.cet_fragment_updata_passwt);
        cet_fragment_updata_passO = (EditText) view.findViewById(R.id.cet_fragment_updata_passO);

        iv_fragment_mycenter_phone_click = (ImageView) view.findViewById(R.id.iv_fragment_mycenter_phone_click);
        iv_fragment_mycenter_name_click = (ImageView) view.findViewById(R.id.iv_fragment_mycenter_name_click);
        iv_fragment_mycenter_username_click = (ImageView) view.findViewById(R.id.iv_fragment_mycenter_username_click);
        iv_fragment_mycenter_pass_click = (ImageView) view.findViewById(R.id.iv_fragment_mycenter_pass_click);

        iv_fragment_mycenter_phone_click.setOnClickListener(this);
        iv_fragment_mycenter_name_click.setOnClickListener(this);
        iv_fragment_mycenter_username_click.setOnClickListener(this);
        iv_fragment_mycenter_pass_click.setOnClickListener(this);

        cet_fragment_mycenter_username.setText(map.get("userAccount"));
        cet_fragment_mycenter_name.setText(map.get("userName"));
        cet_fragment_mycenter_phone.setText(map.get("userTel"));

        mycenter_jia = (TextView) view.findViewById(R.id.mycenter_jia);
        mycenter_yi = (TextView) view.findViewById(R.id.mycenter_yi);
        mycenter_bin = (TextView) view.findViewById(R.id.mycenter_bin);


        mycenter_save_pw = (Button) view.findViewById(R.id.mycenter_save_pw);
        mycenter_save_pw.setOnClickListener(this);

        mycenter_save = (Button) view.findViewById(R.id.mycenter_save);
        mycenter_save.setOnClickListener(this);

        getCheckedUnitsInfoList();
        getChildData();
        getBigInfoList();
    }

    private void upDataUserInfo() {
        UpdataUserInfoEntity registerEntity = new UpdataUserInfoEntity();

        registerEntity.setId(map.get("userID"));

        registerEntity.setUser_account(cet_fragment_mycenter_username.getText().toString());
        registerEntity.setUser_name(cet_fragment_mycenter_name.getText().toString());
        registerEntity.setMobile(cet_fragment_mycenter_phone.getText().toString());
        registerEntity.setInvite_code("");
        registerEntity.setPassword("");
        registerEntity.setUser_type(1);
        registerEntity.setIs_user(1);

        Gson gson = new Gson();
        final String string = gson.toJson(registerEntity);
        new Thread() {
            public void run() {
                HttpURLConnection_Put(getString(R.string.url_put_updataUserInfo), string);
            }
        }.start();
    }

    private void SaveSpUserInfo(BasUserEntity basUserEntity) {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("configUser", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("userID", basUserEntity.getId());
        editor.putString("userTel", basUserEntity.getMobile());
        editor.putString("userName", basUserEntity.getUser_name());
        editor.putString("userAccount", basUserEntity.getUser_account());
        editor.apply();
    }

    boolean isWrite = false;

    boolean isUpdataPW = false;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_fragment_mycenter_phone_click:
            case R.id.iv_fragment_mycenter_name_click:
            case R.id.iv_fragment_mycenter_username_click:
                if (isWrite) {
                    iv_fragment_mycenter_username_click.setImageResource(R.drawable.ico_write);
                    mycenter_save.setVisibility(View.GONE);
                    setEnabled(false);
                    isWrite = false;
                } else {
                    iv_fragment_mycenter_username_click.setImageResource(R.drawable.ico_write_ok);
                    mycenter_save.setVisibility(View.VISIBLE);
                    setEnabled(true);
                    isWrite = true;
                }
                break;
            case R.id.iv_fragment_mycenter_pass_click:
                if (isUpdataPW) {
                    setEnabledPassWord(false);
                    cet_fragment_updata_passO.setVisibility(View.GONE);
                    cet_fragment_updata_passwt.setVisibility(View.GONE);
                    mycenter_save_pw.setVisibility(View.GONE);
                    cet_fragment_updata_passw.setText("123");
                    isUpdataPW = false;
                } else {
                    setEnabledPassWord(true);
                    cet_fragment_updata_passO.setVisibility(View.VISIBLE);
                    cet_fragment_updata_passwt.setVisibility(View.VISIBLE);
                    mycenter_save_pw.setVisibility(View.VISIBLE);
                    cet_fragment_updata_passw.setText("");
                    cet_fragment_updata_passO.setText("");
                    cet_fragment_updata_passwt.setText("");
                    isUpdataPW = true;
                }
                break;

            case R.id.mycenter_save:
                setEnabled(false);
                upDataUserInfo();
                mycenter_save.setVisibility(View.GONE);
                break;
            case R.id.mycenter_save_pw:
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("configUser", Context.MODE_PRIVATE);
                String sp_passWord = sharedPreferences.getString("userPass", "");
                if (sp_passWord != null) {
                    if (sp_passWord.equals(cet_fragment_updata_passO.getText().toString())) {
                        if (cet_fragment_updata_passw.getText().toString().equals(cet_fragment_updata_passwt.getText().toString())) {
                            if (!cet_fragment_updata_passw.getText().toString().isEmpty() && !cet_fragment_updata_passwt.getText().toString().isEmpty() && !cet_fragment_updata_passO.getText().toString().isEmpty()) {
                                upDataPassWord();
                            } else {
                                PromptManager.showToast(getActivity(), "请填写完整");
                            }
                        } else {
                            PromptManager.showToast(getActivity(), "两次密码输入不一致");
                        }
                    } else {
                        PromptManager.showToast(getActivity(), "旧密码不正确");
                    }
                }
                break;
        }
    }

    public void upDataPassWord() {
        String url = String.format(getString(R.string.url_get_editPassword), map.get("userID"),
                cet_fragment_updata_passO.getText().toString(),
                cet_fragment_updata_passwt.getText().toString());

        TwitterRestClient.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                MyCenterUpDataPassEntity myCenterUpDataPassEntity = gson.fromJson(new String(responseBody), MyCenterUpDataPassEntity.class);
                if (statusCode == 200) {
                    if (myCenterUpDataPassEntity != null) {
                        cet_fragment_updata_passw.setText("123");
                        cet_fragment_updata_passO.setText("");
                        cet_fragment_updata_passwt.setText("");
                        cet_fragment_updata_passO.setVisibility(View.GONE);
                        cet_fragment_updata_passwt.setVisibility(View.GONE);
                        mycenter_save_pw.setVisibility(View.GONE);
                        setEnabledPassWord(false);

                        PromptManager.showToast(getActivity(), myCenterUpDataPassEntity.getMsg());
                    } else {
                        PromptManager.showToast(getActivity(), "修改失败");
                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                PromptManager.showToast(getActivity(), "修改失败");
            }
        });


    }

    public void setEnabledPassWord(boolean e) {
        cet_fragment_updata_passw.setEnabled(e);
        cet_fragment_updata_passwt.setEnabled(e);
        cet_fragment_updata_passO.setEnabled(e);
    }

    public void setEnabled(boolean e) {
        cet_fragment_mycenter_username.setEnabled(e);

        cet_fragment_mycenter_name.setEnabled(e);

        cet_fragment_mycenter_phone.setEnabled(e);
    }

    List<PlaceInfoEntity> placeInfoEntities;

    private void getChildData() {
        String url = String.format(getString(R.string.url_get_placeinfo), 1, 5000, "", "", "", 1, map.get("userID"));

        TwitterRestClient.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();

                placeInfoEntities = gson.fromJson(new String(responseBody), new TypeToken<List<PlaceInfoEntity>>() {
                }.getType());

                getChildDataa();

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.v("getChildDataonFailure", new String(responseBody));
            }
        });
    }

    List<PlaceInfoEntity> placeInfoEntitiesa;

    private void getChildDataa() {
        String url = String.format(getString(R.string.url_get_placeinfo), 1, 5000, "", "", "", 0, map.get("userID"));

        TwitterRestClient.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();

                placeInfoEntitiesa = gson.fromJson(new String(responseBody), new TypeToken<List<PlaceInfoEntity>>() {
                }.getType());

                handler.sendEmptyMessage(0);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.v("getChildDataonFailure", new String(responseBody));
            }
        });
    }

    List<UnitsInfoEntity> unitsInfoEntities;

    private void getCheckedUnitsInfoList() {

        String url = String.format(getString(R.string.url_get_unitsinfo), 1, 5000, "", "", map.get("userID"), 1);

        TwitterRestClient.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                unitsInfoEntities = gson.fromJson(new String(responseBody), new TypeToken<List<UnitsInfoEntity>>() {
                }.getType());
                getCheckedUnitsInfoLista();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.v("onFailure", new String(responseBody));
            }
        });
    }

    List<UnitsInfoEntity> unitsInfoEntitiesa;

    private void getCheckedUnitsInfoLista() {

        String url = String.format(getString(R.string.url_get_unitsinfo), 1, 5000, "", "", map.get("userID"), 0);

        TwitterRestClient.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                unitsInfoEntitiesa = gson.fromJson(new String(responseBody), new TypeToken<List<UnitsInfoEntity>>() {
                }.getType());
                handler.sendEmptyMessage(1);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.v("onFailure", new String(responseBody));
            }
        });
    }

    List<BigPlaceInfoEntity> bigPlaceInfoEntities;

    private void getBigInfoList() {
        String url = String.format(getString(R.string.url_get_bigplaceinfo), 1, 60, "", "", "", 0, map.get("userID"));
        TwitterRestClient.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                bigPlaceInfoEntities = gson.fromJson(new String(responseBody), new TypeToken<List<BigPlaceInfoEntity>>() {
                }.getType());
                getBigInfoLista();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    List<BigPlaceInfoEntity> bigPlaceInfoEntitiesa;

    private void getBigInfoLista() {
        String url = String.format(getString(R.string.url_get_bigplaceinfo), 1, 60, "", "", "", 1, map.get("userID"));
        TwitterRestClient.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                bigPlaceInfoEntitiesa = gson.fromJson(new String(responseBody), new TypeToken<List<BigPlaceInfoEntity>>() {
                }.getType());
                handler.sendEmptyMessage(2);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    if (placeInfoEntities != null)
                        mycenter_yi.setText(String.valueOf(placeInfoEntities.size()));
                    if (placeInfoEntitiesa != null)
                        mycenter_yi.setText(String.valueOf(placeInfoEntitiesa.size()));
                    if (placeInfoEntities != null && placeInfoEntitiesa != null)
                        mycenter_yi.setText(String.valueOf(placeInfoEntities.size() + placeInfoEntitiesa.size()));

                    break;
                case 1:
                    if (unitsInfoEntities != null)
                        mycenter_jia.setText(String.valueOf(unitsInfoEntities.size()));
                    if (unitsInfoEntitiesa != null)
                        mycenter_jia.setText(String.valueOf(unitsInfoEntitiesa.size()));
                    if (unitsInfoEntities != null && unitsInfoEntitiesa != null)
                        mycenter_jia.setText(String.valueOf(unitsInfoEntities.size() + unitsInfoEntitiesa.size()));

                    break;
                case 2:
                    if (bigPlaceInfoEntities != null) {
                        mycenter_bin.setText(String.valueOf(bigPlaceInfoEntities.size()));
                    }
                    if (bigPlaceInfoEntitiesa != null) {
                        mycenter_bin.setText(String.valueOf(bigPlaceInfoEntitiesa.size()));
                    }
                    if (bigPlaceInfoEntities != null && bigPlaceInfoEntitiesa != null) {
                        mycenter_bin.setText(String.valueOf(bigPlaceInfoEntitiesa.size() + bigPlaceInfoEntities.size()));
                    }
                    break;
                case SUCCESS_PASSWORD:

                    break;

                case SUCCESS_USERINFO:
                    application.getBasUserEntity().setMobile(cet_fragment_mycenter_phone.getText().toString());
                    application.getBasUserEntity().setUser_name(cet_fragment_mycenter_name.getText().toString());
                    application.getBasUserEntity().setUser_account(cet_fragment_mycenter_username.getText().toString());

                    GlobalParams.userTel = cet_fragment_mycenter_phone.getText().toString();
                    GlobalParams.username = cet_fragment_mycenter_name.getText().toString();
                    GlobalParams.userAccount = cet_fragment_mycenter_username.getText().toString();

                    SaveSpUserInfo(application.getBasUserEntity());

                    cet_fragment_mycenter_phone.setEnabled(false);
                    cet_fragment_mycenter_name.setEnabled(false);
                    cet_fragment_mycenter_username.setEnabled(false);
                    break;
            }
        }
    };


    public void HttpURLConnection_Put(String urlpost, String par) {
        try {
            URL url = new URL("http://101.200.173.175:10003/" + urlpost);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
// //设置连接属性
            httpConn.setDoOutput(true);// 使用 URL 连接进行输出
            httpConn.setDoInput(true);// 使用 URL 连接进行输入
            httpConn.setUseCaches(false);// 忽略缓存
            httpConn.setRequestMethod("PUT");// 设置URL请求方法
// 设置请求属性
// 获得数据字节数据，请求数据流的编码，必须和下面服务器端处理请求流的编码一致
            byte[] requestStringBytes = par.getBytes("utf-8");
            httpConn.setRequestProperty("Content-length", "" + requestStringBytes.length);
            httpConn.setRequestProperty("Content-Type", "application/json");
            httpConn.setRequestProperty("Charset", "UTF-8");
// 建立输出流，并写入数据
            OutputStream outputStream = httpConn.getOutputStream();
            outputStream.write(requestStringBytes);
            outputStream.close();
// 获得响应状态
            int responseCode = httpConn.getResponseCode();

            if (HttpURLConnection.HTTP_OK == responseCode) {// 连接成功
// 当正确响应时处理数据
                StringBuffer sb = new StringBuffer();
                String readLine;
                BufferedReader responseReader;
// 处理响应流，必须与服务器响应流输出的编码一致
                responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
                while ((readLine = responseReader.readLine()) != null) {
                    sb.append(readLine).append("\n");
                }
                responseReader.close();

                Log.v("sb.toString()", sb.toString());

                handler.sendEmptyMessage(SUCCESS_USERINFO);

            } else {
                Log.v("sb.toString()", responseCode + "" + httpConn.getInputStream().toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
