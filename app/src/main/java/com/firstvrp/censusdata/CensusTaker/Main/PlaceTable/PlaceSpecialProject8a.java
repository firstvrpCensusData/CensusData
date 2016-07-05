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
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class PlaceSpecialProject8a extends Fragment implements IBtnCallListener, View.OnClickListener {
    private EditText project8a_boathouse_area, project8a_dock_numbers, project8a_pier_numbers;

    private RadioButton project8a_artificial_channel_y, project8a_artificial_channel_n;
private ImageView project8a_note1;
    private MyApplication application;
    private View view;

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
        view = inflater.inflate(R.layout.fragment_place_special_project8a, container, false);
        project8a_boathouse_area = (EditText) view.findViewById(R.id.project8a_boathouse_area);
        project8a_dock_numbers   = (EditText) view.findViewById(R.id.project8a_dock_numbers);
        project8a_pier_numbers   = (EditText) view.findViewById(R.id.project8a_pier_numbers);

        project8a_artificial_channel_y= (RadioButton) view.findViewById(R.id.project8a_artificial_channel_y);
        project8a_artificial_channel_n = (RadioButton) view.findViewById(R.id.project8a_artificial_channel_n);

        //帮助
        project8a_note1 = (ImageView) view.findViewById(R.id.project8a_note1);
        project8a_note1.setOnClickListener(this);

        application = (MyApplication) getActivity().getApplication();

        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null && application.getPlaceInfoEntity().getPlaceSpecialIndex() != null) {
            PlaceSpecialIndexEntity placeSpecialIndexEntity = application.getPlaceInfoEntity().getPlaceSpecialIndex();
            project8a_boathouse_area.setText(String.valueOf(placeSpecialIndexEntity.getBoathouse_area()));
            project8a_dock_numbers.setText(String.valueOf(placeSpecialIndexEntity.getDock_numbers()));
            project8a_pier_numbers.setText(String.valueOf(placeSpecialIndexEntity.getPier_numbers()));
            project8a_artificial_channel_y.setChecked(false);
            project8a_artificial_channel_n.setChecked(false);

            if (placeSpecialIndexEntity.getShelter() == 1)
                project8a_artificial_channel_y.setChecked(true);
            if (placeSpecialIndexEntity.getShelter() == 2)
                project8a_artificial_channel_n.setChecked(true);
        }

    }

    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setBoathouse_area(project8a_boathouse_area.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setDock_numbers(Integer.valueOf(project8a_dock_numbers.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPier_numbers(Integer.valueOf(project8a_pier_numbers.getText().toString()));

        if (project8a_artificial_channel_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setShelter(1);
        } else if (project8a_artificial_channel_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setShelter(2);
        }

        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);

        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia(); }


        if (project8a_boathouse_area.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "船库面积不能为空，没有可填0");
            return false;
        } else if (project8a_dock_numbers.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "船坞个数不能为空");
            return false;
        } else if (project8a_pier_numbers.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "码头个数不能为空");
            return false;
        }  else return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.project8a_note1:
                StringBuilder stringBuilder = new StringBuilder();
                if (application.getTypeID() == 70) {
                    stringBuilder.append(getActivity().getString(R.string.help_y8_1));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 71) {
                    stringBuilder.append(getActivity().getString(R.string.help_y8_2));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 72) {
                    stringBuilder.append(getActivity().getString(R.string.help_y8_3));
                    stringBuilder.append("\r\n\n");
                }
                stringBuilder.append(getActivity().getString(R.string.help_y8_4));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y8_5));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y8_6));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;

        }
    }
}
