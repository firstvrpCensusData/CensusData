package com.firstvrp.censusdata.CensusTaker.Main.CompanyInformation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.internal.view.menu.ActionMenuView;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.firstvrp.censusdata.CensusTaker.Main.Adapter.FragmentTabAdapter;
import com.firstvrp.censusdata.Entity.BigPlaceInfoEntity;
import com.firstvrp.censusdata.Entity.PlaceInfoEntity;
import com.firstvrp.censusdata.Entity.PlaceSpecialIndexEntity;
import com.firstvrp.censusdata.Entity.SaveStyleEnum;
import com.firstvrp.censusdata.Entity.UnitsInfoEntity;
import com.firstvrp.censusdata.CensusTaker.Main.MainActionActivity;
import com.firstvrp.censusdata.MyApplication;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.BasicInformationFragmentA;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.BasicInformationFragmentB;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject1;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject10;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject11;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject12;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject13;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject14;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject15;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject16;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject17;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject18;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject19;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject2;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject20;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject21;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject22;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject23;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject24;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject25;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject3;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject4;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject4a;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject4b;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject4c;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject5;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject5a;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject6;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject7;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject8;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject8a;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject8b;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProject9;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProjectBig;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProjectBiga;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProjectBigb;
import com.firstvrp.censusdata.CensusTaker.Main.PlaceTable.PlaceSpecialProjectBigc;
import com.firstvrp.censusdata.R;
import com.firstvrp.censusdata.SiteSelection.SiteSelectionActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 单位信息填写，fragment
 */
public class CompanyInfomationActivity extends SherlockFragmentActivity implements IBtnCallListener {
    /**
     * Called when the activity is first created.
     */
    public List<Fragment> fragments = new ArrayList<>();
    public ImageView iv_main_next, iv_main_pro;//左右切换箭头
    public static CompanyInfomationActivity INSTENT;
    public PlaceInfoEntity placeInfoEntity;
    public PlaceSpecialIndexEntity placeSpecialIndexEntity;
    public UnitsInfoEntity unitsInfoEntity;
    public BigPlaceInfoEntity bigPlaceInfoEntity;


    MyApplication application;
    LinearLayout ll_main_cat, ll_main_btn; //小圆点进度所在布局
    List<ImageView> listImageView; //小圆点列表

    TextView tvSelectPlace, tvOK, tvBigPlace;
    ActionBar actionBar;
    Bundle extras;//由组织机构代码，和场地选择传递过来的类型

    String type;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_infomation);

        extras = getIntent().getExtras();

        application = (MyApplication) getApplication();

        unitsInfoEntity = new UnitsInfoEntity();
        placeInfoEntity = new PlaceInfoEntity();
        placeSpecialIndexEntity = new PlaceSpecialIndexEntity();
        bigPlaceInfoEntity = new BigPlaceInfoEntity();

        INSTENT = this;

        type = extras.getString("type") == null ? "0" : extras.getString("type");

        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayUseLogoEnabled(true);

        fragmentsTableSelete();

        init();
    }

    private void fragmentsTableSelete() {
        switch (type) {
            case "big":
                actionBar.setTitle("丙表");
                switch (application.getUnitsInfoEntity().getUnits_type()) {
                    case "行政机关":
                        fragments.add(new PlaceSpecialProjectBig());
                        fragments.add(new PlaceSpecialProjectBiga());
                        fragments.add(new PlaceSpecialProjectBigb());
                        break;
                    case "事业单位":
                        fragments.add(new PlaceSpecialProjectBig());
                        fragments.add(new PlaceSpecialProjectBiga());
                        fragments.add(new PlaceSpecialProjectBigb());
                        break;
                    case "企业":
                        fragments.add(new PlaceSpecialProjectBig());
                        fragments.add(new PlaceSpecialProjectBiga());
                        fragments.add(new PlaceSpecialProjectBigc());
                        break;
                    case "其他单位":
                        fragments.add(new PlaceSpecialProjectBig());
                        fragments.add(new PlaceSpecialProjectBiga());
                        fragments.add(new PlaceSpecialProjectBigc());
                        break;
                    default:
                        fragments.add(new PlaceSpecialProjectBig());
                        fragments.add(new PlaceSpecialProjectBiga());
                        fragments.add(new PlaceSpecialProjectBigc());
                        break;
                }

                break;
            case "companyinfo":
                actionBar.setTitle("单位信息录入");
                fragments.add(new CompanyInfomationA());
                fragments.add(new CompanyInfomationB());
                fragments.add(new CompanyInfomationC());

                String organizationCode = extras.getString("organizationCode");

                unitsInfoEntity.setOrg_code(organizationCode);

                break;
            default:

                fragments.add(new BasicInformationFragmentA());
                fragments.add(new BasicInformationFragmentB());

                placeInfoEntity.setPlace_code(type);

//        <!--乙表01-->
                if (type.equals("1") || type.equals("2") || type.equals("3") || type.equals("4")) {
                    actionBar.setTitle("乙表01");
                    fragments.add(new PlaceSpecialProject1());
                }
//        <!--乙表02-->
                if (type.equals("5")) {
                    actionBar.setTitle("乙表02");
                    fragments.add(new PlaceSpecialProject2());
                }
//        <!--乙表03-->
                if (type.equals("6") || type.equals("7") || type.equals("8") || type.equals("9")) {
                    actionBar.setTitle("乙表03");
                    fragments.add(new PlaceSpecialProject3());
                }
//        <!--乙表04-->
                if (type.equals("11") ||
                        type.equals("12") || type.equals("13") ||
                        type.equals("14") || type.equals("15") ||
                        type.equals("17") || type.equals("18") ||
                        type.equals("19") || type.equals("20") ||
                        type.equals("21") || type.equals("22") ||
                        type.equals("24") || type.equals("16") ||
                        type.equals("25") || type.equals("26") ||
                        type.equals("27") || type.equals("28") ||
                        type.equals("29") || type.equals("30") ||
                        type.equals("31") || type.equals("32") ||
                        type.equals("34") ||
                        type.equals("35") || type.equals("36")) {
                    actionBar.setTitle("乙表04");
                    fragments.add(new PlaceSpecialProject4());
                }
                if (type.equals("23")) {
                    actionBar.setTitle("乙表04");
                    fragments.add(new PlaceSpecialProject4a());
                }
                if (type.equals("33")) {
                    actionBar.setTitle("乙表04");
                    fragments.add(new PlaceSpecialProject4b());
                }
                if (type.equals("10")) {
                    actionBar.setTitle("乙表04");
                    fragments.add(new PlaceSpecialProject4c());
                }

//        <!--乙表05-->
                if (type.equals("37") || type.equals("38") || type.equals("39") ||
                        type.equals("40") ||
                        type.equals("41") || type.equals("42") ||
                        type.equals("43") || type.equals("44") ||
                        type.equals("45") || type.equals("46") ||
                        type.equals("47") || type.equals("48") ||
                        type.equals("49") || type.equals("50") ||
                        type.equals("52") ||
                        type.equals("53") ||
                        type.equals("55") || type.equals("56") ||
                        type.equals("57") || type.equals("58") ||
                        type.equals("59") || type.equals("60")) {
                    actionBar.setTitle("乙表05");
                    fragments.add(new PlaceSpecialProject5());
                }
                if (type.equals("51") || type.equals("54")) {
                    actionBar.setTitle("乙表05");
                    fragments.add(new PlaceSpecialProject5a());
                }
//        <!--乙表06-->
                if (type.equals("61") || type.equals("62") ||
                        type.equals("63") || type.equals("64") ||
                        type.equals("64") || type.equals("65") ||
                        type.equals("66") || type.equals("67")) {
                    actionBar.setTitle("乙表06");
                    fragments.add(new PlaceSpecialProject6());
                }
//        <!--乙表07-->
                if (type.equals("68") || type.equals("69")) {
                    actionBar.setTitle("乙表07");
                    fragments.add(new PlaceSpecialProject7());
                }
//        <!--乙表08-->
                if (type.equals("71")) {
                    actionBar.setTitle("乙表08");
                    fragments.add(new PlaceSpecialProject8());
                }
                if (type.equals("70")) {
                    actionBar.setTitle("乙表08");
                    fragments.add(new PlaceSpecialProject8a());
                }
                if (type.equals("72")) {
                    actionBar.setTitle("乙表08");
                    fragments.add(new PlaceSpecialProject8b());
                }
//        <!--乙表09-->
                if (type.equals("73")) {
                    actionBar.setTitle("乙表09");
                    fragments.add(new PlaceSpecialProject9());
                }
//        <!--乙表10-->
                if (type.equals("74") || type.equals("75")) {
                    actionBar.setTitle("乙表10");
                    fragments.add(new PlaceSpecialProject10());
                }
//        <!--乙表11-->
                if (type.equals("76")) {
                    actionBar.setTitle("乙表11");
                    fragments.add(new PlaceSpecialProject11());
                }
//        <!--乙表12-->
                if (type.equals("77") || type.equals("78") ||
                        type.equals("79")) {
                    actionBar.setTitle("乙表12");
                    fragments.add(new PlaceSpecialProject12());
                }
//        <!--乙表13-->
                if (type.equals("80") || type.equals("81")) {
                    actionBar.setTitle("乙表13");
                    fragments.add(new PlaceSpecialProject13());
                }
//        <!--乙表14-->
                if (type.equals("82")) {
                    actionBar.setTitle("乙表14");
                    fragments.add(new PlaceSpecialProject14());
                }
//        <!--乙表15-->
                if (type.equals("83")) {
                    actionBar.setTitle("乙表15");
                    fragments.add(new PlaceSpecialProject15());
                }
//        <!--乙表16-->
                if (type.equals("84")) {
                    actionBar.setTitle("乙表16");
                    fragments.add(new PlaceSpecialProject16());
                }

                if (type.equals("600") || type.equals("601") || type.equals("602") || type.equals("603")) {
                    actionBar.setTitle("乙表17");
                    fragments.add(new PlaceSpecialProject17());
                }
//            if (type.equals("影剧院")) application.setTypeID(600);
//            if (type.equals("电影院")) application.setTypeID(601);
//            if (type.equals("音乐厅")) application.setTypeID(602);
//            if (type.equals("剧院")) application.setTypeID(603);
                if (type.equals("610")) {
                    actionBar.setTitle("乙表18");
                    fragments.add(new PlaceSpecialProject18());
                }
//            if (type.equals("艺术馆")) application.setTypeID(610);
                if (type.equals("620")) {
                    actionBar.setTitle("乙表19");
                    fragments.add(new PlaceSpecialProject19());
                }
//            if (type.equals("图书馆(类)")) application.setTypeID(620);
                if (type.equals("630")) {
                    actionBar.setTitle("乙表20");
                    fragments.add(new PlaceSpecialProject20());
                }
//            if (type.equals("博物馆")) application.setTypeID(630);
                if (type.equals("650")) {
                    actionBar.setTitle("乙表21");
                    fragments.add(new PlaceSpecialProject21());
                }
//            if (type.equals("文物类")) application.setTypeID(650);
                if (type.equals("640")) {
                    actionBar.setTitle("乙表22");
                    fragments.add(new PlaceSpecialProject22());
                }
//            if (type.equals("文化广场")) application.setTypeID(640);
                if (type.equals("660")) {
                    actionBar.setTitle("乙表23");
                    fragments.add(new PlaceSpecialProject23());
                }
//            if (type.equals("文体站(馆)")) application.setTypeID(660);
                if (type.equals("670")) {
                    actionBar.setTitle("乙表24");
                    fragments.add(new PlaceSpecialProject24());
                }
//            if (type.equals("文体中心")) application.setTypeID(670);
                if (type.equals("900")) {
                    actionBar.setTitle("乙表25");
                    fragments.add(new PlaceSpecialProject25());
                }
//            if (type.equals("其它类型文化场地")) application.setTypeID(900);

                break;
        }
    }

    private void init() {
        ll_main_cat = (LinearLayout) findViewById(R.id.ll_main_cat);
        ll_main_btn = (LinearLayout) findViewById(R.id.ll_main_btn);
        //根据fragment页面数量添加进度圆点,选择场地按键
        listImageView = new ArrayList<>();

        tvSelectPlace = new TextView(CompanyInfomationActivity.this);
        LinearLayout.LayoutParams layoutParams = new ActionMenuView.LayoutParams(250, 70);
        tvSelectPlace.setLayoutParams(layoutParams);
        tvSelectPlace.setText("添加场地");
        tvSelectPlace.setBackgroundResource(R.drawable.bg_btnn);
        tvSelectPlace.setTextColor(R.color.white);
        tvSelectPlace.setGravity(Gravity.CENTER);
        ll_main_btn.addView(tvSelectPlace);

        tvBigPlace = new TextView(CompanyInfomationActivity.this);
        layoutParams = new ActionMenuView.LayoutParams(250, 70);
        tvBigPlace.setLayoutParams(layoutParams);
        tvBigPlace.setText("大型场馆");
        tvBigPlace.setBackgroundResource(R.drawable.bg_btnn);
        tvBigPlace.setTextColor(R.color.white);
        tvBigPlace.setGravity(Gravity.CENTER);
        tvBigPlace.setVisibility(View.GONE);
        ll_main_btn.addView(tvBigPlace);

        tvOK = new TextView(CompanyInfomationActivity.this);
        layoutParams = new ActionMenuView.LayoutParams(250, 70);
        tvOK.setLayoutParams(layoutParams);
        tvOK.setText("完成");
        tvOK.setTextColor(R.color.white);
        tvOK.setBackgroundResource(R.drawable.bg_btnn);
        tvOK.setGravity(Gravity.CENTER);
        tvOK.setPadding(10, 0, 0, 0);
        ll_main_btn.addView(tvOK);


        for (int i = 0; i < fragments.size(); i++) {
            ImageView imageView = new ImageView(this);
            if (i == 0)
                imageView.setImageResource(R.drawable.ico_cat_click);
            else
                imageView.setImageResource(R.drawable.ico_cat);
            layoutParams = new ActionMenuView.LayoutParams(30, 30);
            imageView.setLayoutParams(layoutParams);
            ll_main_cat.addView(imageView);
            listImageView.add(imageView);
        }

        iv_main_next = (ImageView) findViewById(R.id.iv_main_next);
        iv_main_pro = (ImageView) findViewById(R.id.iv_main_pro);
        FragmentTabAdapter tabAdapter = new FragmentTabAdapter(this, fragments, R.id.tab_content, iv_main_pro, iv_main_next);

        //切换回调，改变小圆点状态
        tabAdapter.setOnRgsExtraCheckedChangedListener(new FragmentTabAdapter.OnRgsExtraCheckedChangedListener() {
            @Override
            public void OnRgsExtraCheckedChanged(int index) {
                listImageView.get(index).setImageResource(R.drawable.ico_cat_click);

                if (index == (fragments.size() - 1)) {

                    if (application.getSavestyle() == SaveStyleEnum.CHECKED)
                        ll_main_btn.setVisibility(View.GONE);
                    else
                        ll_main_btn.setVisibility(View.VISIBLE);

                    iv_main_next.setVisibility(View.GONE);
                    ll_main_cat.setVisibility(View.GONE);


                    if (application.getSavestyle() == SaveStyleEnum.UNCHECK) {
                        tvOK.setVisibility(View.VISIBLE);
                        tvSelectPlace.setVisibility(View.GONE);
                    }

                    if (application.getSavestyle() == SaveStyleEnum.CHECKPENDING) {
                        tvOK.setVisibility(View.VISIBLE);
                    }

                    if (application.getSavestyle() == SaveStyleEnum.ADD)
                        tvOK.setVisibility(View.GONE);


                    if (type.equals("1") || type.equals("5") || type.equals("6")) {
                        tvBigPlace.setVisibility(View.VISIBLE);
                    } else {
                        tvBigPlace.setVisibility(View.GONE);
                    }

//                    if (type.equals("companyinfo")) {
//                        if (application.getSavestyle() ==SaveStyleEnum.ADD)
//                            tvOK.setVisibility(View.GONE);
//
//                    } else {
//                        tvOK.setVisibility(View.VISIBLE);
//                    }
                } else {
                    ll_main_btn.setVisibility(View.GONE);
                    iv_main_next.setVisibility(View.VISIBLE);
                    ll_main_cat.setVisibility(View.VISIBLE);
                }

                if (index == 0) {
                    iv_main_pro.setVisibility(View.GONE);
                } else {
                    iv_main_pro.setVisibility(View.VISIBLE);
                }


            }
        });

        tvBigPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnCallListener.transfermsg();
                application.setBigPlaceInfoEntity(null);
                Intent intent = new Intent(CompanyInfomationActivity.this, CompanyInfomationActivity.class);
                intent.putExtra("type", "big");
                startActivity(intent);
            }
        });

        tvSelectPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnCallListener.transfermsg();
                Intent intent = new Intent(CompanyInfomationActivity.this, SiteSelectionActivity.class);
                startActivity(intent);
            }
        });

        tvOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnCallListener.transfermsg();
                Intent intent = new Intent(CompanyInfomationActivity.this, MainActionActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.menu_personage, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_personage:
                Intent intent = new Intent(CompanyInfomationActivity.this, MainActionActivity.class);
                startActivity(intent);
                break;
            case android.R.id.home:
                this.finish();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public IBtnCallListener mBtnCallListener;

    @Override
    public void onAttachFragment(Fragment fragment) {
        try {
            mBtnCallListener = (IBtnCallListener) fragment;
        } catch (Exception ignored) {
        }
        super.onAttachFragment(fragment);
    }

    @Override
    public boolean transfermsg() {
        System.out.println("由Fragment传输过来的信息");
        return true;
    }
}

