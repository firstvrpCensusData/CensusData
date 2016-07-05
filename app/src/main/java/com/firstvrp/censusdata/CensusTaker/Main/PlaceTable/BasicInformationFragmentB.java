package com.firstvrp.censusdata.CensusTaker.Main.PlaceTable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.firstvrp.censusdata.CensusTaker.Main.CompanyInformation.CompanyInfomationActivity;
import com.firstvrp.censusdata.CensusTaker.Main.CompanyInformation.IBtnCallListener;
import com.firstvrp.censusdata.CensusTaker.Main.Dialog.HelpDialog;
import com.firstvrp.censusdata.Entity.PlaceInfoEntity;
import com.firstvrp.censusdata.Http.TwitterRestClient;
import com.firstvrp.censusdata.MyApplication;
import com.firstvrp.censusdata.R;
import com.google.gson.Gson;
import com.loopj.android.http.RequestParams;

import Utils.GetNowTime;
import Utils.PromptManager;

/**
 * 乙表公共部分表2
 */
public class BasicInformationFragmentB extends Fragment implements IBtnCallListener, View.OnClickListener {
    private EditText basic_info_investment_total, basic_info_investment_finances,
            basic_info_investment_chest, basic_info_investment_self,
            basic_info_investment_donate, basic_info_investment_other,
            basic_info_practitioners_counts, basic_info_year_open_days,
            basic_info_income_total, basic_info_expenses_total;
    private RadioButton basic_info_indepedent_operators, basic_info_cooperation,
            basic_info_operation;
    private RadioButton basic_info_five_hundred, basic_info_two_five_thousand,
            basic_info_five_thousand, basic_info_ten_thousand,
            basic_info_ten_thousand_more, basic_info_nothing;
    private RadioButton basic_info_closed, basic_info_semi_open,
            basic_info_all_day;
    private ImageView fragment_b_note1, fragment_b_note2, fragment_b_note3, fragment_b_note4, fragment_b_note5;
    private MyApplication application;
    private LinearLayout ll_people;
    public static RequestParams params;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_basic_information_fragment_b, container, false);
        ll_people = (LinearLayout) view.findViewById(R.id.ll_people);
        basic_info_investment_total = (EditText) view.findViewById(R.id.basic_info_investment_total);
        basic_info_investment_finances = (EditText) view.findViewById(R.id.basic_info_investment_finances);
        basic_info_investment_chest = (EditText) view.findViewById(R.id.basic_info_investment_chest);
        basic_info_investment_self = (EditText) view.findViewById(R.id.basic_info_investment_self);
        basic_info_investment_donate = (EditText) view.findViewById(R.id.basic_info_investment_donate);
        basic_info_investment_other = (EditText) view.findViewById(R.id.basic_info_investment_other);
        basic_info_practitioners_counts = (EditText) view.findViewById(R.id.basic_info_practitioners_counts);
        basic_info_year_open_days = (EditText) view.findViewById(R.id.basic_info_year_open_days);
        basic_info_income_total = (EditText) view.findViewById(R.id.basic_info_income_total);
        basic_info_expenses_total = (EditText) view.findViewById(R.id.basic_info_expenses_total);

        basic_info_indepedent_operators = (RadioButton) view.findViewById(R.id.basic_info_indepedent_operators);
        basic_info_cooperation = (RadioButton) view.findViewById(R.id.basic_info_cooperation);
        basic_info_operation = (RadioButton) view.findViewById(R.id.basic_info_operation);

        basic_info_five_hundred = (RadioButton) view.findViewById(R.id.basic_info_five_hundred);
        basic_info_two_five_thousand = (RadioButton) view.findViewById(R.id.basic_info_two_five_thousand);
        basic_info_five_thousand = (RadioButton) view.findViewById(R.id.basic_info_five_thousand);
        basic_info_ten_thousand = (RadioButton) view.findViewById(R.id.basic_info_ten_thousand);
        basic_info_ten_thousand_more = (RadioButton) view.findViewById(R.id.basic_info_ten_thousand_more);
        basic_info_nothing = (RadioButton) view.findViewById(R.id.basic_info_nothing);

        basic_info_closed = (RadioButton) view.findViewById(R.id.basic_info_closed);
        basic_info_semi_open = (RadioButton) view.findViewById(R.id.basic_info_semi_open);
        basic_info_all_day = (RadioButton) view.findViewById(R.id.basic_info_all_day);

        //帮助
        fragment_b_note1 = (ImageView) view.findViewById(R.id.fragment_b_note1);
        fragment_b_note2 = (ImageView) view.findViewById(R.id.fragment_b_note2);
        fragment_b_note3 = (ImageView) view.findViewById(R.id.fragment_b_note3);
        fragment_b_note4 = (ImageView) view.findViewById(R.id.fragment_b_note4);
        fragment_b_note5 = (ImageView) view.findViewById(R.id.fragment_b_note5);
        fragment_b_note1.setOnClickListener(this);
        fragment_b_note2.setOnClickListener(this);
        fragment_b_note3.setOnClickListener(this);
        fragment_b_note4.setOnClickListener(this);
        fragment_b_note5.setOnClickListener(this);

        basic_info_closed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ll_people.setVisibility(View.GONE);
                } else {
                    ll_people.setVisibility(View.VISIBLE);
                }
            }
        });

        application = (MyApplication) getActivity().getApplication();


        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        basic_info_investment_finances.addTextChangedListener(textWatcher);
        basic_info_investment_self.addTextChangedListener(textWatcher);
        basic_info_investment_donate.addTextChangedListener(textWatcher);
        basic_info_investment_other.addTextChangedListener(textWatcher);

        if (application.getPlaceInfoEntity() != null) {
            PlaceInfoEntity placeInfoEntity = application.getPlaceInfoEntity();
            basic_info_investment_total.setText(placeInfoEntity.getInvestment_total());
            basic_info_investment_finances.setText(placeInfoEntity.getInvestment_finances());
            basic_info_investment_chest.setText(placeInfoEntity.getInvestment_chest());
            basic_info_investment_self.setText(placeInfoEntity.getInvestment_self());
            basic_info_investment_donate.setText(placeInfoEntity.getInvestment_donate());
            basic_info_investment_other.setText(placeInfoEntity.getInvestment_other());
            basic_info_practitioners_counts.setText(String.valueOf(placeInfoEntity.getPractitioners_counts()));
            basic_info_year_open_days.setText(String.valueOf(placeInfoEntity.getYear_open_days()));
            basic_info_income_total.setText(placeInfoEntity.getIncome_total());
            basic_info_expenses_total.setText(placeInfoEntity.getExpenses_total());

            basic_info_indepedent_operators.setChecked(false);
            basic_info_cooperation.setChecked(false);
            basic_info_operation.setChecked(false);
            if (placeInfoEntity.getOperations_mode().equals(basic_info_indepedent_operators.getText().toString()))
                basic_info_indepedent_operators.setChecked(true);
            else if (placeInfoEntity.getOperations_mode().equals(basic_info_cooperation.getText().toString()))
                basic_info_cooperation.setChecked(true);
            else if (placeInfoEntity.getOperations_mode().equals(basic_info_operation.getText().toString()))
                basic_info_operation.setChecked(true);

            basic_info_five_hundred.setChecked(false);
            basic_info_two_five_thousand.setChecked(false);
            basic_info_five_thousand.setChecked(false);
            basic_info_ten_thousand.setChecked(false);
            basic_info_ten_thousand_more.setChecked(false);
            basic_info_nothing.setChecked(false);
            if (placeInfoEntity.getWeek_reception_pcounts().equals(basic_info_five_hundred.getText().toString()))
                basic_info_five_hundred.setChecked(true);
            else if (placeInfoEntity.getWeek_reception_pcounts().equals(basic_info_two_five_thousand.getText().toString()))
                basic_info_two_five_thousand.setChecked(true);
            else if (placeInfoEntity.getWeek_reception_pcounts().equals(basic_info_five_thousand.getText().toString()))
                basic_info_five_thousand.setChecked(true);
            else if (placeInfoEntity.getWeek_reception_pcounts().equals(basic_info_ten_thousand.getText().toString()))
                basic_info_ten_thousand.setChecked(true);
            else if (placeInfoEntity.getWeek_reception_pcounts().equals(basic_info_ten_thousand_more.getText().toString()))
                basic_info_ten_thousand_more.setChecked(true);
            else if (placeInfoEntity.getWeek_reception_pcounts().equals(basic_info_nothing.getText().toString()))
                basic_info_nothing.setChecked(true);

            basic_info_closed.setChecked(false);
            basic_info_semi_open.setChecked(false);
            basic_info_all_day.setChecked(false);
            if (placeInfoEntity.getOpen_situation().equals(basic_info_closed.getText().toString()))
                basic_info_closed.setChecked(true);
            else if (placeInfoEntity.getOpen_situation().equals(basic_info_semi_open.getText().toString()))
                basic_info_semi_open.setChecked(true);
            else if (placeInfoEntity.getOpen_situation().equals(basic_info_all_day.getText().toString()))
                basic_info_all_day.setChecked(true);
        }
    }

    private TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
         int  investment_finances = Integer.parseInt(basic_info_investment_finances.getText().toString().isEmpty() ? "0" : basic_info_investment_finances.getText().toString());
            int investment_chest = Integer.parseInt(basic_info_investment_chest.getText().toString().isEmpty() ? "0" : basic_info_investment_chest.getText().toString());
         int  investment_self = Integer.parseInt(basic_info_investment_self.getText().toString().isEmpty() ? "0" : basic_info_investment_self.getText().toString());
         int  investment_donate = Integer.parseInt(basic_info_investment_donate.getText().toString().isEmpty() ? "0" : basic_info_investment_donate.getText().toString());
         int  investment_other = Integer.parseInt(basic_info_investment_other.getText().toString().isEmpty() ? "0" : basic_info_investment_other.getText().toString());

            basic_info_investment_total.setText(String.valueOf(investment_finances + investment_self + investment_donate + investment_other));

            if (investment_chest>investment_finances){
                PromptManager.showToast(getActivity(),"体彩公益金，应小于财政拨款");
            }
        }
    };

    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setFill_date(GetNowTime.getNowTime());
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setInvestment_total(basic_info_investment_total.getText().toString());
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setInvestment_finances(basic_info_investment_finances.getText().toString());
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setInvestment_chest(basic_info_investment_chest.getText().toString());
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setInvestment_self(basic_info_investment_self.getText().toString());
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setInvestment_donate(basic_info_investment_donate.getText().toString());
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setInvestment_other(basic_info_investment_other.getText().toString());
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPractitioners_counts(Integer.valueOf(String.valueOf(basic_info_practitioners_counts.getText().toString().equals("") ? 0 : basic_info_practitioners_counts.getText().toString())));
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setYear_open_days(Integer.valueOf(String.valueOf(basic_info_year_open_days.getText().toString().equals("") ? 0 : basic_info_year_open_days.getText().toString())));
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setIncome_total(basic_info_income_total.getText().toString());
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setExpenses_total(basic_info_expenses_total.getText().toString());

        if (basic_info_indepedent_operators.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setOperations_mode(basic_info_indepedent_operators.getText().toString());
        } else if (basic_info_cooperation.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setOperations_mode(basic_info_cooperation.getText().toString());
        } else if (basic_info_operation.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setOperations_mode(basic_info_operation.getText().toString());
        }

        if (basic_info_five_hundred.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setWeek_reception_pcounts(basic_info_five_hundred.getText().toString());
        } else if (basic_info_two_five_thousand.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setWeek_reception_pcounts(basic_info_two_five_thousand.getText().toString());
        } else if (basic_info_five_thousand.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setWeek_reception_pcounts(basic_info_five_thousand.getText().toString());
        } else if (basic_info_ten_thousand.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setWeek_reception_pcounts(basic_info_ten_thousand.getText().toString());
        } else if (basic_info_ten_thousand_more.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setWeek_reception_pcounts(basic_info_ten_thousand_more.getText().toString());
        } else if (basic_info_nothing.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setWeek_reception_pcounts(basic_info_nothing.getText().toString());
        }

        if (basic_info_closed.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setOpen_situation(basic_info_closed.getText().toString());
        } else if (basic_info_semi_open.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setOpen_situation(basic_info_semi_open.getText().toString());
        } else if (basic_info_all_day.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setOpen_situation(basic_info_all_day.getText().toString());
        }

        if (basic_info_investment_finances.getText().toString().isEmpty()) {
            basic_info_investment_finances.setText("0");
            PromptManager.showToast(getActivity(), "财政拨款不能为空，没有可填0");
            return false;
        } else if (basic_info_investment_chest.getText().toString().isEmpty()) {
            basic_info_investment_chest.setText("0");
            PromptManager.showToast(getActivity(), "财政拨款不能为空，没有可填0");
            return false;
        } else if (basic_info_investment_self.getText().toString().isEmpty()) {
            basic_info_investment_self.setText("0");
            PromptManager.showToast(getActivity(), "财政拨款不能为空，没有可填0");
            return false;
        } else if (basic_info_investment_donate.getText().toString().isEmpty()) {
            basic_info_investment_donate.setText("0");
            PromptManager.showToast(getActivity(), "财政拨款不能为空，没有可填0");
            return false;
        } else if (basic_info_investment_other.getText().toString().isEmpty()) {
            basic_info_investment_other.setText("0");
            PromptManager.showToast(getActivity(), "财政拨款不能为空，没有可填0");
            return false;
        } else if (basic_info_practitioners_counts.getText().toString().isEmpty()) {
            basic_info_practitioners_counts.setText("0");
            PromptManager.showToast(getActivity(), "从业人员人数不能为空，没有可填0");
            return false;
        } else if (basic_info_year_open_days.getText().toString().isEmpty()) {
            basic_info_year_open_days.setText("0");
            PromptManager.showToast(getActivity(), "年开放天数不能为空，没有可填0");
            return false;
        } else if (basic_info_income_total.getText().toString().isEmpty()) {
            basic_info_income_total.setText("0");
            PromptManager.showToast(getActivity(), "收入合计不能为空，没有可填0");
            return false;
        } else if (basic_info_expenses_total.getText().toString().isEmpty()) {
            basic_info_expenses_total.setText("0");
            PromptManager.showToast(getActivity(), "支出合计不能为空，没有可填0");
            return false;
        } else
            return true;
    }

    public static void postPlaceSpecia() {
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setAudit_state(0);

        final String url = "api/PlaceInfo";
        new Thread() {
            public void run() {
                Gson gson = new Gson();
                String string = gson.toJson(CompanyInfomationActivity.INSTENT.placeInfoEntity);
                Log.v("api_placeinfo_string", string);
                TwitterRestClient.HttpURLConnection_Post(url, string);
            }
        }.start();
    }

    public static void putUpDataPlaceSpecia(){
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setAudit_state(0);

        final String url = "api/PlaceInfo";
        new Thread() {
            public void run() {
                Gson gson = new Gson();
                String string = gson.toJson(CompanyInfomationActivity.INSTENT.placeInfoEntity);
                Log.v("put_placeinfo_string", string);
                TwitterRestClient.HttpURLConnection_Put(url, string);
            }
        }.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_b_note1:
                StringBuilder stringBuilder = new StringBuilder();

                stringBuilder.append(getActivity().getString(R.string.help_y1_12));
                stringBuilder.append("\r\n\n");

                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.fragment_b_note2:
                stringBuilder = new StringBuilder();

                stringBuilder.append(getActivity().getString(R.string.help_y1_13));
                stringBuilder.append("\r\n\n");
                stringBuilder.append(getActivity().getString(R.string.help_y1_20));
                stringBuilder.append("\r\n\n");
                stringBuilder.append(getActivity().getString(R.string.help_y1_22));
                stringBuilder.append("\r\n\n");
                stringBuilder.append(getActivity().getString(R.string.help_y1_23));
                stringBuilder.append("\r\n\n");

                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.fragment_b_note3:
                stringBuilder = new StringBuilder();

                stringBuilder.append(getActivity().getString(R.string.help_y1_14));
                stringBuilder.append("\r\n\n");
                stringBuilder.append(getActivity().getString(R.string.help_y1_15));
                stringBuilder.append("\r\n\n");
                stringBuilder.append(getActivity().getString(R.string.help_y1_16));
                stringBuilder.append("\r\n\n");

                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.fragment_b_note4:
                stringBuilder = new StringBuilder();

                stringBuilder.append(getActivity().getString(R.string.help_y1_21));
                stringBuilder.append("\r\n\n");

                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.fragment_b_note5:
                stringBuilder = new StringBuilder();

                stringBuilder.append(getActivity().getString(R.string.help_y1_17));
                stringBuilder.append("\r\n\n");
                stringBuilder.append(getActivity().getString(R.string.help_y1_18));
                stringBuilder.append("\r\n\n");
                stringBuilder.append(getActivity().getString(R.string.help_y1_19));
                stringBuilder.append("\r\n\n");

                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
        }
    }
}
