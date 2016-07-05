package com.firstvrp.censusdata.CensusTaker.Main.PlaceTable;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.firstvrp.censusdata.CensusTaker.Main.Adapter.Project7Adapter;
import com.firstvrp.censusdata.CensusTaker.Main.CompanyInformation.CompanyInfomationActivity;
import com.firstvrp.censusdata.CensusTaker.Main.CompanyInformation.IBtnCallListener;
import com.firstvrp.censusdata.CensusTaker.Main.Dialog.HelpDialog;
import com.firstvrp.censusdata.Entity.PlaceRangeEntity;
import com.firstvrp.censusdata.GetUserInfo;
import com.firstvrp.censusdata.MyApplication;
import com.firstvrp.censusdata.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Utils.GetNowTime;
import Utils.PromptManager;

/**
 */
public class PlaceSpecialProject7 extends Fragment implements IBtnCallListener, OnClickListener {
    private View view;
    private EditText projcet7_viewers_seats;
    private ExpandableListView project7_exlist;
    private Button project7_add;

    private ImageView project7_note1;
    List<String> group;
    List<List<PlaceRangeEntity>> child;
    public static PlaceSpecialProject7 activity;
    private MyApplication application;
    Project7Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_place_special_project7, container, false);
        activity = this;
        project7_exlist = (ExpandableListView) view.findViewById(R.id.project7_exlist);
        projcet7_viewers_seats = (EditText) view.findViewById(R.id.projcet7_viewers_seats);
        project7_add = (Button) view.findViewById(R.id.project7_add);
        project7_add.setOnClickListener(this);
        // 初始化各级元素
        initialData();
        // 适配器内容
        adapter = new Project7Adapter(this.getActivity(), group, child);

        project7_note1 = (ImageView) view.findViewById(R.id.project7_note1);
        project7_note1.setOnClickListener(this);
        project7_exlist.setAdapter(adapter);
        project7_exlist.setGroupIndicator(null);
        project7_exlist.setDivider(null);
        project7_exlist.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView arg0, View arg1,
                                        int arg2, long arg3) {
                return false;
            }
        });
        project7_exlist.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
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


        if (application.getPlaceInfoEntity() != null && application.getPlaceInfoEntity().getPlaceRanges() != null && application.getPlaceInfoEntity().getPlaceSpecialIndex() != null) {
            projcet7_viewers_seats.setText(String.valueOf(application.getPlaceInfoEntity().getPlaceSpecialIndex().getViewers_seats()));
            List<PlaceRangeEntity> placeRangeEntities = application.getPlaceInfoEntity().getPlaceRanges();
            for (int i = 0; i < placeRangeEntities.size(); i++) {
                List<PlaceRangeEntity> placeRangeEntities1 = new ArrayList<>();
                placeRangeEntities1.add(placeRangeEntities.get(i));
                addInfo(placeRangeEntities.get(i).getRange_type(), placeRangeEntities1);
            }
        }
    }

    public Spinner add_placerange_spinner;
    public EditText add_place_length, add_place_width, add_quantity;
    public Button add_ok, add_no;
    public Dialog dialogAdd;
    public RadioButton add_place_mechanical, add_place_electronic, add_place_other,
            add_place_light_device_y, add_place_light_device_n;

    public void createDialogAdd(boolean n) {
        View viewAdd = LayoutInflater.from(this.getActivity()).inflate(R.layout.add_place_7, null);
        dialogAdd = new Dialog(this.getActivity());
        dialogAdd.setContentView(viewAdd);
        dialogAdd.setTitle("输入新场地信息");
        add_placerange_spinner = (Spinner) viewAdd.findViewById(R.id.add_placerange_spinner);
        add_place_length = (EditText) viewAdd.findViewById(R.id.add_place_length);
        add_place_width = (EditText) viewAdd.findViewById(R.id.add_place_width);
        add_quantity = (EditText) viewAdd.findViewById(R.id.add_quantity);

        add_place_mechanical = (RadioButton) viewAdd.findViewById(R.id.add_place_mechanical);
        add_place_electronic = (RadioButton) viewAdd.findViewById(R.id.add_place_electronic);
        add_place_other = (RadioButton) viewAdd.findViewById(R.id.add_place_other);
        add_place_light_device_y = (RadioButton) viewAdd.findViewById(R.id.add_place_light_device_y);
        add_place_light_device_n = (RadioButton) viewAdd.findViewById(R.id.add_place_light_device_n);

        add_ok = (Button) viewAdd.findViewById(R.id.add_ok);
        add_no = (Button) viewAdd.findViewById(R.id.add_no);

        if (n) {
            add_no.setVisibility(View.VISIBLE);
        } else add_no.setVisibility(View.GONE);

        add_ok.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (add_place_length.getText().toString().isEmpty() ||
                        add_place_width.getText().toString().isEmpty() ||
                        add_quantity.getText().toString().isEmpty()) {
                    PromptManager.showToast(getActivity(), "请将信息填写完整,没有请填0");
                    return;
                }

                List<PlaceRangeEntity> list = new ArrayList<PlaceRangeEntity>();
                PlaceRangeEntity placeRangeEntity = new PlaceRangeEntity();

                placeRangeEntity.setRange_type(add_placerange_spinner.getSelectedItem().toString());

                placeRangeEntity.setPlace_length(add_place_length.getText().toString());
                placeRangeEntity.setPlace_width(add_place_width.getText().toString());
                placeRangeEntity.setQuantity(Integer.valueOf(add_quantity.getText().toString().isEmpty() ? "0" : add_quantity.getText().toString()));

                if (add_place_mechanical.isChecked()) {
                    placeRangeEntity.setRange_system(add_place_mechanical.getText().toString());
                } else if (add_place_electronic.isChecked()) {
                    placeRangeEntity.setRange_system(add_place_electronic.getText().toString());
                } else if (add_place_other.isChecked()) {
                    placeRangeEntity.setRange_system(add_place_other.getText().toString());
                }

                if (add_place_light_device_y.isChecked())
                    placeRangeEntity.setLight_device(1);
                else if (add_place_light_device_n.isChecked())
                    placeRangeEntity.setLight_device(2);


                list.add(placeRangeEntity);
                addInfo(add_placerange_spinner.getSelectedItem().toString(), list);

                adapter.notifyDataSetChanged();

                dialogAdd.dismiss();
            }
        });
        add_no.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                dialogAdd.dismiss();
            }
        });

        dialogAdd.show();
    }

    // 初始化group child内容
    public void initialData() {
        group = new ArrayList<String>();
        child = new ArrayList<List<PlaceRangeEntity>>();
    }


    private void addInfo(String g, List<PlaceRangeEntity> c) {
        group.add(g);
        List<PlaceRangeEntity> childitem = new ArrayList<PlaceRangeEntity>();
        for (int i = 0; i < c.size(); i++) {
            childitem.add(c.get(i));
        }
        child.add(childitem);
    }


    @Override
    public boolean transfermsg() {
        List<PlaceRangeEntity> placeRangeEntities = new ArrayList<PlaceRangeEntity>();
        for (int i = 0; i < child.size(); i++) {
            placeRangeEntities.add(child.get(i).get(0));
        }
        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceRanges(placeRangeEntities);
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setViewers_seats(Integer.parseInt(projcet7_viewers_seats.getText().toString().isEmpty()?"0":projcet7_viewers_seats.getText().toString()));

        GetUserInfo getUserInfo = new GetUserInfo(getActivity());
        Map<String, String> map = getUserInfo.getUserSp();

        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setFill_date(GetNowTime.getNowTime());
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setFill_people(map.get("userID"));
        CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity.setFill_tel(map.get("userTel"));

        CompanyInfomationActivity.INSTENT.placeInfoEntity.setPlaceSpecialIndex(CompanyInfomationActivity.INSTENT.placeSpecialIndexEntity);

        if (application.getPlaceInfoEntity() == null)
            BasicInformationFragmentB.postPlaceSpecia();
        else {
            CompanyInfomationActivity.INSTENT.placeInfoEntity.setId(application.getPlaceInfoEntity().getId());
            CompanyInfomationActivity.INSTENT.placeInfoEntity.getPlaceSpecialIndex().setId(application.getPlaceInfoEntity().getPlaceSpecialIndex().getId());
            BasicInformationFragmentB.putUpDataPlaceSpecia();
        }

        if (projcet7_viewers_seats.getText().toString().isEmpty()){
            projcet7_viewers_seats.setText("0");
            PromptManager.showToast(getActivity(),"观众席位不能为空，没有可填0");
            return false;
        }else
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.project7_add:
                createDialogAdd(true);
                break;
            case R.id.project7_note1:
                StringBuilder stringBuilder = new StringBuilder();
                if (application.getTypeID() == 68) {
                    stringBuilder.append(getActivity().getString(R.string.help_y7_1));
                    stringBuilder.append("\r\n");
                }
                if (application.getTypeID() == 69) {
                    stringBuilder.append(getActivity().getString(R.string.help_y7_2));
                    stringBuilder.append("\r\n");
                }
                stringBuilder.append(getActivity().getString(R.string.help_y7_3));
                stringBuilder.append("\r\n\n");
                stringBuilder.append(getActivity().getString(R.string.help_y7_5));
                stringBuilder.append("\r\n\n");
                stringBuilder.append(getActivity().getString(R.string.help_y7_6));
                stringBuilder.append("\r\n\n");
                stringBuilder.append(getActivity().getString(R.string.help_y7_8));
                stringBuilder.append("\r\n\n");
                new HelpDialog(getActivity(), stringBuilder.toString());
                break;
        }
    }
}
