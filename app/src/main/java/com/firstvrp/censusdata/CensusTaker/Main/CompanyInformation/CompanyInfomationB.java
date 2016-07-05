package com.firstvrp.censusdata.CensusTaker.Main.CompanyInformation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.firstvrp.censusdata.CensusTaker.Main.Dialog.HelpDialog;
import com.firstvrp.censusdata.MyApplication;
import com.firstvrp.censusdata.R;

/**
 * Created with IntelliJ IDEA.
 * Author: wangjie  email:wangjie@cyyun.com
 * Date: 13-6-14
 * Time: 下午2:39
 */
public class CompanyInfomationB extends Fragment implements IBtnCallListener, View.OnClickListener {
    //    IBtnCallListener mbtnListener;

    LinearLayout crg_company_infomation_register_type;

    View view;

    MyApplication application;

    RadioButton crg_company_infomation_sports_system, crg_company_infomation_cultural_system,
            rb_company_infomation_higher_learning, rb_company_infomation_secondary,
            rb_company_infomation_primary_and_secondary,
            rb_company_infomation_other_educational_system, rb_company_infomation_other_system;
    RadioButton rb_company_infomation_central, rb_company_infomation_province,
            rb_company_infomation_city, rb_company_infomation_county,
            rb_company_infomation_street, rb_company_infomation_neighbourhood_committee,
            rb_company_infomation_other;
    RadioButton rb_company_infomation_administrative_organs, rb_company_infomation_institutions,
            rb_company_infomation_enterprise, rb_company_infomation_otherunits;
    RadioButton rb_company_infomation_state_owned_enterprises, rb_company_infomation_collective_enterprise,
            rb_company_infomation_joint_equity, rb_company_infomation_consortium,
            rb_company_infomation_limited_liability_company, rb_company_infomation_joint_stock_company,
            rb_company_infomation_private_enterprise, rb_company_infomation_other_domestic,
            rb_company_infomation_enterprises_funded, rb_company_infomation_foreign_investment_enterprise;

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.iv_company_infomation_where_the_system:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_unit_8));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.iv_company_infomation_administrative_relationship:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_unit_9));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.iv_company_infomation_unit_type:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_unit_10));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.iv_company_infomation_status_of_registration:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_unit_11));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            default:
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_company_infomation_b, container, false);
        crg_company_infomation_register_type = (LinearLayout) view.findViewById(R.id.crg_company_infomation_register_type);

        crg_company_infomation_sports_system = (RadioButton) view.findViewById(R.id.crg_company_infomation_sports_system);
        crg_company_infomation_cultural_system = (RadioButton) view.findViewById(R.id.crg_company_infomation_cultural_system);
        rb_company_infomation_higher_learning = (RadioButton) view.findViewById(R.id.rb_company_infomation_higher_learning);
        rb_company_infomation_primary_and_secondary = (RadioButton) view.findViewById(R.id.rb_company_infomation_primary_and_secondary);
        rb_company_infomation_other_educational_system = (RadioButton) view.findViewById(R.id.rb_company_infomation_other_educational_system);
        rb_company_infomation_other_system = (RadioButton) view.findViewById(R.id.rb_company_infomation_other_system);
        rb_company_infomation_secondary = (RadioButton) view.findViewById(R.id.rb_company_infomation_secondary);

        rb_company_infomation_central = (RadioButton) view.findViewById(R.id.rb_company_infomation_central);
        rb_company_infomation_province = (RadioButton) view.findViewById(R.id.rb_company_infomation_province);
        rb_company_infomation_city = (RadioButton) view.findViewById(R.id.rb_company_infomation_city);
        rb_company_infomation_county = (RadioButton) view.findViewById(R.id.rb_company_infomation_county);
        rb_company_infomation_street = (RadioButton) view.findViewById(R.id.rb_company_infomation_street);
        rb_company_infomation_neighbourhood_committee = (RadioButton) view.findViewById(R.id.rb_company_infomation_neighbourhood_committee);
        rb_company_infomation_other = (RadioButton) view.findViewById(R.id.rb_company_infomation_other);


        rb_company_infomation_administrative_organs = (RadioButton) view.findViewById(R.id.rb_company_infomation_administrative_organs);
        rb_company_infomation_institutions = (RadioButton) view.findViewById(R.id.rb_company_infomation_institutions);
        rb_company_infomation_enterprise = (RadioButton) view.findViewById(R.id.rb_company_infomation_enterprise);
        rb_company_infomation_otherunits = (RadioButton) view.findViewById(R.id.rb_company_infomation_otherunits);


        rb_company_infomation_state_owned_enterprises = (RadioButton) view.findViewById(R.id.rb_company_infomation_state_owned_enterprises);
        rb_company_infomation_collective_enterprise = (RadioButton) view.findViewById(R.id.rb_company_infomation_collective_enterprise);
        rb_company_infomation_joint_equity = (RadioButton) view.findViewById(R.id.rb_company_infomation_joint_equity);
        rb_company_infomation_consortium = (RadioButton) view.findViewById(R.id.rb_company_infomation_consortium);
        rb_company_infomation_limited_liability_company = (RadioButton) view.findViewById(R.id.rb_company_infomation_limited_liability_company);
        rb_company_infomation_joint_stock_company = (RadioButton) view.findViewById(R.id.rb_company_infomation_joint_stock_company);
        rb_company_infomation_private_enterprise = (RadioButton) view.findViewById(R.id.rb_company_infomation_private_enterprise);
        rb_company_infomation_other_domestic = (RadioButton) view.findViewById(R.id.rb_company_infomation_other_domestic);
        rb_company_infomation_enterprises_funded = (RadioButton) view.findViewById(R.id.rb_company_infomation_enterprises_funded);
        rb_company_infomation_foreign_investment_enterprise = (RadioButton) view.findViewById(R.id.rb_company_infomation_foreign_investment_enterprise);

        //帮助
        ImageView iv_company_infomation_where_the_system = (ImageView) view.findViewById(R.id.iv_company_infomation_where_the_system);
        ImageView iv_company_infomation_administrative_relationship = (ImageView) view.findViewById(R.id.iv_company_infomation_administrative_relationship);
        ImageView iv_company_infomation_unit_type = (ImageView) view.findViewById(R.id.iv_company_infomation_unit_type);
        ImageView iv_company_infomation_status_of_registration = (ImageView) view.findViewById(R.id.iv_company_infomation_status_of_registration);
        iv_company_infomation_where_the_system.setOnClickListener(this);
        iv_company_infomation_administrative_relationship.setOnClickListener(this);
        iv_company_infomation_unit_type.setOnClickListener(this);
        iv_company_infomation_status_of_registration.setOnClickListener(this);

        application = (MyApplication) getActivity().getApplication();

        init();

        return view;
    }

    private void init() {
        if (application.getUnitsInfoEntity() != null) {
            crg_company_infomation_sports_system.setChecked(false);
            crg_company_infomation_cultural_system.setChecked(false);
            rb_company_infomation_higher_learning.setChecked(false);
            rb_company_infomation_secondary.setChecked(false);
            rb_company_infomation_primary_and_secondary.setChecked(false);
            rb_company_infomation_other_educational_system.setChecked(false);
            rb_company_infomation_other_system.setChecked(false);

            if (application.getUnitsInfoEntity().getView_system() != null) {
                switch (application.getUnitsInfoEntity().getView_system()) {
                    case "体育系统":
                        crg_company_infomation_sports_system.setChecked(true);
                        break;
                    case "文化系统":
                        crg_company_infomation_cultural_system.setChecked(true);
                        break;
                    case "高等院校":
                        rb_company_infomation_higher_learning.setChecked(true);
                        break;
                    case "中专技校":
                        rb_company_infomation_secondary.setChecked(true);
                        break;
                    case "中小学":
                        rb_company_infomation_primary_and_secondary.setChecked(true);
                        break;
                    case "其他教育系统单位":
                        rb_company_infomation_other_educational_system.setChecked(true);
                        break;
                    case "其他系统":
                        rb_company_infomation_other_system.setChecked(true);
                        break;
                }
            }
            rb_company_infomation_central.setChecked(false);
            rb_company_infomation_province.setChecked(false);
            rb_company_infomation_county.setChecked(false);
            rb_company_infomation_county.setChecked(false);
            rb_company_infomation_street.setChecked(false);
            rb_company_infomation_neighbourhood_committee.setChecked(false);
            rb_company_infomation_other.setChecked(false);

            switch (application.getUnitsInfoEntity().getSubjection_relation()) {
                case "中央":
                    rb_company_infomation_central.setChecked(true);
                    break;
                case "省/自治区/直辖市":
                    rb_company_infomation_province.setChecked(true);
                    break;
                case "地区/市/州/盟":
                    rb_company_infomation_county.setChecked(true);
                    break;
                case "县/市/旗":
                    rb_company_infomation_county.setChecked(true);
                    break;
                case "街道/镇/乡":
                    rb_company_infomation_street.setChecked(true);
                    break;
                case "居民/村民委员会":
                    rb_company_infomation_neighbourhood_committee.setChecked(true);
                    break;
                case "其他":
                    rb_company_infomation_other.setChecked(true);
                    break;
            }

            rb_company_infomation_administrative_organs.setChecked(false);
            rb_company_infomation_institutions.setChecked(false);
            rb_company_infomation_enterprise.setChecked(false);
            rb_company_infomation_otherunits.setChecked(false);

            switch (application.getUnitsInfoEntity().getUnits_type()) {
                case "行政机关":
                    rb_company_infomation_administrative_organs.setChecked(true);
                    break;
                case "事业单位":
                    rb_company_infomation_institutions.setChecked(true);
                    break;
                case "企业":
                    rb_company_infomation_enterprise.setChecked(true);
                    break;
                case "其他单位":
                    rb_company_infomation_otherunits.setChecked(true);
                    break;
            }

            rb_company_infomation_state_owned_enterprises.setChecked(false);
            rb_company_infomation_collective_enterprise.setChecked(false);
            rb_company_infomation_joint_equity.setChecked(false);
            rb_company_infomation_consortium.setChecked(false);
            rb_company_infomation_joint_stock_company.setChecked(false);
            rb_company_infomation_limited_liability_company.setChecked(false);
            rb_company_infomation_joint_stock_company.setChecked(false);
            rb_company_infomation_private_enterprise.setChecked(false);
            rb_company_infomation_enterprises_funded.setChecked(false);
            rb_company_infomation_foreign_investment_enterprise.setChecked(false);
            if (application.getUnitsInfoEntity().getRegister_type() != null) {
                switch (application.getUnitsInfoEntity().getRegister_type()) {
                    case "国有企业":
                        rb_company_infomation_state_owned_enterprises.setChecked(true);
                        break;
                    case "集体企业":
                        rb_company_infomation_collective_enterprise.setChecked(true);
                        break;
                    case "股份合作企业":
                        rb_company_infomation_joint_equity.setChecked(true);
                        break;
                    case "联营企业":
                        rb_company_infomation_consortium.setChecked(true);
                        break;
                    case "有限责任公司":
                        rb_company_infomation_limited_liability_company.setChecked(true);
                        break;
                    case "股份有限公司":
                        rb_company_infomation_joint_stock_company.setChecked(true);
                        break;
                    case "私营企业":
                        rb_company_infomation_private_enterprise.setChecked(true);
                        break;
                    case "港、澳、台商投资企业":
                        rb_company_infomation_enterprises_funded.setChecked(true);
                        break;
                    case "外商投资企业":
                        rb_company_infomation_foreign_investment_enterprise.setChecked(true);
                        break;
                }
            }
        }

        rb_company_infomation_enterprise.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    crg_company_infomation_register_type.setVisibility(View.VISIBLE);
                } else {
                    crg_company_infomation_register_type.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public boolean transfermsg() {
        if (crg_company_infomation_sports_system.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setView_system(crg_company_infomation_sports_system.getText().toString());
        } else if (crg_company_infomation_cultural_system.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setView_system(crg_company_infomation_cultural_system.getText().toString());
        } else if (rb_company_infomation_higher_learning.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setView_system(rb_company_infomation_higher_learning.getText().toString());
        } else if (rb_company_infomation_primary_and_secondary.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setView_system(rb_company_infomation_primary_and_secondary.getText().toString());
        } else if (rb_company_infomation_other_educational_system.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setView_system(rb_company_infomation_other_educational_system.getText().toString());
        } else if (rb_company_infomation_other_system.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setView_system(rb_company_infomation_other_system.getText().toString());
        } else if (rb_company_infomation_secondary.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setView_system(rb_company_infomation_secondary.getText().toString());
        }

        if (rb_company_infomation_central.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setSubjection_relation(rb_company_infomation_central.getText().toString());
        } else if (rb_company_infomation_province.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setSubjection_relation(rb_company_infomation_province.getText().toString());
        } else if (rb_company_infomation_city.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setSubjection_relation(rb_company_infomation_city.getText().toString());
        } else if (rb_company_infomation_county.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setSubjection_relation(rb_company_infomation_county.getText().toString());
        } else if (rb_company_infomation_street.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setSubjection_relation(rb_company_infomation_street.getText().toString());
        } else if (rb_company_infomation_neighbourhood_committee.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setSubjection_relation(rb_company_infomation_neighbourhood_committee.getText().toString());
        } else if (rb_company_infomation_other.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setSubjection_relation(rb_company_infomation_other.getText().toString());
        }

        if (rb_company_infomation_administrative_organs.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setUnits_type(rb_company_infomation_administrative_organs.getText().toString());
        } else if (rb_company_infomation_institutions.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setUnits_type(rb_company_infomation_institutions.getText().toString());
        } else if (rb_company_infomation_enterprise.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setUnits_type(rb_company_infomation_enterprise.getText().toString());
        } else if (rb_company_infomation_otherunits.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setUnits_type(rb_company_infomation_otherunits.getText().toString());
        }


        if (rb_company_infomation_state_owned_enterprises.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setRegister_type(rb_company_infomation_state_owned_enterprises.getText().toString());
        } else if (rb_company_infomation_collective_enterprise.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setRegister_type(rb_company_infomation_collective_enterprise.getText().toString());
        } else if (rb_company_infomation_joint_equity.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setRegister_type(rb_company_infomation_joint_equity.getText().toString());
        } else if (rb_company_infomation_consortium.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setRegister_type(rb_company_infomation_consortium.getText().toString());
        } else if (rb_company_infomation_limited_liability_company.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setRegister_type(rb_company_infomation_limited_liability_company.getText().toString());
        } else if (rb_company_infomation_joint_stock_company.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setRegister_type(rb_company_infomation_joint_stock_company.getText().toString());
        } else if (rb_company_infomation_private_enterprise.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setRegister_type(rb_company_infomation_private_enterprise.getText().toString());
        } else if (rb_company_infomation_other_domestic.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setRegister_type(rb_company_infomation_other_domestic.getText().toString());
        } else if (rb_company_infomation_enterprises_funded.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setRegister_type(rb_company_infomation_enterprises_funded.getText().toString());
        } else if (rb_company_infomation_foreign_investment_enterprise.isChecked()) {
            CompanyInfomationActivity.INSTENT.unitsInfoEntity.setRegister_type(rb_company_infomation_foreign_investment_enterprise.getText().toString());
        }

        return true;
    }


}
