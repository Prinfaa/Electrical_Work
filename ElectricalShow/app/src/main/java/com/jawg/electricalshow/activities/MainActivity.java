package com.jawg.electricalshow.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.jawg.electricalshow.R;
import com.jawg.electricalshow.common.BaseActivity;
import com.jawg.electricalshow.common.BaseFragment2;
import com.jawg.electricalshow.fragments.HomeFragment;
import com.jawg.electricalshow.fragments.MessageFragment;
import com.jawg.electricalshow.fragments.StatisticsFragment;
import com.jawg.electricalshow.utils.MyApplication;
import com.jawg.electricalshow.utils.StatusColorSetting;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.frameLayout)
    FrameLayout frameLayout;
    @BindView(R.id.rb_home)
    RadioButton rbHome;
    @BindView(R.id.rb_message)
    RadioButton rbMessage;
    @BindView(R.id.rb_statistic)
    RadioButton rbStatistic;
    @BindView(R.id.rg_main)
    RadioGroup rgMain;
    //装fragment的实例集合
    private ArrayList<BaseFragment2> fragments;

    private int position = 0;

    //缓存Fragment或上次显示的Fragment
    private Fragment tempFragment;

    private long firstTime = 0;

    @Override
    public void initViews() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MyApplication.getInstance().addActivity(this);
        StatusColorSetting.getInstance().setStatusBar(this, true, false);
    }

    @Override
    public void initData() {

        initFragment();
    }

    @Override
    public void initEvents() {
        rgMain.check(R.id.rb_home);
        switchFragment(tempFragment, getFragment(position));
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_home: //首页
                        position = 0;
                        break;
                    case R.id.rb_message: //消息
                        position = 1;
                        break;
                    case R.id.rb_statistic: //统计
                        position = 2;
                        break;

                }
                //根据位置得到相应的Fragment
                BaseFragment2 baseFragment = getFragment(position);
                /**
                 * 第一个参数: 上次显示的Fragment
                 * 第二个参数: 当前正要显示的Fragment
                 */
                switchFragment(tempFragment,baseFragment);
            }
        });


    }

    /**
     * 添加的时候按照顺序
     */
    private void initFragment(){
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new MessageFragment());
        fragments.add(new StatisticsFragment());
    }

    /**
     * 根据位置得到对应的 Fragment
     * @param position
     * @return
     */
    private BaseFragment2 getFragment(int position){
        if(fragments != null && fragments.size()>0){
            BaseFragment2 baseFragment = fragments.get(position);
            return baseFragment;
        }
        return null;
    }

    /**
     * 切换Fragment
     * @param fragment
     * @param nextFragment
     */
    private void switchFragment(Fragment fragment,BaseFragment2 nextFragment){
        if (tempFragment != nextFragment){
            tempFragment = nextFragment;
            if (nextFragment != null){
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //判断nextFragment是否添加成功
                if (!nextFragment.isAdded()){
                    //隐藏当前的Fragment
                    if (fragment != null){
                        transaction.hide(fragment);
                    }
                    //添加Fragment
                    transaction.add(R.id.frameLayout,nextFragment).commit();
                }else {
                    //隐藏当前Fragment
                    if (fragment != null){
                        transaction.hide(fragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }
//    private void getdata(String fac) {
//
//        RequestParams params = new RequestParams();
//        params.addBodyParameter("fac", "" + fac);
//
//        HttpTool.getInstance(this).httpWithParams(Url.GET_DEVICE_LIST, params, new SMObjectCallBack<DeviceInfo>() {
//
//            @Override
//            public void onSuccess(DeviceInfo deviceInfo) {
//
//                if (deviceInfo.getResult() != null && deviceInfo.getResult().size() > 0) {
//
//
//                }
//
//            }
//
//            @Override
//            public void onError(int error, String msg) {
//
//            }
//        });
//
//
//    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = secondTime;
                return true;
            } else {
                MyApplication.getInstance().exit();
            }
        }
        return super.onKeyUp(keyCode, event);
    }



}
