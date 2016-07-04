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
import com.firstvrp.censusdata.OrganizationCodeActivity;
import com.firstvrp.censusdata.R;
import com.firstvrp.censusdata.SearchActivity;

/**
 * 主页页面
 */
public class MainActionActivity extends SherlockActivity {
    private FragmentTabHost tabHost;
    private FrameLayout unfinished_framelayout, checkpending_framelayout, checked_framelayout, mycenter_framelayout, add_framelayout;

    private ImageView tab_unfinished_click, tab_checkpending, tab_checked_click, tab_mycenter_click, tab_add_click;
    private TextView tab_unfinished_text, tab_checkpending_text, tab_shop_text_click, tab_personal_text_click, tab_add_text_click;

    private ActionBar actionBar;

    public static MainActionActivity INSTANCE;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tab_action);// 显示真正的应用界面
        initView();
        init();

        INSTANCE = MainActionActivity.this;
    }

    private void initView() {

        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);

        tabHost.setup(this, getSupportFragmentManager(), R.id.framlayout_my);

        tabHost.addTab(tabHost.newTabSpec("1").setIndicator("1")
                , UnfinishedFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("2").setIndicator("2")
                , CheckPendingFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("3").setIndicator("3")
                , CheckedFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("4").setIndicator("4")
                , MyCenterFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("5").setIndicator("5")
                , AddFragment.class, null);

        //设置默认显示页面
        tabHost.setCurrentTab(4);

        unfinished_framelayout = (FrameLayout) findViewById(R.id.unfinished_framelayout);
        checkpending_framelayout = (FrameLayout) findViewById(R.id.checkpending_framelayout);
        checked_framelayout = (FrameLayout) findViewById(R.id.checked_framelayout);
        mycenter_framelayout = (FrameLayout) findViewById(R.id.mycenter_framelayout);
        add_framelayout = (FrameLayout) findViewById(R.id.add_framelayout);

        unfinished_framelayout.setOnClickListener(l);
        checkpending_framelayout.setOnClickListener(l);
        checked_framelayout.setOnClickListener(l);
        mycenter_framelayout.setOnClickListener(l);
        add_framelayout.setOnClickListener(l);

        tab_unfinished_click = (ImageView) findViewById(R.id.tab_unfinished_click);
        tab_checkpending = (ImageView) findViewById(R.id.tab_checkpending);
        tab_checked_click = (ImageView) findViewById(R.id.tab_checked_click);
        tab_mycenter_click = (ImageView) findViewById(R.id.tab_mycenter_click);
        tab_add_click = (ImageView) findViewById(R.id.tab_add_click);

        tab_unfinished_text = (TextView) findViewById(R.id.tab_unfinished_text);
        tab_checkpending_text = (TextView) findViewById(R.id.tab_checkpending_text);
        tab_shop_text_click = (TextView) findViewById(R.id.tab_checked_text);
        tab_personal_text_click = (TextView) findViewById(R.id.tab_mycenter_text);
        tab_add_text_click = (TextView) findViewById(R.id.tab_add_text);
    }

    View.OnClickListener l = new View.OnClickListener() {

        public void onClick(View arg0) {
             switch (arg0.getId()) {
                case R.id.unfinished_framelayout:
                    tabHost.setCurrentTabByTag("1");
                    tab_unfinished_click.setImageResource(R.drawable.tab_home_click);
                    tab_checkpending.setImageResource(R.drawable.tab_bang);
                    tab_checked_click.setImageResource(R.drawable.tab_find);
                    tab_mycenter_click.setImageResource(R.drawable.tab_person);
                    tab_add_click.setImageResource(R.drawable.tab_ask);

                    tab_unfinished_text.setTextColor(R.color.bartext);
                    tab_checkpending_text.setTextColor(R.color.black);
                    tab_shop_text_click.setTextColor(R.color.black);
                    tab_personal_text_click.setTextColor(R.color.black);
                    tab_add_text_click.setTextColor(R.color.black);

                    actionBar.setTitle(R.string.unfinished);
                    break;
                case R.id.checkpending_framelayout:
                    tabHost.setCurrentTabByTag("2");
                    tab_unfinished_click.setImageResource(R.drawable.tab_home);
                    tab_checkpending.setImageResource(R.drawable.tab_bang_click);
                    tab_checked_click.setImageResource(R.drawable.tab_find);
                    tab_mycenter_click.setImageResource(R.drawable.tab_person);
                    tab_add_click.setImageResource(R.drawable.tab_ask);

                    tab_unfinished_text.setTextColor(R.color.black);
                    tab_checkpending_text.setTextColor(R.color.bartext);
                    tab_shop_text_click.setTextColor(R.color.black);
                    tab_personal_text_click.setTextColor(R.color.black);
                    tab_add_text_click.setTextColor(R.color.black);

                    actionBar.setTitle(R.string.checkpending);
                    break;
                case R.id.checked_framelayout:
                    tabHost.setCurrentTabByTag("3");
                    tab_unfinished_click.setImageResource(R.drawable.tab_home);
                    tab_checkpending.setImageResource(R.drawable.tab_bang);
                    tab_checked_click.setImageResource(R.drawable.tab_find_click);
                    tab_mycenter_click.setImageResource(R.drawable.tab_person);
                    tab_add_click.setImageResource(R.drawable.tab_ask);

                    tab_unfinished_text.setTextColor(R.color.black);
                    tab_checkpending_text.setTextColor(R.color.black);
                    tab_shop_text_click.setTextColor(R.color.bartext);
                    tab_personal_text_click.setTextColor(R.color.black);
                    tab_add_text_click.setTextColor(R.color.black);

                    actionBar.setTitle(R.string.checked);
                    break;
                case R.id.mycenter_framelayout:
                    tabHost.setCurrentTabByTag("4");
                    tab_unfinished_click.setImageResource(R.drawable.tab_home);
                    tab_checkpending.setImageResource(R.drawable.tab_bang);
                    tab_checked_click.setImageResource(R.drawable.tab_find);
                    tab_mycenter_click.setImageResource(R.drawable.tab_person_click);
                    tab_add_click.setImageResource(R.drawable.tab_ask);

                    tab_unfinished_text.setTextColor(R.color.black);
                    tab_checkpending_text.setTextColor(R.color.black);
                    tab_shop_text_click.setTextColor(R.color.black);
                    tab_personal_text_click.setTextColor(R.color.bartext);
                    tab_add_text_click.setTextColor(R.color.black);


                    actionBar.setTitle(R.string.personage);
                    break;

                case R.id.add_framelayout:
                    tabHost.setCurrentTabByTag("5");
                    tab_unfinished_click.setImageResource(R.drawable.tab_home);
                    tab_checkpending.setImageResource(R.drawable.tab_bang);
                    tab_checked_click.setImageResource(R.drawable.tab_find);
                    tab_mycenter_click.setImageResource(R.drawable.tab_person);
                    tab_add_click.setImageResource(R.drawable.tab_ask_click);

                    tab_unfinished_text.setTextColor(R.color.black);
                    tab_checkpending_text.setTextColor(R.color.black);
                    tab_shop_text_click.setTextColor(R.color.black);
                    tab_personal_text_click.setTextColor(R.color.black);
                    tab_add_text_click.setTextColor(R.color.bartext);
                    actionBar.setTitle(R.string.app_name);

                    Intent intent = new Intent(MainActionActivity.this, OrganizationCodeActivity.class);
                    startActivity(intent);
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
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setTitle(R.string.app_name);
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
                Intent intent = new Intent(MainActionActivity.this, SearchActivity.class);
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