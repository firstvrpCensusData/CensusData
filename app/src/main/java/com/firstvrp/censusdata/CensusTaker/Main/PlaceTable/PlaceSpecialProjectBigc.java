package com.firstvrp.censusdata.CensusTaker.Main.PlaceTable;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.firstvrp.censusdata.CensusTaker.Main.CompanyInformation.CompanyInfomationActivity;
import com.firstvrp.censusdata.CensusTaker.Main.CompanyInformation.IBtnCallListener;
import com.firstvrp.censusdata.CensusTaker.Main.Dialog.HelpDialog;
import com.firstvrp.censusdata.Entity.BigPlaceInfoEntity;
import com.firstvrp.censusdata.Http.TwitterRestClient;
import com.firstvrp.censusdata.MyApplication;
import com.firstvrp.censusdata.R;
import com.google.gson.Gson;

import Utils.PromptManager;

/**
 * A simple {@link Fragment} subclass#
 */
public class PlaceSpecialProjectBigc extends Fragment implements IBtnCallListener, View.OnClickListener {

    private EditText assets_total, be_in_debt_total, income_total,
            cost_total, manage_cost, energy_costa, water_cost, electricity_cost,
            gas_cost, taxes_tatol, business_profit;
    private ImageView projectbigc_note1;
    MyApplication application;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_place_special_project_bigc, container, false);
        assets_total = (EditText) view.findViewById(R.id.assets_total);
        be_in_debt_total = (EditText) view.findViewById(R.id.be_in_debt_total);
        income_total = (EditText) view.findViewById(R.id.income_total);
        cost_total = (EditText) view.findViewById(R.id.cost_total);
        manage_cost = (EditText) view.findViewById(R.id.manage_cost);
        energy_costa = (EditText) view.findViewById(R.id.energy_costa);
        water_cost = (EditText) view.findViewById(R.id.water_cost);
        gas_cost = (EditText) view.findViewById(R.id.gas_cost);
        electricity_cost = (EditText) view.findViewById(R.id.electricity_cost);
        taxes_tatol = (EditText) view.findViewById(R.id.taxes_tatol);
        business_profit = (EditText) view.findViewById(R.id.business_profit);

        //帮助
        projectbigc_note1 = (ImageView) view.findViewById(R.id.projectbigc_note1);
        projectbigc_note1.setOnClickListener(this);

        application = (MyApplication) getActivity().getApplication();

        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        if (application.getBigPlaceInfoEntity() != null) {
            BigPlaceInfoEntity bigPlaceInfoEntity = application.getBigPlaceInfoEntity();
            assets_total.setText(String.valueOf(bigPlaceInfoEntity.getAssets_total()));
            be_in_debt_total.setText(String.valueOf(bigPlaceInfoEntity.getBe_in_debt_total()));
            income_total.setText(String.valueOf(bigPlaceInfoEntity.getIncome_total()));
            cost_total.setText(String.valueOf(bigPlaceInfoEntity.getCost_total()));
            manage_cost.setText(String.valueOf(bigPlaceInfoEntity.getManage_cost()));
            energy_costa.setText(String.valueOf(bigPlaceInfoEntity.getEnergy_cost()));
            water_cost.setText(String.valueOf(bigPlaceInfoEntity.getWater_cost()));
            gas_cost.setText(String.valueOf(bigPlaceInfoEntity.getGas_cost()));
            electricity_cost.setText(String.valueOf(bigPlaceInfoEntity.getElectricity_cost()));
            taxes_tatol.setText(String.valueOf(bigPlaceInfoEntity.getTaxes_tatol()));
            business_profit.setText(String.valueOf(bigPlaceInfoEntity.getBusiness_profit()));
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setAssets_total(assets_total.getText().toString());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setBe_in_debt_total(be_in_debt_total.getText().toString());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setCareer_income(income_total.getText().toString());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setCost_total(cost_total.getText().toString());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setManage_cost(manage_cost.getText().toString());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setEnergy_cost(energy_costa.getText().toString());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setWater_cost(water_cost.getText().toString());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setGas_cost(gas_cost.getText().toString());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setElectricity_cost(electricity_cost.getText().toString());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setTaxes_tatol(taxes_tatol.getText().toString());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setBusiness_profit(business_profit.getText().toString());

        if (assets_total.getText().toString().isEmpty()) {
            assets_total.setText("0");
            PromptManager.showToast(getActivity(), "资产总计不能为空");
            return false;
        } else if (be_in_debt_total.getText().toString().isEmpty()) {
            be_in_debt_total.setText("0");
            PromptManager.showToast(getActivity(), "负债合计不能为空");
            return false;
        } else if (income_total.getText().toString().isEmpty()) {
            income_total.setText("0");
            PromptManager.showToast(getActivity(), "业务收入合计不能为空");
            return false;
        } else if (cost_total.getText().toString().isEmpty()) {
            cost_total.setText("0");
            PromptManager.showToast(getActivity(), "业务成本合计不能为空");
            return false;
        } else if (manage_cost.getText().toString().isEmpty()) {
            manage_cost.setText("0");
            PromptManager.showToast(getActivity(), "管理费用不能为空");
            return false;
        } else if (energy_costa.getText().toString().isEmpty()) {
            energy_costa.setText("0");
            PromptManager.showToast(getActivity(), "能源费用不能为空");
            return false;
        } else if (water_cost.getText().toString().isEmpty()) {
            water_cost.setText("0");
            PromptManager.showToast(getActivity(), "水费不能为空");
            return false;
        } else if (electricity_cost.getText().toString().isEmpty()) {
            electricity_cost.setText("0");
            PromptManager.showToast(getActivity(), "电费不能为空");
            return false;
        } else if (gas_cost.getText().toString().isEmpty()) {
            gas_cost.setText("0");
            PromptManager.showToast(getActivity(), "燃气、热力费不能为空");
            return false;
        } else if (taxes_tatol.getText().toString().isEmpty()) {
            taxes_tatol.setText("0");
            PromptManager.showToast(getActivity(), "税金合计不能为空");
            return false;
        } else if (business_profit.getText().toString().isEmpty()) {
            business_profit.setText("0");
            PromptManager.showToast(getActivity(), "营业利润不能为空");
            return false;
        } else {

            if (application.getBigPlaceInfoEntity() == null) {
                postBigPlace();
            } else {

                CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setId(application.getBigPlaceInfoEntity().getId());
                putBigPlace();
            }


            return true;
        }
    }

    private void postBigPlace() {
        new Thread() {
            public void run() {
                String url = "/BigPlaceInfo";
                Gson gson = new Gson();
                String par = gson.toJson(CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity);
                TwitterRestClient.HttpURLConnection_Post(url, par);
            }
        }.start();

    }

    private void putBigPlace(){
        new Thread() {
            public void run() {
                String url = "/BigPlaceInfo";
                Gson gson = new Gson();
                String par = gson.toJson(CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity);
                TwitterRestClient.HttpURLConnection_Put(url, par);
            }
        }.start();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.projectbigc_note1:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_big_25));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_big_26));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_big_27));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_big_28));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_big_29));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_big_30));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_big_31));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_big_32));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_big_33));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_big_34));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
        }
    }
}
