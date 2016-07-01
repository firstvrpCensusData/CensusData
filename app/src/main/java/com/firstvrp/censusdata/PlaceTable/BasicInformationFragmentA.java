package com.firstvrp.censusdata.PlaceTable;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.firstvrp.censusdata.CompanyInformation.CompanyInfomationActivity;
import com.firstvrp.censusdata.CompanyInformation.IBtnCallListener;
import com.firstvrp.censusdata.CustomTools.CustomNestRadioGroup;
import com.firstvrp.censusdata.Dialog.HelpDialog;
import com.firstvrp.censusdata.Entity.PlaceHomeEntity;
import com.firstvrp.censusdata.Entity.PlaceInfoEntity;
import com.firstvrp.censusdata.GetUserInfo;
import com.firstvrp.censusdata.MyApplication;
import com.firstvrp.censusdata.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Utils.GetLocation;
import Utils.PromptManager;

/**
 * 乙表公共部分表1
 */
public class BasicInformationFragmentA extends Fragment implements IBtnCallListener, View.OnClickListener {

    MyApplication application;
    private EditText basic_info_create_year, basic_info_land_area,
            basic_info_building_area, basic_info_place_area,basic_info_place_name ;
    private TextView basic_info_place_location;

    IBtnCallListener mbtnListener;

    private CheckBox basic_info_sportscentre, basic_info_trainingbase,
            basic_info_sportspark, basic_info_teensclub, basic_info_sports_school,
            basic_info_other2;

    private RadioButton basic_info_placehome, basic_info_park,
            basic_info_campus, basic_info_oredistrict,
            basic_info_enterprisehouse, basic_info_hotels,
            basic_info_residential, basic_info_villages,
            basic_info_barracks, basic_info_other;

    private ImageView fragment_a_note, fragment_a_note2, fragment_a_note3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basic_information_fragment_a, container, false);
        application = (MyApplication) getActivity().getApplication();
        basic_info_place_name = (EditText) view.findViewById(R.id.basic_info_place_name);
        basic_info_create_year = (EditText) view.findViewById(R.id.basic_info_create_year);
        basic_info_land_area = (EditText) view.findViewById(R.id.basic_info_land_area);
        basic_info_building_area = (EditText) view.findViewById(R.id.basic_info_building_area);
        basic_info_place_area = (EditText) view.findViewById(R.id.basic_info_place_area);

        basic_info_place_location = (TextView) view.findViewById(R.id.basic_info_place_location);

        basic_info_sportscentre = (CheckBox) view.findViewById(R.id.basic_info_sportscentre);
        basic_info_trainingbase = (CheckBox) view.findViewById(R.id.basic_info_trainingbase);
        basic_info_sportspark = (CheckBox) view.findViewById(R.id.basic_info_sportspark);
        basic_info_teensclub = (CheckBox) view.findViewById(R.id.basic_info_teensclub);
        basic_info_sports_school = (CheckBox) view.findViewById(R.id.basic_info_sports_school);
        basic_info_other2 = (CheckBox) view.findViewById(R.id.basic_info_other2);

        basic_info_placehome = (RadioButton) view.findViewById(R.id.basic_info_placehome);
        basic_info_park = (RadioButton) view.findViewById(R.id.basic_info_park);
        basic_info_campus = (RadioButton) view.findViewById(R.id.basic_info_campus);
        basic_info_oredistrict = (RadioButton) view.findViewById(R.id.basic_info_oredistrict);
        basic_info_enterprisehouse = (RadioButton) view.findViewById(R.id.basic_info_enterprisehouse);
        basic_info_hotels = (RadioButton) view.findViewById(R.id.basic_info_hotels);
        basic_info_residential = (RadioButton) view.findViewById(R.id.basic_info_residential);
        basic_info_villages = (RadioButton) view.findViewById(R.id.basic_info_villages);
        basic_info_barracks = (RadioButton) view.findViewById(R.id.basic_info_barracks);
        basic_info_other = (RadioButton) view.findViewById(R.id.basic_info_other);

        //帮助
        fragment_a_note = (ImageView) view.findViewById(R.id.fragment_a_note);
        fragment_a_note2 = (ImageView) view.findViewById(R.id.fragment_a_note2);
        fragment_a_note3 = (ImageView) view.findViewById(R.id.fragment_a_note3);
        fragment_a_note.setOnClickListener(this);
        fragment_a_note2.setOnClickListener(this);
        fragment_a_note3.setOnClickListener(this);

        forcingDefault();


        basic_info_place_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetLocation getLocation = new GetLocation(getActivity());
                getLocation.setFinishListener(new GetLocation.DataFinishListener() {
                    @Override
                    public void dataFinishSuccessfully(String data) {
                        basic_info_place_location.setText(data);
                    }
                });
            }
        });


        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null) {
            PlaceInfoEntity placeInfoEntity = application.getPlaceInfoEntity();

            basic_info_place_location.setText(placeInfoEntity.getCoordinate());

            basic_info_place_name.setText(placeInfoEntity.getPlace_name());
            basic_info_create_year.setText(placeInfoEntity.getCreate_year());
            basic_info_land_area.setText(placeInfoEntity.getLand_area());
            basic_info_building_area.setText(placeInfoEntity.getBuilding_area());
            basic_info_place_area.setText(placeInfoEntity.getPlace_area());

            List<PlaceHomeEntity> placeHomeEntitiesa = placeInfoEntity.getPlaceHome();
            if (placeHomeEntitiesa != null && placeHomeEntitiesa.size() > 0) {
                basic_info_sportscentre.setChecked(false);
                basic_info_trainingbase.setChecked(false);
                basic_info_sportspark.setChecked(false);
                basic_info_teensclub.setChecked(false);
                basic_info_sports_school.setChecked(false);
                basic_info_other2.setChecked(false);
                for (int i = 0; i < placeHomeEntitiesa.size(); i++) {
                    if (placeHomeEntitiesa.get(i).getIndex_code().equals("1"))
                        basic_info_sportscentre.setChecked(true);
                    if (placeHomeEntitiesa.get(i).getIndex_code().equals("2"))
                        basic_info_trainingbase.setChecked(true);
                    if (placeHomeEntitiesa.get(i).getIndex_code().equals("3"))
                        basic_info_sportspark.setChecked(true);
                    if (placeHomeEntitiesa.get(i).getIndex_code().equals("4"))
                        basic_info_teensclub.setChecked(true);
                    if (placeHomeEntitiesa.get(i).getIndex_code().equals("5"))
                        basic_info_sports_school.setChecked(true);
                    if (placeHomeEntitiesa.get(i).getIndex_code().equals("6"))
                        basic_info_other2.setChecked(true);
                }
            }
            basic_info_placehome.setChecked(false);
            basic_info_park.setChecked(false);
            basic_info_campus.setChecked(false);
            basic_info_oredistrict.setChecked(false);
            basic_info_enterprisehouse.setChecked(false);
            basic_info_hotels.setChecked(false);
            basic_info_residential.setChecked(false);
            basic_info_villages.setChecked(false);
            basic_info_barracks.setChecked(false);
            basic_info_other.setChecked(false);
            if (placeInfoEntity.getPlace_distributed().equals(basic_info_placehome.getText().toString()))
                basic_info_placehome.setChecked(true);
            if (placeInfoEntity.getPlace_distributed().equals(basic_info_park.getText().toString()))
                basic_info_placehome.setChecked(true);
            if (placeInfoEntity.getPlace_distributed().equals(basic_info_campus.getText().toString()))
                basic_info_campus.setChecked(true);
            if (placeInfoEntity.getPlace_distributed().equals(basic_info_oredistrict.getText().toString()))
                basic_info_oredistrict.setChecked(true);
            if (placeInfoEntity.getPlace_distributed().equals(basic_info_enterprisehouse.getText().toString()))
                basic_info_enterprisehouse.setChecked(true);
            if (placeInfoEntity.getPlace_distributed().equals(basic_info_hotels.getText().toString()))
                basic_info_hotels.setChecked(true);
            if (placeInfoEntity.getPlace_distributed().equals(basic_info_residential.getText().toString()))
                basic_info_residential.setChecked(true);
            if (placeInfoEntity.getPlace_distributed().equals(basic_info_villages.getText().toString()))
                basic_info_villages.setChecked(true);
            if (placeInfoEntity.getPlace_distributed().equals(basic_info_barracks.getText().toString()))
                basic_info_barracks.setChecked(true);
            if (placeInfoEntity.getPlace_distributed().equals(basic_info_other.getText().toString()))
                basic_info_other.setChecked(true);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_a_note:
                StringBuilder stringBuilder = new StringBuilder();

                stringBuilder.append(getActivity().getString(R.string.help_y1_5));
                stringBuilder.append("\r\n\n");
                stringBuilder.append(getActivity().getString(R.string.help_y1_8));
                stringBuilder.append("\r\n\n");
                stringBuilder.append(getActivity().getString(R.string.help_y1_9));
                stringBuilder.append("\r\n\n");
                stringBuilder.append(getActivity().getString(R.string.help_y1_10));
                stringBuilder.append("\r\n\n");
                stringBuilder.append(getActivity().getString(R.string.help_y1_11));
                stringBuilder.append("\r\n\n");

                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.fragment_a_note2:
                stringBuilder = new StringBuilder();

                stringBuilder.append(getActivity().getString(R.string.help_y1_6));
                stringBuilder.append("\r\n\n");

                new HelpDialog(getActivity(), stringBuilder.toString());

                break;
            case R.id.fragment_a_note3:
                stringBuilder = new StringBuilder();

                stringBuilder.append(getActivity().getString(R.string.help_y1_7));
                stringBuilder.append("\r\n\n");

                new HelpDialog(getActivity(), stringBuilder.toString());
                break;

        }
    }

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        try {
            mbtnListener = (IBtnCallListener) activity;
        } catch (Exception e) {
            // TODO: handle exception
            throw new ClassCastException(activity.toString() + "must implement mbtnListener");
        }
        super.onAttach(activity);
    }

    @Override
    public boolean transfermsg() {

        GetUserInfo getUserInfo = new GetUserInfo(getActivity());
        Map<String, String> map = getUserInfo.getUserSp();
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setStatistics_principal(map.get("userName"));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setFill_people(map.get("userID"));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setFill_tel(map.get("userTel"));

        CompanyInfomationActivity.INSTENT.placeInfoEntity.setCoordinate(basic_info_place_location.getText().toString());

        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlace_code(String.valueOf(application.getTypeID()));
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setUnits_id(application.getUnitsID());
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlace_name(basic_info_place_name.getText().toString());
        application.setPlaceName(basic_info_place_name.getText().toString());

        CompanyInfomationActivity.INSTENT.placeInfoEntity.setCreate_year(basic_info_create_year.getText().toString());
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setLand_area(basic_info_land_area.getText().toString());
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setBuilding_area(basic_info_building_area.getText().toString());
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlace_area(basic_info_place_area.getText().toString());

        PlaceHomeEntity placeHomeEntity;
        List<PlaceHomeEntity> placeHomeEntities = new ArrayList<>();
        if (basic_info_sportscentre.isChecked()) {
            placeHomeEntity = new PlaceHomeEntity();
            placeHomeEntity.setIndex_code(String.valueOf(1));
            placeHomeEntity.setIndex_name(basic_info_sportscentre.getText().toString());
            placeHomeEntities.add(placeHomeEntity);
        }
        if (basic_info_trainingbase.isChecked()) {
            placeHomeEntity = new PlaceHomeEntity();
            placeHomeEntity.setIndex_code(String.valueOf(2));
            placeHomeEntity.setIndex_name(basic_info_trainingbase.getText().toString());
            placeHomeEntities.add(placeHomeEntity);
        }
        if (basic_info_sportspark.isChecked()) {
            placeHomeEntity = new PlaceHomeEntity();
            placeHomeEntity.setIndex_code(String.valueOf(3));
            placeHomeEntity.setIndex_name(basic_info_sportspark.getText().toString());
            placeHomeEntities.add(placeHomeEntity);
        }
        if (basic_info_teensclub.isChecked()) {
            placeHomeEntity = new PlaceHomeEntity();
            placeHomeEntity.setIndex_code(String.valueOf(4));
            placeHomeEntity.setIndex_name(basic_info_teensclub.getText().toString());
            placeHomeEntities.add(placeHomeEntity);
        }
        if (basic_info_sports_school.isChecked()) {
            placeHomeEntity = new PlaceHomeEntity();
            placeHomeEntity.setIndex_code(String.valueOf(5));
            placeHomeEntity.setIndex_name(basic_info_sports_school.getText().toString());
            placeHomeEntities.add(placeHomeEntity);
        }
        if (basic_info_other2.isChecked()) {
            placeHomeEntity = new PlaceHomeEntity();
            placeHomeEntity.setIndex_code(String.valueOf(6));
            placeHomeEntity.setIndex_name(basic_info_other2.getText().toString());
            placeHomeEntities.add(placeHomeEntity);
        }
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceHome(placeHomeEntities);

        if (basic_info_placehome.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlace_distributed(basic_info_placehome.getText().toString());
        } else if (basic_info_park.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlace_distributed(basic_info_park.getText().toString());
        } else if (basic_info_campus.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlace_distributed(basic_info_campus.getText().toString());
        } else if (basic_info_oredistrict.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlace_distributed(basic_info_oredistrict.getText().toString());
        } else if (basic_info_enterprisehouse.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlace_distributed(basic_info_enterprisehouse.getText().toString());
        } else if (basic_info_hotels.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlace_distributed(basic_info_hotels.getText().toString());
        } else if (basic_info_residential.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlace_distributed(basic_info_residential.getText().toString());
        } else if (basic_info_villages.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlace_distributed(basic_info_villages.getText().toString());
        } else if (basic_info_barracks.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlace_distributed(basic_info_barracks.getText().toString());
        } else if (basic_info_other.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlace_distributed(basic_info_other.getText().toString());
        }
        if (basic_info_place_name.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "场地名称不能为空");
            return false;
        } else if (basic_info_create_year.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "建成年份不能为空");
            return false;
        } else if (basic_info_land_area.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "用地面积不能为空，没有可填0");
            return false;
        } else if (basic_info_building_area.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "建筑面积不能为空，没有可填0");
            return false;
        } else if (basic_info_place_area.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "场地面积不能为空，没有可填0");
            return false;
        } else
            return true;
    }

}
