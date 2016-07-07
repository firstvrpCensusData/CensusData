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
public class PlaceSpecialProject13 extends Fragment implements IBtnCallListener, View.OnClickListener {
    private View view;
    private EditText project13_step_length, project13_step_widht;
    private RadioButton project13_synthetic_material, project13_wood,
            project13_cement, projcet13_pitch, project13_soil,
            project13_other;
    private ImageView project13_note1, project13_note2;
    private MyApplication application;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_place_special_project13, container, false);
        project13_step_length = (EditText) view.findViewById(R.id.project13_step_length);
        project13_step_widht  = (EditText) view.findViewById(R.id.project13_step_widht);

        project13_synthetic_material = (RadioButton) view.findViewById(R.id.project13_synthetic_material);
        project13_wood = (RadioButton) view.findViewById(R.id.project13_wood);
        project13_cement = (RadioButton) view.findViewById(R.id.project13_cement);
        projcet13_pitch = (RadioButton) view.findViewById(R.id.projcet13_pitch);
        project13_soil = (RadioButton) view.findViewById(R.id.project13_soil);
        project13_other = (RadioButton) view.findViewById(R.id.project13_other);

        //帮助
        project13_note1 = (ImageView) view.findViewById(R.id.project13_note1);
        project13_note2 = (ImageView) view.findViewById(R.id.project13_note2);
        project13_note1.setOnClickListener(this);
        project13_note2.setOnClickListener(this);

        application = (MyApplication) getActivity().getApplication();
        forcingDefault();

        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null && application.getPlaceInfoEntity().getPlaceSpecialIndex() != null) {
            PlaceSpecialIndexEntity placeSpecialIndexEntity = application.getPlaceInfoEntity().getPlaceSpecialIndex();
            project13_step_length.setText(String.valueOf(placeSpecialIndexEntity.getStep_length()));
            project13_step_widht.setText(String.valueOf(placeSpecialIndexEntity.getStep_widht()));

            project13_synthetic_material.setChecked(false);
            project13_wood.setChecked(false);
            project13_cement.setChecked(false);
            projcet13_pitch.setChecked(false);
            project13_soil.setChecked(false);
            project13_other.setChecked(false);

            if (placeSpecialIndexEntity.getStep_surface().equals(project13_synthetic_material.getText().toString()))
                project13_synthetic_material.setChecked(true);
            else if (placeSpecialIndexEntity.getStep_surface().equals(project13_wood.getText().toString()))
                project13_wood.setChecked(true);
            else if (placeSpecialIndexEntity.getStep_surface().equals(project13_cement.getText().toString()))
                project13_cement.setChecked(true);
            else if (placeSpecialIndexEntity.getStep_surface().equals(projcet13_pitch.getText().toString()))
                projcet13_pitch.setChecked(true);
            else if (placeSpecialIndexEntity.getStep_surface().equals(project13_soil.getText().toString()))
                project13_soil.setChecked(true);
            else if (placeSpecialIndexEntity.getStep_surface().equals(project13_other.getText().toString()))
                project13_other.setChecked(true);

        }
    }

    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setStep_length(project13_step_length.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setStep_length(project13_step_widht.getText().toString());

        if (project13_synthetic_material.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setStep_surface(project13_synthetic_material.getText().toString());
        } else if (project13_wood.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setStep_surface(project13_wood.getText().toString());

        } else if (project13_cement.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setStep_surface(project13_cement.getText().toString());

        } else if (projcet13_pitch.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setStep_surface(projcet13_pitch.getText().toString());

        } else if (project13_soil.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setStep_surface(project13_soil.getText().toString());

        } else if (project13_other.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setStep_surface(project13_other.getText().toString());

        }

        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);

        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia(); }

        if (project13_step_length.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "步道长度不能为空");
            return false;
        } else if (project13_step_widht.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "步道平均宽度不能为空");
            return false;
        }  else return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.project13_note1:
                StringBuilder stringBuilder = new StringBuilder();
                if (application.getTypeID() == 80) {
                    stringBuilder.append(getActivity().getString(R.string.help_y13_1));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 81) {
                    stringBuilder.append(getActivity().getString(R.string.help_y13_2));
                    stringBuilder.append("\r\n\n");
                }
                stringBuilder.append(getActivity().getString(R.string.help_y13_3));
                stringBuilder.append("\r\n\n");
                stringBuilder.append(getActivity().getString(R.string.help_y13_4));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project13_note2:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y13_5));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
        }
    }
}
