package com.firstvrp.censusdata.CompanyInformation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.firstvrp.censusdata.AccessSelect.AccessSelectActivity;
import com.firstvrp.censusdata.Dialog.HelpDialog;
import com.firstvrp.censusdata.MyApplication;
import com.firstvrp.censusdata.R;

import Utils.PromptManager;

/**
 * 单位基本信息第一页
 */
public class CompanyInfomationA extends Fragment implements View.OnClickListener,
        IBtnCallListener {

    MyApplication application;
    IBtnCallListener mbtnListener;
    //单位名称，单位负责人，单位电话，主管部门，单位地址，区划代码
    public EditText et_company_infomation_name, et_company_infomation_head_of_unit, et_company_infomation_office_tel,
            et_company_infomation_administration, et_company_infomation_access_edit,
            et_company_infomation_area_code, et_company_infomation_zhuan, basic_info_place_organization;

    //街道选择
    public TextView tv_company_infomation_access_select;

    //指标解释
    public ImageView iv_activity_unit_info_note;

    public View view;

    @Override
    public void onAttach(Activity activity) {
        try {
            mbtnListener = (IBtnCallListener) activity;
        } catch (Exception e) {
            throw new ClassCastException(activity.toString() + "must implement mbtnListener");
        }
        super.onAttach(activity);
    }

    public static final int resultCODE = 0X11;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_company_infomation_a, container, false);

        application = (MyApplication) getActivity().getApplication();
        init();

        return view;
    }

    private void init() {
        basic_info_place_organization = (EditText) view.findViewById(R.id.basic_info_place_organization);
        et_company_infomation_name = (EditText) view.findViewById(R.id.et_company_infomation_name);
        et_company_infomation_head_of_unit = (EditText) view.findViewById(R.id.et_company_infomation_head_of_unit);

        et_company_infomation_office_tel = (EditText) view.findViewById(R.id.et_company_infomation_office_tel);
        et_company_infomation_zhuan = (EditText) view.findViewById(R.id.et_company_infomation_zhuan);

        et_company_infomation_administration = (EditText) view.findViewById(R.id.et_company_infomation_administration);
        et_company_infomation_access_edit = (EditText) view.findViewById(R.id.et_company_infomation_access_edit);
        et_company_infomation_area_code = (EditText) view.findViewById(R.id.et_company_infomation_area_code);

        tv_company_infomation_access_select = (TextView) view.findViewById(R.id.tv_company_infomation_access_select);

        iv_activity_unit_info_note = (ImageView) view.findViewById(R.id.iv_activity_unit_info_note);

        basic_info_place_organization.setText(CompanyInfomationActivity.INSTENT.unitsInfoEntity.getOrg_code() == null ? "0" : CompanyInfomationActivity.INSTENT.unitsInfoEntity.getOrg_code());

        iv_activity_unit_info_note.setOnClickListener(this);
        tv_company_infomation_access_select.setOnClickListener(this);

        if (application.getUnitsInfoEntity() != null) {
            basic_info_place_organization.setText(application.getUnitsInfoEntity().getOrg_code());
            et_company_infomation_name.setText(application.getUnitsInfoEntity().getUnits_name());
            et_company_infomation_head_of_unit.setText(application.getUnitsInfoEntity().getUnits_principal());

            if (application.getUnitsInfoEntity().getUnits_tel() != null) {
                String[] telStr = application.getUnitsInfoEntity().getUnits_tel().split("-");
                if (telStr.length > 1) {
                    et_company_infomation_office_tel.setText(telStr[0]);
                    et_company_infomation_zhuan.setText(telStr[1]);
                } else {
                    et_company_infomation_office_tel.setText(telStr[0]);
                }
            }
            et_company_infomation_administration.setText(application.getUnitsInfoEntity().getDeptname());

            String strCity = "";
            if (application.getUnitsInfoEntity().getCity_id() == 440303) strCity = "罗湖区";
            else if (application.getUnitsInfoEntity().getCity_id() == 440304) strCity = "罗湖区";
            else if (application.getUnitsInfoEntity().getCity_id() == 440305) strCity = "福田区";
            else if (application.getUnitsInfoEntity().getCity_id() == 440306) strCity = "南山区";
            else if (application.getUnitsInfoEntity().getCity_id() == 440307) strCity = "宝安区";
            else if (application.getUnitsInfoEntity().getCity_id() == 440308) strCity = "龙岗区";
            else if (application.getUnitsInfoEntity().getCity_id() == 440309) strCity = "龙华新区";
            else if (application.getUnitsInfoEntity().getCity_id() == 440310) strCity = "坪山新区";
            else if (application.getUnitsInfoEntity().getCity_id() == 440311) strCity = "光明新区";
            else if (application.getUnitsInfoEntity().getCity_id() == 440312) strCity = "大鹏新区";

            tv_company_infomation_access_select.setText(strCity +
                    application.getUnitsInfoEntity().getTownship() +
                    application.getUnitsInfoEntity().getStreet());
            et_company_infomation_access_edit.setText(application.getUnitsInfoEntity().getStreet_code());
            et_company_infomation_area_code.setText(application.getUnitsInfoEntity().getArea_code() +
                    application.getUnitsInfoEntity().getCity_code());

            String strAdd = application.getUnitsInfoEntity().getCity_id() + "," +
                    application.getUnitsInfoEntity().getTownship() + "," +
                    application.getUnitsInfoEntity().getStreet() + "," +
                    application.getUnitsInfoEntity().getArea_code() + "," +
                    application.getUnitsInfoEntity().getCity_code();

            strings = strAdd.split(",");

        }
    }


    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.unitsInfoEntity.setOrg_code(basic_info_place_organization.getText().toString());
        CompanyInfomationActivity.INSTENT.unitsInfoEntity.setUnits_name(et_company_infomation_name.getText().toString());
        CompanyInfomationActivity.INSTENT.unitsInfoEntity.setUnits_principal(et_company_infomation_head_of_unit.getText().toString());

        if (!et_company_infomation_zhuan.getText().toString().isEmpty())
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setUnits_tel(et_company_infomation_office_tel.getText().toString() + "-" + et_company_infomation_zhuan.getText().toString());
        else {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setUnits_tel(et_company_infomation_office_tel.getText().toString());
        }

        CompanyInfomationActivity.INSTENT.unitsInfoEntity.setDeptname(et_company_infomation_administration.getText().toString());
        CompanyInfomationActivity.INSTENT.unitsInfoEntity.setProvince_id(440000);
        CompanyInfomationActivity.INSTENT.unitsInfoEntity.setCity_id(440300);
        if (strings != null) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setArea_code(strings[3]);
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setCity_code(strings[4]);

            switch (strings[0]) {
                case "罗湖区":
                    CompanyInfomationActivity.INSTENT.unitsInfoEntity.setCounty_id(440303);
                    break;
                case "福田区":
                    CompanyInfomationActivity.INSTENT.unitsInfoEntity.setCounty_id(440304);
                    break;
                case "南山区":
                    CompanyInfomationActivity.INSTENT.unitsInfoEntity.setCounty_id(440305);
                    break;
                case "宝安区":
                    CompanyInfomationActivity.INSTENT.unitsInfoEntity.setCounty_id(440306);
                    break;
                case "龙岗区":
                    CompanyInfomationActivity.INSTENT.unitsInfoEntity.setCounty_id(440307);
                    break;
                case "盐田区":
                    CompanyInfomationActivity.INSTENT.unitsInfoEntity.setCounty_id(440308);
                    break;
                case "龙华新区":
                    CompanyInfomationActivity.INSTENT.unitsInfoEntity.setCounty_id(440309);
                    break;
                case "坪山新区":
                    CompanyInfomationActivity.INSTENT.unitsInfoEntity.setCounty_id(440310);
                    break;
                case "光明新区":
                    CompanyInfomationActivity.INSTENT.unitsInfoEntity.setCounty_id(440311);
                    break;
                case "大鹏新区":
                    CompanyInfomationActivity.INSTENT.unitsInfoEntity.setCounty_id(440312);
                    break;
            }

            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setTownship(strings[1]);
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setStreet(strings[2]);

        }
        CompanyInfomationActivity.INSTENT.unitsInfoEntity.setStreet_code(et_company_infomation_access_edit.getText().toString());

        System.out.println(CompanyInfomationActivity.INSTENT.unitsInfoEntity.toString());

        if (et_company_infomation_name.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "单位名称不能为空");
            return false;
        } else if (et_company_infomation_head_of_unit.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "单位负责人不能为空");
            return false;
        } else if (et_company_infomation_office_tel.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "单位电话不能为空");
            return false;
        } else if (et_company_infomation_administration.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "主管部门不能为空");
            return false;
        } else if (et_company_infomation_access_edit.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "地址补充完整");
            return false;
        } else return true;

    }

    private String[] strings;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String accessSelected;
        if (data != null) {
            accessSelected = data.getStringExtra("accessSelected");
            strings = accessSelected.split(",");
        } else {
            strings = null;
        }
        // 根据上面发送过去的请求码来区别
        switch (requestCode) {
            case resultCODE:
                tv_company_infomation_access_select.setText(strings != null ? strings[0] + strings[1] + strings[2] : "点击选择街道");

                et_company_infomation_area_code.setText(strings != null ? strings[3] + strings[4] : "");
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_company_infomation_access_select:
                startActivityForResult(new Intent(getActivity(), AccessSelectActivity.class), resultCODE);
                break;
            case R.id.iv_activity_unit_info_note:
                new HelpDialog(getActivity(), getActivity().getString(R.string.help_unit_1) + "\r\n\n" + getActivity().getString(R.string.help_unit_2) + "\r\n\n" + getActivity().getString(R.string.help_unit_3) + "\r\n\n" + getActivity().getString(R.string.help_unit_4) + "\r\n\n" + getActivity().getString(R.string.help_unit_5) + "\r\n\n" + getActivity().getString(R.string.help_unit_6) + "\r\n\n" + getActivity().getString(R.string.help_unit_7) + "\r\n\n");
                break;
        }
    }

}
