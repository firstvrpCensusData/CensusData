package com.firstvrp.censusdata.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.firstvrp.censusdata.Entity.PlaceRangeEntity;
import com.firstvrp.censusdata.PlaceTable.PlaceSpecialProject7;
import com.firstvrp.censusdata.R;

import java.util.List;

/**
 * Created by chenyuan on 16/6/19.
 */
public class Project7Adapter extends BaseExpandableListAdapter {
    Context context;
    List<String> group;
    List<List<PlaceRangeEntity>> child;

    public Project7Adapter(Context context, List<String> group, List<List<PlaceRangeEntity>> child) {
        this.context = context;
        this.group = group;
        this.child = child;
    }
    @Override
    public int getGroupCount() {
        return group.size();
    }
    @Override
    public int getChildrenCount(int groupPosition) {
        return child.get(groupPosition).size();
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
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.place_7_first, null);
            viewHolder = new ViewHolder();
            viewHolder.iv_place_7_first_ico = (ImageView) convertView.findViewById(R.id.iv_place_7_first_ico);
            viewHolder.tv_place_7_first_name = (TextView) convertView.findViewById(R.id.tv_place_7_first_name);
            viewHolder.btn_place_7_first_updata = (ImageView) convertView.findViewById(R.id.btn_place_7_first_updata);
            viewHolder.btn_place_7_first_delete = (ImageView) convertView.findViewById(R.id.btn_place_7_first_delete);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tv_place_7_first_name.setText(group.get(groupPosition));

        viewHolder.btn_place_7_first_updata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlaceSpecialProject7.activity.createDialogAdd(false);
                if (child.get(groupPosition).get(0).getRange_type().equals("10米靶场"))
                    PlaceSpecialProject7.activity.add_placerange_spinner.setSelection(0, true);
                else if (child.get(groupPosition).get(0).getRange_type().equals("25米靶场"))
                    PlaceSpecialProject7.activity.add_placerange_spinner.setSelection(1, true);
                else if (child.get(groupPosition).get(0).getRange_type().equals("50米靶场"))
                    PlaceSpecialProject7.activity.add_placerange_spinner.setSelection(2, true);
                else if (child.get(groupPosition).get(0).getRange_type().equals("10米移动靶场"))
                    PlaceSpecialProject7.activity.add_placerange_spinner.setSelection(3, true);
                else if (child.get(groupPosition).get(0).getRange_type().equals("50米移动靶场"))
                    PlaceSpecialProject7.activity.add_placerange_spinner.setSelection(4, true);
                else if (child.get(groupPosition).get(0).getRange_type().equals("飞碟多向靶场"))
                    PlaceSpecialProject7.activity.add_placerange_spinner.setSelection(5, true);
                else if (child.get(groupPosition).get(0).getRange_type().equals("飞碟双多向靶场"))
                    PlaceSpecialProject7.activity.add_placerange_spinner.setSelection(6, true);
                else if (child.get(groupPosition).get(0).getRange_type().equals("飞碟双向靶场"))
                    PlaceSpecialProject7.activity.add_placerange_spinner.setSelection(7, true);
                else if (child.get(groupPosition).get(0).getRange_type().equals("决赛靶场"))
                    PlaceSpecialProject7.activity.add_placerange_spinner.setSelection(8, true);
                else if (child.get(groupPosition).get(0).getRange_type().equals("其他靶场"))
                    PlaceSpecialProject7.activity.add_placerange_spinner.setSelection(9, true);

                PlaceSpecialProject7.activity.add_place_width.setText(String.valueOf(child.get(groupPosition).get(0).getPlace_width()));
                PlaceSpecialProject7.activity.add_place_length.setText(String.valueOf(child.get(groupPosition).get(0).getPlace_length()));
                PlaceSpecialProject7.activity.add_quantity.setText(String.valueOf(child.get(groupPosition).get(0).getQuantity()));

                if (child.get(groupPosition).get(0).getRange_system().equals("机械靶")) {
                    PlaceSpecialProject7.activity.add_place_mechanical.setChecked(true);
                } else if (child.get(groupPosition).get(0).getRange_system().equals("电子靶")) {
                    PlaceSpecialProject7.activity.add_place_electronic.setChecked(true);
                } else if (child.get(groupPosition).get(0).getRange_system().equals("其他")) {
                    PlaceSpecialProject7.activity.add_place_other.setChecked(true);
                }

                if (child.get(groupPosition).get(0).getLight_device() == 1) {
                    PlaceSpecialProject7.activity.add_place_light_device_y.setChecked(true);
                } else if (child.get(groupPosition).get(0).getLight_device() == 2) {
                    PlaceSpecialProject7.activity.add_place_light_device_n.setChecked(true);
                }

                group.remove(groupPosition);
                child.remove(groupPosition).remove(0);
                notifyDataSetChanged();
            }
        });

        viewHolder.btn_place_7_first_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
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
            viewHolder.iv_place_7_first_ico.setBackgroundResource(R.drawable.ico_pull_down);
        else viewHolder.iv_place_7_first_ico.setBackgroundResource(R.drawable.ico_pull_up);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.place_7_second, null);
            viewHolder = new ViewHolder();
            viewHolder.place_7_range_type = (TextView) convertView.findViewById(R.id.place_7_range_type);
            viewHolder.place_7_place_length = (TextView) convertView.findViewById(R.id.place_7_place_length);
            viewHolder.place_7_place_width = (TextView) convertView.findViewById(R.id.place_7_place_width);
            viewHolder.place_7_quantity = (TextView) convertView.findViewById(R.id.place_7_quantity);
            viewHolder.place_7_range_system = (TextView) convertView.findViewById(R.id.place_7_range_system);
            viewHolder.place_7_light_device = (TextView) convertView.findViewById(R.id.place_7_light_device);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.place_7_range_type.setText(child.get(groupPosition).get(childPosition).getRange_type());
        viewHolder.place_7_place_length.setText(child.get(groupPosition).get(childPosition).getPlace_length());
        viewHolder.place_7_place_width.setText(child.get(groupPosition).get(childPosition).getPlace_width());
        viewHolder.place_7_quantity.setText(String.valueOf(child.get(groupPosition).get(childPosition).getQuantity()));
        viewHolder.place_7_range_system.setText(child.get(groupPosition).get(childPosition).getRange_system());

        if (child.get(groupPosition).get(childPosition).getLight_device() == 1)
            viewHolder.place_7_light_device.setText("有");
        else if (child.get(groupPosition).get(childPosition).getLight_device() == 2)
            viewHolder.place_7_light_device.setText("无");

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    static class ViewHolder {
        ImageView iv_place_7_first_ico, btn_place_7_first_updata, btn_place_7_first_delete;
        TextView tv_place_7_first_name;
        TextView place_7_range_type, place_7_place_length,
                place_7_place_width, place_7_quantity,
                place_7_range_system, place_7_light_device;
    }
}
