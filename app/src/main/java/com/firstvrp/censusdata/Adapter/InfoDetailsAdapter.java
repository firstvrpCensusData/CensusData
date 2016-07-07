package com.firstvrp.censusdata.Adapter;

/**
 * Created by chenyuan on 16/6/2.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.firstvrp.censusdata.Entity.ChailPlaceInfoEntity;
import com.firstvrp.censusdata.Entity.PlaceInfoChildEntity;
import com.firstvrp.censusdata.Entity.Project4SyndromeEntity;
import com.firstvrp.censusdata.PlaceTable.PlaceSpecialProject4c;
import com.firstvrp.censusdata.PlaceTable.PlaceSpecialProject7;
import com.firstvrp.censusdata.R;

import java.util.List;

public class InfoDetailsAdapter extends BaseExpandableListAdapter {

    Activity activity;
    List<String> group;
    List<List<PlaceInfoChildEntity>> child;

    public InfoDetailsAdapter(Activity a, List<String> group,
                              List<List<PlaceInfoChildEntity>> child) {
        activity = a;
        this.group = group;
        this.child = child;
    }

    @Override
    public int getGroupCount() {
        return group.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return group.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return child.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    ViewHolder viewHolder;

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        final PlaceInfoChildEntity placeInfoChildEntity = (PlaceInfoChildEntity) getChild(groupPosition,0);
        if (convertView == null) {
            convertView = LayoutInflater.from(activity).inflate(R.layout.place_4c_first, null);
            viewHolder = new ViewHolder();
            viewHolder.iv_place_4c_first_ico = (ImageView) convertView.findViewById(R.id.iv_place_4c_first_ico);
            viewHolder.tv_place_4c_first_name = (TextView) convertView.findViewById(R.id.tv_place_4c_first_name);
            viewHolder.btn_place_4c_first_updata = (ImageView) convertView.findViewById(R.id.btn_place_4c_first_updata);
            viewHolder.btn_place_4c_first_delete = (ImageView) convertView.findViewById(R.id.btn_place_4c_first_delete);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tv_place_4c_first_name.setText(group.get(groupPosition));

        viewHolder.btn_place_4c_first_updata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlaceSpecialProject4c.activity.createDialogAdd(false);

                if (placeInfoChildEntity.getPlace_code().equals("11")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(0, true);
                if (placeInfoChildEntity.getPlace_code().equals("12")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(1, true);
                if (placeInfoChildEntity.getPlace_code().equals("13")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(2, true);
                if (placeInfoChildEntity.getPlace_code().equals("14")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(3, true);
                if (placeInfoChildEntity.getPlace_code().equals("15")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(4, true);
                if (placeInfoChildEntity.getPlace_code().equals("16")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(5, true);
                if (placeInfoChildEntity.getPlace_code().equals("17")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(6, true);
                if (placeInfoChildEntity.getPlace_code().equals("18")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(7, true);
                if (placeInfoChildEntity.getPlace_code().equals("19")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(8, true);
                if (placeInfoChildEntity.getPlace_code().equals("20")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(9, true);
                if (placeInfoChildEntity.getPlace_code().equals("21")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(10, true);
                if (placeInfoChildEntity.getPlace_code().equals("22")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(11, true);
                if (placeInfoChildEntity.getPlace_code().equals("23")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(12, true);
                if (placeInfoChildEntity.getPlace_code().equals("24")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(13, true);
                if (placeInfoChildEntity.getPlace_code().equals("25")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(14, true);
                if (placeInfoChildEntity.getPlace_code().equals("26")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(15, true);
                if (placeInfoChildEntity.getPlace_code().equals("27")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(16, true);
                if (placeInfoChildEntity.getPlace_code().equals("28")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(17, true);
                if (placeInfoChildEntity.getPlace_code().equals("29")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(18, true);
                if (placeInfoChildEntity.getPlace_code().equals("30")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(19, true);
                if (placeInfoChildEntity.getPlace_code().equals("31")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(20, true);
                if (placeInfoChildEntity.getPlace_code().equals("32")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(21, true);
                if (placeInfoChildEntity.getPlace_code().equals("33")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(22, true);
                if (placeInfoChildEntity.getPlace_code().equals("34")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(23, true);
                if (placeInfoChildEntity.getPlace_code().equals("35")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(24, true);
                if (placeInfoChildEntity.getPlace_code().equals("36")) PlaceSpecialProject4c.activity.add_place_spinner.setSelection(25, true);

                PlaceSpecialProject4c.activity.add_place_length.setText(String.valueOf(placeInfoChildEntity.getPlace_length()));
                PlaceSpecialProject4c.activity.add_place_width.setText(String.valueOf(placeInfoChildEntity.getPlace_width()));
                PlaceSpecialProject4c.activity.add_indoor_high.setText(String.valueOf(placeInfoChildEntity.getIndoor_high()));
                PlaceSpecialProject4c.activity.add_place_quantity.setText(String.valueOf(placeInfoChildEntity.getPlace_quantity()));
                if (placeInfoChildEntity.getPlace_surface().equals("木地板")) {
                    PlaceSpecialProject4c.activity.add_place_wood_flooring.setChecked(true);
                } else if (placeInfoChildEntity.getPlace_surface().equals("合成材料")) {
                    PlaceSpecialProject4c.activity.add_place_synthetic_material.setChecked(true);
                } else if (placeInfoChildEntity.getPlace_surface().equals("水泥")) {
                    PlaceSpecialProject4c.activity.add_place_cement.setChecked(true);
                } else if (placeInfoChildEntity.getPlace_surface().equals("冰")) {
                    PlaceSpecialProject4c.activity.add_place_ice.setChecked(true);
                } else if (placeInfoChildEntity.getPlace_surface().equals("沙土")) {
                    PlaceSpecialProject4c.activity.add_place_soil.setChecked(true);
                } else if (placeInfoChildEntity.getPlace_surface().equals("其他")) {
                    PlaceSpecialProject4c.activity.add_place_other.setChecked(true);
                }
                group.remove(groupPosition);
                child.remove(groupPosition).remove(0);
                notifyDataSetChanged();
            }
        });

        viewHolder.btn_place_4c_first_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setMessage("确认删除吗？");
                builder.setTitle("提示");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        group.remove(groupPosition);
                        child.remove(groupPosition).remove(0);
                        notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        });

        if (isExpanded)
            viewHolder.iv_place_4c_first_ico.setBackgroundResource(R.drawable.ico_pull_down);
        else viewHolder.iv_place_4c_first_ico.setBackgroundResource(R.drawable.ico_pull_up);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        PlaceInfoChildEntity placeInfoChildEntity = child.get(groupPosition).get(childPosition);
        if (convertView == null) {
            convertView = LayoutInflater.from(activity).inflate(R.layout.place_4c_second, null);
            viewHolder = new ViewHolder();
            viewHolder.place_4c_second_txt = (TextView) convertView.findViewById(R.id.place_4c_second_txt);
            viewHolder.place_4c_place_width = (TextView) convertView.findViewById(R.id.place_4c_place_width);
            viewHolder.place_4c_indoor_high = (TextView) convertView.findViewById(R.id.place_4c_indoor_high);
            viewHolder.place_4c_place_quantity = (TextView) convertView.findViewById(R.id.place_4c_place_quantity);
            viewHolder.place_4c_wood_flooring = (TextView) convertView.findViewById(R.id.place_4c_wood_flooring);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.place_4c_second_txt.setText(String.valueOf(placeInfoChildEntity.getPlace_length()));
        viewHolder.place_4c_place_width.setText(String.valueOf(placeInfoChildEntity.getPlace_width()));
        viewHolder.place_4c_indoor_high.setText(String.valueOf(placeInfoChildEntity.getIndoor_high()));
        viewHolder.place_4c_place_quantity.setText(String.valueOf(placeInfoChildEntity.getPlace_quantity()));
        viewHolder.place_4c_wood_flooring.setText(placeInfoChildEntity.getPlace_surface());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private class ViewHolder {
        ImageView iv_place_4c_first_ico, btn_place_4c_first_updata, btn_place_4c_first_delete;
        TextView tv_place_4c_first_name;

        TextView place_4c_second_txt, place_4c_place_width, place_4c_indoor_high, place_4c_place_quantity,
                place_4c_wood_flooring;
    }
}
