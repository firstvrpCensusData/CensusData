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
public class PlaceSpecialProject23 extends Fragment implements IBtnCallListener {
    private EditText project23_sports_facility_area, project23_culture_facility_area,
            project23_rirections;
    private RadioButton project23_dress_room_y, project23_dress_room_n;

    private MyApplication application;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_place_special_project23, container, false);
        project23_sports_facility_area = (EditText) view.findViewById(R.id.project23_sports_facility_area);
        project23_culture_facility_area = (EditText) view.findViewById(R.id.project23_culture_facility_area);
        project23_rirections             = (EditText) view.findViewById(R.id.project23_rirections);

        project23_dress_room_y = (RadioButton) view.findViewById(R.id.project23_dress_room_y);
        project23_dress_room_n = (RadioButton) view.findViewById(R.id.project23_dress_room_n);
        application = (MyApplication) getActivity().getApplication();
        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null && application.getPlaceInfoEntity().getPlaceSpecialIndex() != null) {
            PlaceSpecialIndexEntity placeSpecialIndexEntity = application.getPlaceInfoEntity().getPlaceSpecialIndex();
            project23_sports_facility_area.setText(String.valueOf(placeSpecialIndexEntity.getViewers_seats()));
            project23_culture_facility_area.setText(String.valueOf(placeSpecialIndexEntity.getPlace_radius()));
            project23_rirections.setText(String.valueOf(placeSpecialIndexEntity.getPool_deep()));

            project23_dress_room_y.setChecked(false);
            project23_dress_room_n.setChecked(false);
            if (placeSpecialIndexEntity.getDress_room() == 1)
                project23_dress_room_y.setChecked(true);
            else if (placeSpecialIndexEntity.getDress_room() == 2)
                project23_dress_room_n.setChecked(true);

        }
    }

    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setSports_facility_area(project23_sports_facility_area.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setCulture_facility_area(project23_culture_facility_area.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setRirections(project23_rirections.getText().toString());

        if (project23_dress_room_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setDress_room(1);
        } else if (project23_dress_room_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setDress_room(2);
        }
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);

        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia(); }

        if (project23_sports_facility_area.getText().toString().isEmpty()) {
            project23_sports_facility_area.setText("0");
            PromptManager.showToast(getActivity(), "体育设施面积不能为空");
            return false;
        } else if (project23_culture_facility_area.getText().toString().isEmpty()) {
            project23_culture_facility_area.setText("0");
            PromptManager.showToast(getActivity(), "文化设施面积不能为空");
            return false;
        } else
            return true;
    }
}
