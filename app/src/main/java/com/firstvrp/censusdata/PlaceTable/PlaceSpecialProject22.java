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
public class PlaceSpecialProject22 extends Fragment implements IBtnCallListener {
    private EditText project22_greening_area, project22_fitness_area, project22_rirections;
    private RadioButton project22_stage_y, project22_stage_n,
            project22_screen_device_y, project22_screen_device_n,
            project22_light_device_y, project22_light_device_n;
    private MyApplication application;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_place_special_project22, container, false);
        project22_greening_area = (EditText) view.findViewById(R.id.project22_greening_area);
        project22_fitness_area = (EditText) view.findViewById(R.id.project22_fitness_area);
        project22_rirections = (EditText) view.findViewById(R.id.project22_rirections);

        project22_stage_y = (RadioButton) view.findViewById(R.id.project22_stage_y);
        project22_stage_n = (RadioButton) view.findViewById(R.id.project22_stage_n);

        project22_screen_device_y = (RadioButton) view.findViewById(R.id.project22_screen_device_y);
        project22_screen_device_n = (RadioButton) view.findViewById(R.id.project22_screen_device_n);

        project22_light_device_y = (RadioButton) view.findViewById(R.id.project22_light_device_y);
        project22_light_device_n = (RadioButton) view.findViewById(R.id.project22_light_device_n);

        application = (MyApplication) getActivity().getApplication();
        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null && application.getPlaceInfoEntity().getPlaceSpecialIndex() != null) {
            PlaceSpecialIndexEntity placeSpecialIndexEntity = application.getPlaceInfoEntity().getPlaceSpecialIndex();
            project22_greening_area.setText(String.valueOf(placeSpecialIndexEntity.getGreening_area()));
            project22_fitness_area.setText(String.valueOf(placeSpecialIndexEntity.getFitness_area()));
            project22_rirections.setText(String.valueOf(placeSpecialIndexEntity.getRirections()));

            project22_stage_y.setChecked(false);
            project22_stage_n.setChecked(false);
            if (placeSpecialIndexEntity.getLight_device() == 1)
                project22_stage_y.setChecked(true);
            else if (placeSpecialIndexEntity.getLight_device() == 2)
                project22_stage_n.setChecked(true);

            project22_screen_device_y.setChecked(false);
            project22_screen_device_n.setChecked(false);
            if (placeSpecialIndexEntity.getLight_device() == 1)
                project22_screen_device_y.setChecked(true);
            else if (placeSpecialIndexEntity.getLight_device() == 2)
                project22_screen_device_n.setChecked(true);

            project22_light_device_y.setChecked(false);
            project22_light_device_n.setChecked(false);
            if (placeSpecialIndexEntity.getLight_device() == 1)
                project22_light_device_y.setChecked(true);
            else if (placeSpecialIndexEntity.getLight_device() == 2)
                project22_light_device_n.setChecked(true);

        }
    }

    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setViewers_seats(Integer.valueOf(project22_greening_area.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_radius(project22_fitness_area.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPool_deep(project22_rirections.getText().toString());

        if (project22_screen_device_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setScreen_device(1);
        } else if (project22_screen_device_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setScreen_device(2);
        }

        if (project22_stage_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setStage(1);
        } else if (project22_stage_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setStage(2);
        }

        if (project22_light_device_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setLight_device(1);
        } else if (project22_light_device_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setLight_device(2);
        }

        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);

        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia();}

        if (project22_greening_area.getText().toString().isEmpty()) {
            project22_greening_area.setText("0");
            PromptManager.showToast(getActivity(), "大厅面积不能为空");
            return false;
        } else if (project22_fitness_area.getText().toString().isEmpty()) {
            project22_fitness_area.setText("0");
            PromptManager.showToast(getActivity(), "展厅面积不能为空");
            return false;
        }  else
            return true;
    }
}
