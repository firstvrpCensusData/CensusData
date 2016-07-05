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
 * A simple {@link Fragment} subclass.
 */
public class PlaceSpecialProjectBigb extends Fragment implements IBtnCallListener, View.OnClickListener {

    private EditText assets_total, be_in_debt_total, income_total, financial, career_income,
            operate_income, expenses_tatol, balance, taxes_tatol,
            fund_rate, gas_cost;

    private ImageView projectbigb_note1;
    private MyApplication application;

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
        View view = inflater.inflate(R.layout.fragment_place_special_project_bigb, container, false);
        assets_total = (EditText) view.findViewById(R.id.assets_total);
        be_in_debt_total = (EditText) view.findViewById(R.id.be_in_debt_total);
        income_total = (EditText) view.findViewById(R.id.income_total);
        financial = (EditText) view.findViewById(R.id.financial);
        career_income = (EditText) view.findViewById(R.id.career_income);
        operate_income = (EditText) view.findViewById(R.id.operate_income);
        expenses_tatol = (EditText) view.findViewById(R.id.expenses_tatol);
        balance = (EditText) view.findViewById(R.id.balance);
        taxes_tatol = (EditText) view.findViewById(R.id.taxes_tatol);
        fund_rate = (EditText) view.findViewById(R.id.fund_rate);
        gas_cost = (EditText) view.findViewById(R.id.gas_cost);
        //帮助
        projectbigb_note1 = (ImageView) view.findViewById(R.id.projectbigb_note1);
        projectbigb_note1.setOnClickListener(this);
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
            financial.setText(String.valueOf(bigPlaceInfoEntity.getFinancial()));
            career_income.setText(String.valueOf(bigPlaceInfoEntity.getCareer_income()));
            operate_income.setText(String.valueOf(bigPlaceInfoEntity.getOperate_income()));
            expenses_tatol.setText(String.valueOf(bigPlaceInfoEntity.getExpenses_tatol()));
            balance.setText(String.valueOf(bigPlaceInfoEntity.getBalance()));
            taxes_tatol.setText(String.valueOf(bigPlaceInfoEntity.getTaxes_tatol()));
            fund_rate.setText(String.valueOf(bigPlaceInfoEntity.getFund_rate()));
            gas_cost.setText(String.valueOf(bigPlaceInfoEntity.getGas_cost()));
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public boolean transfermsg() {

        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setAssets_total(assets_total.getText().toString().isEmpty() ? "0" : assets_total.getText().toString());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setBe_in_debt_total(be_in_debt_total.getText().toString().isEmpty() ? "0" : be_in_debt_total.getText().toString());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setIncome_total(income_total.getText().toString().isEmpty() ? "0" : income_total.getText().toString());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setFinancial(financial.getText().toString().isEmpty() ? "0" : financial.getText().toString());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setCareer_income(career_income.getText().toString().isEmpty() ? "0" : career_income.getText().toString());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setOperate_income(operate_income.getText().toString().isEmpty() ? "0" : operate_income.getText().toString());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setExpenses_tatol(expenses_tatol.getText().toString().isEmpty() ? "0" : expenses_tatol.getText().toString());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setBalance(balance.getText().toString().isEmpty() ? "0" : balance.getText().toString());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setTaxes_tatol(taxes_tatol.getText().toString().isEmpty() ? "0" : taxes_tatol.getText().toString());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setFund_rate(fund_rate.getText().toString().isEmpty() ? "0" : fund_rate.getText().toString());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setGas_cost(gas_cost.getText().toString());
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
            PromptManager.showToast(getActivity(), "收入合计不能为空");
            return false;
        } else if (financial.getText().toString().isEmpty()) {
            financial.setText("0");
            PromptManager.showToast(getActivity(), "财政拨款不能为空");
            return false;
        } else if (career_income.getText().toString().isEmpty()) {
            career_income.setText("0");
            PromptManager.showToast(getActivity(), "事业收入不能为空");
            return false;
        } else if (operate_income.getText().toString().isEmpty()) {
            operate_income.setText("0");
            PromptManager.showToast(getActivity(), "经营收入不能为空");
            return false;
        } else if (expenses_tatol.getText().toString().isEmpty()) {
            expenses_tatol.setText("0");
            PromptManager.showToast(getActivity(), "支出合计不能为空");
            return false;
        } else if (gas_cost.getText().toString().isEmpty()) {
            gas_cost.setText("0");
            PromptManager.showToast(getActivity(), "能源费用不能为空");
            return false;
        } else if (balance.getText().toString().isEmpty()) {
            balance.setText("0");
            PromptManager.showToast(getActivity(), "收支结余不能为空");
            return false;
        } else if (taxes_tatol.getText().toString().isEmpty()) {
            taxes_tatol.setText("0");
            PromptManager.showToast(getActivity(), "税金合计不能为空");
            return false;
        } else if (fund_rate.getText().toString().isEmpty()) {
            fund_rate.setText("0");
            PromptManager.showToast(getActivity(), "经费自给率不能为空");
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

    private void putBigPlace() {
        new Thread() {
            public void run() {
                String url = "/BigPlaceInfo";
                Gson gson = new Gson();
                String par = gson.toJson(CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity);
                TwitterRestClient.HttpURLConnection_Put(url, par);
            }
        }.start();

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.projectbigb_note1:
                new HelpDialog(getActivity(), getActivity().getString(R.string.help_big_13) + "\r\n" + getActivity().getString(R.string.help_big_14) + "\r\n" + getActivity().getString(R.string.help_big_15) + "\r\n" + getActivity().getString(R.string.help_big_16) + "\r\n" + getActivity().getString(R.string.help_big_17) + "\r\n" + getActivity().getString(R.string.help_big_18) + "\r\n" + getActivity().getString(R.string.help_big_19) + "\r\n" + getActivity().getString(R.string.help_big_20) + "\r\n" + getActivity().getString(R.string.help_big_21) + "\r\n" + getActivity().getString(R.string.help_big_22) + "\r\n" + getActivity().getString(R.string.help_big_23) + "\r\n");
                break;
        }
    }
}
