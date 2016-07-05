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
 *
 */
public class PlaceSpecialProject12 extends Fragment implements IBtnCallListener, View.OnClickListener {
    private EditText project12_rock_ice_quantity;
    private RadioButton project12_light_device_y, project12_light_device_n;
    private View view;
    private ImageView project12_note1, project12_note2;

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
        view = inflater.inflate(R.layout.fragment_place_special_project12, container, false);
        project12_rock_ice_quantity = (EditText) view.findViewById(R.id.project12_rock_ice_quantity);
        project12_light_device_y = (RadioButton) view.findViewById(R.id.project12_light_device_y);
        project12_light_device_n = (RadioButton) view.findViewById(R.id.project12_light_device_n);

        //帮助
        project12_note1 = (ImageView) view.findViewById(R.id.project12_note1);
        project12_note2 = (ImageView) view.findViewById(R.id.project12_note2);
        project12_note1.setOnClickListener(this);
        project12_note2.setOnClickListener(this);


        application = (MyApplication) getActivity().getApplication();

        forcingDefault();

        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null && application.getPlaceInfoEntity().getPlaceSpecialIndex() != null) {
            PlaceSpecialIndexEntity placeSpecialIndexEntity = application.getPlaceInfoEntity().getPlaceSpecialIndex();
            project12_rock_ice_quantity.setText(String.valueOf(placeSpecialIndexEntity.getRock_ice_quantity()));

            project12_light_device_y.setChecked(false);
            project12_light_device_n.setChecked(false);

            if (placeSpecialIndexEntity.getLight_device() == 1)
                project12_light_device_y.setChecked(true);
            else if (placeSpecialIndexEntity.getLight_device() == 2)
                project12_light_device_n.setChecked(true);

        }
    }

    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setRock_ice_quantity(Integer.valueOf(project12_rock_ice_quantity.getText().toString()));

        if (project12_light_device_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setLight_device(1);
        } else {
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


        if (project12_rock_ice_quantity.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "岩/冰壁数量不能为空");
            return false;
        } else return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.project12_note1:
                StringBuilder stringBuilder = new StringBuilder();
                if (application.getTypeID() == 77) {
                    stringBuilder.append(getActivity().getString(R.string.help_y12_1));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 78) {
                    stringBuilder.append(getActivity().getString(R.string.help_y12_2));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 79) {
                    stringBuilder.append(getActivity().getString(R.string.help_y12_3));
                    stringBuilder.append("\r\n\n");
                }
                stringBuilder.append(getActivity().getString(R.string.help_y12_4));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project12_note2:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y12_5));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
        }
    }
}
