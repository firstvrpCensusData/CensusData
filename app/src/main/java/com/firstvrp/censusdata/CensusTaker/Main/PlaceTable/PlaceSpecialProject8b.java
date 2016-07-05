package com.firstvrp.censusdata.CensusTaker.Main.PlaceTable;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.firstvrp.censusdata.CensusTaker.Main.CompanyInformation.CompanyInfomationActivity;
import com.firstvrp.censusdata.CensusTaker.Main.CompanyInformation.IBtnCallListener;
import com.firstvrp.censusdata.CensusTaker.Main.Dialog.HelpDialog;
import com.firstvrp.censusdata.Entity.PlaceSpecialIndexEntity;
import com.firstvrp.censusdata.MyApplication;
import com.firstvrp.censusdata.R;

import Utils.PromptManager;

/**
 *
 */
public class PlaceSpecialProject8b extends Fragment implements IBtnCallListener, View.OnClickListener {
    private EditText project8_swim_water_area;
    private View view;
    private ImageView project8b_note1;
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
        view = inflater.inflate(R.layout.fragment_place_special_project8b, container, false);

        project8_swim_water_area = (EditText) view.findViewById(R.id.project8_swim_water_area);

        //帮助
        project8b_note1 = (ImageView) view.findViewById(R.id.project8b_note1);
        project8b_note1.setOnClickListener(this);

        application = (MyApplication) getActivity().getApplication();

        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null && application.getPlaceInfoEntity().getPlaceSpecialIndex() != null) {
            PlaceSpecialIndexEntity placeSpecialIndexEntity = application.getPlaceInfoEntity().getPlaceSpecialIndex();
            project8_swim_water_area.setText(String.valueOf(placeSpecialIndexEntity.getSwim_water_area()));
        }
    }

    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setSwim_water_area(project8_swim_water_area.getText().toString());

        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);

        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia(); }


        if (project8_swim_water_area.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "水面面积不能为空");
            return false;
        }  else return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.project8b_note1:
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
                stringBuilder.append(getActivity().getString(R.string.help_y8_8));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
        }
    }
}
