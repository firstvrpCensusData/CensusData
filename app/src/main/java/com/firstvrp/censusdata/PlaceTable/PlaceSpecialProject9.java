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
public class PlaceSpecialProject9 extends Fragment implements IBtnCallListener, View.OnClickListener {
    private EditText project9_track_length, project9_track_width;
    private RadioButton project9_cement, projcet9_pitch, project9_sandy_soil, project9_other;
    private View view;
    private ImageView project9_note1, project9_note2;
    private MyApplication application;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_place_special_project9, container, false);

        project9_track_length = (EditText) view.findViewById(R.id.project9_track_length);
        project9_track_width = (EditText) view.findViewById(R.id.project9_track_width);

        project9_cement = (RadioButton) view.findViewById(R.id.project9_cement);
        projcet9_pitch = (RadioButton) view.findViewById(R.id.projcet9_pitch);
        project9_sandy_soil = (RadioButton) view.findViewById(R.id.project9_sandy_soil);
        project9_other = (RadioButton) view.findViewById(R.id.project9_other);

        //帮助
        project9_note1 = (ImageView) view.findViewById(R.id.project9_note1);
        project9_note2 = (ImageView) view.findViewById(R.id.project9_note2);
        project9_note1.setOnClickListener(this);
        project9_note2.setOnClickListener(this);

        application = (MyApplication) getActivity().getApplication();
        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null && application.getPlaceInfoEntity().getPlaceSpecialIndex() != null) {
            PlaceSpecialIndexEntity placeSpecialIndexEntity = application.getPlaceInfoEntity().getPlaceSpecialIndex();
            project9_track_length.setText(String.valueOf(placeSpecialIndexEntity.getTrack_length()));
            project9_track_width.setText(String.valueOf(placeSpecialIndexEntity.getTrack_width()));

            project9_cement.setChecked(false);
            projcet9_pitch.setChecked(false);
            project9_sandy_soil.setChecked(false);
            project9_other.setChecked(false);
            if (placeSpecialIndexEntity.getTrack_surface().equals(project9_cement.getText().toString()))
                project9_cement.setChecked(true);
            else if (placeSpecialIndexEntity.getTrack_surface().equals(projcet9_pitch.getText().toString()))
                projcet9_pitch.setChecked(true);
            else if (placeSpecialIndexEntity.getTrack_surface().equals(project9_sandy_soil.getText().toString()))
                project9_sandy_soil.setChecked(true);
            else if (placeSpecialIndexEntity.getTrack_surface().equals(project9_other.getText().toString()))
                project9_other.setChecked(true);
        }
    }

    @Override
    public boolean transfermsg() {

        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setTrack_length(project9_track_length.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setTrack_length(project9_track_width.getText().toString());

        if (project9_cement.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setTrack_surface(project9_cement.getText().toString());
        } else if (projcet9_pitch.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setTrack_surface(projcet9_pitch.getText().toString());

        } else if (project9_sandy_soil.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setTrack_surface(project9_sandy_soil.getText().toString());

        } else if (project9_other.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setTrack_surface(project9_other.getText().toString());
        }

        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);

        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia();
        }

        if (project9_track_length.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "跑道长度不能为空");
            return false;
        } else if (project9_track_width.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "跑道宽度不能为空");
            return false;
        } else return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.project9_note1:
                StringBuilder stringBuilder = new StringBuilder();

                stringBuilder.append(getActivity().getString(R.string.help_y9_1));
                stringBuilder.append("\r\n\n");

                stringBuilder.append(getActivity().getString(R.string.help_y9_2));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y9_3));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project9_note2:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y9_4));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
        }
    }
}
