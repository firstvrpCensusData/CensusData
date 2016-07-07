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
 * 专项场地信息乙表01
 */
public class PlaceSpecialProject1 extends Fragment implements IBtnCallListener, View.OnClickListener {
    private EditText project1_viewers_seats, project1_track_quantity,
            project1_track_length;
    private RadioButton project1_screen_device_y, project1_screen_device_n,
            project1_light_device_y, project1_light_device_n,
            project1_pvc, project1_coal,
            project1_other, project1_grass,
            project1_pedaline, project1_soil,
            project1_other1;

    private ImageView project1_note1, project1_note2, project1_note3, project1_note4, project1_note5;
    private View view;
    private MyApplication application;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_place_special_project1, container, false);

        application = (MyApplication) getActivity().getApplication();
        project1_viewers_seats = (EditText) view.findViewById(R.id.project1_viewers_seats);
        project1_track_quantity = (EditText) view.findViewById(R.id.project1_track_quantity);
        project1_track_length = (EditText) view.findViewById(R.id.project1_track_length);

        project1_screen_device_y = (RadioButton) view.findViewById(R.id.project1_screen_device_y);
        project1_screen_device_n = (RadioButton) view.findViewById(R.id.project1_screen_device_n);

        project1_light_device_y = (RadioButton) view.findViewById(R.id.project1_light_device_y);
        project1_light_device_n = (RadioButton) view.findViewById(R.id.project1_light_device_n);

        project1_pvc = (RadioButton) view.findViewById(R.id.project1_pvc);
        project1_coal = (RadioButton) view.findViewById(R.id.project1_coal);
        project1_other = (RadioButton) view.findViewById(R.id.project1_other);

        project1_grass = (RadioButton) view.findViewById(R.id.project1_grass);
        project1_pedaline = (RadioButton) view.findViewById(R.id.project1_pedaline);
        project1_soil = (RadioButton) view.findViewById(R.id.project1_soil);
        project1_other1 = (RadioButton) view.findViewById(R.id.project1_other1);

        project1_note1 = (ImageView) view.findViewById(R.id.project1_note1);
        project1_note2 = (ImageView) view.findViewById(R.id.project1_note2);
        project1_note3 = (ImageView) view.findViewById(R.id.project1_note3);
        project1_note4 = (ImageView) view.findViewById(R.id.project1_note4);
        project1_note5 = (ImageView) view.findViewById(R.id.project1_note5);
        project1_note1.setOnClickListener(this);
        project1_note2.setOnClickListener(this);
        project1_note3.setOnClickListener(this);
        project1_note4.setOnClickListener(this);
        project1_note5.setOnClickListener(this);

        if (application.getTypeID() == 1) {
            project1_viewers_seats.setHint(R.string.greater_five_hundred);
            project1_track_quantity.setHint(R.string.greater_six);
            project1_track_length.setHint(R.string.equal_four_hundred);
            project1_track_length.setText(String.valueOf(400));
        }
        if (application.getTypeID() == 2) {
            project1_track_quantity.setHint(R.string.greater_one);
            project1_viewers_seats.setHint(R.string.less_five_hundred);
            project1_track_length.setHint(R.string.equal_four_hundred);
        }
        if (application.getTypeID() == 3) {
            project1_track_length.setHint(R.string.greater_two_hundred);
        }
        if (application.getTypeID() == 4) {
            project1_track_length.setHint(R.string.greater_two_hundred_less_four_hundred);
        }

        forcingDefault();

        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null && application.getPlaceInfoEntity().getPlaceSpecialIndex() != null) {
            PlaceSpecialIndexEntity placeSpecialIndexEntity = application.getPlaceInfoEntity().getPlaceSpecialIndex();

            project1_viewers_seats.setText(String.valueOf(placeSpecialIndexEntity.getViewers_seats()));
            project1_track_quantity.setText(String.valueOf(placeSpecialIndexEntity.getTrack_quantity()));
            project1_track_length.setText(String.valueOf(placeSpecialIndexEntity.getTrack_length()));

            project1_screen_device_y.setChecked(false);
            project1_screen_device_n.setChecked(false);

            project1_light_device_y.setChecked(false);
            project1_light_device_n.setChecked(false);

            project1_pvc.setChecked(false);
            project1_coal.setChecked(false);
            project1_other.setChecked(false);

            project1_grass.setChecked(false);
            project1_pedaline.setChecked(false);
            project1_soil.setChecked(false);
            project1_other1.setChecked(false);

            if (placeSpecialIndexEntity.getScreen_device() == 1)
                project1_screen_device_y.setChecked(true);
            else if (placeSpecialIndexEntity.getScreen_device() == 2)
                project1_screen_device_n.setChecked(true);

            if (placeSpecialIndexEntity.getLight_device() == 1)
                project1_light_device_y.setChecked(true);
            else if (placeSpecialIndexEntity.getLight_device() == 2)
                project1_light_device_n.setChecked(true);

            if (placeSpecialIndexEntity.getTrack_surface().equals(project1_pvc.getText().toString()))
                project1_pvc.setChecked(true);
            else if (placeSpecialIndexEntity.getTrack_surface().equals(project1_coal.getText().toString()))
                project1_coal.setChecked(true);
            else if (placeSpecialIndexEntity.getTrack_surface().equals(project1_other.getText().toString()))
                project1_other.setChecked(true);

            if (placeSpecialIndexEntity.getCenter_surface().equals(project1_grass.getText().toString()))
                project1_grass.setChecked(true);
            else if (placeSpecialIndexEntity.getCenter_surface().equals(project1_pedaline.getText().toString()))
                project1_pedaline.setChecked(true);
            else if (placeSpecialIndexEntity.getCenter_surface().equals(project1_soil.getText().toString()))
                project1_soil.setChecked(true);
            else if (placeSpecialIndexEntity.getCenter_surface().equals(project1_other1.getText().toString()))
                project1_other1.setChecked(true);
        }
    }

    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setViewers_seats(Integer.valueOf(project1_viewers_seats.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setTrack_quantity(Integer.valueOf(project1_track_quantity.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setTrack_length(project1_track_length.getText().toString());
        if (project1_screen_device_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setScreen_device(1);
        } else if (project1_screen_device_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setScreen_device(2);
        }
        if (project1_light_device_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setLight_device(1);
        } else if (project1_light_device_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setLight_device(2);
        }
        if (project1_pvc.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setTrack_surface(project1_pvc.getText().toString());
        } else if (project1_coal.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setTrack_surface(project1_coal.getText().toString());
        } else if (project1_other.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setTrack_surface(project1_other.getText().toString());
        }
        if (project1_grass.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setCenter_surface(project1_grass.getText().toString());
        } else if (project1_pedaline.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setCenter_surface(project1_pedaline.getText().toString());
        } else if (project1_soil.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setCenter_surface(project1_soil.getText().toString());
        } else if (project1_other1.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setCenter_surface(project1_other1.getText().toString());
        }

        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);
        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia();
        }


        if (project1_viewers_seats.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "观众席位不能为空，没有可填0");
            return false;
        } else if (project1_track_quantity.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "场地数量不能为空，没有可填0");
            return false;
        } else if (project1_track_length.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "场地长度不能为空");
            return false;
        } else if (project1_track_length.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "场地宽度不能为空");
            return false;
        } else return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.project1_note1:
                StringBuilder stringBuilder = new StringBuilder();

                if (application.getTypeID() == 1) {
                    stringBuilder.append(getActivity().getString(R.string.help_y1_1));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 2) {
                    stringBuilder.append(getActivity().getString(R.string.help_y1_2));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 3) {
                    stringBuilder.append(getActivity().getString(R.string.help_y1_3));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 4) {
                    stringBuilder.append(getActivity().getString(R.string.help_y1_4));
                    stringBuilder.append("\r\n\n");
                }

                stringBuilder.append(getActivity().getString(R.string.help_y1_24));
                stringBuilder.append("\r\n\n");
                stringBuilder.append(getActivity().getString(R.string.help_y1_27));
                stringBuilder.append("\r\n\n");
                stringBuilder.append(getActivity().getString(R.string.help_y1_28));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project1_note2:
                stringBuilder = new StringBuilder();

                stringBuilder.append(getActivity().getString(R.string.help_y1_25));
                stringBuilder.append("\r\n\n");

                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project1_note3:
                stringBuilder = new StringBuilder();

                stringBuilder.append(getActivity().getString(R.string.help_y1_26));
                stringBuilder.append("\r\n\n");

                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project1_note4:
                stringBuilder = new StringBuilder();

                stringBuilder.append(getActivity().getString(R.string.help_y1_29));
                stringBuilder.append("\r\n\n");

                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project1_note5:
                stringBuilder = new StringBuilder();

                stringBuilder.append(getActivity().getString(R.string.help_y1_30));
                stringBuilder.append("\r\n\n");

                new HelpDialog(getActivity(), stringBuilder.toString());
                break;

        }
    }
}
