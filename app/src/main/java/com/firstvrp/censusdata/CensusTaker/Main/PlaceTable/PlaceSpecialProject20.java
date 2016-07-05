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
public class PlaceSpecialProject20 extends Fragment implements IBtnCallListener {
    private EditText project20_hall, project20_show_room,
            project20_goods_show_area, project20_book_picture_area,
            project20_show_area_high, project20_rirections;
    private RadioButton project20_lectures_room_y, project20_lectures_room_n,
            project20_video_room_y, project20_video_room_n,
            project20_function_room_y, project20_function_room_n,
            project20_receive_room_y, project20_receive_room_n,
            project20_meeting_room_y, project20_meeting_room_n,
            project20_history_store_y, project20_history_store_n;

    private MyApplication application;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_place_special_project20, container, false);
        project20_hall              = (EditText) view.findViewById(R.id.project20_hall);
        project20_show_room         = (EditText) view.findViewById(R.id.project20_show_room);
        project20_goods_show_area   = (EditText) view.findViewById(R.id.project20_goods_show_area);
        project20_book_picture_area  = (EditText) view.findViewById(R.id.project20_book_picture_area);
        project20_show_area_high    = (EditText) view.findViewById(R.id.project20_show_area_high);
        project20_rirections        = (EditText) view.findViewById(R.id.project20_rirections);

        project20_lectures_room_y = (RadioButton) view.findViewById(R.id.project20_lectures_room_y);
        project20_lectures_room_n = (RadioButton) view.findViewById(R.id.project20_lectures_room_n);

        project20_video_room_y = (RadioButton) view.findViewById(R.id.project20_video_room_y);
        project20_video_room_n = (RadioButton) view.findViewById(R.id.project20_video_room_n);

        project20_function_room_y = (RadioButton) view.findViewById(R.id.project20_function_room_y);
        project20_function_room_n = (RadioButton) view.findViewById(R.id.project20_function_room_n);

        project20_receive_room_y = (RadioButton) view.findViewById(R.id.project20_receive_room_y);
        project20_receive_room_n = (RadioButton) view.findViewById(R.id.project20_receive_room_n);

        project20_meeting_room_y = (RadioButton) view.findViewById(R.id.project20_meeting_room_y);
        project20_meeting_room_n = (RadioButton) view.findViewById(R.id.project20_meeting_room_n);

        project20_history_store_y = (RadioButton) view.findViewById(R.id.project20_history_store_y);
        project20_history_store_n = (RadioButton) view.findViewById(R.id.project20_history_store_n);

        application = (MyApplication) getActivity().getApplication();
        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null && application.getPlaceInfoEntity().getPlaceSpecialIndex() != null) {
            PlaceSpecialIndexEntity placeSpecialIndexEntity = application.getPlaceInfoEntity().getPlaceSpecialIndex();
            project20_hall.setText(String.valueOf(placeSpecialIndexEntity.getHall()));
            project20_show_room.setText(String.valueOf(placeSpecialIndexEntity.getShow_room()));
            project20_goods_show_area.setText(String.valueOf(placeSpecialIndexEntity.getGoods_show_area()));
            project20_book_picture_area.setText(String.valueOf(placeSpecialIndexEntity.getBook_picture_area()));
            project20_show_area_high.setText(String.valueOf(placeSpecialIndexEntity.getShow_area_high()));
            project20_rirections.setText(String.valueOf(placeSpecialIndexEntity.getRirections()));

            project20_lectures_room_n.setChecked(false);
            project20_lectures_room_y.setChecked(false);
            if (placeSpecialIndexEntity.getLectures_room() == 1)
                project20_lectures_room_y.setChecked(true);
            else if (placeSpecialIndexEntity.getLectures_room() == 2)
                project20_lectures_room_n.setChecked(true);

            project20_video_room_y.setChecked(false);
            project20_video_room_n.setChecked(false);
            if (placeSpecialIndexEntity.getVideo_room() == 1)
                project20_video_room_y.setChecked(true);
            else if (placeSpecialIndexEntity.getVideo_room() == 2)
                project20_video_room_n.setChecked(true);

            project20_function_room_y.setChecked(false);
            project20_function_room_n.setChecked(false);
            if (placeSpecialIndexEntity.getFunction_room() == 1)
                project20_function_room_y.setChecked(true);
            else if (placeSpecialIndexEntity.getFunction_room() == 2)
                project20_function_room_n.setChecked(true);

            project20_receive_room_y.setChecked(false);
            project20_receive_room_n.setChecked(false);
            if (placeSpecialIndexEntity.getRecording_room() == 1)
                project20_receive_room_y.setChecked(true);
            else if (placeSpecialIndexEntity.getRecording_room() == 2)
                project20_receive_room_n.setChecked(true);

            project20_meeting_room_y.setChecked(false);
            project20_meeting_room_n.setChecked(false);
            if (placeSpecialIndexEntity.getMeeting_room() == 1)
                project20_meeting_room_y.setChecked(true);
            else if (placeSpecialIndexEntity.getMeeting_room() == 2)
                project20_meeting_room_n.setChecked(true);

            project20_history_store_y.setChecked(false);
            project20_history_store_n.setChecked(false);
            if (placeSpecialIndexEntity.getHistory_store() == 1)
                project20_history_store_y.setChecked(true);
            else if (placeSpecialIndexEntity.getHistory_store() == 2)
                project20_history_store_n.setChecked(true);
        }
    }

    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setHall(project20_hall.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setShow_room(project20_show_room.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setGoods_show_area(project20_goods_show_area.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setBook_picture_area(project20_book_picture_area.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setShow_area_high(project20_show_area_high.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setRirections(project20_rirections.getText().toString());

        if (project20_lectures_room_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setLectures_room(1);
        } else if (project20_lectures_room_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setLectures_room(2);
        }

        if (project20_video_room_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setVideo_room(1);
        } else if (project20_video_room_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setVideo_room(2);
        }

        if (project20_function_room_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setFunction_room(1);
        } else if (project20_function_room_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setFunction_room(2);
        }

        if (project20_receive_room_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setReceive_room(1);
        } else if (project20_receive_room_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setReceive_room(2);
        }

        if (project20_meeting_room_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setMeeting_room(1);
        } else if (project20_meeting_room_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setMeeting_room(2);
        }

        if (project20_history_store_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setHistory_store(1);
        } else if (project20_history_store_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setHistory_store(2);
        }

        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);

        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia(); }

        if (project20_hall.getText().toString().isEmpty()) {
            project20_hall.setText("0");
            PromptManager.showToast(getActivity(), "大厅面积不能为空");
            return false;
        } else if (project20_show_room.getText().toString().isEmpty()) {
            project20_show_room.setText("0");
            PromptManager.showToast(getActivity(), "展厅面积不能为空");
            return false;
        } else if (project20_goods_show_area.getText().toString().isEmpty()) {
            project20_goods_show_area.setText("0");
            PromptManager.showToast(getActivity(), "物品展区面积不能为空");
            return false;
        } else if (project20_book_picture_area.getText().toString().isEmpty()) {
            project20_book_picture_area.setText("0");
            PromptManager.showToast(getActivity(), "书画展区面积不能为空");
            return false;
        }else if (project20_show_area_high.getText().toString().isEmpty()) {
            project20_show_area_high.setText("0");
            PromptManager.showToast(getActivity(), "展区内高不能为空");
            return false;
        } else return true;
    }
}
