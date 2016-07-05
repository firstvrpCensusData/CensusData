package com.firstvrp.censusdata.CensusTaker.Main.PlaceTable;

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
public class PlaceSpecialProject5 extends Fragment implements IBtnCallListener, View.OnClickListener {
    private EditText project5_viewers_seats, project5_place_quantity,
            project5_place_length, project5_place_width;
    private RadioButton project5_savageness_grass, project5_pedaline,
            project5_synthetic_material, project5_cement,
            project5_soil, project5_ice,
            projcet5_other;
    private RadioButton project5_light_device_y, project5_light_device_n;
    private RadioButton project5_shelter_y, project5_shelter_n;
    private MyApplication application;
    private ImageView project5_note1, project5_note2, project5_note3, project5_note4, project5_note5;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_place_special_project5, container, false);

        project5_viewers_seats = (EditText) view.findViewById(R.id.project5_viewers_seats);
        project5_place_quantity = (EditText) view.findViewById(R.id.project5_place_quantity);
        project5_place_length = (EditText) view.findViewById(R.id.project5_place_length);
        project5_place_width = (EditText) view.findViewById(R.id.project5_place_width);

        project5_savageness_grass = (RadioButton) view.findViewById(R.id.project5_savageness_grass);
        project5_pedaline = (RadioButton) view.findViewById(R.id.project5_pedaline);
        project5_synthetic_material = (RadioButton) view.findViewById(R.id.project5_synthetic_material);
        project5_cement = (RadioButton) view.findViewById(R.id.project5_cement);
        project5_soil = (RadioButton) view.findViewById(R.id.project5_soil);
        project5_ice = (RadioButton) view.findViewById(R.id.project5_ice);
        projcet5_other = (RadioButton) view.findViewById(R.id.project5_other);

        project5_light_device_y = (RadioButton) view.findViewById(R.id.project5_light_device_y);
        project5_light_device_n = (RadioButton) view.findViewById(R.id.project5_light_device_n);

        project5_shelter_y = (RadioButton) view.findViewById(R.id.project5_shelter_y);
        project5_shelter_n = (RadioButton) view.findViewById(R.id.project5_shelter_n);

        //帮助
        project5_note1 = (ImageView) view.findViewById(R.id.project5_note1);
        project5_note2 = (ImageView) view.findViewById(R.id.project5_note2);
        project5_note3 = (ImageView) view.findViewById(R.id.project5_note3);
        project5_note4 = (ImageView) view.findViewById(R.id.project5_note4);
        project5_note5 = (ImageView) view.findViewById(R.id.project5_note5);
        project5_note1.setOnClickListener(this);
        project5_note2.setOnClickListener(this);
        project5_note3.setOnClickListener(this);
        project5_note4.setOnClickListener(this);
        project5_note5.setOnClickListener(this);

        application = (MyApplication) getActivity().getApplication();

        if (application.getTypeID() == 37) {
            project5_place_length.setHint(getString(R.string.greater_equal_ninety));
            project5_place_width.setHint(getString(R.string.greater_equal_forty_five));
        }
        if (application.getTypeID() == 38) {
            project5_place_length.setHint(getString(R.string.greater_equal_twenty_five));
            project5_place_width.setHint(getString(R.string.greater_equal_fifteen));
        }
        if (application.getTypeID() == 39) {
            project5_place_length.setHint(getString(R.string.greater_equal_forty_five));
            project5_place_width.setHint(getString(R.string.greater_equal_forty_five));
        }
        if (application.getTypeID() == 40) {
//            28×15
            project5_place_length.setHint(getString(R.string.greater_equal_twenty_eight));
            project5_place_width.setHint(getString(R.string.greater_equal_fifteen));

        }

        if (application.getTypeID() == 41) {
//            14×15
            project5_place_length.setHint(getString(R.string.greater_equal_forteen));
            project5_place_width.setHint(getString(R.string.greater_equal_fifteen));
        }
        if (application.getTypeID() == 42) {
//            18×9
            project5_place_length.setHint(getString(R.string.greater_equal_eighteen));
            project5_place_width.setHint(getString(R.string.greater_equal_nine));
        }
        if (application.getTypeID() == 43) {
//            16×8
            project5_place_length.setHint(getString(R.string.greater_equal_sixteen));
            project5_place_width.setHint(getString(R.string.greater_equal_eight));
        }
        if (application.getTypeID() == 44) {
//            40×20
            project5_place_length.setHint(getString(R.string.greater_equal_forty));
            project5_place_width.setHint(getString(R.string.greater_equal_twenty));
        }
        if (application.getTypeID() == 45) {
//            27×12
            project5_place_length.setHint(getString(R.string.greater_equal_twenty_seven));

            project5_place_width.setHint(getString(R.string.greater_equal_twelfth));
        }
        if (application.getTypeID() == 46) {
            project5_place_length.setHint(getString(R.string.less_equal_one_hundred));

            project5_place_width.setHint(getString(R.string.greater_equal_seventy));
        }
        if (application.getTypeID() == 47) {
            project5_place_length.setHint(getString(R.string.greater_equal_twelfth_three_seven_seven));

            project5_place_width.setHint(getString(R.string.greater_equal_eight_twenty_three));
        }

        if (application.getTypeID() == 48) {
            project5_place_length.setHint(getString(R.string.greater_equal_ninety_one_four));

            project5_place_width.setHint(getString(R.string.greater_equal_fifty_five));
        }


        if (application.getTypeID() == 49) {
            project5_place_length.setHint(getString(R.string.greater_equal_thirteen_four));

            project5_place_width.setHint(getString(R.string.greater_equal_five_eighteen));
        }

        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null && application.getPlaceInfoEntity().getPlaceSpecialIndex() != null) {
            PlaceSpecialIndexEntity placeSpecialIndexEntity = application.getPlaceInfoEntity().getPlaceSpecialIndex();
            project5_viewers_seats.setText(String.valueOf(placeSpecialIndexEntity.getViewers_seats()));
            project5_place_quantity.setText(String.valueOf(placeSpecialIndexEntity.getPlace_quantity()));
            project5_place_length.setText(String.valueOf(placeSpecialIndexEntity.getPlace_length()));
            project5_place_width.setText(String.valueOf(placeSpecialIndexEntity.getPlace_width()));

            project5_savageness_grass.setChecked(false);
            project5_pedaline.setChecked(false);
            project5_synthetic_material.setChecked(false);
            project5_cement.setChecked(false);
            project5_soil.setChecked(false);
            project5_ice.setChecked(false);
            projcet5_other.setChecked(false);

            if (placeSpecialIndexEntity.getPlace_surface().equals(project5_savageness_grass.getText().toString()))
                project5_savageness_grass.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project5_pedaline.getText().toString()))
                project5_pedaline.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project5_synthetic_material.getText().toString()))
                project5_synthetic_material.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project5_cement.getText().toString()))
                project5_cement.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project5_soil.getText().toString()))
                project5_soil.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(project5_ice.getText().toString()))
                project5_ice.setChecked(true);
            else if (placeSpecialIndexEntity.getPlace_surface().equals(projcet5_other.getText().toString()))
                projcet5_other.setChecked(true);

            project5_light_device_y.setChecked(false);
            project5_light_device_n.setChecked(false);

            project5_shelter_y.setChecked(false);
            project5_shelter_n.setChecked(false);

            if (placeSpecialIndexEntity.getLight_device() == 1)
                project5_light_device_y.setChecked(true);
            else if (placeSpecialIndexEntity.getLight_device() == 2)
                project5_light_device_n.setChecked(true);

            if (placeSpecialIndexEntity.getShelter() == 1)
                project5_shelter_y.setChecked(true);
            else if (placeSpecialIndexEntity.getShelter() == 2)
                project5_shelter_n.setChecked(true);
        }
    }

    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setViewers_seats(Integer.valueOf(project5_viewers_seats.getText().toString().isEmpty() ? "0" : project5_viewers_seats.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_quantity(Integer.valueOf(project5_place_quantity.getText().toString().isEmpty() ? "0" : project5_place_quantity.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_length(project5_place_length.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_width(project5_place_width.getText().toString());

        if (project5_savageness_grass.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project5_savageness_grass.getText().toString());
        } else if (project5_pedaline.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project5_pedaline.getText().toString());
        } else if (project5_synthetic_material.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project5_synthetic_material.getText().toString());
        } else if (project5_cement.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project5_cement.getText().toString());
        } else if (project5_soil.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project5_soil.getText().toString());
        } else if (project5_ice.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(project5_ice.getText().toString());
        } else if (projcet5_other.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setPlace_surface(projcet5_other.getText().toString());
        }

        if (project5_light_device_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setLight_device(1);
        } else if (project5_light_device_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setLight_device(2);
        }

        if (project5_shelter_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setShelter(1);
        } else if (project5_shelter_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setShelter(2);
        }
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);
        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia();
        }


        if (project5_viewers_seats.getText().toString().isEmpty()) {
            project5_viewers_seats.setText("0");
            PromptManager.showToast(getActivity(), "观众席位不能为空，没有可填0");
            return false;
        } else if (project5_place_quantity.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "场地数量不能为空");
            return false;
        } else if (project5_place_length.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "场地宽度不能为空");
            return false;
        } else if (project5_place_width.getText().toString().isEmpty()) {
            PromptManager.showToast(getActivity(), "场地长度不能为空");
            return false;
        } else return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.project5_note1:
                StringBuilder stringBuilder = new StringBuilder();

                if (application.getTypeID() == 37) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_1));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 38) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_2));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 39) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_3));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 40) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_4));
                    stringBuilder.append("\r\n");
                }

                if (application.getTypeID() == 41) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_5));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 42) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_6));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 43) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_7));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 44) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_8));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 45) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_9));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 46) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_10));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 47) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_11));
                    stringBuilder.append("\r\n");
                }

                if (application.getTypeID() == 48) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_12));
                    stringBuilder.append("\r\n");
                }


                if (application.getTypeID() == 49) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_13));
                    stringBuilder.append("\r\n");
                }

                if (application.getTypeID() == 50) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_14));
                    stringBuilder.append("\r\n");
                }



                if (application.getTypeID() == 52) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_16));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 53) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_17));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 54) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_18));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 55) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_19));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 56) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_20));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 57) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_21));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 58) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_22));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 59) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_23));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 60) {
                    stringBuilder.append(getActivity().getString(R.string.help_y5_24));
                    stringBuilder.append("\r\n");
                }

                stringBuilder.append(getActivity().getString(R.string.help_y5_25));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y5_26));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project5_note2:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y5_27));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y5_28));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project5_note3:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y5_30));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project5_note4:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y5_31));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project5_note5:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y5_32));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
        }
    }
}
