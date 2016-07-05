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
public class PlaceSpecialProject10 extends Fragment implements IBtnCallListener, View.OnClickListener {
    private EditText project10_trail_length, project10_trail_width,
            project10_cableway_quantity, project10_cableway_length;
    private RadioButton project10_jumping_y, project10_jumping_n;
    private RadioButton project10_light_device_y, project10_light_device_n;
    private ImageView project10_note1, project10_note2, project10_note3;
    MyApplication application;
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
        view = inflater.inflate(R.layout.fragment_place_special_project10, container, false);
        project10_trail_length = (EditText) view.findViewById(R.id.project10_trail_length);
        project10_trail_width = (EditText) view.findViewById(R.id.project10_trail_width);
        project10_cableway_quantity = (EditText) view.findViewById(R.id.project10_cableway_quantity);
        project10_cableway_length = (EditText) view.findViewById(R.id.project10_cableway_length);

        project10_jumping_y = (RadioButton) view.findViewById(R.id.project10_jumping_y);
        project10_jumping_n = (RadioButton) view.findViewById(R.id.project10_jumping_n);

        project10_light_device_y = (RadioButton) view.findViewById(R.id.project10_light_device_y);
        project10_light_device_n = (RadioButton) view.findViewById(R.id.project10_light_device_n);

        //帮助
        project10_note1 = (ImageView) view.findViewById(R.id.project10_note1);
        project10_note2 = (ImageView) view.findViewById(R.id.project10_note1);
        project10_note3 = (ImageView) view.findViewById(R.id.project10_note3);
        project10_note1.setOnClickListener(this);
        project10_note2.setOnClickListener(this);
        project10_note3.setOnClickListener(this);

        application = (MyApplication) getActivity().getApplication();

        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null && application.getPlaceInfoEntity().getPlaceSpecialIndex() != null) {
            PlaceSpecialIndexEntity placeSpecialIndexEntity = application.getPlaceInfoEntity().getPlaceSpecialIndex();
            project10_trail_length.setText(String.valueOf(placeSpecialIndexEntity.getTrail_length()));
            project10_trail_width.setText(String.valueOf(placeSpecialIndexEntity.getTrail_width()));
            project10_cableway_quantity.setText(String.valueOf(placeSpecialIndexEntity.getCableway_quantity()));
            project10_cableway_length.setText(String.valueOf(placeSpecialIndexEntity.getCableway_length()));

            project10_jumping_y.setChecked(false);
            project10_jumping_n.setChecked(false);
            if (placeSpecialIndexEntity.getJumping() == 1) {
                project10_jumping_y.setChecked(true);
            } else if (placeSpecialIndexEntity.getJumping() == 2) {
                project10_jumping_n.setChecked(true);
            }
            project10_light_device_y.setChecked(false);
            project10_light_device_n.setChecked(false);
            if (placeSpecialIndexEntity.getLight_device() == 1) {
                project10_light_device_y.setChecked(true);
            } else if (placeSpecialIndexEntity.getLight_device() == 2) {
                project10_light_device_n.setChecked(true);
            }

        }
    }


    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setTrail_length(project10_trail_length.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setTrail_width(project10_trail_width.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setCableway_quantity(Integer.valueOf(project10_cableway_quantity.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setCableway_length(project10_cableway_length.getText().toString());

        if (project10_jumping_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setJumping(1);
        } else if (project10_jumping_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setJumping(2);
        }

        if (project10_light_device_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setLight_device(1);
        } else if (project10_light_device_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setLight_device(2);
        }

        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);

        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia();}
        if (project10_trail_length.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "雪道长度不能为空，没有可填0");
            return false;
        } else if (project10_trail_width.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "雪道宽度不能为空");
            return false;
        } else if (project10_cableway_quantity.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "索道数量不能为空");
            return false;
        } else if (project10_cableway_length.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "索道总长度不能为空");
            return false;
        } else return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.project10_note1:
                StringBuilder stringBuilder = new StringBuilder();

                if (application.getTypeID() == 74) {
                    stringBuilder.append(getActivity().getString(R.string.help_y10_1));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 75) {
                    stringBuilder.append(getActivity().getString(R.string.help_y10_2));
                    stringBuilder.append("\r\n\n");
                }
                stringBuilder.append(getActivity().getString(R.string.help_y10_3));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y10_4));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y10_5));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y10_6));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project10_note2:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y10_7));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project10_note3:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y10_8));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
        }
    }
}
