package com.firstvrp.censusdata.Adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SimpleAdapter;

import com.firstvrp.censusdata.R;

import java.util.List;
import java.util.Map;

/**
 * Created by arthur on 2016/7/6.
 */
public class CheakSimpleAdapter extends SimpleAdapter {
    /**
     * Constructor
     *
     * @param context  The context where the View associated with this SimpleAdapter is running
     * @param data     A List of Maps. Each entry in the List corresponds to one row in the list. The
     *                 Maps contain the data for each row, and should include all the entries specified in
     *                 "from"
     * @param resource Resource identifier of a view layout that defines the views for this list
     *                 item. The layout file should include at least those named views defined in "to"
     * @param from     A list of column names that will be added to the Map associated with each
     *                 item.
     * @param to       The views that should display column in the "from" parameter. These should all be
     *                 TextViews. The first N views in this list are given the values of the first N columns
     */
    LayoutInflater inflater;
    public CheckBox mCheckBox;
    private boolean isShow =false;
    Context mContext;
    public CheakSimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        mContext = context;
        inflater=LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fragment_checkpending, null);
        mCheckBox = (CheckBox) view.findViewById(R.id.checkBox);
    }
    public void toggle(){
        new Thread(){
            public void run(){
                Message message = new Message();
                if(isShow){
                    
                }
                // message.what=;
                handler.sendMessage(message);
            }
        }.start();

        if(isShow){
            HideCheckBox();
        }else{
            ShowCheckBox();
        }
     
        
        
        
    }
    private void ShowCheckBox() {
        if(isShow)return;
        mCheckBox.setVisibility(View.VISIBLE);
        isShow = true;
    }
    private void HideCheckBox() {
        if(!isShow)return;
        mCheckBox.setVisibility(View.GONE);
        isShow = false;
    }
    private Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg){
       
            //更新UI
        }
    };
    
    
    
    class MyRunnable implements Runnable{

        @Override
        public void run() {
            // TODO Auto-generated method stub
            /*index = index%3;
            iv.setImageResource(images[index]);
            handler.postDelayed(myRunnable,1000);*/
        }
    }
    
}
