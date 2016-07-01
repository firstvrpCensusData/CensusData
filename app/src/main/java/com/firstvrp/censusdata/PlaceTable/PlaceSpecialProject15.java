package com.firstvrp.censusdata.PlaceTable;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.firstvrp.censusdata.CompanyInformation.CompanyInfomationActivity;
import com.firstvrp.censusdata.CompanyInformation.IBtnCallListener;
import com.firstvrp.censusdata.Dialog.HelpDialog;
import com.firstvrp.censusdata.Entity.PlaceInfoEntity;
import com.firstvrp.censusdata.Entity.SportsItemEntity;
import com.firstvrp.censusdata.GetUserInfo;
import com.firstvrp.censusdata.MyApplication;
import com.firstvrp.censusdata.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Utils.GetNowTime;

/**
 *
 */
public class PlaceSpecialProject15 extends Fragment implements IBtnCallListener, View.OnClickListener {
    private View view;
    private CheckBox project15_drift, project15_outward_bound,
            project15_orienteering, project15_fishing,
            project15_mountain_bike, project15_other;
    private ImageView project15_note1;
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
        view = inflater.inflate(R.layout.fragment_place_special_project15, container, false);
        project15_drift = (CheckBox) view.findViewById(R.id.project15_drift);
        project15_outward_bound = (CheckBox) view.findViewById(R.id.project15_outward_bound);
        project15_orienteering = (CheckBox) view.findViewById(R.id.project15_orienteering);
        project15_fishing = (CheckBox) view.findViewById(R.id.project15_fishing);
        project15_mountain_bike = (CheckBox) view.findViewById(R.id.project15_mountain_bike);
        project15_other = (CheckBox) view.findViewById(R.id.project15_other);

        //帮助
        project15_note1 = (ImageView) view.findViewById(R.id.project15_note1);
        project15_note1.setOnClickListener(this);

        application = (MyApplication) getActivity().getApplication();

        forcingDefault();

        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null) {
            PlaceInfoEntity placeInfoEntity = application.getPlaceInfoEntity();

            for (int i = 0; i < placeInfoEntity.getSportsItem().size(); i++) {
                if (placeInfoEntity.getSportsItem().get(i).get_item_code().equals("1")) {
                    project15_drift.setChecked(true);
                }
                if (placeInfoEntity.getSportsItem().get(i).get_item_code().equals("2")) {
                    project15_outward_bound.setChecked(true);
                }
                if (placeInfoEntity.getSportsItem().get(i).get_item_code().equals("3")) {
                    project15_orienteering.setChecked(true);
                }
                if (placeInfoEntity.getSportsItem().get(i).get_item_code().equals("4")) {
                    project15_fishing.setChecked(true);
                }
                if (placeInfoEntity.getSportsItem().get(i).get_item_code().equals("5")) {
                    project15_mountain_bike.setChecked(true);
                }
                if (placeInfoEntity.getSportsItem().get(i).get_item_code().equals("5")) {
                    project15_other.setChecked(true);
                }
            }
        }
    }

    @Override
    public boolean transfermsg() {
        SportsItemEntity sportsItemEntity;
        List<SportsItemEntity> sportsItemEntities = new ArrayList<>();

        if (project15_drift.isChecked()) {
            sportsItemEntity = new SportsItemEntity();
            sportsItemEntity.set_item_code("1");
            sportsItemEntity.set_item_name(project15_drift.getText().toString());

            sportsItemEntities.add(sportsItemEntity);
        }
        if (project15_outward_bound.isChecked()) {
            sportsItemEntity = new SportsItemEntity();
            sportsItemEntity.set_item_code("2");
            sportsItemEntity.set_item_name(project15_outward_bound.getText().toString());

            sportsItemEntities.add(sportsItemEntity);
        }
        if (project15_orienteering.isChecked()) {
            sportsItemEntity = new SportsItemEntity();
            sportsItemEntity.set_item_code("3");
            sportsItemEntity.set_item_name(project15_orienteering.getText().toString());

            sportsItemEntities.add(sportsItemEntity);
        }
        if (project15_fishing.isChecked()) {
            sportsItemEntity = new SportsItemEntity();
            sportsItemEntity.set_item_code("4");
            sportsItemEntity.set_item_name(project15_fishing.getText().toString());

            sportsItemEntities.add(sportsItemEntity);
        }
        if (project15_mountain_bike.isChecked()) {
            sportsItemEntity = new SportsItemEntity();
            sportsItemEntity.set_item_code("5");
            sportsItemEntity.set_item_name(project15_mountain_bike.getText().toString());

            sportsItemEntities.add(sportsItemEntity);
        }
        if (project15_other.isChecked()) {
            sportsItemEntity = new SportsItemEntity();
            sportsItemEntity.set_item_code("6");
            sportsItemEntity.set_item_name(project15_other.getText().toString());

            sportsItemEntities.add(sportsItemEntity);
        }
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setSportsItem(sportsItemEntities);

        CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setFill_date(GetNowTime.getNowTime());
        GetUserInfo getUserInfo = new GetUserInfo(getActivity());
        Map<String, String> map = getUserInfo.getUserSp();
        CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setFill_people(map.get("userID"));
        CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setFill_tel(map.get("userTel"));

        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);

        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia();
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.project15_note1:
                StringBuilder stringBuilder = new StringBuilder();

                stringBuilder.append(getActivity().getString(R.string.help_y15_1));
                stringBuilder.append("\r\n");
                stringBuilder.append(getActivity().getString(R.string.help_y15_2));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
        }
    }
}
