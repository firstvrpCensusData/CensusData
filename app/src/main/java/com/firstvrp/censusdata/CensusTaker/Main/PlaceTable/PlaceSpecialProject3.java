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
 * 专项场地信息乙表03
 */
public class PlaceSpecialProject3 extends Fragment implements IBtnCallListener, View.OnClickListener {
    private EditText project3_viewers_seats, project3_tournament_length,
            project3_tournament_width, project3_tournament_deep,
            project3_training_length, project3_training_width,
            project3_training_deep, project3_bathing_length,
            project3_bathing_width, project3_bathing_deep,
            project3_diving_length, project3_diving_width,
            project3_diving_deep, project3_jumping_quantity1,
            project3_jumping_quantity2, project3_jumping_quantity3,
            project3_jumping_quantity4, project3_jumping_quantity5,
            project3_springboard_quantity1, project3_springboard_quantity2;

    private RadioButton project3_screen_device_y, project3_screen_device_n;

    private MyApplication application;

    private RadioButton project3_light_device_y, project3_light_device_n;

    private ImageView project3_note1, project3_note2, project3_note3, project3_note4,
            project3_note5, project3_note6, project3_note7,
            project3_note8, project3_note9;
    View view;

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
        view = inflater.inflate(R.layout.fragment_place_special_project3, container, false);
        project3_viewers_seats = (EditText) view.findViewById(R.id.project3_viewers_seats);
        project3_tournament_length = (EditText) view.findViewById(R.id.project3_tournament_length);
        project3_tournament_width = (EditText) view.findViewById(R.id.project3_tournament_width);
        project3_tournament_deep = (EditText) view.findViewById(R.id.project3_tournament_deep);
        project3_training_length = (EditText) view.findViewById(R.id.project3_training_length);
        project3_training_width = (EditText) view.findViewById(R.id.project3_training_width);
        project3_training_deep = (EditText) view.findViewById(R.id.project3_training_deep);
        project3_bathing_length = (EditText) view.findViewById(R.id.project3_bathing_length);
        project3_bathing_width = (EditText) view.findViewById(R.id.project3_bathing_width);
        project3_bathing_deep = (EditText) view.findViewById(R.id.project3_bathing_deep);
        project3_diving_length = (EditText) view.findViewById(R.id.project3_diving_length);
        project3_diving_width = (EditText) view.findViewById(R.id.project3_diving_width);
        project3_diving_deep = (EditText) view.findViewById(R.id.project3_diving_deep);
        project3_jumping_quantity1 = (EditText) view.findViewById(R.id.project3_jumping_quantity1);
        project3_jumping_quantity2 = (EditText) view.findViewById(R.id.project3_jumping_quantity2);
        project3_jumping_quantity3 = (EditText) view.findViewById(R.id.project3_jumping_quantity3);
        project3_jumping_quantity4 = (EditText) view.findViewById(R.id.project3_jumping_quantity4);
        project3_jumping_quantity5 = (EditText) view.findViewById(R.id.project3_jumping_quantity5);
        project3_springboard_quantity1 = (EditText) view.findViewById(R.id.project3_springboard_quantity1);
        project3_springboard_quantity2 = (EditText) view.findViewById(R.id.project3_springboard_quantity2);

        project3_screen_device_y = (RadioButton) view.findViewById(R.id.project3_screen_device_y);
        project3_screen_device_n = (RadioButton) view.findViewById(R.id.project3_screen_device_n);

        project3_light_device_y = (RadioButton) view.findViewById(R.id.project3_light_device_y);
        project3_light_device_n = (RadioButton) view.findViewById(R.id.project3_light_device_n);

        //帮助
        project3_note1 = (ImageView) view.findViewById(R.id.project3_note1);
        project3_note2 = (ImageView) view.findViewById(R.id.project3_note2);
        project3_note3 = (ImageView) view.findViewById(R.id.project3_note3);
        project3_note4 = (ImageView) view.findViewById(R.id.project3_note4);
        project3_note5 = (ImageView) view.findViewById(R.id.project3_note5);
        project3_note6 = (ImageView) view.findViewById(R.id.project3_note6);
        project3_note7 = (ImageView) view.findViewById(R.id.project3_note7);
        project3_note8 = (ImageView) view.findViewById(R.id.project3_note8);
        project3_note9 = (ImageView) view.findViewById(R.id.project3_note9);
        project3_note1.setOnClickListener(this);
        project3_note2.setOnClickListener(this);
        project3_note3.setOnClickListener(this);
        project3_note4.setOnClickListener(this);
        project3_note5.setOnClickListener(this);
        project3_note6.setOnClickListener(this);
        project3_note7.setOnClickListener(this);
        project3_note8.setOnClickListener(this);
        project3_note9.setOnClickListener(this);

        application = (MyApplication) getActivity().getApplication();

        if (application.getTypeID() == 6) {
            project3_tournament_length.setHint(getActivity().getString(R.string.greater_equal_twenty_five));
            project3_tournament_width.setHint(getActivity().getString(R.string.greater_equal_sixteen));
            project3_tournament_deep.setHint(getActivity().getString(R.string.greater_equal_one_two));
        }
        if (application.getTypeID() == 7) {
            project3_training_length.setHint(getActivity().getString(R.string.greater_equal_sixteen));
            project3_training_width.setHint(getActivity().getString(R.string.greater_equal_twenty_one));
        }
        if (application.getTypeID() == 8) {
            project3_bathing_length.setHint(getActivity().getString(R.string.greater_equal_twenty_five));
            project3_bathing_width.setHint(getActivity().getString(R.string.greater_equal_sixteen));
            project3_bathing_deep.setHint(getActivity().getString(R.string.greater_equal_one_two));
        }
        if (application.getTypeID() == 9) {
            project3_diving_length.setHint(getActivity().getString(R.string.greater_equal_sixteen));
            project3_diving_width.setHint(getActivity().getString(R.string.greater_equal_twenty_one));
        }
        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null && application.getPlaceInfoEntity().getPlaceSpecialIndex() != null) {
            PlaceSpecialIndexEntity placeSpecialIndexEntity = application.getPlaceInfoEntity().getPlaceSpecialIndex();
            project3_viewers_seats.setText(String.valueOf(placeSpecialIndexEntity.getViewers_seats()));
            project3_tournament_length.setText(String.valueOf(placeSpecialIndexEntity.getTournament_length()));
            project3_tournament_width.setText(String.valueOf(placeSpecialIndexEntity.getTournament_width()));

            project3_tournament_deep.setText(String.valueOf(placeSpecialIndexEntity.getTournament_deep()));

            project3_training_length.setText(String.valueOf(placeSpecialIndexEntity.getTraining_length()));
            project3_training_width.setText(String.valueOf(placeSpecialIndexEntity.getTraining_width()));
            project3_training_deep.setText(String.valueOf(placeSpecialIndexEntity.getTraining_deep()));
            project3_bathing_length.setText(String.valueOf(placeSpecialIndexEntity.getBathing_length()));
            project3_bathing_width.setText(String.valueOf(placeSpecialIndexEntity.getBathing_width()));
            project3_bathing_deep.setText(String.valueOf(placeSpecialIndexEntity.getBathing_deep()));
            project3_diving_length.setText(String.valueOf(placeSpecialIndexEntity.getDiving_length()));
            project3_diving_width.setText(String.valueOf(placeSpecialIndexEntity.getDiving_width()));
            project3_diving_deep.setText(String.valueOf(placeSpecialIndexEntity.getDiving_deep()));
            project3_jumping_quantity1.setText(String.valueOf(placeSpecialIndexEntity.getJumping_quantity1()));
            project3_jumping_quantity2.setText(String.valueOf(placeSpecialIndexEntity.getJumping_quantity2()));
            project3_jumping_quantity3.setText(String.valueOf(placeSpecialIndexEntity.getJumping_quantity3()));
            project3_jumping_quantity4.setText(String.valueOf(placeSpecialIndexEntity.getJumping_quantity4()));
            project3_jumping_quantity5.setText(String.valueOf(placeSpecialIndexEntity.getJumping_quantity5()));
            project3_springboard_quantity1.setText(String.valueOf(placeSpecialIndexEntity.getSpringboard_quantity1()));
            project3_springboard_quantity2.setText(String.valueOf(placeSpecialIndexEntity.getSpringboard_quantity1()));

            project3_screen_device_y.setChecked(false);
            project3_screen_device_n.setChecked(false);

            project3_light_device_y.setChecked(false);
            project3_light_device_n.setChecked(false);

            if (placeSpecialIndexEntity.getScreen_device() == 1)
                project3_screen_device_y.setChecked(true);
            else if (placeSpecialIndexEntity.getScreen_device() == 2)
                project3_screen_device_n.setChecked(true);

            if (placeSpecialIndexEntity.getLight_device() == 1)
                project3_light_device_y.setChecked(true);
            else if (placeSpecialIndexEntity.getLight_device() == 2)
                project3_light_device_n.setChecked(true);
        }


    }

    @Override
    public boolean transfermsg() {
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setViewers_seats(Integer.valueOf(project3_viewers_seats.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setTournament_length(project3_tournament_length.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setTournament_width(project3_tournament_width.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setTournament_deep(project3_tournament_deep.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setTraining_length(project3_training_length.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setTraining_width(project3_training_width.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setTraining_deep(project3_training_deep.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setBathing_length(project3_bathing_length.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setBathing_width(project3_bathing_width.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setBathing_deep(project3_bathing_deep.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setDiving_length(project3_diving_length.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setDiving_width(project3_diving_width.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setDiving_deep(project3_diving_deep.getText().toString());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setJumping_quantity1(Integer.valueOf(project3_jumping_quantity1.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setJumping_quantity2(Integer.valueOf(project3_jumping_quantity2.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setJumping_quantity3(Integer.valueOf(project3_jumping_quantity3.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setJumping_quantity4(Integer.valueOf(project3_jumping_quantity4.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setJumping_quantity5(Integer.valueOf(project3_jumping_quantity5.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setSpringboard_quantity1(Integer.valueOf(project3_springboard_quantity1.getText().toString()));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setSpringboard_quantity1(Integer.valueOf(project3_springboard_quantity2.getText().toString()));
        if (project3_screen_device_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setScreen_device(1);
        } else if (project3_screen_device_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setScreen_device(2);
        }

        if (project3_light_device_y.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setLight_device(1);
        } else if (project3_light_device_n.isChecked()) {
            CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setLight_device(2);
        }
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);

        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia(); }

        if (project3_viewers_seats.getText().toString().isEmpty()) {
            project3_viewers_seats.setText("0");
            PromptManager.showToast(getActivity(), "观众席位不能为空");
            return false;
        } else if (project3_tournament_length.getText().toString().isEmpty()) {
            project3_tournament_length.setText("0");
            PromptManager.showToast(getActivity(), "比赛池长不能为空");
            return false;
        } else if (project3_tournament_width.getText().toString().isEmpty()) {
            project3_tournament_width.setText("0");
            PromptManager.showToast(getActivity(), "比赛池宽不能为空");
            return false;
        } else if (project3_tournament_deep.getText().toString().isEmpty()) {
            project3_tournament_deep.setText("0");
            PromptManager.showToast(getActivity(), "比赛池深不能为空");
            return false;
        } else if (project3_training_length.getText().toString().isEmpty()) {
            project3_training_length.setText("0");
            PromptManager.showToast(getActivity(), "训练池长不能为空");
            return false;
        } else if (project3_training_width.getText().toString().isEmpty()) {
            project3_training_width.setText("0");
            PromptManager.showToast(getActivity(), "训练池宽不能为空");
            return false;
        } else if (project3_training_deep.getText().toString().isEmpty()) {
            project3_training_deep.setText("0");
            PromptManager.showToast(getActivity(), "训练池深不能为空");
            return false;
        } else if (project3_bathing_length.getText().toString().isEmpty()) {
            project3_bathing_length.setText("0");
            PromptManager.showToast(getActivity(), "戏水池长不能为空");
            return false;
        } else if (project3_bathing_width.getText().toString().isEmpty()) {
            project3_bathing_width.setText("0");
            PromptManager.showToast(getActivity(), "戏水池宽不能为空");
            return false;
        } else if (project3_bathing_deep.getText().toString().isEmpty()) {
            project3_bathing_deep.setText("0");
            PromptManager.showToast(getActivity(), "戏水池深不能为空");
            return false;
        } else if (project3_diving_length.getText().toString().isEmpty()) {
            project3_diving_length.setText("0");
            PromptManager.showToast(getActivity(), "跳水池长不能为空");
            return false;
        } else if (project3_diving_width.getText().toString().isEmpty()) {
            project3_diving_width.setText("0");
            PromptManager.showToast(getActivity(), "跳水池宽不能为空");
            return false;
        } else if (project3_diving_deep.getText().toString().isEmpty()) {
            project3_diving_deep.setText("0");
            PromptManager.showToast(getActivity(), "跳水池深不能为空");
            return false;
        } else if (project3_jumping_quantity1.getText().toString().isEmpty()) {
            project3_jumping_quantity1.setText("0");
            PromptManager.showToast(getActivity(), "10米跳台不能为空");
            return false;
        } else if (project3_jumping_quantity2.getText().toString().isEmpty()) {
            project3_jumping_quantity2.setText("0");
            PromptManager.showToast(getActivity(), "7.5米跳台不能为空");
            return false;
        } else if (project3_jumping_quantity3.getText().toString().isEmpty()) {
            project3_jumping_quantity3.setText("0");
            PromptManager.showToast(getActivity(), "5米跳台不能为空");
            return false;
        } else if (project3_jumping_quantity4.getText().toString().isEmpty()) {
            project3_jumping_quantity4.setText("0");
            PromptManager.showToast(getActivity(), "3米跳台不能为空");
            return false;
        } else if (project3_jumping_quantity5.getText().toString().isEmpty()) {
            project3_jumping_quantity5.setText("0");
            PromptManager.showToast(getActivity(), "1米跳台不能为空");
            return false;
        } else if (project3_springboard_quantity1.getText().toString().isEmpty()) {
            project3_springboard_quantity1.setText("0");
            PromptManager.showToast(getActivity(), "3米跳板不能为空");
            return false;
        } else if (project3_springboard_quantity2.getText().toString().isEmpty()) {
            project3_springboard_quantity2.setText("0");
            PromptManager.showToast(getActivity(), "1米跳板不能为空");
            return false;
        }else return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.project3_note1:
                StringBuilder stringBuilder = new StringBuilder();

                if (application.getTypeID() == 6) {
                    stringBuilder.append(getActivity().getString(R.string.help_y3_1));
                    stringBuilder.append("\r\n\n");  }
                if (application.getTypeID() == 7) {
                    stringBuilder.append(getActivity().getString(R.string.help_y3_2));
                    stringBuilder.append("\r\n\n"); }
                if (application.getTypeID() == 8) {
                    stringBuilder.append(getActivity().getString(R.string.help_y3_3));
                    stringBuilder.append("\r\n\n");  }
                if (application.getTypeID() == 9) {
                    stringBuilder.append(getActivity().getString(R.string.help_y3_4));
                    stringBuilder.append("\r\n\n");}
                
                stringBuilder.append(getActivity().getString(R.string.help_y3_5));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project3_note2:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y3_8));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project3_note3:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y3_9));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project3_note4:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y3_10));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project3_note5:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y3_11));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project3_note6:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y3_12));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project3_note7:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y3_13));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project3_note8:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y3_15));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.project3_note9:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_y3_14));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
        }
    }
}
