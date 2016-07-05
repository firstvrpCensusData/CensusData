package com.firstvrp.censusdata.CensusTaker.Main.PlaceTable;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.firstvrp.censusdata.CensusTaker.Main.Adapter.InfoDetailsAdapter;
import com.firstvrp.censusdata.CensusTaker.Main.CompanyInformation.CompanyInfomationActivity;
import com.firstvrp.censusdata.CensusTaker.Main.CompanyInformation.IBtnCallListener;
import com.firstvrp.censusdata.Entity.PlaceInfoChildEntity;
import com.firstvrp.censusdata.GetUserInfo;
import com.firstvrp.censusdata.MyApplication;
import com.firstvrp.censusdata.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Utils.GetNowTime;
import Utils.PromptManager;

public class PlaceSpecialProject4c extends Fragment implements View.OnClickListener, IBtnCallListener {
    ExpandableListView expandList;
    InfoDetailsAdapter adapter;
    public static PlaceSpecialProject4c activity;
    List<String> group;
    List<List<PlaceInfoChildEntity>> child;

    private MyApplication application;
    private Button add_place_4c;


    // 初始化group child内容
    public void initialData() {
        group = new ArrayList<String>();
        child = new ArrayList<List<PlaceInfoChildEntity>>();
    }

    private void addInfo(String g, List<PlaceInfoChildEntity> c) {
        group.add(g);
        List<PlaceInfoChildEntity> childitem = new ArrayList<PlaceInfoChildEntity>();
        for (int i = 0; i < c.size(); i++) {
            childitem.add(c.get(i));
        }
        child.add(childitem);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_place_special_project4c, container, false);
        activity = this;
        expandList = (ExpandableListView) view.findViewById(R.id.expandList);
        // 初始化各级元素
        initialData();

        add_place_4c = (Button) view.findViewById(R.id.add_place_4c);

        add_place_4c.setOnClickListener(this);

        // 适配器内容
        adapter = new InfoDetailsAdapter(this.getActivity(), group, child);

        expandList.setAdapter(adapter);
        expandList.setGroupIndicator(null);
        expandList.setDivider(null);
        expandList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView arg0, View arg1,
                                        int arg2, long arg3) {
                return false;
            }
        });
        expandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView arg0, View arg1,
                                        int arg2, int arg3, long arg4) {
                return false;
            }
        });

        application = (MyApplication) getActivity().getApplication();

        forcingDefault();
        return view;
    }

    private void forcingDefault() {
        if (application.getPlaceInfoEntity() != null  && application.getPlaceInfoEntity().getPlaceinfochild() != null) {
            List<PlaceInfoChildEntity> placeInfoChildEntity = application.getPlaceInfoEntity().getPlaceinfochild();
            for (int i = 0; i < placeInfoChildEntity.size(); i++) {
                List<PlaceInfoChildEntity> placeInfoChildEntities = new ArrayList<>();
                placeInfoChildEntities.add(placeInfoChildEntity.get(i));
                addInfo(placeInfoChildEntity.get(i).getPlace_name(), placeInfoChildEntities);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_place_4c:
                createDialogAdd(true);

                break;
        }
    }

    public Spinner add_place_spinner;
    public EditText add_place_length, add_place_width, add_indoor_high, add_place_quantity;
    public Button add_ok, add_no;
    public Dialog dialogAdd;
    public RadioButton add_place_wood_flooring, add_place_synthetic_material, add_place_cement,
            add_place_ice, add_place_soil, add_place_other;

    public void createDialogAdd(boolean n) {
        View viewAdd = LayoutInflater.from(this.getActivity()).inflate(R.layout.add_place_4c, null);
        dialogAdd = new Dialog(this.getActivity());
        dialogAdd.setContentView(viewAdd);
        dialogAdd.setTitle("输入新场地信息");
        dialogAdd.setCanceledOnTouchOutside(false);
        add_place_spinner = (Spinner) viewAdd.findViewById(R.id.add_place_spinner);
        add_place_length = (EditText) viewAdd.findViewById(R.id.add_place_length);
        add_place_width = (EditText) viewAdd.findViewById(R.id.add_place_width);
        add_indoor_high = (EditText) viewAdd.findViewById(R.id.add_indoor_high);
        add_place_quantity = (EditText) viewAdd.findViewById(R.id.add_place_quantity);

        add_place_wood_flooring = (RadioButton) viewAdd.findViewById(R.id.add_place_wood_flooring);
        add_place_synthetic_material = (RadioButton) viewAdd.findViewById(R.id.add_place_synthetic_material);
        add_place_cement = (RadioButton) viewAdd.findViewById(R.id.add_place_cement);
        add_place_ice = (RadioButton) viewAdd.findViewById(R.id.add_place_ice);
        add_place_soil = (RadioButton) viewAdd.findViewById(R.id.add_place_soil);
        add_place_other = (RadioButton) viewAdd.findViewById(R.id.add_place_other);

        add_ok = (Button) viewAdd.findViewById(R.id.add_ok);
        add_no = (Button) viewAdd.findViewById(R.id.add_no);

        if (n)
            add_no.setVisibility(View.VISIBLE);
        else
            add_no.setVisibility(View.GONE);

        add_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (add_place_length.getText().toString().isEmpty() ||
                        add_place_width.getText().toString().isEmpty() ||
                        add_indoor_high.getText().toString().isEmpty() ||
                        add_place_quantity.getText().toString().isEmpty()) {
                    PromptManager.showToast(getActivity(), "请将信息填写完整,没有请填0");
                    return;
                }

                List<PlaceInfoChildEntity> list = new ArrayList<PlaceInfoChildEntity>();
                PlaceInfoChildEntity project4SyndromeEntity = new PlaceInfoChildEntity();

                if (add_place_spinner.getSelectedItem().toString().equals("篮球房(馆)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(11));
                if (add_place_spinner.getSelectedItem().toString().equals("排球房(馆)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(12));
                if (add_place_spinner.getSelectedItem().toString().equals("手球房(馆)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(13));
                if (add_place_spinner.getSelectedItem().toString().equals("体操房(馆)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(14));
                if (add_place_spinner.getSelectedItem().toString().equals("羽毛球房(馆)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(15));
                if (add_place_spinner.getSelectedItem().toString().equals("乒乓球房(馆)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(16));
                if (add_place_spinner.getSelectedItem().toString().equals("武术房(馆)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(17));
                if (add_place_spinner.getSelectedItem().toString().equals("摔跤柔道拳击跆拳道空手道房(馆)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(18));
                if (add_place_spinner.getSelectedItem().toString().equals("举重房(馆)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(19));
                if (add_place_spinner.getSelectedItem().toString().equals("击剑房(馆)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(20));
                if (add_place_spinner.getSelectedItem().toString().equals("健身房(馆)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(21));
                if (add_place_spinner.getSelectedItem().toString().equals("棋牌房(室)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(22));
                if (add_place_spinner.getSelectedItem().toString().equals("保龄球房(馆)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(23));
                if (add_place_spinner.getSelectedItem().toString().equals("台球房(馆)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(24));
                if (add_place_spinner.getSelectedItem().toString().equals("沙狐球房(馆)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(25));
                if (add_place_spinner.getSelectedItem().toString().equals("五人制足球场(室内)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(26));
                if (add_place_spinner.getSelectedItem().toString().equals("网球房(馆)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(27));
                if (add_place_spinner.getSelectedItem().toString().equals("曲棍球场(室内)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(28));
                if (add_place_spinner.getSelectedItem().toString().equals("射箭场(室内)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(29));
                if (add_place_spinner.getSelectedItem().toString().equals("马术场(室内)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(30));
                if (add_place_spinner.getSelectedItem().toString().equals("冰球场(含短道速滑和速度滑冰)(室内)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(31));
                if (add_place_spinner.getSelectedItem().toString().equals("速滑场(室内)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(32));
                if (add_place_spinner.getSelectedItem().toString().equals("冰壶球场(室内)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(33));
                if (add_place_spinner.getSelectedItem().toString().equals("轮滑场(室内)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(34));
                if (add_place_spinner.getSelectedItem().toString().equals("壁球房(馆)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(35));
                if (add_place_spinner.getSelectedItem().toString().equals("门球房(馆)"))
                    project4SyndromeEntity.setPlace_code(String.valueOf(36));

                project4SyndromeEntity.setPlace_name(add_place_spinner.getSelectedItem().toString());
                project4SyndromeEntity.setPlace_length(Float.parseFloat(add_place_length.getText().toString()));
                project4SyndromeEntity.setPlace_width(Float.parseFloat(add_place_width.getText().toString()));
                project4SyndromeEntity.setIndoor_high(Float.parseFloat(add_indoor_high.getText().toString()));
                project4SyndromeEntity.setPlace_quantity(Integer.parseInt(add_place_quantity.getText().toString()));

                if (add_place_wood_flooring.isChecked()) {
                    project4SyndromeEntity.setPlace_surface(add_place_wood_flooring.getText().toString());
                } else if (add_place_synthetic_material.isChecked()) {
                    project4SyndromeEntity.setPlace_surface(add_place_synthetic_material.getText().toString());
                } else if (add_place_cement.isChecked()) {
                    project4SyndromeEntity.setPlace_surface(add_place_cement.getText().toString());
                } else if (add_place_ice.isChecked()) {
                    project4SyndromeEntity.setPlace_surface(add_place_ice.getText().toString());
                } else if (add_place_soil.isChecked()) {
                    project4SyndromeEntity.setPlace_surface(add_place_soil.getText().toString());
                } else if (add_place_other.isChecked()) {
                    project4SyndromeEntity.setPlace_surface(add_place_other.getText().toString());
                }

                list.add(project4SyndromeEntity);
                addInfo(add_place_spinner.getSelectedItem().toString(), list);

                adapter.notifyDataSetChanged();

                dialogAdd.dismiss();
            }
        });
        add_no.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialogAdd.dismiss();
            }
        });

        dialogAdd.show();
    }

    @Override
    public boolean transfermsg() {
        List<PlaceInfoChildEntity> placeInfoChildEntities = new ArrayList<PlaceInfoChildEntity>();
        for (int i = 0; i < child.size(); i++) {
            placeInfoChildEntities.add(child.get(i).get(0));
        }
        GetUserInfo getUserInfo = new GetUserInfo(getActivity());
        Map<String, String> map = getUserInfo.getUserSp();

        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setFill_date(GetNowTime.getNowTime());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setFill_people(map.get("userID"));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setFill_tel(map.get("userTel"));

        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceinfochild(placeInfoChildEntities);

        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);

        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia();
        }

        return true;
    }
}
