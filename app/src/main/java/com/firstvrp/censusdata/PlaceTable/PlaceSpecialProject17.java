package com.firstvrp.censusdata.PlaceTable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;

import com.firstvrp.censusdata.CompanyInformation.CompanyInfomationActivity;
import com.firstvrp.censusdata.CompanyInformation.IBtnCallListener;
import com.firstvrp.censusdata.Entity.PlaceSpecialIndexEntity;
import com.firstvrp.censusdata.MyApplication;
import com.firstvrp.censusdata.R;

import Utils.PromptManager;

/**
 *
 */
public class PlaceSpecialProject17 extends Fragment implements IBtnCallListener {
    private EditText project17_funpool_area, project17_viewers_seats, project17_functionroom_area,
            project17_enter_deep, project17_enter_width, project17_enter_height,
            project17_rirections;

    private RadioButton project17_updorp_station_y, project17_updorp_station_n,
            project17_light_device_y, project17_light_device_n,
            project17_makeup_room_y, project17_makeup_room_n,
            project17_rest_room_y, project17_rest_room_n,
            project17_reataurant_y, project17_reataurant_n,
            project17_recording_room_y, project17_recording_room_n;


    private MyApplication application;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_place_special_project17, container, false);
        project17_funpool_area      = (EditText) view.findViewById(R.id.project17_funpool_area);
        project17_viewers_seats     = (EditText) view.findViewById(R.id.project17_viewers_seats);
        project17_functionroom_area = (EditText) view.findViewById(R.id.project17_functionroom_area);
        project17_enter_deep        = (EditText) view.findViewById(R.id.project17_enter_deep);
        project17_enter_width       = (EditText) view.findViewById(R.id.project17_enter_width);
        project17_enter_height      = (EditText) view.findViewById(R.id.project17_enter_height);
        project17_rirections        = (EditText) view.findViewById(R.id.project17_rirections);

        project17_updorp_station_y = (RadioButton) view.findViewById(R.id.project17_updorp_station_y);
        project17_updorp_station_n = (RadioButton) view.findViewById(R.id.project17_updorp_station_n);

        project17_light_device_y = (RadioButton) view.findViewById(R.id.project17_light_device_y);
        project17_light_device_n = (RadioButton) view.findViewById(R.id.project17_light_device_n);

        project17_makeup_room_y = (RadioButton) view.findViewById(R.id.project17_makeup_room_y);
        project17_makeup_room_n = (RadioButton) view.findViewById(R.id.project17_makeup_room_n);

        project17_rest_room_y = (RadioButton) view.findViewById(R.id.project17_rest_room_y);
        project17_rest_room_n = (RadioButton) view.findViewById(R.id.project17_rest_room_n);

        project17_reataurant_y = (RadioButton) view.findViewById(R.id.project17_reataurant_y);
        project17_reataurant_n = (RadioButton) view.findViewById(R.id.project17_reataurant_n);

        project17_recording_room_y = (RadioButton) view.findViewById(R.id.project17_recording_room_y);
        project17_recording_room_n = (RadioButton) view.findViewById(R.id.project17_recording_room_n);

        application = (MyApplication) getActivity().getApplication();
        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null && application.getPlaceInfoEntity().getPlaceSpecialIndex() != null) {
            PlaceSpecialIndexEntity placeSpecialIndexEntity = application.getPlaceInfoEntity().getPlaceSpecialIndex();
            project17_funpool_area.setText(String.valueOf(placeSpecialIndexEntity.getFunpool_area()));
            project17_viewers_seats.setText(String.valueOf(placeSpecialIndexEntity.getViewers_seats()));
            project17_functionroom_area.setText(String.valueOf(placeSpecialIndexEntity.getFunctionroom_area()));
            project17_enter_deep.setText(String.valueOf(placeSpecialIndexEntity.getEnter_deep()));
            project17_enter_width.setText(String.valueOf(placeSpecialIndexEntity.getEnter_width()));
            project17_enter_height.setText(String.valueOf(placeSpecialIndexEntity.getEnter_high()));
            project17_rirections.setText(String.valueOf(placeSpecialIndexEntity.getRirections()));

            project17_updorp_station_y.setChecked(false);
            project17_updorp_station_n.setChecked(false);
            if (placeSpecialIndexEntity.getUpdrop_station() == 1)
                project17_updorp_station_y.setChecked(true);
            else if (placeSpecialIndexEntity.getUpdrop_station() == 2)
                project17_updorp_station_n.setChecked(true);

            project17_light_device_y.setChecked(false);
            project17_light_device_n.setChecked(false);
            if (placeSpecialIndexEntity.getLight_device() == 1)
                project17_light_device_y.setChecked(true);
            else if (placeSpecialIndexEntity.getLight_device() == 2)
                project17_light_device_n.setChecked(true);

            project17_makeup_room_y.setChecked(false);
            project17_makeup_room_n.setChecked(false);
            if (placeSpecialIndexEntity.getMakeup_room() == 1)
                project17_makeup_room_y.setChecked(true);
            else if (placeSpecialIndexEntity.getMakeup_room() == 2)
                project17_makeup_room_n.setChecked(true);

            project17_rest_room_y.setChecked(false);
            project17_rest_room_n.setChecked(false);
            if (placeSpecialIndexEntity.getRest_room() == 1)
                project17_rest_room_y.setChecked(true);
            else if (placeSpecialIndexEntity.getRest_room() == 2)
                project17_rest_room_n.setChecked(true);

            project17_reataurant_y.setChecked(false);
            project17_reataurant_n.setChecked(false);
            if (placeSpecialIndexEntity.getRestaurant() == 1)
                project17_reataurant_y.setChecked(true);
            else if (placeSpecialIndexEntity.getRestaurant() == 2)
                project17_reataurant_n.setChecked(true);

            project17_recording_room_y.setChecked(false);
            project17_recording_room_n.setChecked(false);
            if (placeSpecialIndexEntity.getRecording_room() == 1)
                project17_recording_room_y.setChecked(true);
            else if (placeSpecialIndexEntity.getRecording_room() == 2)
                project17_recording_room_n.setChecked(true);
        }
    }

    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setFunpool_area(project17_funpool_area.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setViewers_seats(Integer.valueOf(project17_viewers_seats.getText().toString().isEmpty() ? "0" : project17_viewers_seats.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setFunctionroom_area(project17_functionroom_area.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setEnter_deep(project17_enter_deep.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setEnter_width(project17_enter_width.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setEnter_high(project17_enter_height.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setRirections(project17_rirections.getText().toString());

        if (project17_updorp_station_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setUpdrop_station(1);
        } else if (project17_updorp_station_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setUpdrop_station(2);
        }
        if (project17_light_device_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setLight_device(1);
        } else if (project17_light_device_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setLight_device(2);
        }
        if (project17_makeup_room_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setMakeup_room(1);
        } else if (project17_makeup_room_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setMakeup_room(2);
        }
        if (project17_rest_room_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setRest_room(1);
        } else if (project17_rest_room_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setRest_room(2);
        }
        if (project17_reataurant_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setRestaurant(1);
        } else if (project17_reataurant_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setRestaurant(2);
        }
        if (project17_recording_room_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setRecording_room(1);
        } else if (project17_recording_room_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setRecording_room(2);
        }


        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);
        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia();  }
//        project17_funpool_area
//                project17_viewers_seats
//        project17_functionroom_area
//                project17_enter_deep
//        project17_enter_width
//                project17_enter_height
//        project17_rirections

        if (project17_funpool_area.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "乐池面积不能为空");
            return false;
        }else if (project17_viewers_seats.getText().toString().isEmpty()){
            PromptManager.showToast(getActivity(), "观众席位不能为空");
            return false;
        }else if (project17_functionroom_area.getText().toString().isEmpty()){
            PromptManager.showToast(getActivity(), "多功能厅面积不能为空");
            return false;
        }else if (project17_enter_deep.getText().toString().isEmpty()){
            PromptManager.showToast(getActivity(), "舞台总进深不能为空");
            return false;
        }else if (project17_enter_width.getText().toString().isEmpty()){
            PromptManager.showToast(getActivity(), "舞台总进深不能为空");
            return false;
        }else if (project17_enter_height.getText().toString().isEmpty()){
            PromptManager.showToast(getActivity(), "舞台总进深不能为空");
            return false;
        } else return true;
    }
}
