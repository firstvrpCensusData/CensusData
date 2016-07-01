package com.firstvrp.censusdata.PlaceTable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.firstvrp.censusdata.CompanyInformation.CompanyInfomationActivity;
import com.firstvrp.censusdata.CompanyInformation.IBtnCallListener;
import com.firstvrp.censusdata.Dialog.HelpDialog;
import com.firstvrp.censusdata.Entity.PlaceSpecialIndexEntity;
import com.firstvrp.censusdata.MyApplication;
import com.firstvrp.censusdata.R;

import Utils.PromptManager;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class PlaceSpecialProject5a extends Fragment implements IBtnCallListener, View.OnClickListener {
    private View view;

    private EditText project5a_viewers_seats, project5a_place_quantity,
            project5a_place_radius;
    private RadioButton project5a_savageness_grass, project5a_pedaline,
            project5a_synthetic_material, project5a_cement,
            project5a_soil, project5a_ice,
            project5a_other;
    private RadioButton project5a_light_device_y, project5a_light_device_n;
    private RadioButton project5a_shelter_y, project5a_shelter_n;
    private ImageView project5a_note1, project5a_note2, project5a_note3, project5a_note4;

    private MyApplication application;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_place_special_project5a, container, false);

        project5a_viewers_seats = (EditText) view.findViewById(R.id.project5a_viewers_seats);
        project5a_place_quantity = (EditText) view.findViewById(R.id.project5a_place_quantity);
        project5a_place_radius = (EditText) view.findViewById(R.id.project5a_place_radius);

        project5a_savageness_grass = (RadioButton) view.findViewById(R.id.project5a_savageness_grass);
        project5a_pedaline = (RadioButton) view.findViewById(R.id.project5a_pedaline);
        project5a_synthetic_material = (RadioButton) view.findViewById(R.id.project5a_synthetic_material);
        project5a_cement = (RadioButton) view.findViewById(R.id.project5a_cement);
        project5a_soil = (RadioButton) view.findViewById(R.id.project5a_soil);
        project5a_ice = (RadioButton) view.findViewById(R.id.project5a_ice);
        project5a_other = (RadioButton) view.findViewById(R.id.project5a_other);

        project5a_light_device_y = (RadioButton) view.findViewById(R.id.project5a_light_device_y);
        project5a_light_device_n = (RadioButton) view.findViewById(R.id.project5a_light_device_n);

        project5a_shelter_y = (RadioButton) view.findViewById(R.id.project5a_shelter_y);
        project5a_shelter_n = (RadioButton) view.findViewById(R.id.project5a_shelter_n);

        //帮助
        project5a_note1 = (ImageView) view.findViewById(R.id.project5a_note1);
        project5a_note2 = (ImageView) view.findViewById(R.id.project5a_note2);
        project5a_note3 = (ImageView) view.findViewById(R.id.project5a_note3);
        project5a_note4 = (ImageView) view.findViewById(R.id.project5a_note4);
        project5a_note1.setOnClickListener(this);
        project5a_note2.setOnClickListener(this);
        project5a_note3.setOnClickListener(this);
        project5a_note4.setOnClickListener(this);

        application = (MyApplication) getActivity().getApplication();
        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null && application.getPlaceInfoEntity().getPlaceSpecialIndex() != null) {
            PlaceSpecialIndexEntity placeSpecialIndexEntity = application.getPlaceInfoEntity().getPlaceSpecialIndex();

            project5a_viewers_seats.setText(String.valueOf(placeSpecialIndexEntity.getViewers_seats()));
            project5a_place_quantity.setText(String.valueOf(placeSpecialIndexEntity.getPlace_quantity()));
            project5a_place_radius.setText(String.valueOf(placeSpecialIndexEntity.getPlace_radius()));

            project5a_savageness_grass.setChecked(false);
            project5a_pedaline.setChecked(false);
            project5a_synthetic_material.setChecked(false);
            project5a_cement.setChecked(false);
            project5a_soil.setChecked(false);
            project5a_ice.setChecked(false);
            project5a_other.setChecked(false);

            if (placeSpecialIndexEntity.getPlace_surface().equals(project5a_savageness_grass.getText().toString()))
                project5a_savageness_grass.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project5a_pedaline.getText().toString()))
                project5a_pedaline.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project5a_synthetic_material.getText().toString()))
                project5a_synthetic_material.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project5a_cement.getText().toString()))
                project5a_cement.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project5a_soil.getText().toString()))
                project5a_soil.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project5a_ice.getText().toString()))
                project5a_ice.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project5a_other.getText().toString()))
                project5a_other.setChecked(true);

            project5a_light_device_y.setChecked(false);
            project5a_light_device_n.setChecked(false);

            project5a_shelter_y.setChecked(false);
            project5a_shelter_n.setChecked(false);

            if (placeSpecialIndexEntity.getLight_device() == 1)
                project5a_light_device_y.setChecked(true);
            else if (placeSpecialIndexEntity.getLight_device() == 2)
                project5a_light_device_n.setChecked(true);

            if (placeSpecialIndexEntity.getShelter() == 1)
                project5a_shelter_y.setChecked(true);
            else if (placeSpecialIndexEntity.getShelter() == 2)
                project5a_shelter_n.setChecked(true);
        }
    }

    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setViewers_seats(Integer.valueOf(project5a_viewers_seats.getText().toString().isEmpty() ? "0" : project5a_viewers_seats.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_quantity(Integer.valueOf(project5a_place_quantity.getText().toString().isEmpty() ? "0" : project5a_place_quantity.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_radius(project5a_place_radius.getText().toString());

        if (project5a_savageness_grass.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project5a_savageness_grass.getText().toString());
        } else if (project5a_pedaline.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project5a_pedaline.getText().toString());
        } else if (project5a_synthetic_material.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project5a_synthetic_material.getText().toString());
        } else if (project5a_cement.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project5a_cement.getText().toString());
        } else if (project5a_soil.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project5a_soil.getText().toString());
        } else if (project5a_ice.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project5a_ice.getText().toString());
        } else if (project5a_other.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project5a_other.getText().toString());
        }

        if (project5a_light_device_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setLight_device(1);
        } else if (project5a_light_device_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setLight_device(2);
        }

        if (project5a_shelter_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setShelter(1);
        } else if (project5a_shelter_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setShelter(2);
        }
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);

        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia();
        }

        if (project5a_viewers_seats.getText().toString().isEmpty()) {
            project5a_viewers_seats.setText("0");
            PromptManager.showToast(getActivity(), "观众席位不能为空，没有可填0");
            return false;
        } else if (project5a_place_quantity.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "场地数量不能为空");
            return false;
        } else if (project5a_place_radius.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "场地半径不能为空");
            return false;
        } else return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.project5a_note1:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y5_15));
                stringBuilder.append("\r\n");

                stringBuilder.append(getActivity().getString(R.string.help_y5_25));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y5_26));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y5_29));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project5a_note2:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y5_27));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y5_28));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project5a_note3:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y5_30));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project5a_note4:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y5_31));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
        }
    }
}
