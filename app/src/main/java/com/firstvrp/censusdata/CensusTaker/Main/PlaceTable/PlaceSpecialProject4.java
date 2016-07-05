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
public class PlaceSpecialProject4 extends Fragment implements IBtnCallListener, View.OnClickListener {
    private EditText project4_viewers_seats, project4_place_quantity, project4_place_length,
            project4_place_width, project4_indoor_high;
    private RadioButton project4_wood_flooring, project4_synthetic_material,
            project4_cement, project4_ice,
            project4_sandy_soil, project4_other;
    private View view;
    private ImageView project4_note1, project4_note2, project4_note3;
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
        view = inflater.inflate(R.layout.fragment_place_special_project4, container, false);
        project4_viewers_seats = (EditText) view.findViewById(R.id.project4_viewers_seats);
        project4_place_quantity = (EditText) view.findViewById(R.id.project4_place_quantity);
        project4_place_length = (EditText) view.findViewById(R.id.project4_place_length);
        project4_place_width = (EditText) view.findViewById(R.id.project4_place_width);
        project4_indoor_high = (EditText) view.findViewById(R.id.project4_indoor_high);

        project4_wood_flooring = (RadioButton) view.findViewById(R.id.project4_wood_flooring);
        project4_synthetic_material = (RadioButton) view.findViewById(R.id.project4_synthetic_material);
        project4_cement = (RadioButton) view.findViewById(R.id.project4_cement);
        project4_ice = (RadioButton) view.findViewById(R.id.project4_ice);
        project4_sandy_soil = (RadioButton) view.findViewById(R.id.project4_sandy_soil);
        project4_other = (RadioButton) view.findViewById(R.id.project4_other);

        //帮助
        project4_note1 = (ImageView) view.findViewById(R.id.project4_note1);
        project4_note2 = (ImageView) view.findViewById(R.id.project4_note2);
        project4_note3 = (ImageView) view.findViewById(R.id.project4_note3);
        project4_note1.setOnClickListener(this);
        project4_note2.setOnClickListener(this);
        project4_note3.setOnClickListener(this);

        application = (MyApplication) getActivity().getApplication();
        if (application.getTypeID() == 11) {
            project4_place_length.setHint(getActivity().getString(R.string.greater_equal_twenty_eight));
            project4_place_width.setHint(getActivity().getString(R.string.greater_equal_fifteen));
        }

        if (application.getTypeID() == 12) {
            project4_place_length.setHint(getActivity().getString(R.string.greater_equal_eighteen));
            project4_place_width.setHint(getActivity().getString(R.string.greater_equal_nine));
        }

        if (application.getTypeID() == 13) {
            project4_place_length.setHint(getActivity().getString(R.string.greater_equal_forty));
            project4_place_width.setHint(getActivity().getString(R.string.greater_equal_twenty));
        }

        if (application.getTypeID() == 14) {
            project4_place_length.setHint(getActivity().getString(R.string.greater_equal_forty));
            project4_place_width.setHint(getActivity().getString(R.string.greater_equal_twenty_five));
        }

        if (application.getTypeID() == 15) {
            project4_place_length.setHint(getActivity().getString(R.string.greater_equal_thirteen_four));
            project4_place_width.setHint(getActivity().getString(R.string.greater_equal_five_eighteen));
        }

        if (application.getTypeID() == 16) {

        }

        if (application.getTypeID() == 17) {
            project4_place_length.setHint(getActivity().getString(R.string.greater_equal_twelfth));
            project4_place_width.setHint(getActivity().getString(R.string.greater_equal_twelfth));
        }

        if (application.getTypeID() == 18) {

        }

        if (application.getTypeID() == 19) {
            project4_place_length.setHint(getActivity().getString(R.string.greater_equal_four));
            project4_place_width.setHint(getActivity().getString(R.string.greater_equal_four));
        }

        if (application.getTypeID() == 20) {
            project4_place_length.setHint(getActivity().getString(R.string.greater_equal_forteen));
            project4_place_width.setHint(getActivity().getString(R.string.greater_equal_two));
        }

        if (application.getTypeID() == 21) {

        }

        if (application.getTypeID() == 22) {

        }

        if (application.getTypeID() == 24) {

        }

        if (application.getTypeID() == 25) {

        }
        if (application.getTypeID() == 26) {
            project4_place_length.setHint(getActivity().getString(R.string.greater_equal_twenty_five));
            project4_place_width.setHint(getActivity().getString(R.string.greater_equal_fifteen));
        }
        if (application.getTypeID() == 27) {
            project4_place_length.setHint(getActivity().getString(R.string.greater_equal_twenty_three_seven_seven));
            project4_place_width.setHint(getActivity().getString(R.string.greater_equal_eight_twenty_three));
        }
        if (application.getTypeID() == 28) {
            project4_place_length.setHint(getActivity().getString(R.string.greater_equal_ninety_one_four));
            project4_place_width.setHint(getActivity().getString(R.string.greater_equal_fifty_five));
        }
        if (application.getTypeID() == 29) {

        }
        if (application.getTypeID() == 30) {

        }

        if (application.getTypeID() == 31) {
            project4_place_length.setHint(getActivity().getString(R.string.greater_equal_fifty_six));
            project4_place_width.setHint(getActivity().getString(R.string.greater_equal_twenty_six));
        }

        if (application.getTypeID() == 32) {

        }

        if (application.getTypeID() == 34) {
            project4_place_width.setHint(getActivity().getString(R.string.greater_equal_five));
        }
        if (application.getTypeID() == 35) {

        }
        if (application.getTypeID() == 36) {

        }

        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null && application.getPlaceInfoEntity().getPlaceSpecialIndex() != null) {
            PlaceSpecialIndexEntity placeSpecialIndexEntity = application.getPlaceInfoEntity().getPlaceSpecialIndex();
            project4_viewers_seats.setText(String.valueOf(placeSpecialIndexEntity.getViewers_seats()));
            project4_place_quantity.setText(String.valueOf(placeSpecialIndexEntity.getPlace_quantity()));

            project4_place_length.setText(String.valueOf(placeSpecialIndexEntity.getPlace_length()));
            project4_place_width.setText(String.valueOf(placeSpecialIndexEntity.getPlace_width()));
            project4_indoor_high.setText(String.valueOf(placeSpecialIndexEntity.getIndoor_high()));

            project4_wood_flooring.setChecked(false);
            project4_synthetic_material.setChecked(false);
            project4_cement.setChecked(false);
            project4_ice.setChecked(false);
            project4_sandy_soil.setChecked(false);
            project4_other.setChecked(false);

            if (placeSpecialIndexEntity.getPlace_surface().equals(project4_wood_flooring.getText().toString()))
                project4_wood_flooring.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project4_synthetic_material.getText().toString()))
                project4_synthetic_material.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project4_cement.getText().toString()))
                project4_cement.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project4_ice.getText().toString()))
                project4_ice.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project4_sandy_soil.getText().toString()))
                project4_sandy_soil.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project4_other.getText().toString()))
                project4_other.setChecked(true);
        }
    }

    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setViewers_seats(Integer.valueOf(project4_viewers_seats.getText().toString().isEmpty() ? "0" : project4_viewers_seats.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_quantity(Integer.valueOf(project4_place_quantity.getText().toString().isEmpty() ? "0" : project4_place_quantity.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_length(project4_place_length.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_width(project4_place_width.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setIndoor_high(project4_indoor_high.getText().toString());

        if (project4_wood_flooring.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project4_wood_flooring.getText().toString());
        } else if (project4_synthetic_material.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project4_synthetic_material.getText().toString());
        } else if (project4_cement.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project4_cement.getText().toString());
        } else if (project4_ice.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project4_ice.getText().toString());
        } else if (project4_sandy_soil.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project4_sandy_soil.getText().toString());
        } else if (project4_other.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project4_other.getText().toString());
        }
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);
        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia();
        }

        if (project4_viewers_seats.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "观众席位不能为空");
            return false;
        } else if (project4_place_quantity.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "场地数量不能为空");
            return false;
        } else if (project4_place_length.getText().toString().isEmpty()) {
            project4_place_length.setText("0");
            PromptManager.showToast(getActivity(), "场地长度不能为空");
            return false;
        } else if (project4_place_width.getText().toString().isEmpty()) {
            project4_place_width.setText("0");
            PromptManager.showToast(getActivity(), "场地宽度不能为空");
            return false;
        } else if (project4_indoor_high.getText().toString().isEmpty()) {
            project4_indoor_high.setText("0");
            PromptManager.showToast(getActivity(), "室内净高不能为空");
            return false;
        } else return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.project4_note1:
                StringBuilder stringBuilder = new StringBuilder();

                if (application.getTypeID() == 11) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_2));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 12) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_3));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 13) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_4));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 14) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_5));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 15) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_6));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 16) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_7));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 17) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_8));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 18) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_9));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 19) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_10));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 20) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_11));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 21) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_12));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 22) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_13));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 24) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_15));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 25) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_16));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 26) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_17));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 27) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_18));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 28) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_20));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 29) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_21));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 30) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_22));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 31) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_23));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 32) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_24));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 34) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_26));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 35) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_27));
                    stringBuilder.append("\r\n\n");
                }
                if (application.getTypeID() == 36) {
                    stringBuilder.append(getActivity().getString(R.string.help_y4_28));
                    stringBuilder.append("\r\n\n");
                }

                stringBuilder.append(getActivity().getString(R.string.help_y4_30));
                stringBuilder.append("\r\n\n");
                stringBuilder.append(getActivity().getString(R.string.help_y4_35));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project4_note2:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y4_31));
                stringBuilder.append("\r\n\n");
                stringBuilder.append(getActivity().getString(R.string.help_y4_32));
                stringBuilder.append("\r\n\n");
                stringBuilder.append(getActivity().getString(R.string.help_y4_33));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project4_note3:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y4_34));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
        }
    }
}
