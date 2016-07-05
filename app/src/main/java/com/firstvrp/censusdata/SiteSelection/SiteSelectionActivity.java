package com.firstvrp.censusdata.SiteSelection;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.firstvrp.censusdata.CensusTaker.Main.CompanyInformation.CompanyInfomationActivity;
import com.firstvrp.censusdata.CensusTaker.Main.MainActionActivity;
import com.firstvrp.censusdata.R;
import com.firstvrp.censusdata.SiteSelection.SideBar.OnTouchingLetterChangedListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.firstvrp.censusdata.MyApplication;

public class SiteSelectionActivity extends SherlockActivity implements SectionIndexer {
    private ListView sortListView;
    private SideBar sideBar;
    private TextView dialog;
    private SortGroupMemberAdapter adapter;
    private ClearEditText mClearEditText;

    private LinearLayout titleLayout;
    private TextView title;
    private TextView tvNofriends;
    /**
     */
    private int lastFirstVisibleItem = -1;
    /**
     */
    private CharacterParser characterParser;
    private List<GroupMemberBean> SourceDateList;

    /**
     */
    private PinyinComparator pinyinComparator;

    MyApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_selection);

        application = (MyApplication) getApplication();
        initViews();

        init();
    }

    private void initViews() {
        titleLayout = (LinearLayout) findViewById(R.id.title_layout);
        title = (TextView) this.findViewById(R.id.title_layout_catalog);
        tvNofriends = (TextView) this
                .findViewById(R.id.title_layout_no_friends);
        characterParser = CharacterParser.getInstance();

        pinyinComparator = new PinyinComparator();

        sideBar = (SideBar) findViewById(R.id.sidrbar);
        dialog = (TextView) findViewById(R.id.dialog);
        sideBar.setTextView(dialog);

        sideBar.setOnTouchingLetterChangedListener(new OnTouchingLetterChangedListener() {

            @Override
            public void onTouchingLetterChanged(String s) {
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    sortListView.setSelection(position);
                }

            }
        });

        sortListView = (ListView) findViewById(R.id.country_lvcountry);
        sortListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String type = ((GroupMemberBean) adapter.getItem(position)).getName();

                if (type.equals("体育场")) application.setTypeID(1);
                if (type.equals("田径场")) application.setTypeID(2);
                if (type.equals("田径房(馆)")) application.setTypeID(3);
                if (type.equals("小运动场")) application.setTypeID(4);

                if (type.equals("体育馆")) application.setTypeID(5);

                if (type.equals("游泳馆")) application.setTypeID(6);
                if (type.equals("跳水馆")) application.setTypeID(7);
                if (type.equals("游泳池(室外)")) application.setTypeID(8);
                if (type.equals("跳水池(室外)")) application.setTypeID(9);

                if (type.equals("篮球房(馆)")) application.setTypeID(11);
                if (type.equals("排球房(馆)")) application.setTypeID(12);
                if (type.equals("手球房(馆)")) application.setTypeID(13);
                if (type.equals("体操房(馆)")) application.setTypeID(14);
                if (type.equals("羽毛球房(馆)")) application.setTypeID(15);
                if (type.equals("乒乓球房(馆)")) application.setTypeID(16);
                if (type.equals("武术房(馆)")) application.setTypeID(17);
                if (type.equals("摔跤柔道拳击跆拳道空手道房(馆)")) application.setTypeID(18);
                if (type.equals("举重房(馆)")) application.setTypeID(19);
                if (type.equals("击剑房(馆)")) application.setTypeID(20);
                if (type.equals("健身房(馆)")) application.setTypeID(21);
                if (type.equals("棋牌房(室)")) application.setTypeID(22);
                if (type.equals("保龄球房(馆)")) application.setTypeID(23);
                if (type.equals("台球房(馆)")) application.setTypeID(24);
                if (type.equals("沙狐球房(馆)")) application.setTypeID(25);
                if (type.equals("五人制足球场(室内)")) application.setTypeID(26);
                if (type.equals("网球房(馆)")) application.setTypeID(27);
                if (type.equals("曲棍球场(室内)")) application.setTypeID(28);
                if (type.equals("射箭场(室内)")) application.setTypeID(29);
                if (type.equals("马术场(室内)")) application.setTypeID(30);
                if (type.equals("冰球场(含短道速滑和速度滑冰)(室内)")) application.setTypeID(31);
                if (type.equals("速滑场(室内)")) application.setTypeID(32);
                if (type.equals("冰壶球场(室内)")) application.setTypeID(33);
                if (type.equals("轮滑场(室内)")) application.setTypeID(34);
                if (type.equals("壁球房(馆)")) application.setTypeID(35);
                if (type.equals("门球房(馆)")) application.setTypeID(36);
                if (type.equals("综合房(馆)")) application.setTypeID(10);

                if (type.equals("足球场")) application.setTypeID(37);
                if (type.equals("足球场(室外五人制)")) application.setTypeID(38);
                if (type.equals("足球场(室外七人制)")) application.setTypeID(39);
                if (type.equals("篮球场")) application.setTypeID(40);
                if (type.equals("篮球场(三人制)")) application.setTypeID(41);
                if (type.equals("排球场")) application.setTypeID(42);
                if (type.equals("排球场沙滩")) application.setTypeID(43);
                if (type.equals("手球场(室外)")) application.setTypeID(44);
                if (type.equals("手球场沙滩")) application.setTypeID(45);
                if (type.equals("橄榄球场")) application.setTypeID(46);
                if (type.equals("网球场(室外)")) application.setTypeID(47);
                if (type.equals("曲棍球场(室外)")) application.setTypeID(48);
                if (type.equals("羽毛球场")) application.setTypeID(49);
                if (type.equals("乒乓球场")) application.setTypeID(50);
                if (type.equals("棒垒球场")) application.setTypeID(51);
                if (type.equals("射箭场(室外)")) application.setTypeID(52);
                if (type.equals("轮滑场(室外)")) application.setTypeID(53);
                if (type.equals("木球场")) application.setTypeID(55);
                if (type.equals("地掷球场")) application.setTypeID(56);
                if (type.equals("门球场(室外)")) application.setTypeID(57);
                if (type.equals("冰球场(含短道速滑和速度滑冰)(室外、人工)")) application.setTypeID(58);
                if (type.equals("速滑场(人工)")) application.setTypeID(59);
                if (type.equals("冰壶场(室外、人工)")) application.setTypeID(60);
                if (type.equals("板球场")) application.setTypeID(54);

                if (type.equals("摩托车赛车场")) application.setTypeID(61);
                if (type.equals("汽车赛车场")) application.setTypeID(62);
                if (type.equals("卡丁车赛车场")) application.setTypeID(63);
                if (type.equals("自行车赛车场")) application.setTypeID(64);
                if (type.equals("自行车赛车馆")) application.setTypeID(65);
                if (type.equals("小轮车赛车场")) application.setTypeID(66);
                if (type.equals("马术场(室外)")) application.setTypeID(67);

                if (type.equals("射击房(馆)")) application.setTypeID(68);
                if (type.equals("射击场(室外)")) application.setTypeID(69);

                if (type.equals("水上运动场")) application.setTypeID(70);
                if (type.equals("海上运动场")) application.setTypeID(71);
                if (type.equals("天然游泳场")) application.setTypeID(72);

                if (type.equals("航空运动机场")) application.setTypeID(73);

                if (type.equals("滑雪场(室内)")) application.setTypeID(74);
                if (type.equals("滑雪场(室外，人工)")) application.setTypeID(75);

                if (type.equals("高尔夫球场")) application.setTypeID(76);

                if (type.equals("攀岩场(室外，人工)")) application.setTypeID(77);
                if (type.equals("攀岩馆")) application.setTypeID(78);
                if (type.equals("攀冰馆")) application.setTypeID(79);

                if (type.equals("登山步道")) application.setTypeID(80);
                if (type.equals("城市健身步道")) application.setTypeID(81);

                if (type.equals("全民健身路径")) application.setTypeID(82);

                if (type.equals("户外活动营地")) application.setTypeID(83);

                if (type.equals("其他类体育场地")) application.setTypeID(84);

                if (type.equals("影剧院")) application.setTypeID(600);
                if (type.equals("电影院")) application.setTypeID(601);
                if (type.equals("音乐厅")) application.setTypeID(602);
                if (type.equals("剧院")) application.setTypeID(603);
                if (type.equals("艺术馆")) application.setTypeID(610);
                if (type.equals("图书馆(类)")) application.setTypeID(620);
                if (type.equals("博物馆")) application.setTypeID(630);
                if (type.equals("文物类")) application.setTypeID(650);
                if (type.equals("文化广场")) application.setTypeID(640);
                if (type.equals("文体站(馆)")) application.setTypeID(660);
                if (type.equals("文体中心")) application.setTypeID(670);
                if (type.equals("其它类型文化场地")) application.setTypeID(900);


//                Toast.makeText(
//                        getApplication(), position + "---" +
//                                type + "---" + application.getTypeID(),
//                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(SiteSelectionActivity.this, CompanyInfomationActivity.class);
                intent.putExtra("type", String.valueOf(application.getTypeID()));

                application.setPlaceInfoEntity(null);

                startActivity(intent);
            }
        });

        SourceDateList = filledData(getResources().getStringArray(R.array.date));

        Collections.sort(SourceDateList, pinyinComparator);
        adapter = new SortGroupMemberAdapter(this, SourceDateList);
        sortListView.setAdapter(adapter);
        sortListView.setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                int section = getSectionForPosition(firstVisibleItem);
                int nextSection = getSectionForPosition(firstVisibleItem + 1);
                int nextSecPosition = getPositionForSection(+nextSection);
                if (firstVisibleItem != lastFirstVisibleItem) {
                    MarginLayoutParams params = (MarginLayoutParams) titleLayout
                            .getLayoutParams();
                    params.topMargin = 0;
                    titleLayout.setLayoutParams(params);
                    title.setText(SourceDateList.get(
                            getPositionForSection(section)).getSortLetters());
                }
                if (nextSecPosition == firstVisibleItem + 1) {
                    View childView = view.getChildAt(0);
                    if (childView != null) {
                        int titleHeight = titleLayout.getHeight();
                        int bottom = childView.getBottom();
                        MarginLayoutParams params = (MarginLayoutParams) titleLayout
                                .getLayoutParams();
                        if (bottom < titleHeight) {
                            float pushedDistance = bottom - titleHeight;
                            params.topMargin = (int) pushedDistance;
                            titleLayout.setLayoutParams(params);
                        } else {
                            if (params.topMargin != 0) {
                                params.topMargin = 0;
                                titleLayout.setLayoutParams(params);
                            }
                        }
                    }
                }
                lastFirstVisibleItem = firstVisibleItem;
            }
        });
        mClearEditText = (ClearEditText) findViewById(R.id.filter_edit);

        mClearEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                titleLayout.setVisibility(View.GONE);
                filterData(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    /**
     * ListView
     *
     * @param date
     * @return
     */
    private List<GroupMemberBean> filledData(String[] date) {
        List<GroupMemberBean> mSortList = new ArrayList<GroupMemberBean>();

        for (int i = 0; i < date.length; i++) {
            GroupMemberBean sortModel = new GroupMemberBean();
            sortModel.setName(date[i]);
            String pinyin = characterParser.getSelling(date[i]);
            String sortString = pinyin.substring(0, 1).toUpperCase();

            if (sortString.matches("[A-Z]")) {
                sortModel.setSortLetters(sortString.toUpperCase());
            } else {
                sortModel.setSortLetters("#");
            }

            mSortList.add(sortModel);
        }
        return mSortList;

    }

    /**
     * ListView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
        List<GroupMemberBean> filterDateList = new ArrayList<GroupMemberBean>();

        if (TextUtils.isEmpty(filterStr)) {
            filterDateList = SourceDateList;
            tvNofriends.setVisibility(View.GONE);
        } else {
            filterDateList.clear();
            for (GroupMemberBean sortModel : SourceDateList) {
                String name = sortModel.getName();
                if (name.indexOf(filterStr.toString()) != -1
                        || characterParser.getSelling(name).startsWith(
                        filterStr.toString())) {
                    filterDateList.add(sortModel);
                }
            }
        }

        Collections.sort(filterDateList, pinyinComparator);
        adapter.updateListView(filterDateList);
        if (filterDateList.size() == 0) {
            tvNofriends.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public Object[] getSections() {
        return null;
    }

    /**
     */
    public int getSectionForPosition(int position) {
        return SourceDateList.get(position).getSortLetters().charAt(0);
    }

    /**
     */
    public int getPositionForSection(int section) {
        for (int i = 0; i < SourceDateList.size(); i++) {
            String sortStr = SourceDateList.get(i).getSortLetters();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }
        return -1;
    }

    private void init() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayUseLogoEnabled(true);
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
                Intent intent = new Intent(SiteSelectionActivity.this, MainActionActivity.class);
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
}
