package com.firstvrp.censusdata.PlaceTable;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

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
public class PlaceSpecialProject14 extends Fragment implements IBtnCallListener, View.OnClickListener {
    private EditText project14_instrument_quantity;
    private View view;
    private ImageView project14_note1;
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
        view = inflater.inflate(R.layout.fragment_place_special_project14, container, false);
        project14_instrument_quantity = (EditText) view.findViewById(R.id.project14_instrument_quantity);

        //帮助
        project14_note1 = (ImageView) view.findViewById(R.id.project14_note1);
        project14_note1.setOnClickListener(this);

        application = (MyApplication) getActivity().getApplication();
        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null && application.getPlaceInfoEntity().getPlaceSpecialIndex() != null) {
            PlaceSpecialIndexEntity placeSpecialIndexEntity = application.getPlaceInfoEntity().getPlaceSpecialIndex();
            project14_instrument_quantity.setText(String.valueOf(placeSpecialIndexEntity.getInstrument_quantity()));
        }
    }

    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setInstrument_quantity(Integer.valueOf(project14_instrument_quantity.getText().toString()));

        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);

        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia();
        }

        if (project14_instrument_quantity.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "器械数量不能为空");
            return false;
        } else return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.project14_note1:
                StringBuilder stringBuilder = new StringBuilder();

                stringBuilder.append(getActivity().getString(R.string.help_y14_1));
                stringBuilder.append("\r\n\n");

                stringBuilder.append(getActivity().getString(R.string.help_y14_2));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
        }

    }
}
