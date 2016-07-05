package com.firstvrp.censusdata.CensusTaker.Main.PlaceTable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;

import com.firstvrp.censusdata.CensusTaker.Main.CompanyInformation.CompanyInfomationActivity;
import com.firstvrp.censusdata.CensusTaker.Main.CompanyInformation.IBtnCallListener;
import com.firstvrp.censusdata.Entity.PlaceSpecialIndexEntity;
import com.firstvrp.censusdata.MyApplication;
import com.firstvrp.censusdata.R;

import Utils.PromptManager;

/**
 *
 */
public class PlaceSpecialProject18 extends Fragment implements IBtnCallListener {
    private EditText project_display_room, project18_hall,
            project18_show_room, building_high,
            project18_rirections;

    private RadioButton project18_report_room_y, project18_report_room_n,
            project18_art_classroom_y, project18_art_classroom_n,
            project18_function_room_y, project18_function_room_n,
            project18_meeting_room_y, project18_meeting_room_n,
            project18_books_room_y, project18_books_room_n,
            project18_device_room_y, project18_device_room_n,
            project18_store_room_y, project18_store_room_n;

    private MyApplication application;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_place_special_project18, container, false);
        project_display_room = (EditText) view.findViewById(R.id.project_display_room);
        project18_hall = (EditText) view.findViewById(R.id.project18_hall);
        project18_show_room = (EditText) view.findViewById(R.id.project18_show_room);
        building_high = (EditText) view.findViewById(R.id.building_high);
        project18_rirections = (EditText) view.findViewById(R.id.project18_rerections);

        project18_report_room_y = (RadioButton) view.findViewById(R.id.project18_report_room_y);
        project18_report_room_n = (RadioButton) view.findViewById(R.id.project18_report_room_n);

        project18_art_classroom_y = (RadioButton) view.findViewById(R.id.project18_art_classroom_y);
        project18_art_classroom_n = (RadioButton) view.findViewById(R.id.project18_art_classroom_n);

        project18_function_room_y = (RadioButton) view.findViewById(R.id.project18_function_room_y);
        project18_function_room_n = (RadioButton) view.findViewById(R.id.project18_function_room_n);

        project18_meeting_room_y = (RadioButton) view.findViewById(R.id.project18_meeting_room_y);
        project18_meeting_room_n = (RadioButton) view.findViewById(R.id.project18_meeting_room_n);

        project18_books_room_y = (RadioButton) view.findViewById(R.id.project18_books_room_y);
        project18_books_room_n = (RadioButton) view.findViewById(R.id.project18_books_room_n);

        project18_device_room_y = (RadioButton) view.findViewById(R.id.project18_device_room_y);
        project18_device_room_n = (RadioButton) view.findViewById(R.id.project18_device_room_n);

        project18_store_room_y = (RadioButton) view.findViewById(R.id.project18_store_room_y);
        project18_store_room_n = (RadioButton) view.findViewById(R.id.project18_store_room_n);


        application = (MyApplication) getActivity().getApplication();
        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null && application.getPlaceInfoEntity().getPlaceSpecialIndex() != null) {
            PlaceSpecialIndexEntity placeSpecialIndexEntity = application.getPlaceInfoEntity().getPlaceSpecialIndex();
            project_display_room.setText(String.valueOf(placeSpecialIndexEntity.getDisplay_room()));
            project18_hall.setText(String.valueOf(placeSpecialIndexEntity.getHall()));
            project18_show_room.setText(String.valueOf(placeSpecialIndexEntity.getShow_room()));
            building_high.setText(String.valueOf(placeSpecialIndexEntity.getBuilding_high()));
            project18_rirections.setText(String.valueOf(placeSpecialIndexEntity.getRirections()));

            project18_report_room_y.setChecked(false);
            project18_report_room_n.setChecked(false);
            if (placeSpecialIndexEntity.getReport_room() == 1)
                project18_report_room_y.setChecked(true);
            else if (placeSpecialIndexEntity.getReport_room() == 2)
                project18_report_room_n.setChecked(true);

            project18_art_classroom_y.setChecked(false);
            project18_art_classroom_n.setChecked(false);
            if (placeSpecialIndexEntity.getArt_classroom() == 1)
                project18_art_classroom_y.setChecked(true);
            else if (placeSpecialIndexEntity.getArt_classroom() == 2)
                project18_art_classroom_n.setChecked(true);

            project18_function_room_y.setChecked(false);
            project18_function_room_n.setChecked(false);
            if (placeSpecialIndexEntity.getFunction_room() == 1)
                project18_function_room_y.setChecked(true);
            else if (placeSpecialIndexEntity.getFunction_room() == 2)
                project18_function_room_n.setChecked(true);

            project18_meeting_room_y.setChecked(false);
            project18_meeting_room_n.setChecked(false);
            if (placeSpecialIndexEntity.getMeeting_room() == 1)
                project18_meeting_room_y.setChecked(true);
            else if (placeSpecialIndexEntity.getMakeup_room() == 2)
                project18_meeting_room_n.setChecked(true);

            project18_books_room_y.setChecked(false);
            project18_books_room_n.setChecked(false);
            if (placeSpecialIndexEntity.getBooks_room() == 1)
                project18_books_room_y.setChecked(true);
            else if (placeSpecialIndexEntity.getBooks_room() == 2)
                project18_books_room_n.setChecked(true);

            project18_device_room_y.setChecked(false);
            project18_device_room_n.setChecked(false);
            if (placeSpecialIndexEntity.getDevice_room() == 1)
                project18_device_room_y.setChecked(true);
            else if (placeSpecialIndexEntity.getDevice_room() == 2)
                project18_device_room_n.setChecked(true);

            project18_store_room_y.setChecked(false);
            project18_store_room_n.setChecked(false);
            if (placeSpecialIndexEntity.getStore_room() == 1)
                project18_store_room_y.setChecked(true);
            else if (placeSpecialIndexEntity.getStore_room() == 2)
                project18_store_room_n.setChecked(true);

        }
    }

    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setDisplay_room(project_display_room.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setHall(project18_hall.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setShow_room(project18_show_room.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setBuilding_high(building_high.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setRirections(project18_rirections.getText().toString());

        if (project18_report_room_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setReport_room(1);
        } else if (project18_report_room_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setReport_room(2);
        }
        if (project18_art_classroom_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setArt_classroom(1);
        } else if (project18_art_classroom_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setArt_classroom(2);
        }
        if (project18_function_room_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setFunction_room(1);
        } else if (project18_function_room_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setFunction_room(2);
        }
        if (project18_meeting_room_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setMeeting_room(1);
        } else if (project18_meeting_room_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setMeeting_room(2);
        }
        if (project18_books_room_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setBooks_room(1);
        } else if (project18_books_room_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setBooks_room(2);
        }
        if (project18_device_room_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setDevice_room(1);
        } else if (project18_device_room_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setDevice_room(2);
        }
        if (project18_store_room_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setStore_room(1);
        } else if (project18_store_room_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setStore_room(2);
        }

        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);
        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia(); }

//        project_display_room
//                project18_hall
//        project18_show_room
//                building_high
//        project18_rirections
        if (project_display_room.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "大厅面积不能为空");
            return false;
        } else if (project18_hall.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "展厅不能为空");
            return false;
        } else if (project18_show_room.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "陈列厅面积不能为空");
            return false;
        } else if (building_high.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "建筑高度不能为空");
            return false;
        } else return true;
    }
}
