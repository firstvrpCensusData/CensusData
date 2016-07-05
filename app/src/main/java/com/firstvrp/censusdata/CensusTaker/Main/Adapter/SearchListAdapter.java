package com.firstvrp.censusdata.CensusTaker.Main.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.firstvrp.censusdata.CensusTaker.Main.CompanyInformation.CompanyInfomationActivity;
import com.firstvrp.censusdata.Entity.PlaceInfoEntity;
import com.firstvrp.censusdata.MyApplication;
import com.firstvrp.censusdata.R;

import java.util.List;

/**
 * Created by chenyuan on 16/6/18.
 */
public class SearchListAdapter extends BaseAdapter {
    List<PlaceInfoEntity> placeInfoEntities;
    Context context;
    MyApplication application;
    public SearchListAdapter(Context context,List<PlaceInfoEntity> placeInfoEntities,MyApplication application) {
        this.placeInfoEntities = placeInfoEntities;
        this.context = context;
        this.application= application;
    }

    @Override
    public int getCount() {
        return placeInfoEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return placeInfoEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final PlaceInfoEntity placeInfoEntity = (PlaceInfoEntity) getItem(position);
        ViewHolder holder;
        //观察convertView随ListView滚动情况
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.search_list_style,
                    null);
            holder = new ViewHolder();
                    /*得到各个控件的对象*/
            holder.title = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(holder);//绑定ViewHolder对象
        } else {
            holder = (ViewHolder) convertView.getTag();//取出ViewHolder对象

        }
            /*设置TextView显示的内容，即我们存放在动态数组中的数据*/
        holder.title.setText(placeInfoEntity.getPlace_name());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CompanyInfomationActivity.class);
                intent.putExtra("type", placeInfoEntity.getPlace_code());
//                application.setUnitsInfoEntity((UnitsInfoEntity) getGroup(groupPosition));
                application.setUnitsID( placeInfoEntity.getUnits_id());

                application.setTypeID(Integer.valueOf(placeInfoEntity.getPlace_code()));

                application.setPlaceInfoEntity(placeInfoEntity);

                context.startActivity(intent);
            }
        });
        return convertView;
    }

    /*存放控件*/
    public final class ViewHolder {
        public TextView title;

    }
}
