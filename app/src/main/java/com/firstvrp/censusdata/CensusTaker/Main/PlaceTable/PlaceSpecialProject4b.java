package com.firstvrp.censusdata.CensusTaker.Main.PlaceTable;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.firstvrp.censusdata.CensusTaker.Main.CompanyInformation.CompanyInfomationActivity;
import com.firstvrp.censusdata.CensusTaker.Main.CompanyInformation.IBtnCallListener;
import com.firstvrp.censusdata.CensusTaker.Main.Dialog.HelpDialog;
import com.firstvrp.censusdata.Entity.PlaceSpecialIndexEntity;
import com.firstvrp.censusdata.MyApplication;
import com.firstvrp.censusdata.R;

import Utils.PromptManager;

/**
 */
public class PlaceSpecialProject4b extends Fragment implements IBtnCallListener, View.OnClickListener {
    private EditText project4b_viewers_seats, project4b_place_quantity,
            project4b_pot_road_quantity, project4b_place_length,
            project4b_place_width, project4b_indoor_high;
    private RadioButton project4b_wood_flooring, project4b_synthetic_material,
            project4b_cement, project4b_ice,
            project4b_sandy_soil, project4b_other;
    private View view;
    private ImageView project4b_note1, project4b_note2, project4b_note3;
    private MyApplication application;

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
        view = inflater.inflate(R.layout.fragment_place_special_project4b, container, false);
        project4b_viewers_seats = (EditText) view.findViewById(R.id.project4b_viewers_seats);
        project4b_place_quantity = (EditText) view.findViewById(R.id.project4b_place_quantity);
        project4b_pot_road_quantity = (EditText) view.findViewById(R.id.project4b_pot_road_quantity);
        project4b_place_length = (EditText) view.findViewById(R.id.project4b_place_length);
        project4b_place_width = (EditText) view.findViewById(R.id.project4b_place_width);
        project4b_indoor_high = (EditText) view.findViewById(R.id.project4b_indoor_high);

        project4b_wood_flooring = (RadioButton) view.findViewById(R.id.project4b_wood_flooring);
        project4b_synthetic_material = (RadioButton) view.findViewById(R.id.project4b_synthetic_material);
        project4b_cement = (RadioButton) view.findViewById(R.id.project4b_cement);
        project4b_ice = (RadioButton) view.findViewById(R.id.project4b_ice);
        project4b_sandy_soil = (RadioButton) view.findViewById(R.id.project4b_sandy_soil);
        project4b_other = (RadioButton) view.findViewById(R.id.project4b_other);

        //帮助
        project4b_note1 = (ImageView) view.findViewById(R.id.project4b_note1);
        project4b_note2 = (ImageView) view.findViewById(R.id.project4b_note2);
        project4b_note3 = (ImageView) view.findViewById(R.id.project4b_note3);
        project4b_note1.setOnClickListener(this);
        project4b_note2.setOnClickListener(this);
        project4b_note3.setOnClickListener(this);

        application = (MyApplication) getActivity().getApplication();
        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null && application.getPlaceInfoEntity().getPlaceSpecialIndex() != null) {
            PlaceSpecialIndexEntity placeSpecialIndexEntity = application.getPlaceInfoEntity().getPlaceSpecialIndex();
            project4b_viewers_seats.setText(String.valueOf(placeSpecialIndexEntity.getViewers_seats()));
            project4b_place_quantity.setText(String.valueOf(placeSpecialIndexEntity.getPlace_quantity()));
            project4b_place_length.setText(String.valueOf(placeSpecialIndexEntity.getPlace_length()));
            project4b_place_width.setText(String.valueOf(placeSpecialIndexEntity.getPlace_width()));
            project4b_indoor_high.setText(String.valueOf(placeSpecialIndexEntity.getIndoor_high()));

            project4b_wood_flooring.setChecked(false);
            project4b_synthetic_material.setChecked(false);
            project4b_cement.setChecked(false);
            project4b_ice.setChecked(false);
            project4b_sandy_soil.setChecked(false);
            project4b_other.setChecked(false);

            if (placeSpecialIndexEntity.getPlace_surface().equals(project4b_wood_flooring.getText().toString()))
                project4b_wood_flooring.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project4b_synthetic_material.getText().toString()))
                project4b_synthetic_material.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project4b_cement.getText().toString()))
                project4b_cement.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project4b_ice.getText().toString()))
                project4b_ice.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project4b_sandy_soil.getText().toString()))
                project4b_sandy_soil.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project4b_other.getText().toString()))
                project4b_other.setChecked(true);
        }
    }

    @Override
    public boolean transfermsg() {

        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setViewers_seats(Integer.valueOf(project4b_viewers_seats.getText().toString().isEmpty() ? "0" : project4b_viewers_seats.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_quantity(Integer.valueOf(project4b_place_quantity.getText().toString().isEmpty() ? "0" : project4b_place_quantity.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_length(project4b_place_length.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_width(project4b_place_width.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setIndoor_high(project4b_indoor_high.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPot_road_quantity(Integer.valueOf(project4b_pot_road_quantity.getText().toString()));

        if (project4b_wood_flooring.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project4b_wood_flooring.getText().toString());
        } else if (project4b_synthetic_material.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project4b_synthetic_material.getText().toString());
        } else if (project4b_cement.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project4b_cement.getText().toString());
        } else if (project4b_ice.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project4b_ice.getText().toString());
        } else if (project4b_sandy_soil.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project4b_sandy_soil.getText().toString());
        } else if (project4b_other.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project4b_other.getText().toString());
        }
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);

        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia();}

        if (project4b_viewers_seats.getText().toString().isEmpty()) {
            project4b_viewers_seats.setText("0");
            PromptManager.showToast(getActivity(), "观众席位不能为空，没有可填0");
            return false;
        } else if (project4b_place_quantity.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "场地数量不能为空");
            return false;
        } else if (project4b_pot_road_quantity.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "冰壶球壶道数量不能为空");
            return false;
        } else if (project4b_place_length.getText().toString().isEmpty()) {
            project4b_place_length.setText("0");
            PromptManager.showToast(getActivity(), "场地长度不能为空");
            return false;
        } else if (project4b_place_width.getText().toString().isEmpty()) {
            project4b_place_width.setText("0");
            PromptManager.showToast(getActivity(), "场地宽度不能为空");
            return false;
        } else if (project4b_indoor_high.getText().toString().isEmpty()) {
            project4b_indoor_high.setText("0");
            PromptManager.showToast(getActivity(), "室内净高不能为空");
            return false;
        } else return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.project4b_note1:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y4_25));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y4_30));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y4_35));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y4_37));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project4b_note2:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y4_31));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y4_32));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y4_33));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project4b_note3:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y4_34));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
        }
    }
}
