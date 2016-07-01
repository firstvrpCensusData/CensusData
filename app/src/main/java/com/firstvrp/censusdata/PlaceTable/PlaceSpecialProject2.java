package com.firstvrp.censusdata.PlaceTable;

import android.app.Activity;
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
 * 专项场地信息乙表02
 */
public class PlaceSpecialProject2 extends Fragment implements IBtnCallListener, View.OnClickListener {
    private EditText project2_viewers_seats, project2_place_length, project2_place_width,
            project2_indoor_high;
    private RadioButton project2_screen_device_y, project2_screen_device_n;

    private RadioButton project2_board, project2_complex, project2_cement, project2_other;

    private MyApplication application;

    private ImageView project2_note1, project2_note2, project2_note3;

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
        View view = inflater.inflate(R.layout.fragment_place_special_project2, container, false);
        project2_viewers_seats = (EditText) view.findViewById(R.id.project2_viewers_seats);
        project2_place_length = (EditText) view.findViewById(R.id.project2_place_length);
        project2_place_width = (EditText) view.findViewById(R.id.project2_place_width);
        project2_indoor_high = (EditText) view.findViewById(R.id.project2_indoor_high);

        project2_screen_device_y = (RadioButton) view.findViewById(R.id.project2_screen_device_y);
        project2_screen_device_n = (RadioButton) view.findViewById(R.id.project2_screen_device_n);

        project2_board = (RadioButton) view.findViewById(R.id.project2_board);
        project2_complex = (RadioButton) view.findViewById(R.id.project2_complex);
        project2_cement = (RadioButton) view.findViewById(R.id.project2_cement);
        project2_other = (RadioButton) view.findViewById(R.id.project2_other);

        //帮助
        project2_note1 = (ImageView) view.findViewById(R.id.project2_note1);
        project2_note2 = (ImageView) view.findViewById(R.id.project2_note2);
        project2_note3 = (ImageView) view.findViewById(R.id.project2_note3);
        project2_note1.setOnClickListener(this);
        project2_note2.setOnClickListener(this);
        project2_note3.setOnClickListener(this);


        application = (MyApplication) getActivity().getApplication();

        if (application.getTypeID() == 5) {
            project2_viewers_seats.setHint(getActivity().getString(R.string.greater_equal_five_hundred));
        }

        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null) {
            PlaceSpecialIndexEntity placeSpecialIndexEntity = application.getPlaceInfoEntity().getPlaceSpecialIndex();

            project2_viewers_seats.setText(String.valueOf(placeSpecialIndexEntity.getViewers_seats()));
            project2_place_length.setText(String.valueOf(placeSpecialIndexEntity.getPlace_length()));
            project2_place_width.setText(String.valueOf(placeSpecialIndexEntity.getPlace_width()));
            project2_indoor_high.setText(String.valueOf(placeSpecialIndexEntity.getIndoor_high()));
            project2_screen_device_y.setChecked(false);
            project2_screen_device_n.setChecked(false);

            project2_board.setChecked(false);
            project2_complex.setChecked(false);
            project2_cement.setChecked(false);
            project2_other.setChecked(false);

            if (placeSpecialIndexEntity.getLight_device() == 1)
                project2_screen_device_y.setChecked(true);
            else if (placeSpecialIndexEntity.getLight_device() == 2)
                project2_screen_device_y.setChecked(true);

            if (placeSpecialIndexEntity.getPlace_surface().equals(project2_board.getText().toString()))
                project2_board.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project2_complex.getText().toString()))
                project2_complex.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project2_cement.getText().toString()))
                project2_cement.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project2_other.getText().toString()))
                project2_other.setChecked(true);
        }
    }

    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setViewers_seats(Integer.valueOf(project2_viewers_seats.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_length(project2_place_length.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_width(project2_place_width.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setIndoor_high(project2_indoor_high.getText().toString());

        if (project2_screen_device_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setScreen_device(project2_screen_device_y.getText().toString().equals("有") ? 1 : 2);
        } else if (project2_screen_device_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setScreen_device(project2_screen_device_y.getText().toString().equals("无") ? 2 : 1);
        }

        if (project2_board.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project2_board.getText().toString());
        } else if (project2_complex.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project2_complex.getText().toString());
        } else if (project2_cement.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project2_cement.getText().toString());
        } else if (project2_other.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project2_other.getText().toString());
        }
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);
        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia();}

        if (project2_viewers_seats.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "观众席位不能为空");
            return false;
        } else if (project2_place_length.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "场地长度不能为空");
            return false;
        } else if (project2_place_width.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "场地宽度不能为空");
            return false;
        } else if (project2_indoor_high.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "室内净高不能为空");
            return false;
        }else return true;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.project2_note1:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y2_1));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y2_2));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y2_4));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y2_5));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y2_6));
                stringBuilder.append("\r\n");

                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project2_note2:
                stringBuilder = new StringBuilder();

                stringBuilder.append(getActivity().getString(R.string.help_y2_3));
                stringBuilder.append("\r\n");

                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project2_note3:
                stringBuilder = new StringBuilder();

                stringBuilder.append(getActivity().getString(R.string.help_y2_7));
                stringBuilder.append("\r\n");

                new HelpDialog(getActivity(), stringBuilder.toString());
                break;

        }
    }
}
