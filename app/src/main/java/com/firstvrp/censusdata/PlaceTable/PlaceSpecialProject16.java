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
 *
 */
public class PlaceSpecialProject16 extends Fragment implements IBtnCallListener, View.OnClickListener {
    private EditText project16_viewers_seats, project16_place_radius,
            project16_pool_deep, project16_place_length,
            project16_place_width;
    private RadioButton project16_light_device_y, project16_light_device_n;

    private RadioButton project16_savageness_grass, project16_pedaline,
            project16_synthetic_material, project16_cement,
            project16_pitch, project16_soil,
            project16_ice, project16_water, project16_other;

    private ImageView project16_note1, project16_note2, project16_note3, project16_note4;
    private MyApplication application;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_place_special_project16, container, false);
        project16_viewers_seats = (EditText) view.findViewById(R.id.project16_viewers_seats);
        project16_place_radius  = (EditText) view.findViewById(R.id.project16_place_radius);
        project16_pool_deep     = (EditText) view.findViewById(R.id.project16_pool_deep);
        project16_place_length  = (EditText) view.findViewById(R.id.project16_place_length);
        project16_place_width   = (EditText) view.findViewById(R.id.project16_place_width);

        project16_light_device_y = (RadioButton) view.findViewById(R.id.project16_light_device_y);
        project16_light_device_n = (RadioButton) view.findViewById(R.id.project16_light_device_n);

        project16_savageness_grass = (RadioButton) view.findViewById(R.id.project16_savageness_grass);
        project16_pedaline = (RadioButton) view.findViewById(R.id.project16_pedaline);
        project16_synthetic_material = (RadioButton) view.findViewById(R.id.project16_synthetic_material);
        project16_cement = (RadioButton) view.findViewById(R.id.project16_cement);
        project16_pitch = (RadioButton) view.findViewById(R.id.project16_pitch);
        project16_soil = (RadioButton) view.findViewById(R.id.project16_soil);
        project16_ice = (RadioButton) view.findViewById(R.id.project16_ice);
        project16_water = (RadioButton) view.findViewById(R.id.project16_water);
        project16_other = (RadioButton) view.findViewById(R.id.project16_other);

        //帮助
        project16_note1 = (ImageView) view.findViewById(R.id.project16_note1);
        project16_note2 = (ImageView) view.findViewById(R.id.project16_note2);
        project16_note3 = (ImageView) view.findViewById(R.id.project16_note3);
        project16_note4 = (ImageView) view.findViewById(R.id.project16_note4);
        project16_note1.setOnClickListener(this);
        project16_note2.setOnClickListener(this);
        project16_note3.setOnClickListener(this);
        project16_note4.setOnClickListener(this);

        application = (MyApplication) getActivity().getApplication();
        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null && application.getPlaceInfoEntity().getPlaceSpecialIndex() != null) {
            PlaceSpecialIndexEntity placeSpecialIndexEntity = application.getPlaceInfoEntity().getPlaceSpecialIndex();
            project16_viewers_seats.setText(String.valueOf(placeSpecialIndexEntity.getViewers_seats()));
            project16_place_radius.setText(String.valueOf(placeSpecialIndexEntity.getPlace_radius()));
            project16_pool_deep.setText(String.valueOf(placeSpecialIndexEntity.getPool_deep()));
            project16_place_length.setText(String.valueOf(placeSpecialIndexEntity.getPlace_length()));
            project16_place_width.setText(String.valueOf(placeSpecialIndexEntity.getPlace_width()));
            project16_light_device_y.setChecked(false);
            project16_light_device_n.setChecked(false);
            if (placeSpecialIndexEntity.getLight_device() == 1)
                project16_light_device_y.setChecked(true);
            else if (placeSpecialIndexEntity.getLight_device() == 2)
                project16_light_device_y.setChecked(true);

            project16_savageness_grass.setChecked(false);
            project16_pedaline.setChecked(false);
            project16_synthetic_material.setChecked(false);
            project16_cement.setChecked(false);
            project16_pitch.setChecked(false);
            project16_soil.setChecked(false);
            project16_ice.setChecked(false);
            project16_water.setChecked(false);
            project16_other.setChecked(false);

            if (placeSpecialIndexEntity.getPlace_surface().equals(project16_savageness_grass.getText().toString()))
                project16_savageness_grass.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project16_pedaline.getText().toString()))
                project16_pedaline.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project16_synthetic_material.getText().toString()))
                project16_synthetic_material.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project16_cement.getText().toString()))
                project16_cement.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project16_pitch.getText().toString()))
                project16_pitch.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project16_soil.getText().toString()))
                project16_soil.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project16_ice.getText().toString()))
                project16_ice.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project16_water.getText().toString()))
                project16_water.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project16_other.getText().toString()))
                project16_other.setChecked(true);
        }
    }

    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setViewers_seats(Integer.valueOf(project16_viewers_seats.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_radius(project16_place_radius.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPool_deep(project16_pool_deep.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_length(project16_place_length.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_width(project16_place_width.getText().toString());

        if (project16_light_device_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setLight_device(1);
        } else if (project16_light_device_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setLight_device(2);
        }

        if (project16_savageness_grass.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project16_savageness_grass.getText().toString());
        } else if (project16_pedaline.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project16_pedaline.getText().toString());
        } else if (project16_synthetic_material.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project16_synthetic_material.getText().toString());
        } else if (project16_cement.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project16_cement.getText().toString());
        } else if (project16_pitch.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project16_pitch.getText().toString());
        } else if (project16_soil.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project16_soil.getText().toString());
        } else if (project16_ice.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project16_ice.getText().toString());
        } else if (project16_water.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project16_water.getText().toString());
        } else if (project16_other.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project16_other.getText().toString());
        }
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);

        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia(); }

        if (project16_viewers_seats.getText().toString().isEmpty()) {
            project16_viewers_seats.setText("0");
            PromptManager.showToast(getActivity(), "观众席位不能为空，没有可填0");
        } else if (project16_place_radius.getText().toString().isEmpty()) {
            project16_place_radius.setText("0");
            PromptManager.showToast(getActivity(), "场地半径不能为空，没有可填0");
        } else if (project16_pool_deep.getText().toString().isEmpty()) {
            project16_pool_deep.setText("0");
            PromptManager.showToast(getActivity(), "水池深度不能为空，没有可填0");
        } else if (project16_place_length.getText().toString().isEmpty()) {
            project16_place_length.setText("0");
            PromptManager.showToast(getActivity(), "场地长度不能为空，没有可填0");
        }else if (project16_place_width.getText().toString().isEmpty()) {
            project16_place_width.setText("0");
            PromptManager.showToast(getActivity(), "场地宽度不能为空，没有可填0");
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.project16_note1:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y16_1));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y16_4));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y16_8));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y16_7));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project16_note2:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y16_5));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y16_6));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project16_note3:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y16_10));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project16_note4:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y16_9));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
        }
    }
}
