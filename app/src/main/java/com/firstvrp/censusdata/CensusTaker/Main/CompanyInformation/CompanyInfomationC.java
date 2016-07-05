package com.firstvrp.censusdata.CensusTaker.Main.CompanyInformation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.firstvrp.censusdata.CustomTools.CustomNestRadioGroup;
import com.firstvrp.censusdata.CensusTaker.Main.Dialog.HelpDialog;
import com.firstvrp.censusdata.Entity.UnitsInfoReturnEntity;
import com.firstvrp.censusdata.GetUserInfo;
import com.firstvrp.censusdata.MyApplication;
import com.firstvrp.censusdata.R;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import Utils.GetNowTime;

/**
 * Created with chen.
 */
public class CompanyInfomationC extends Fragment implements View.OnClickListener, IBtnCallListener, CustomNestRadioGroup.OnCheckedChangeListener {

    View view;
    private RadioButton rb_company_infomation_no_sports_team, rb_company_infomation_sparetime_sports_team, rb_company_infomation_specialized_sports_team;
    private RadioButton rb_company_infomation_nothing, rb_company_infomation_ten_person,
            rb_company_infomation_thirty_person, rb_company_infomation_fifty_person,
            rb_company_infomation_hundred_person, rb_company_infomation_hundred_one_person;
    private RadioButton rb_company_infomation_nothing_day, rb_company_infomation_ten_day,
            rb_company_infomation_twenty_day, rb_company_infomation_thirty_day,
            rb_company_infomation_fifty_day, rb_company_infomation_hunderd_day,
            rb_company_infomation_two_hundred_day, rb_company_infomation_two_hundred_one_day;

    static MyApplication application;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_company_infomation_c, container, false);


        rb_company_infomation_no_sports_team = (RadioButton) view.findViewById(R.id.rb_company_infomation_no_sports_team);
        rb_company_infomation_sparetime_sports_team = (RadioButton) view.findViewById(R.id.rb_company_infomation_sparetime_sports_team);
        rb_company_infomation_specialized_sports_team = (RadioButton) view.findViewById(R.id.rb_company_infomation_specialized_sports_team);

        rb_company_infomation_nothing = (RadioButton) view.findViewById(R.id.rb_company_infomation_nothing);
        rb_company_infomation_ten_person = (RadioButton) view.findViewById(R.id.rb_company_infomation_ten_person);
        rb_company_infomation_thirty_person = (RadioButton) view.findViewById(R.id.rb_company_infomation_thirty_person);
        rb_company_infomation_fifty_person = (RadioButton) view.findViewById(R.id.rb_company_infomation_fifty_person);
        rb_company_infomation_hundred_person = (RadioButton) view.findViewById(R.id.rb_company_infomation_hundred_person);
        rb_company_infomation_hundred_one_person = (RadioButton) view.findViewById(R.id.rb_company_infomation_hundred_one_person);

        rb_company_infomation_nothing_day = (RadioButton) view.findViewById(R.id.rb_company_infomation_nothing_day);
        rb_company_infomation_ten_day = (RadioButton) view.findViewById(R.id.rb_company_infomation_ten_day);
        rb_company_infomation_twenty_day = (RadioButton) view.findViewById(R.id.rb_company_infomation_twenty_day);
        rb_company_infomation_thirty_day = (RadioButton) view.findViewById(R.id.rb_company_infomation_thirty_day);
        rb_company_infomation_fifty_day = (RadioButton) view.findViewById(R.id.rb_company_infomation_fifty_day);
        rb_company_infomation_hunderd_day = (RadioButton) view.findViewById(R.id.rb_company_infomation_hunderd_day);
        rb_company_infomation_two_hundred_day = (RadioButton) view.findViewById(R.id.rb_company_infomation_two_hundred_day);
        rb_company_infomation_two_hundred_one_day = (RadioButton) view.findViewById(R.id.rb_company_infomation_two_hundred_one_day);

        //帮助
        ImageView index_name12 = (ImageView) view.findViewById(R.id.index_name12);
        ImageView index_name13 = (ImageView) view.findViewById(R.id.index_name13);
        ImageView index_name14 = (ImageView) view.findViewById(R.id.index_name14);
        index_name12.setOnClickListener(this);
        index_name13.setOnClickListener(this);
        index_name14.setOnClickListener(this);

        application = (MyApplication) getActivity().getApplication();

        init();

        return view;
    }

    private void init() {
        if (application.getUnitsInfoEntity() != null) {
            rb_company_infomation_no_sports_team.setChecked(false);
            rb_company_infomation_sparetime_sports_team.setChecked(false);
            rb_company_infomation_specialized_sports_team.setChecked(false);
            switch (application.getUnitsInfoEntity().getAthlete_type()) {
                case "未接待过运动队":
                    rb_company_infomation_no_sports_team.setChecked(true);
                    break;
                case "业余运动队":
                    rb_company_infomation_sparetime_sports_team.setChecked(true);
                    break;
                case "专业运动队、职业俱乐部运动队":
                    rb_company_infomation_specialized_sports_team.setChecked(true);
                    break;
            }

            rb_company_infomation_nothing.setChecked(false);
            rb_company_infomation_ten_person.setChecked(false);
            rb_company_infomation_thirty_person.setChecked(false);
            rb_company_infomation_fifty_person.setChecked(false);
            rb_company_infomation_hundred_person.setChecked(false);
            rb_company_infomation_hundred_one_person.setChecked(false);
            switch (application.getUnitsInfoEntity().getReceive_people_counts()) {
                case "无":
                    rb_company_infomation_nothing.setChecked(true);
                    break;
                case "10 人以下":
                    rb_company_infomation_ten_person.setChecked(true);
                    break;
                case "11-30 人":
                    rb_company_infomation_thirty_person.setChecked(true);
                    break;
                case "31-50 人":
                    rb_company_infomation_fifty_person.setChecked(true);
                    break;
                case "50-100 人":
                    rb_company_infomation_hundred_person.setChecked(true);
                    break;
                case "101 人以上":
                    rb_company_infomation_hundred_one_person.setChecked(true);
                    break;
            }

            rb_company_infomation_nothing_day.setChecked(false);
            rb_company_infomation_ten_day.setChecked(false);
            rb_company_infomation_twenty_day.setChecked(false);
            rb_company_infomation_thirty_day.setChecked(false);
            rb_company_infomation_fifty_day.setChecked(false);
            rb_company_infomation_hunderd_day.setChecked(false);
            rb_company_infomation_two_hundred_day.setChecked(false);
            rb_company_infomation_two_hundred_one_day.setChecked(false);

            switch (application.getUnitsInfoEntity().getReceive_days()) {
                case "无":
                    rb_company_infomation_nothing_day.setChecked(true);
                    break;
                case "10 天以下":
                    rb_company_infomation_ten_day.setChecked(true);
                    break;
                case "11-20 天":
                    rb_company_infomation_twenty_day.setChecked(true);
                    break;
                case "21-30 天":
                    rb_company_infomation_thirty_day.setChecked(true);
                    break;
                case "31-50 天":
                    rb_company_infomation_fifty_day.setChecked(true);
                    break;
                case "50-100 天":
                    rb_company_infomation_hunderd_day.setChecked(true);
                    break;
                case "101-200 天":
                    rb_company_infomation_two_hundred_day.setChecked(true);
                    break;
                case "201 天以上":
                    rb_company_infomation_two_hundred_one_day.setChecked(true);
                    break;
            }
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.index_name12:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_unit_12));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.index_name13:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_unit_13));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.index_name14:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_unit_14));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
        }
    }

    @Override
    public boolean transfermsg() {
        if (rb_company_infomation_no_sports_team.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setAthlete_type(rb_company_infomation_no_sports_team.getText().toString());

        } else if (rb_company_infomation_sparetime_sports_team.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setAthlete_type(rb_company_infomation_sparetime_sports_team.getText().toString());

        } else if (rb_company_infomation_specialized_sports_team.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setAthlete_type(rb_company_infomation_specialized_sports_team.getText().toString());
        }

        if (rb_company_infomation_nothing.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setReceive_people_counts(rb_company_infomation_nothing.getText().toString());
        } else if (rb_company_infomation_ten_person.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setReceive_people_counts(rb_company_infomation_ten_person.getText().toString());
        } else if (rb_company_infomation_thirty_person.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setReceive_people_counts(rb_company_infomation_thirty_person.getText().toString());
        } else if (rb_company_infomation_fifty_person.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setReceive_people_counts(rb_company_infomation_fifty_person.getText().toString());
        } else if (rb_company_infomation_hundred_person.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setReceive_people_counts(rb_company_infomation_hundred_person.getText().toString());
        } else if (rb_company_infomation_hundred_one_person.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setReceive_people_counts(rb_company_infomation_hundred_one_person.getText().toString());
        }


        if (rb_company_infomation_nothing_day.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setReceive_days(rb_company_infomation_nothing_day.getText().toString());
        } else if (rb_company_infomation_ten_day.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setReceive_days(rb_company_infomation_ten_day.getText().toString());
        } else if (rb_company_infomation_twenty_day.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setReceive_days(rb_company_infomation_twenty_day.getText().toString());
        } else if (rb_company_infomation_thirty_day.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setReceive_days(rb_company_infomation_thirty_day.getText().toString());
        } else if (rb_company_infomation_fifty_day.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setReceive_days(rb_company_infomation_fifty_day.getText().toString());
        } else if (rb_company_infomation_hunderd_day.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setReceive_days(rb_company_infomation_hunderd_day.getText().toString());
        } else if (rb_company_infomation_two_hundred_day.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setReceive_days(rb_company_infomation_two_hundred_day.getText().toString());
        } else if (rb_company_infomation_two_hundred_one_day.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setReceive_days(rb_company_infomation_two_hundred_one_day.getText().toString());
        }

        GetUserInfo getUserInfo = new GetUserInfo(getActivity());
        Map<String, String> map = getUserInfo.getUserSp();
        CompanyInfomationActivity.INSTENT.unitsInfoEntity.setStatistics_principal(map.get("userName"));
        CompanyInfomationActivity.INSTENT.unitsInfoEntity.setFill_people(map.get("userID"));
        CompanyInfomationActivity.INSTENT.unitsInfoEntity.setFill_tel(map.get("userTel"));

        CompanyInfomationActivity.INSTENT.unitsInfoEntity.setFill_date(GetNowTime.getNowTime());
        CompanyInfomationActivity.INSTENT.unitsInfoEntity.setAudit_state(0);

        Log.v("CompanyInfomationActivity", CompanyInfomationActivity.INSTENT.unitsInfoEntity.toString());


        if (application.getUnitsInfoEntity() == null) {

            application.setUnitsInfoEntity(CompanyInfomationActivity.INSTENT.unitsInfoEntity);

            new Thread() {
                public void run() {
                    Gson gson = new Gson();
                    String string = gson.toJson(CompanyInfomationActivity.INSTENT.unitsInfoEntity);
                    HttpURLConnection_Post("api/unitsInfo", string);

                }
            }.start();
        } else {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setId(application.getUnitsInfoEntity().getId());
            application.setUnitsInfoEntity(CompanyInfomationActivity.INSTENT.unitsInfoEntity);
            new Thread() {
                public void run() {
                    Gson gson = new Gson();
                    String string = gson.toJson(CompanyInfomationActivity.INSTENT.unitsInfoEntity);
                    HttpURLConnection_Put("api/unitsInfo", string);
                }
            }.start();
        }

        return true;
    }

    @Override
    public void onCheckedChanged(CustomNestRadioGroup group, int checkedId) {

    }


    public static void HttpURLConnection_Post(String urlpost, String par) {
        try {
            URL url = new URL("http://101.200.173.175:10003/" + urlpost);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
// //设置连接属性
            httpConn.setDoOutput(true);// 使用 URL 连接进行输出
            httpConn.setDoInput(true);// 使用 URL 连接进行输入
            httpConn.setUseCaches(false);// 忽略缓存
            httpConn.setRequestMethod("POST");// 设置URL请求方法
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
                StringBuilder sb = new StringBuilder();
                String readLine;
                BufferedReader responseReader;
// 处理响应流，必须与服务器响应流输出的编码一致
                responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
                while ((readLine = responseReader.readLine()) != null) {
                    sb.append(readLine).append("\n");
                }
                responseReader.close();

                Log.v("sb.toString()", sb.toString());

                Gson gson = new Gson();

                UnitsInfoReturnEntity unitsInfoReturnEntity = gson.fromJson(sb.toString(), UnitsInfoReturnEntity.class);

                application.setUnitsID(unitsInfoReturnEntity.getId());

            } else {
                Log.v("sb.toString()", responseCode + "" + httpConn.getInputStream().toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void HttpURLConnection_Put(String urlpost, String par) {
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
                StringBuilder sb = new StringBuilder();
                String readLine;
                BufferedReader responseReader;
// 处理响应流，必须与服务器响应流输出的编码一致
                responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
                while ((readLine = responseReader.readLine()) != null) {
                    sb.append(readLine).append("\n");
                }
                responseReader.close();

                Log.v("sb.toString()", sb.toString());

                application.setUnitsID(application.getUnitsInfoEntity().getId());

            } else {
                Log.v("sb.toString()", responseCode + "" + httpConn.getInputStream().toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
