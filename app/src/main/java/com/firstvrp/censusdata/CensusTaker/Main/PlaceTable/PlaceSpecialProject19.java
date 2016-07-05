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
public class PlaceSpecialProject19 extends Fragment implements IBtnCallListener {
    private EditText project19_stack_room, project19_hall,
            project19_tool_reading_room, project19_electronic_reading_room,
            project19_news_reading_room, project19_save_reading_room,
            project19_temp_reading_room, project19_foreign_reading_room,
            project19_paper_library;
    private RadioButton project19_restaurant_y, project19_restaurant_n,
            project19_function_room_y, project19_function_room_n,
            project19_stop_place_y, project19_stop_place_n;

    private MyApplication application;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_place_special_project19, container, false);
        project19_stack_room              = (EditText) view.findViewById(R.id.project19_stack_room);
        project19_hall                    = (EditText) view.findViewById(R.id.project19_hall);
        project19_tool_reading_room       = (EditText) view.findViewById(R.id.project19_tool_reading_room);
        project19_electronic_reading_room = (EditText) view.findViewById(R.id.project19_electronic_reading_room);
        project19_news_reading_room       = (EditText) view.findViewById(R.id.project19_news_reading_room);
        project19_save_reading_room       = (EditText) view.findViewById(R.id.project19_save_reading_room);
        project19_temp_reading_room       = (EditText) view.findViewById(R.id.project19_temp_reading_room);
        project19_foreign_reading_room    = (EditText) view.findViewById(R.id.project19_foreign_reading_room);
        project19_paper_library           = (EditText) view.findViewById(R.id.project19_paper_library);

        project19_restaurant_y = (RadioButton) view.findViewById(R.id.project19_restaurant_y);
        project19_restaurant_n = (RadioButton) view.findViewById(R.id.project19_restaurant_n);

        project19_function_room_y = (RadioButton) view.findViewById(R.id.project19_function_room_y);
        project19_function_room_n = (RadioButton) view.findViewById(R.id.project19_function_room_n);

        project19_stop_place_y = (RadioButton) view.findViewById(R.id.project19_stop_place_y);
        project19_stop_place_n = (RadioButton) view.findViewById(R.id.project19_stop_place_n);


        application = (MyApplication) getActivity().getApplication();
        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null && application.getPlaceInfoEntity().getPlaceSpecialIndex() != null) {
            PlaceSpecialIndexEntity placeSpecialIndexEntity = application.getPlaceInfoEntity().getPlaceSpecialIndex();
            project19_stack_room.setText(String.valueOf(placeSpecialIndexEntity.getStack_room()));
            project19_hall.setText(String.valueOf(placeSpecialIndexEntity.getHall()));
            project19_tool_reading_room.setText(String.valueOf(placeSpecialIndexEntity.getTool_reading_room()));
            project19_electronic_reading_room.setText(String.valueOf(placeSpecialIndexEntity.getElectronic_reading_room()));
            project19_news_reading_room.setText(String.valueOf(placeSpecialIndexEntity.getNews_reading_room()));
            project19_save_reading_room.setText(String.valueOf(placeSpecialIndexEntity.getSave_reading_room()));
            project19_temp_reading_room.setText(String.valueOf(placeSpecialIndexEntity.getTemp_reading_room()));
            project19_foreign_reading_room.setText(String.valueOf(placeSpecialIndexEntity.getForeign_reading_room()));
            project19_paper_library.setText(String.valueOf(placeSpecialIndexEntity.getPaper_library()));

            project19_restaurant_y.setChecked(false);
            project19_restaurant_n.setChecked(false);
            if (placeSpecialIndexEntity.getRestaurant() == 1)
                project19_restaurant_y.setChecked(true);
            else if (placeSpecialIndexEntity.getRestaurant() == 2)
                project19_restaurant_n.setChecked(true);

            project19_function_room_y.setChecked(false);
            project19_function_room_n.setChecked(false);
            if (placeSpecialIndexEntity.getFunction_room() == 1)
                project19_function_room_y.setChecked(true);
            else if (placeSpecialIndexEntity.getFunction_room() == 2)
                project19_function_room_n.setChecked(true);

            project19_stop_place_y.setChecked(false);
            project19_stop_place_n.setChecked(false);
            if (placeSpecialIndexEntity.getStop_place() == 1)
                project19_stop_place_y.setChecked(true);
            else if (placeSpecialIndexEntity.getStop_place() == 2)
                project19_stop_place_n.setChecked(true);
        }
    }

    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setStack_room(project19_stack_room.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setHall(project19_hall.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setTool_reading_room(project19_tool_reading_room.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setElectronic_reading_room(project19_electronic_reading_room.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setNews_reading_room(project19_news_reading_room.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setSave_reading_room(project19_save_reading_room.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setTemp_reading_room(project19_temp_reading_room.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setForeign_reading_room(project19_foreign_reading_room.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPaper_library(project19_paper_library.getText().toString());

        if (project19_restaurant_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setRestaurant(1);
        } else if (project19_restaurant_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setRestaurant(2);
        }

        if (project19_function_room_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setFunction_room(1);
        } else if (project19_function_room_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setFunction_room(2);
        }

        if (project19_stop_place_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setStop_place(1);
        } else if (project19_stop_place_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setStop_place(2);
        }

        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);

        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia(); }
//        project19_stack_room
//                project19_hall
//        project19_tool_reading_room
//                project19_electronic_reading_room
//        project19_news_reading_room
//                project19_save_reading_room
//        project19_temp_reading_room
//                project19_foreign_reading_room
//        project19_paper_library
        if (project19_stack_room.getText().toString().isEmpty()) {
            project19_stack_room.setText("0");
            PromptManager.showToast(getActivity(), "书库面积不能为空");
            return false;
        } else if (project19_hall.getText().toString().isEmpty()) {
            project19_stack_room.setText("0");
            PromptManager.showToast(getActivity(), "大厅面积不能为空");
            return false;
        } else if (project19_tool_reading_room.getText().toString().isEmpty()) {
            project19_stack_room.setText("0");
            PromptManager.showToast(getActivity(), "工具书阅览室面积不能为空");
            return false;
        } else if (project19_electronic_reading_room.getText().toString().isEmpty()) {
            project19_stack_room.setText("0");
            PromptManager.showToast(getActivity(), "电子阅览室面积不能为空");
            return false;
        }else if (project19_news_reading_room.getText().toString().isEmpty()) {
            project19_stack_room.setText("0");
            PromptManager.showToast(getActivity(), "杂志报纸阅览室面积不能为空");
            return false;
        }else if (project19_save_reading_room.getText().toString().isEmpty()) {
            project19_stack_room.setText("0");
            PromptManager.showToast(getActivity(), "保存本阅览室面积不能为空");
            return false;
        }else if (project19_temp_reading_room.getText().toString().isEmpty()) {
            project19_stack_room.setText("0");
            PromptManager.showToast(getActivity(), "临时阅览室面积不能为空");
            return false;
        }else if (project19_foreign_reading_room.getText().toString().isEmpty()) {
            project19_stack_room.setText("0");
            PromptManager.showToast(getActivity(), "国外港台阅览室面积不能为空");
            return false;
        }else if (project19_paper_library.getText().toString().isEmpty()) {
            project19_stack_room.setText("0");
            PromptManager.showToast(getActivity(), "论文文库面积不能为空");
            return false;
        } else return true;
    }
}
