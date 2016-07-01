package com.firstvrp.censusdata.PlaceTable;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.firstvrp.censusdata.CompanyInformation.CompanyInfomationA;
import com.firstvrp.censusdata.CompanyInformation.CompanyInfomationActivity;
import com.firstvrp.censusdata.CompanyInformation.IBtnCallListener;
import com.firstvrp.censusdata.Dialog.HelpDialog;
import com.firstvrp.censusdata.Entity.BearTaskEntity;
import com.firstvrp.censusdata.Entity.BigPlaceInfoEntity;
import com.firstvrp.censusdata.Entity.FitnessItemEntity;
import com.firstvrp.censusdata.Entity.SportsStateEntity;
import com.firstvrp.censusdata.GetUserInfo;
import com.firstvrp.censusdata.MyApplication;
import com.firstvrp.censusdata.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Utils.GetNowTime;
import Utils.GlobalParams;

/**
 * A simple {@link Fragment}
 */
public class PlaceSpecialProjectBig extends Fragment implements IBtnCallListener, View.OnClickListener {
    private CheckBox place_big_undertake, place_big_olympiad,
            place_big_asian_games, place_big_national_athletic_meet,
            place_big_city_games, place_big_mind_sports,
            place_big_sports_meeting, place_big_provincial_games,
            place_big_universiade, place_big_peasant_games,
            place_big_national_minority_games, place_big_other;

    private ImageView projectbig_note1, projectbig_note2, projectbig_note3, projectbig_note4;

    private MyApplication application;

    private CheckBox place_big_the_main_venue, place_big_competition_gymnasiums_and_stadiums;
    private LinearLayout project_big_match;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_place_special_project_big, container, false);
        place_big_undertake = (CheckBox) view.findViewById(R.id.place_big_undertake);
        place_big_olympiad = (CheckBox) view.findViewById(R.id.place_big_olympiad);
        place_big_asian_games = (CheckBox) view.findViewById(R.id.place_big_asian_games);
        place_big_national_athletic_meet = (CheckBox) view.findViewById(R.id.place_big_national_athletic_meet);
        place_big_city_games = (CheckBox) view.findViewById(R.id.place_big_city_games);
        place_big_mind_sports = (CheckBox) view.findViewById(R.id.place_big_mind_sports);
        place_big_universiade = (CheckBox) view.findViewById(R.id.place_big_universiade);
        place_big_peasant_games = (CheckBox) view.findViewById(R.id.place_big_peasant_games);
        place_big_national_minority_games = (CheckBox) view.findViewById(R.id.place_big_national_minority_games);
        place_big_other = (CheckBox) view.findViewById(R.id.place_big_other);
        place_big_sports_meeting = (CheckBox) view.findViewById(R.id.place_big_sports_meeting);
        place_big_provincial_games = (CheckBox) view.findViewById(R.id.place_big_provincial_games);

        project_big_match = (LinearLayout) view.findViewById(R.id.project_big_match);
        place_big_the_main_venue = (CheckBox) view.findViewById(R.id.place_big_the_main_venue);
        place_big_competition_gymnasiums_and_stadiums = (CheckBox) view.findViewById(R.id.place_big_competition_gymnasiums_and_stadiums);

        place_big_basketball = (CheckBox) view.findViewById(R.id.place_big_basketball);
        place_big_badminton = (CheckBox) view.findViewById(R.id.place_big_badminton);
        place_big_tennis = (CheckBox) view.findViewById(R.id.place_big_tennis);
        place_big_dancesport = (CheckBox) view.findViewById(R.id.place_big_dancesport);
        place_big_aerobics = (CheckBox) view.findViewById(R.id.place_big_aerobics);
        place_big_swim = (CheckBox) view.findViewById(R.id.place_big_swim);
        place_big_football = (CheckBox) view.findViewById(R.id.place_big_football);
        place_big_wushu = (CheckBox) view.findViewById(R.id.place_big_wushu);
        place_big_chess = (CheckBox) view.findViewById(R.id.place_big_chess);
        place_big_taekwondo = (CheckBox) view.findViewById(R.id.place_big_taekwondo);
        place_big_billiards = (CheckBox) view.findViewById(R.id.place_big_billiards);
        place_big_bowling = (CheckBox) view.findViewById(R.id.place_big_bowling);
        place_big_skidding = (CheckBox) view.findViewById(R.id.place_big_skidding);
        place_big_golf = (CheckBox) view.findViewById(R.id.place_big_golf);
        place_big_pingpong = (CheckBox) view.findViewById(R.id.place_big_pingpong);
        place_big_boxing = (CheckBox) view.findViewById(R.id.place_big_boxing);
        place_big_fencing = (CheckBox) view.findViewById(R.id.place_big_fencing);
        place_big_qigong = (CheckBox) view.findViewById(R.id.place_big_qigong);
        place_big_volleyball = (CheckBox) view.findViewById(R.id.place_big_volleyball);
        place_big_squash = (CheckBox) view.findViewById(R.id.place_big_squash);
        place_big_calisthenics = (CheckBox) view.findViewById(R.id.place_big_calisthenics);
        place_big_gateball = (CheckBox) view.findViewById(R.id.place_big_gateball);
        place_big_yoga = (CheckBox) view.findViewById(R.id.place_big_yoga);
        place_big_field = (CheckBox) view.findViewById(R.id.place_big_field);
        place_big_shooting = (CheckBox) view.findViewById(R.id.place_big_shooting);
        place_big_other2 = (CheckBox) view.findViewById(R.id.place_big_other2);

        //帮助
        projectbig_note1 = (ImageView) view.findViewById(R.id.projectbig_note1);
        projectbig_note2 = (ImageView) view.findViewById(R.id.projectbig_note2);
        projectbig_note3 = (ImageView) view.findViewById(R.id.projectbig_note3);
        projectbig_note1.setOnClickListener(this);
        projectbig_note2.setOnClickListener(this);
        projectbig_note3.setOnClickListener(this);
        application = (MyApplication) getActivity().getApplication();

        place_big_undertake.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    project_big_match.setVisibility(View.GONE);
                } else {
                    project_big_match.setVisibility(View.VISIBLE);
                }
            }
        });

        forcingDefault();

        return view;
    }

    private void forcingDefault() {
        if (application.getBigPlaceInfoEntity() != null) {
            BigPlaceInfoEntity bigPlaceInfoEntity = application.getBigPlaceInfoEntity();
            place_big_undertake.setChecked(false);
            place_big_olympiad.setChecked(false);
            place_big_asian_games.setChecked(false);
            place_big_national_athletic_meet.setChecked(false);
            place_big_city_games.setChecked(false);
            place_big_mind_sports.setChecked(false);
            place_big_universiade.setChecked(false);
            place_big_peasant_games.setChecked(false);
            place_big_national_minority_games.setChecked(false);
            place_big_other.setChecked(false);
            place_big_sports_meeting.setChecked(false);
            place_big_provincial_games.setChecked(false);

            place_big_the_main_venue.setChecked(false);
            place_big_competition_gymnasiums_and_stadiums.setChecked(false);

            place_big_basketball.setChecked(false);
            place_big_badminton.setChecked(false);
            place_big_tennis.setChecked(false);
            place_big_dancesport.setChecked(false);
            place_big_aerobics.setChecked(false);
            place_big_swim.setChecked(false);
            place_big_football.setChecked(false);
            place_big_wushu.setChecked(false);
            place_big_chess.setChecked(false);
            place_big_taekwondo.setChecked(false);
            place_big_billiards.setChecked(false);
            place_big_bowling.setChecked(false);
            place_big_skidding.setChecked(false);
            place_big_golf.setChecked(false);
            place_big_pingpong.setChecked(false);
            place_big_boxing.setChecked(false);
            place_big_fencing.setChecked(false);
            place_big_qigong.setChecked(false);
            place_big_volleyball.setChecked(false);
            place_big_squash.setChecked(false);
            place_big_calisthenics.setChecked(false);
            place_big_gateball.setChecked(false);
            place_big_yoga.setChecked(false);
            place_big_field.setChecked(false);
            place_big_shooting.setChecked(false);
            place_big_other2.setChecked(false);

            for (SportsStateEntity sportsStateEntity : bigPlaceInfoEntity.getSportsState()) {
                if (sportsStateEntity.getType_code().equals("1"))
                    place_big_undertake.setChecked(true);
                if (sportsStateEntity.getType_code().equals("2"))
                    place_big_olympiad.setChecked(true);
                if (sportsStateEntity.getType_code().equals("3"))
                    place_big_asian_games.setChecked(true);
                if (sportsStateEntity.getType_code().equals("4"))
                    place_big_national_athletic_meet.setChecked(true);
                if (sportsStateEntity.getType_code().equals("5"))
                    place_big_city_games.setChecked(true);
                if (sportsStateEntity.getType_code().equals("6"))
                    place_big_mind_sports.setChecked(true);
                if (sportsStateEntity.getType_code().equals("7"))
                    place_big_universiade.setChecked(true);
                if (sportsStateEntity.getType_code().equals("8"))
                    place_big_peasant_games.setChecked(true);
                if (sportsStateEntity.getType_code().equals("9"))
                    place_big_national_minority_games.setChecked(true);
                if (sportsStateEntity.getType_code().equals("10")) place_big_other.setChecked(true);
                if (sportsStateEntity.getType_code().equals("11"))
                    place_big_sports_meeting.setChecked(true);
                if (sportsStateEntity.getType_code().equals("12"))
                    place_big_provincial_games.setChecked(true);
            }
            for (BearTaskEntity bearTaskEntity : bigPlaceInfoEntity.getBearTask()) {
                if (bearTaskEntity.getTask_code().equals("1"))
                    place_big_the_main_venue.setChecked(true);
                if (bearTaskEntity.getTask_code().equals("2"))
                    place_big_competition_gymnasiums_and_stadiums.setChecked(true);
            }
            for (FitnessItemEntity fitnessItemEntity : bigPlaceInfoEntity.getFitnessItem()) {
                if (fitnessItemEntity.getItem_code().equals("1"))
                    place_big_basketball.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("2"))
                    place_big_badminton.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("3")) place_big_tennis.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("4"))
                    place_big_dancesport.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("5"))
                    place_big_aerobics.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("6")) place_big_swim.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("7"))
                    place_big_football.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("8")) place_big_wushu.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("9")) place_big_chess.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("10"))
                    place_big_taekwondo.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("11"))
                    place_big_billiards.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("12"))
                    place_big_bowling.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("13"))
                    place_big_skidding.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("14")) place_big_golf.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("15"))
                    place_big_pingpong.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("16"))
                    place_big_boxing.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("17"))
                    place_big_fencing.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("18"))
                    place_big_qigong.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("19"))
                    place_big_volleyball.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("20"))
                    place_big_squash.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("21"))
                    place_big_calisthenics.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("22"))
                    place_big_gateball.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("23")) place_big_yoga.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("24")) place_big_field.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("25"))
                    place_big_shooting.setChecked(true);
                if (fitnessItemEntity.getItem_code().equals("26"))
                    place_big_other2.setChecked(true);
            }
        }
    }

    List<SportsStateEntity> sportsStateEntities = new ArrayList<SportsStateEntity>();
    SportsStateEntity sportsStateEntity;

    List<BearTaskEntity> bearTaskEntities = new ArrayList<BearTaskEntity>();
    BearTaskEntity bearTaskEntity;

    List<FitnessItemEntity> fitnessItemEntities = new ArrayList<FitnessItemEntity>();
    FitnessItemEntity fitnessItemEntity;

    private void init() {
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setPlace_name(application.getPlaceName());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setPlace_code(String.valueOf(application.getTypeID()));
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setUnits_id(application.getUnitsID());

        if (place_big_undertake.isChecked()) {
            sportsStateEntity = new SportsStateEntity();
            sportsStateEntity.setType_code("1");
            sportsStateEntity.setType_name(place_big_undertake.getText().toString());
            sportsStateEntities.add(sportsStateEntity);
        }
        if (place_big_olympiad.isChecked()) {
            sportsStateEntity = new SportsStateEntity();
            sportsStateEntity.setType_code("2");
            sportsStateEntity.setType_name(place_big_olympiad.getText().toString());
            sportsStateEntities.add(sportsStateEntity);
        }
        if (place_big_asian_games.isChecked()) {
            sportsStateEntity = new SportsStateEntity();
            sportsStateEntity.setType_code("3");
            sportsStateEntity.setType_name(place_big_asian_games.getText().toString());
            sportsStateEntities.add(sportsStateEntity);
        }
        if (place_big_national_athletic_meet.isChecked()) {
            sportsStateEntity = new SportsStateEntity();

            sportsStateEntity.setType_code("4");
            sportsStateEntity.setType_name(place_big_national_athletic_meet.getText().toString());
            sportsStateEntities.add(sportsStateEntity);
        }

        if (place_big_city_games.isChecked()) {
            sportsStateEntity = new SportsStateEntity();
            sportsStateEntity.setType_code("5");
            sportsStateEntity.setType_name(place_big_city_games.getText().toString());
            sportsStateEntities.add(sportsStateEntity);
        }
        if (place_big_mind_sports.isChecked()) {
            sportsStateEntity = new SportsStateEntity();
            sportsStateEntity.setType_code("6");
            sportsStateEntity.setType_name(place_big_mind_sports.getText().toString());
            sportsStateEntities.add(sportsStateEntity);
        }
        if (place_big_universiade.isChecked()) {
            sportsStateEntity = new SportsStateEntity();
            sportsStateEntity.setType_code("7");
            sportsStateEntity.setType_name(place_big_universiade.getText().toString());
            sportsStateEntities.add(sportsStateEntity);
        }
        if (place_big_peasant_games.isChecked()) {
            sportsStateEntity = new SportsStateEntity();
            sportsStateEntity.setType_code("8");
            sportsStateEntity.setType_name(place_big_peasant_games.getText().toString());
            sportsStateEntities.add(sportsStateEntity);
        }
        if (place_big_national_minority_games.isChecked()) {
            sportsStateEntity = new SportsStateEntity();
            sportsStateEntity.setType_code("9");
            sportsStateEntity.setType_name(place_big_national_minority_games.getText().toString());
            sportsStateEntities.add(sportsStateEntity);
        }
        if (place_big_other.isChecked()) {
            sportsStateEntity = new SportsStateEntity();
            sportsStateEntity.setType_code("10");
            sportsStateEntity.setType_name(place_big_other.getText().toString());
            sportsStateEntities.add(sportsStateEntity);
        }
        if (place_big_sports_meeting.isChecked()) {
            sportsStateEntity = new SportsStateEntity();
            sportsStateEntity.setType_code("11");
            sportsStateEntity.setType_name(place_big_sports_meeting.getText().toString());
            sportsStateEntities.add(sportsStateEntity);
        }
        if (place_big_provincial_games.isChecked()) {
            sportsStateEntity = new SportsStateEntity();
            sportsStateEntity.setType_code("12");
            sportsStateEntity.setType_name(place_big_provincial_games.getText().toString());
            sportsStateEntities.add(sportsStateEntity);
        }


        if (place_big_the_main_venue.isChecked()) {
            bearTaskEntity = new BearTaskEntity();
            bearTaskEntity.setTask_code("1");
            bearTaskEntity.setTask_name(place_big_the_main_venue.getText().toString());
            bearTaskEntities.add(bearTaskEntity);
        }
        if (place_big_competition_gymnasiums_and_stadiums.isChecked()) {
            bearTaskEntity = new BearTaskEntity();

            bearTaskEntity.setTask_code("2");
            bearTaskEntity.setTask_name(place_big_competition_gymnasiums_and_stadiums.getText().toString());

            bearTaskEntities.add(bearTaskEntity);
        }

        if (place_big_basketball.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("1");
            fitnessItemEntity.setItem_name(place_big_basketball.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_badminton.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("2");
            fitnessItemEntity.setItem_name(place_big_badminton.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_tennis.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("3");
            fitnessItemEntity.setItem_name(place_big_tennis.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_dancesport.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("4");
            fitnessItemEntity.setItem_name(place_big_dancesport.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_aerobics.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("5");
            fitnessItemEntity.setItem_name(place_big_aerobics.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_swim.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("6");
            fitnessItemEntity.setItem_name(place_big_swim.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_football.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("7");
            fitnessItemEntity.setItem_name(place_big_football.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_wushu.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("8");
            fitnessItemEntity.setItem_name(place_big_wushu.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_chess.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("9");
            fitnessItemEntity.setItem_name(place_big_chess.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_taekwondo.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("10");
            fitnessItemEntity.setItem_name(place_big_taekwondo.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_billiards.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("11");
            fitnessItemEntity.setItem_name(place_big_billiards.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_bowling.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("12");
            fitnessItemEntity.setItem_name(place_big_bowling.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_skidding.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("13");
            fitnessItemEntity.setItem_name(place_big_skidding.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_golf.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("14");
            fitnessItemEntity.setItem_name(place_big_golf.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_pingpong.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("15");
            fitnessItemEntity.setItem_name(place_big_pingpong.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_boxing.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("16");
            fitnessItemEntity.setItem_name(place_big_boxing.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_fencing.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("17");
            fitnessItemEntity.setItem_name(place_big_fencing.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_qigong.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("18");
            fitnessItemEntity.setItem_name(place_big_qigong.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_volleyball.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("19");
            fitnessItemEntity.setItem_name(place_big_volleyball.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_squash.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("20");
            fitnessItemEntity.setItem_name(place_big_squash.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_calisthenics.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("21");
            fitnessItemEntity.setItem_name(place_big_calisthenics.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_gateball.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("22");
            fitnessItemEntity.setItem_name(place_big_gateball.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_yoga.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("23");
            fitnessItemEntity.setItem_name(place_big_yoga.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_field.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("24");
            fitnessItemEntity.setItem_name(place_big_field.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_shooting.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("25");
            fitnessItemEntity.setItem_name(place_big_shooting.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        if (place_big_other2.isChecked()) {
            fitnessItemEntity = new FitnessItemEntity();

            fitnessItemEntity.setItem_code("26");
            fitnessItemEntity.setItem_name(place_big_other2.getText().toString());
            fitnessItemEntities.add(fitnessItemEntity);
        }

        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setUnits_id(application.getUnitsID());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setPlace_code(String.valueOf(application.getTypeID()));
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setFitnessItem(fitnessItemEntities);
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setBearTask(bearTaskEntities);
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setSportsState(sportsStateEntities);

        GetUserInfo getUserInfo = new GetUserInfo(getActivity());
        Map<String, String> map = getUserInfo.getUserSp();
        map.put("userID", GlobalParams.userID);
        map.put("userAccount", GlobalParams.userAccount);
        map.put("userName", GlobalParams.username);
        map.put("userTel", GlobalParams.userTel);
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setFill_people(map.get("userID"));
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setFill_date(GetNowTime.getNowTime());
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setFill_tel(map.get("userTel"));
    }

    private CheckBox place_big_basketball, place_big_badminton, place_big_tennis,
            place_big_dancesport, place_big_aerobics, place_big_swim,
            place_big_football, place_big_wushu, place_big_chess,
            place_big_taekwondo, place_big_billiards, place_big_bowling,
            place_big_skidding, place_big_golf, place_big_pingpong, place_big_boxing,
            place_big_fencing, place_big_qigong, place_big_volleyball,
            place_big_squash, place_big_calisthenics, place_big_gateball, place_big_yoga,
            place_big_field, place_big_shooting, place_big_other2;

    @Override
    public boolean transfermsg() {
        init();
        CompanyInfomationActivity.INSTENT.bigPlaceInfoEntity.setAudit_state(0);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.projectbig_note1:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_big_3));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.projectbig_note2:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_big_4));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
            case R.id.projectbig_note3:
                stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.help_big_5));
                stringBuilder.append("\r\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
        }
    }
}
