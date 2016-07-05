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
public class PlaceSpecialProject6 extends Fragment implements IBtnCallListener, View.OnClickListener {
    View view;
    private EditText project6_viewers_seats, projcet6_track_length, project6_place_length,
            projcet6_place_width;
    private RadioButton project6_wood_flooring, project6_Cement, project6_pitch,
            projcet6_soil, project6_other;
    private RadioButton project6_light_device_y, project6_light_device_n;
    private ImageView project6_note1, project6_note2, project6_note3, project6_note4;

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
        view = inflater.inflate(R.layout.fragment_place_special_project6, container, false);
        project6_viewers_seats = (EditText) view.findViewById(R.id.project6_viewers_seats);
        projcet6_track_length = (EditText) view.findViewById(R.id.projcet6_track_length);
        project6_place_length = (EditText) view.findViewById(R.id.project6_place_length);
        projcet6_place_width = (EditText) view.findViewById(R.id.projcet6_place_width);

        project6_wood_flooring = (RadioButton) view.findViewById(R.id.project6_wood_flooring);
        project6_Cement = (RadioButton) view.findViewById(R.id.project6_Cement);
        project6_pitch = (RadioButton) view.findViewById(R.id.project6_pitch);
        projcet6_soil = (RadioButton) view.findViewById(R.id.projcet6_soil);
        project6_other = (RadioButton) view.findViewById(R.id.project6_other);

        project6_light_device_y = (RadioButton) view.findViewById(R.id.project6_light_device_y);
        project6_light_device_n = (RadioButton) view.findViewById(R.id.project6_light_device_n);

        //帮助
        project6_note1 = (ImageView) view.findViewById(R.id.project6_note1);
        project6_note2 = (ImageView) view.findViewById(R.id.project6_note2);
        project6_note3 = (ImageView) view.findViewById(R.id.project6_note3);
        project6_note4 = (ImageView) view.findViewById(R.id.project6_note4);
        project6_note1.setOnClickListener(this);
        project6_note2.setOnClickListener(this);
        project6_note3.setOnClickListener(this);
        project6_note4.setOnClickListener(this);
        application = (MyApplication) getActivity().getApplication();
        if (application.getTypeID() == 64 || application.getTypeID() == 65) {
            projcet6_track_length.setHint(getString(R.string.greater_equal_two_hunder_five));
        }

        if (application.getTypeID() == 66) {
            projcet6_track_length.setHint(getString(R.string.greater_equal_three_hunderd));
        }
        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null && application.getPlaceInfoEntity().getPlaceSpecialIndex() != null) {
            PlaceSpecialIndexEntity placeSpecialIndexEntity = application.getPlaceInfoEntity().getPlaceSpecialIndex();
            project6_viewers_seats.setText(String.valueOf(placeSpecialIndexEntity.getViewers_seats()));
            projcet6_track_length.setText(String.valueOf(placeSpecialIndexEntity.getTrack_length()));
            project6_place_length.setText(String.valueOf(placeSpecialIndexEntity.getPlace_length()));
            projcet6_place_width.setText(String.valueOf(placeSpecialIndexEntity.getPlace_width()));

            project6_wood_flooring.setChecked(false);
            project6_Cement.setChecked(false);
            project6_pitch.setChecked(false);
            projcet6_soil.setChecked(false);
            project6_other.setChecked(false);

            if (placeSpecialIndexEntity.getPlace_surface().equals(project6_wood_flooring.getText().toString()))
                project6_wood_flooring.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project6_Cement.getText().toString()))
                project6_Cement.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project6_pitch.getText().toString()))
                project6_pitch.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(projcet6_soil.getText().toString()))
                projcet6_soil.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project6_other.getText().toString()))
                project6_other.setChecked(true);

            project6_light_device_y.setChecked(false);
            project6_light_device_n.setChecked(false);

            if (placeSpecialIndexEntity.getLight_device() == 1)
                project6_light_device_y.setChecked(true);
            else if (placeSpecialIndexEntity.getLight_device() == 2)
                project6_light_device_n.setChecked(true);
        }
    }

    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setViewers_seats(Integer.valueOf(project6_viewers_seats.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setTrack_length(projcet6_track_length.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_length(project6_place_length.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_width(projcet6_place_width.getText().toString());

        if (project6_wood_flooring.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project6_wood_flooring.getText().toString());
        } else if (project6_Cement.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project6_Cement.getText().toString());
        } else if (project6_pitch.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project6_pitch.getText().toString());
        } else if (projcet6_soil.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(projcet6_soil.getText().toString());
        } else if (project6_other.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project6_other.getText().toString());
        }

        if (project6_light_device_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setLight_device(1);
        } else if (project6_light_device_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setLight_device(2);
        }
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);

        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia();
        }


        if (project6_viewers_seats.getText().toString().isEmpty()) {
            project6_viewers_seats.setText("0");
            PromptManager.showToast(getActivity(), "观众席位不能为空，没有可填0");
            return false;
        } else if (projcet6_track_length.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "赛道周长不能为空");
            return false;
        } else if (project6_place_length.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "场地宽度不能为空");
            return false;
        } else if (projcet6_place_width.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "场地长度不能为空");
            return false;
        } else return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.project6_note1:
                StringBuilder stringBuilder = new StringBuilder();
                if (application.getTypeID() == 61) {
                    stringBuilder.append(getActivity().getString(R.string.help_y6_1));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 62) {
                    stringBuilder.append(getActivity().getString(R.string.help_y6_2));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 63) {
                    stringBuilder.append(getActivity().getString(R.string.help_y6_3));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 64) {
                    stringBuilder.append(getActivity().getString(R.string.help_y6_4));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 65) {
                    stringBuilder.append(getActivity().getString(R.string.help_y6_5));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 66) {
                    stringBuilder.append(getActivity().getString(R.string.help_y6_6));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 67) {
                    stringBuilder.append(getActivity().getString(R.string.help_y6_7));
                    stringBuilder.append("\r\n");
                }
                stringBuilder.append(getActivity().getString(R.string.help_y6_8));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y6_11));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project6_note2:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y6_9));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y6_10));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project6_note3:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y6_12));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project6_note4:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y6_13));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;

        }
    }
}
