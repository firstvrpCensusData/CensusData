package com.firstvrp.censusdata.PlaceTable;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import com.firstvrp.censusdata.CompanyInformation.CompanyInfomationActivity;
import com.firstvrp.censusdata.CompanyInformation.IBtnCallListener;
import com.firstvrp.censusdata.Dialog.HelpDialog;
import com.firstvrp.censusdata.Entity.BigPlaceInfoEntity;
import com.firstvrp.censusdata.Entity.TrainItemEntity;
import com.firstvrp.censusdata.MyApplication;
import com.firstvrp.censusdata.R;

import java.util.ArrayList;
import java.util.List;
import android.widget.ImageView;

import Utils.PromptManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceSpecialProjectBiga extends Fragment implements IBtnCallListener, View.OnClickListener {

    private ImageView projectbiga_note1,projectbiga_note2;
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
        View view = inflater.inflate(R.layout.fragment_place_special_project_biga, container, false);
        place_biga_badminton = (CheckBox) view.findViewById(R.id.place_biga_badminton);
        place_biga_tennis = (CheckBox) view.findViewById(R.id.place_biga_tennis);
        place_biga_dancesport = (CheckBox) view.findViewById(R.id.place_biga_dancesport);
        place_biga_aerobics = (CheckBox) view.findViewById(R.id.place_biga_aerobics);
        place_biga_swim = (CheckBox) view.findViewById(R.id.place_biga_swim);
        place_biga_football = (CheckBox) view.findViewById(R.id.place_biga_football);
        place_biga_basketball = (CheckBox) view.findViewById(R.id.place_biga_basketball);
        place_biga_wushu = (CheckBox) view.findViewById(R.id.place_biga_wushu);
        place_biga_taekwondo = (CheckBox) view.findViewById(R.id.place_biga_taekwondo);
        place_biga_skidding = (CheckBox) view.findViewById(R.id.place_biga_skidding);
        place_biga_pingpong = (CheckBox) view.findViewById(R.id.place_biga_pingpong);
        place_biga_boxing = (CheckBox) view.findViewById(R.id.place_biga_boxing);
        place_biga_fencing = (CheckBox) view.findViewById(R.id.place_biga_fencing);
        place_biga_qigong = (CheckBox) view.findViewById(R.id.place_biga_qigong);
        place_biga_volleyball = (CheckBox) view.findViewById(R.id.place_biga_volleyball);
        place_biga_squash = (CheckBox) view.findViewById(R.id.place_biga_squash);
        place_biga_equipment = (CheckBox) view.findViewById(R.id.place_biga_equipment);
        place_biga_yoga = (CheckBox) view.findViewById(R.id.place_biga_yoga);
        place_biga_gateball = (CheckBox) view.findViewById(R.id.place_biga_gateball);
        place_biga_other = (CheckBox) view.findViewById(R.id.place_biga_other);

        open_place_area   = (EditText) view.findViewById(R.id.open_place_area);
        week_open_times  = (EditText) view.findViewById(R.id.week_open_times);
        train_quantity  = (EditText) view.findViewById(R.id.train_quantity);
        train_pcounts   = (EditText) view.findViewById(R.id.train_pcounts);
        country_event   = (EditText) view.findViewById(R.id.country_event);
        province_event  = (EditText) view.findViewById(R.id.province_event);
        culture         = (EditText) view.findViewById(R.id.culture);
        exhibition     = (EditText) view.findViewById(R.id.exhibition);
        public_interest = (EditText) view.findViewById(R.id.public_interest);
        other_activity  = (EditText) view.findViewById(R.id.other_activity);

        //帮助
        projectbiga_note1 = (ImageView) view.findViewById(R.id.projectbiga_note1);
        projectbiga_note2 = (ImageView) view.findViewById(R.id.projectbiga_note2);
        projectbiga_note1.setOnClickListener(this);
        projectbiga_note2.setOnClickListener(this);

        application = (MyApplication) getActivity().getApplication();
        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        if (application.getBigPlaceInfoEntity() != null) {
            BigPlaceInfoEntity bigPlaceInfoEntity = application.getBigPlaceInfoEntity();
            open_place_area.setText(String.valueOf(bigPlaceInfoEntity.getOpen_place_area()));
            week_open_times.setText(String.valueOf(bigPlaceInfoEntity.getWeek_open_times()));
            train_quantity.setText(String.valueOf(bigPlaceInfoEntity.getTrain_quantity()));
            train_pcounts.setText(String.valueOf(bigPlaceInfoEntity.getTrain_pcounts()));
            country_event.setText(String.valueOf(bigPlaceInfoEntity.getCountry_event()));
            province_event.setText(String.valueOf(bigPlaceInfoEntity.getProvince_event()));
            culture.setText(String.valueOf(bigPlaceInfoEntity.getCulture()));
            exhibition.setText(String.valueOf(bigPlaceInfoEntity.getExhibition()));
            public_interest.setText(String.valueOf(bigPlaceInfoEntity.getPublic_interest()));
            other_activity.setText(String.valueOf(bigPlaceInfoEntity.getOther_activity()));

            for (TrainItemEntity trainItemEntity : bigPlaceInfoEntity.getTrainItem()) {
                if (trainItemEntity.getItem_code().equals("1"))
                    place_biga_badminton.setChecked(true);
                if (trainItemEntity.getItem_code().equals("2"))
                    place_biga_tennis.setChecked(true);
                if (trainItemEntity.getItem_code().equals("3"))
                    place_biga_dancesport.setChecked(true);
                if (trainItemEntity.getItem_code().equals("4"))
                    place_biga_aerobics.setChecked(true);
                if (trainItemEntity.getItem_code().equals("5"))
                    place_biga_swim.setChecked(true);
                if (trainItemEntity.getItem_code().equals("6"))
                    place_biga_football.setChecked(true);
                if (trainItemEntity.getItem_code().equals("7"))
                    place_biga_basketball.setChecked(true);
                if (trainItemEntity.getItem_code().equals("8"))
                    place_biga_wushu.setChecked(true);
                if (trainItemEntity.getItem_code().equals("9"))
                    place_biga_taekwondo.setChecked(true);
                if (trainItemEntity.getItem_code().equals("10"))
                    place_biga_skidding.setChecked(true);
                if (trainItemEntity.getItem_code().equals("11"))
                    place_biga_pingpong.setChecked(true);
                if (trainItemEntity.getItem_code().equals("12"))
                    place_biga_boxing.setChecked(true);
                if (trainItemEntity.getItem_code().equals("13"))
                    place_biga_fencing.setChecked(true);
                if (trainItemEntity.getItem_code().equals("14"))
                    place_biga_qigong.setChecked(true);
                if (trainItemEntity.getItem_code().equals("15"))
                    place_biga_volleyball.setChecked(true);
                if (trainItemEntity.getItem_code().equals("16"))
                    place_biga_squash.setChecked(true);
                if (trainItemEntity.getItem_code().equals("17"))
                    place_biga_equipment.setChecked(true);
                if (trainItemEntity.getItem_code().equals("18"))
                    place_biga_yoga.setChecked(true);
                if (trainItemEntity.getItem_code().equals("19"))
                    place_biga_gateball.setChecked(true);
                if (trainItemEntity.getItem_code().equals("20"))
                    place_biga_other.setChecked(true);
            }
        }
    }

    List<TrainItemEntity> trainItemEntityList = new ArrayList<TrainItemEntity>();
    TrainItemEntity trainItemEntity;

    private void init() {
        if (place_biga_badminton.isChecked()) {
            trainItemEntity = new TrainItemEntity();

            trainItemEntity.setItem_code("1");
            trainItemEntity.setItem_name(place_biga_badminton.getText().toString());
            trainItemEntityList.add(trainItemEntity);
        }

        if (place_biga_tennis.isChecked()) {
            trainItemEntity = new TrainItemEntity();

            trainItemEntity.setItem_code("2");
            trainItemEntity.setItem_name(place_biga_tennis.getText().toString());
            trainItemEntityList.add(trainItemEntity);
        }

        if (place_biga_dancesport.isChecked()) {
            trainItemEntity = new TrainItemEntity();

            trainItemEntity.setItem_code("3");
            trainItemEntity.setItem_name(place_biga_dancesport.getText().toString());
            trainItemEntityList.add(trainItemEntity);
        }

        if (place_biga_aerobics.isChecked()) {
            trainItemEntity = new TrainItemEntity();

            trainItemEntity.setItem_code("4");
            trainItemEntity.setItem_name(place_biga_aerobics.getText().toString());
            trainItemEntityList.add(trainItemEntity);
        }

        if (place_biga_swim.isChecked()) {
            trainItemEntity = new TrainItemEntity();

            trainItemEntity.setItem_code("5");
            trainItemEntity.setItem_name(place_biga_swim.getText().toString());
            trainItemEntityList.add(trainItemEntity);
        }

        if (place_biga_football.isChecked()) {
            trainItemEntity = new TrainItemEntity();

            trainItemEntity.setItem_code("6");
            trainItemEntity.setItem_name(place_biga_football.getText().toString());
            trainItemEntityList.add(trainItemEntity);
        }

        if (place_biga_basketball.isChecked()) {
            trainItemEntity = new TrainItemEntity();

            trainItemEntity.setItem_code("7");
            trainItemEntity.setItem_name(place_biga_basketball.getText().toString());
            trainItemEntityList.add(trainItemEntity);
        }

        if (place_biga_wushu.isChecked()) {
            trainItemEntity = new TrainItemEntity();

            trainItemEntity.setItem_code("8");
            trainItemEntity.setItem_name(place_biga_wushu.getText().toString());
            trainItemEntityList.add(trainItemEntity);
        }

        if (place_biga_taekwondo.isChecked()) {
            trainItemEntity = new TrainItemEntity();

            trainItemEntity.setItem_code("9");
            trainItemEntity.setItem_name(place_biga_taekwondo.getText().toString());
            trainItemEntityList.add(trainItemEntity);
        }

        if (place_biga_skidding.isChecked()) {
            trainItemEntity = new TrainItemEntity();

            trainItemEntity.setItem_code("10");
            trainItemEntity.setItem_name(place_biga_skidding.getText().toString());
            trainItemEntityList.add(trainItemEntity);
        }

        if (place_biga_pingpong.isChecked()) {
            trainItemEntity = new TrainItemEntity();

            trainItemEntity.setItem_code("11");
            trainItemEntity.setItem_name(place_biga_pingpong.getText().toString());
            trainItemEntityList.add(trainItemEntity);
        }

        if (place_biga_boxing.isChecked()) {
            trainItemEntity = new TrainItemEntity();

            trainItemEntity.setItem_code("12");
            trainItemEntity.setItem_name(place_biga_boxing.getText().toString());
            trainItemEntityList.add(trainItemEntity);
        }

        if (place_biga_fencing.isChecked()) {
            trainItemEntity = new TrainItemEntity();

            trainItemEntity.setItem_code("13");
            trainItemEntity.setItem_name(place_biga_fencing.getText().toString());
            trainItemEntityList.add(trainItemEntity);
        }

        if (place_biga_qigong.isChecked()) {
            trainItemEntity = new TrainItemEntity();

            trainItemEntity.setItem_code("14");
            trainItemEntity.setItem_name(place_biga_qigong.getText().toString());
            trainItemEntityList.add(trainItemEntity);
        }

        if (place_biga_volleyball.isChecked()) {
            trainItemEntity = new TrainItemEntity();

            trainItemEntity.setItem_code("15");
            trainItemEntity.setItem_name(place_biga_volleyball.getText().toString());
            trainItemEntityList.add(trainItemEntity);
        }

        if (place_biga_squash.isChecked()) {
            trainItemEntity = new TrainItemEntity();

            trainItemEntity.setItem_code("16");
            trainItemEntity.setItem_name(place_biga_squash.getText().toString());
            trainItemEntityList.add(trainItemEntity);
        }

        if (place_biga_equipment.isChecked()) {
            trainItemEntity = new TrainItemEntity();

            trainItemEntity.setItem_code("17");
            trainItemEntity.setItem_name(place_biga_equipment.getText().toString());
            trainItemEntityList.add(trainItemEntity);
        }

        if (place_biga_yoga.isChecked()) {
            trainItemEntity = new TrainItemEntity();

            trainItemEntity.setItem_code("18");
            trainItemEntity.setItem_name(place_biga_yoga.getText().toString());
            trainItemEntityList.add(trainItemEntity);
        }

        if (place_biga_gateball.isChecked()) {
            trainItemEntity = new TrainItemEntity();

            trainItemEntity.setItem_code("19");
            trainItemEntity.setItem_name(place_biga_gateball.getText().toString());
            trainItemEntityList.add(trainItemEntity);
        }

        if (place_biga_other.isChecked()) {
            trainItemEntity = new TrainItemEntity();

            trainItemEntity.setItem_code("20");
            trainItemEntity.setItem_name(place_biga_other.getText().toString());
            trainItemEntityList.add(trainItemEntity);
        }

        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setTrainItem(trainItemEntityList);

        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setOpen_place_area(open_place_area.getText().toString());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setWeek_open_times(week_open_times.getText().toString());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setTrain_quantity(Integer.valueOf(train_quantity.getText().toString().isEmpty() ? "0" : train_quantity.getText().toString()));
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setTrain_pcounts(Integer.valueOf(train_pcounts.getText().toString().isEmpty() ? "0" : train_pcounts.getText().toString()));
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setCountry_event(Integer.valueOf(country_event.getText().toString().isEmpty() ? "0" : country_event.getText().toString()));
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setProvince_event(Integer.valueOf(province_event.getText().toString().isEmpty() ? "0" : province_event.getText().toString()));
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setCulture(Integer.valueOf(culture.getText().toString().isEmpty() ? "0" : culture.getText().toString()));
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setExhibition(Integer.valueOf(exhibition.getText().toString().isEmpty() ? "0" : exhibition.getText().toString()));
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setPublic_interest(Integer.valueOf(public_interest.getText().toString().isEmpty() ? "0" : public_interest.getText().toString()));
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setOther_activity(Integer.valueOf(other_activity.getText().toString().isEmpty() ? "0" : other_activity.getText().toString()));

    }


    private CheckBox place_biga_badminton, place_biga_tennis, place_biga_dancesport,
            place_biga_aerobics, place_biga_swim, place_biga_football,
            place_biga_basketball, place_biga_wushu, place_biga_taekwondo,
            place_biga_skidding, place_biga_pingpong, place_biga_boxing,
            place_biga_fencing, place_biga_qigong, place_biga_volleyball,
            place_biga_squash, place_biga_equipment, place_biga_yoga,
            place_biga_gateball, place_biga_other;

    private EditText open_place_area, week_open_times, train_quantity, train_pcounts,
            country_event, province_event, culture, exhibition,
            public_interest, other_activity;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public boolean transfermsg() {
        init();

        if (open_place_area.getText().toString().isEmpty()) {
            open_place_area.setText("0");
            PromptManager.showToast(getActivity(), "对外开放面积不能为空");
            return false;
        } else if (week_open_times.getText().toString().isEmpty()) {
            week_open_times.setText("0");
            PromptManager.showToast(getActivity(), "周对外开放时间不能为空");
            return false;
        } else if (train_quantity.getText().toString().isEmpty()) {
            train_quantity.setText("0");
            PromptManager.showToast(getActivity(), "全年健身培训班数量不能为空");
            return false;
        } else if (train_pcounts.getText().toString().isEmpty()) {
            train_pcounts.setText("0");
            PromptManager.showToast(getActivity(), "全年健身培训人次不能为空");
            return false;
        }else if (country_event.getText().toString().isEmpty()) {
            country_event.setText("0");
            PromptManager.showToast(getActivity(), "全国及以上体育赛事不能为空");
            return false;
        }else if (province_event.getText().toString().isEmpty()) {
            province_event.setText("0");
            PromptManager.showToast(getActivity(), "省级以下体育赛事不能为空");
            return false;
        }else if (culture.getText().toString().isEmpty()) {
            culture.setText("0");
            PromptManager.showToast(getActivity(), "文化演艺活动不能为空");
            return false;
        }else if (exhibition.getText().toString().isEmpty()) {
            exhibition.setText("0");
            PromptManager.showToast(getActivity(), "会展活动不能为空");
            return false;
        }else if (public_interest.getText().toString().isEmpty()) {
            public_interest.setText("0");
            PromptManager.showToast(getActivity(), "公益活动不能为空");
            return false;
        }else if (other_activity.getText().toString().isEmpty()) {
            other_activity.setText("0");
            PromptManager.showToast(getActivity(), "其他活动不能为空");
            return false;
        } else return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.projectbiga_note1:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_big_6));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_big_7));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_big_8));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_big_9));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_big_10));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.projectbiga_note2:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_big_11));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
        }
    }
}
