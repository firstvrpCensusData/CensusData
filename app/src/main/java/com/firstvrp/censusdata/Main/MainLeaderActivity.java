package com.firstvrp.censusdata.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.firstvrp.censusdata.R;
import com.firstvrp.censusdata.SearchActivity;

/**
 * 主页页面
 */
public class MainLeaderActivity extends SherlockActivity {
    private FragmentTabHost tabHost;
    private FrameLayout  checkpending_framelayout, checked_framelayout,analyze_framelayout,search_framelayout, mycenter_framelayout;

    private ImageView tab_checkpending, tab_checked_click, tab_analyze_click, tab_search_click, tab_mycenter_click;
    private TextView tab_checkpending_text, tab_checked_text, tab_analyze_text, tab_search_text, tab_mycenter_text;

    private ActionBar actionBar;

    public static MainLeaderActivity INSTANCE;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_tab_action);// 显示真正的应用界面
        initView();
        init();

        INSTANCE = MainLeaderActivity.this;
    }

    private void initView() {

        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);

        tabHost.setup(this, getSupportFragmentManager(), R.id.framlayout_my);

        tabHost.addTab(tabHost.newTabSpec("1").setIndicator("1")
                , LeaderCheckPendingFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("2").setIndicator("2")
                , CheckedFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("3").setIndicator("3")
                , AnalyzeFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("4").setIndicator("4")
                , SearchFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("5").setIndicator("5")
                , MyCenterFragment.class, null);

        //设置默认显示页面
        tabHost.setCurrentTab(1);

        checkpending_framelayout = (FrameLayout) findViewById(R.id.checkpending_framelayout);
        checked_framelayout = (FrameLayout) findViewById(R.id.checked_framelayout);
        analyze_framelayout = (FrameLayout) findViewById(R.id.analyze_framelayout);
        search_framelayout = (FrameLayout) findViewById(R.id.search_framelayout);
        mycenter_framelayout = (FrameLayout) findViewById(R.id.mycenter_framelayout);



        checkpending_framelayout.setOnClickListener(l);
        checked_framelayout.setOnClickListener(l);
        analyze_framelayout.setOnClickListener(l);
        search_framelayout.setOnClickListener(l);
        mycenter_framelayout.setOnClickListener(l);



        tab_checkpending = (ImageView) findViewById(R.id.tab_checkpending);
        tab_checked_click = (ImageView) findViewById(R.id.tab_checked_click);
        tab_analyze_click = (ImageView) findViewById(R.id.tab_analyze_click);
        tab_search_click = (ImageView) findViewById(R.id.tab_search_click);
        tab_mycenter_click = (ImageView) findViewById(R.id.tab_mycenter_click);


        tab_checkpending_text = (TextView) findViewById(R.id.tab_checkpending_text);
        tab_checked_text = (TextView) findViewById(R.id.tab_checked_text);
        tab_analyze_text = (TextView) findViewById(R.id.tab_analyze_text);
        tab_search_text = (TextView) findViewById(R.id.tab_search_text);
        tab_mycenter_text = (TextView) findViewById(R.id.tab_mycenter_text);
    }

    View.OnClickListener l = new View.OnClickListener() {

        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            switch (arg0.getId()) {
                case R.id.checkpending_framelayout:
                    tabHost.setCurrentTabByTag("1");
                  /*  Intent intent = new Intent(MainLeaderActivity.this,CheckPendingActivity.class);
                    startActivity(intent);*/
                    tab_checkpending.setImageResource(R.drawable.tab_home_click);
                    tab_checked_click.setImageResource(R.drawable.tab_bang);
                    tab_analyze_click.setImageResource(R.drawable.tab_analyze);
                    tab_search_click.setImageResource(R.drawable.tab_search);
                    tab_mycenter_click.setImageResource(R.drawable.tab_person);
                    
                    tab_checked_text.setTextColor(R.color.bartext);
                    tab_checkpending_text.setTextColor(R.color.black);
                    tab_analyze_text.setTextColor(R.color.black);
                    tab_mycenter_text.setTextColor(R.color.black);
                    tab_search_text.setTextColor(R.color.black);

                    actionBar.setTitle(R.string.check_pending);
                    break;
                case R.id.checked_framelayout:
                    tabHost.setCurrentTabByTag("2");
                    
                    tab_checkpending.setImageResource(R.drawable.tab_home);
                    tab_checked_click.setImageResource(R.drawable.tab_bang_click);
                    tab_analyze_click.setImageResource(R.drawable.tab_analyze);
                    tab_search_click.setImageResource(R.drawable.tab_search);
                    tab_mycenter_click.setImageResource(R.drawable.tab_person);


                    tab_checked_text.setTextColor(R.color.black);
                    tab_checkpending_text.setTextColor(R.color.bartext);
                    tab_analyze_text.setTextColor(R.color.black);
                    tab_mycenter_text.setTextColor(R.color.black);
                    tab_search_text.setTextColor(R.color.black);

                    actionBar.setTitle(R.string.checke_text);
                    
                    break;
                case R.id.analyze_framelayout:
                    tabHost.setCurrentTabByTag("3");

                    tab_checkpending.setImageResource(R.drawable.tab_home);
                    tab_checked_click.setImageResource(R.drawable.tab_bang);
                    tab_analyze_click.setImageResource(R.drawable.tab_analyze_click);
                    tab_search_click.setImageResource(R.drawable.tab_search);
                    tab_mycenter_click.setImageResource(R.drawable.tab_person);

                    tab_checked_text.setTextColor(R.color.black);
                    tab_checkpending_text.setTextColor(R.color.black);
                    tab_analyze_text.setTextColor(R.color.bartext);
                    tab_mycenter_text.setTextColor(R.color.black);
                    tab_search_text.setTextColor(R.color.black);

                    actionBar.setTitle(R.string.analyze);
                    break;

                case R.id.search_framelayout:
                    tabHost.setCurrentTabByTag("4");
                    tab_checkpending.setImageResource(R.drawable.tab_home);
                    tab_checked_click.setImageResource(R.drawable.tab_bang);
                    tab_analyze_click.setImageResource(R.drawable.tab_analyze);
                    tab_search_click.setImageResource(R.drawable.tab_search_click);
                    tab_mycenter_click.setImageResource(R.drawable.tab_person);


                    tab_checked_text.setTextColor(R.color.black);
                    tab_checkpending_text.setTextColor(R.color.black);
                    tab_analyze_text.setTextColor(R.color.black);
                    tab_mycenter_text.setTextColor(R.color.bartext);
                    tab_search_text.setTextColor(R.color.black);
                    actionBar.setTitle(R.string.search);
                    break;
                case R.id.mycenter_framelayout:
                    tabHost.setCurrentTabByTag("5");
                    tab_checkpending.setImageResource(R.drawable.tab_home);
                    tab_checked_click.setImageResource(R.drawable.tab_bang);
                    tab_analyze_click.setImageResource(R.drawable.tab_analyze);
                    tab_search_click.setImageResource(R.drawable.tab_search);
                    tab_mycenter_click.setImageResource(R.drawable.tab_person_click);


                    tab_checked_text.setTextColor(R.color.black);
                    tab_checkpending_text.setTextColor(R.color.black);
                    tab_analyze_text.setTextColor(R.color.black);
                    tab_mycenter_text.setTextColor(R.color.black);
                    tab_search_text.setTextColor(R.color.bartext);
                    
                    actionBar.setTitle(R.string.user_management);
                    break;
            }
        }
    };
    private void init() {
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.menu_search, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                Intent intent = new Intent(MainLeaderActivity.this, SearchActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        // 如果是返回键,直接返回到桌面
//        if (keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_HOME) {
//            showExitGameAlert();
//        }
//
//        return super.onKeyDown(keyCode, event);
//    }
//
//    private void showExitGameAlert() {
//        new AlertDialog.Builder(this).setTitle("系统提示")//设置对话框标题
//
//                .setMessage("请确认所有数据都保存后再退出系统！")//设置显示的内容
//
//                .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加确定按钮
//
//                    @Override
//
//                    public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件
//
//                        finish();
//
//                    }
//
//                }).setNegativeButton("返回", new DialogInterface.OnClickListener() {//添加返回按钮
//
//
//            @Override
//
//            public void onClick(DialogInterface dialog, int which) {//响应事件
//
//                Log.i("alertdialog", " 请保存数据！");
//
//            }
//
//        }).show();//在按键响应事件中显示此对话框
//    }

}