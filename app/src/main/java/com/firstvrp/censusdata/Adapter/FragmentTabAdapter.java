package com.firstvrp.censusdata.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;

import com.firstvrp.censusdata.CompanyInformation.CompanyInfomationActivity;
import com.firstvrp.censusdata.R;

import java.util.List;

/**
 * FragmentTab切换
 */
public class FragmentTabAdapter implements View.OnClickListener {
    private List<Fragment> fragments; // 一个tab页面对应一个Fragment
    private FragmentActivity fragmentActivity; // Fragment所属的Activity
    private int fragmentContentId; // Activity中所要被替换的区域的id
    public ImageView iv_main_next, iv_main_pro;
    private int currentTab; // 当前Tab页面索引

    public OnRgsExtraCheckedChangedListener onRgsExtraCheckedChangedListener; // 用于让调用者在切换tab时候增加新的功能

    public FragmentTabAdapter(FragmentActivity fragmentActivity, List<Fragment> fragments, int fragmentContentId, ImageView iv_main_next, ImageView iv_main_pro) {
        this.fragments = fragments;
        this.fragmentActivity = fragmentActivity;
        this.fragmentContentId = fragmentContentId;

        this.iv_main_next = iv_main_next;
        this.iv_main_pro = iv_main_pro;

        // 默认显示第一页
        FragmentTransaction ft = fragmentActivity.getSupportFragmentManager().beginTransaction();
        ft.add(fragmentContentId, fragments.get(0));
        ft.commit();

        iv_main_next.setOnClickListener(this);
        iv_main_pro.setOnClickListener(this);
    }


    public void onCheckedChanged(int index) {

        // 如果设置了切换tab额外功能功能接口
        if (null != onRgsExtraCheckedChangedListener) {
            onRgsExtraCheckedChangedListener.OnRgsExtraCheckedChanged(
                    index);
        }

        Fragment fragment = fragments.get(index);
        FragmentTransaction ft = obtainFragmentTransaction();

        getCurrentFragment().onPause(); // 暂停当前tab
        // getCurrentFragment().onStop(); // 暂停当前tab
        if (fragment.isAdded()) {
            // fragment.onStart(); // 启动目标tab的onStart()
            fragment.onResume(); // 启动目标tab的onResume()
        } else {
            ft.add(fragmentContentId, fragment);

        }
        showTab(index); // 显示目标tab
        ft.commit();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_main_next:

                if (CompanyInfomationActivity.INSTENT.mBtnCallListener.transfermsg()) {
                    if (getCurrentTab() + 1 <= fragments.size() - 1) {
                        onCheckedChanged(getCurrentTab() + 1);
                    }
                }
                break;
            case R.id.iv_main_pro:
                if (CompanyInfomationActivity.INSTENT.mBtnCallListener.transfermsg()) {
                    if (getCurrentTab() - 1 >= 0) {
                        onCheckedChanged(getCurrentTab() - 1);
                    }
                }
                break;
        }
    }

    /**
     * 切换tab
     *
     * @param idx 切换id
     */
    public void showTab(int idx) {
        for (int i = 0; i < fragments.size(); i++) {
            Fragment fragment = fragments.get(i);
            FragmentTransaction ft = obtainFragmentTransaction();
            if (idx == i) {
                ft.show(fragment);
            } else {
                ft.hide(fragment);
            }
            ft.commit();
        }
        currentTab = idx; // 更新目标tab为当前tab
    }


    /**
     * 获取一个带动画的FragmentTransaction
     *
     * @return 动画界面
     */
    private FragmentTransaction obtainFragmentTransaction() {
        // 设置切换动画
//        if(index > currentTab){
//            ft.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_left_out);
//        }else{
//            ft.setCustomAnimations(R.anim.slide_right_in, R.anim.slide_right_out);
//        }
        return fragmentActivity.getSupportFragmentManager().beginTransaction();
    }

    public int getCurrentTab() {
        return currentTab;
    }

    public Fragment getCurrentFragment() {
        return fragments.get(currentTab);
    }

    public void setOnRgsExtraCheckedChangedListener(OnRgsExtraCheckedChangedListener onRgsExtraCheckedChangedListener) {
        this.onRgsExtraCheckedChangedListener = onRgsExtraCheckedChangedListener;
    }


    /**
     * 切换tab额外功能功能接口
     */
    public static class OnRgsExtraCheckedChangedListener {
        public void OnRgsExtraCheckedChanged(int index) {

        }
    }

}
