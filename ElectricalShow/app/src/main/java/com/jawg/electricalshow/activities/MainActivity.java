package com.jawg.electricalshow.activities;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jawg.electricalshow.R;
import com.jawg.electricalshow.common.BaseActivity;
import com.jawg.electricalshow.common.BaseFragment2;
import com.jawg.electricalshow.fragments.HomeFragment;
import com.jawg.electricalshow.fragments.MessageFragment;
import com.jawg.electricalshow.fragments.StatisticsFragment;
import com.jawg.electricalshow.mInterface.IGetMessageCallBack;
import com.jawg.electricalshow.services.MQTTService;
import com.jawg.electricalshow.utils.MyApplication;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity  implements IGetMessageCallBack {

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
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.btn_change_data)
    Button btnChangeData;
    @BindView(R.id.btn_change_pwd)
    Button btnChangePwd;
    @BindView(R.id.btn_change_username)
    Button btnChangeUsername;
    @BindView(R.id.btn_exit)
    Button btnExit;
    @BindView(R.id.btn_about)
    Button btnAbout;
    @BindView(R.id.ll_menu)
    LinearLayout llMenu;
    @BindView(R.id.id_drawerlayout)
    DrawerLayout idDrawerlayout;
    //装fragment的实例集合
    private ArrayList<BaseFragment2> fragments;

    private int position = 0;

    //缓存Fragment或上次显示的Fragment
    private Fragment tempFragment;

    private long firstTime = 0;


    private MyServiceConnection serviceConnection;
    private MQTTService mqttService;
    @Override
    public void initViews() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MyApplication.getInstance().addActivity(this);

        serviceConnection = new MyServiceConnection();
        serviceConnection.setIGetMessageCallBack(MainActivity.this);

        Intent intent = new Intent(this, MQTTService.class);

        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);

    }

    @Override
    public void initData() {

        initFragment();

        idDrawerlayout.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        });
    }

    @Override
    public void initEvents() {
        rgMain.check(R.id.rb_home);
        switchFragment(tempFragment, getFragment(position));
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
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
                switchFragment(tempFragment, baseFragment);
            }
        });


    }

    /**
     * 添加的时候按照顺序
     */
    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new MessageFragment());
        fragments.add(new StatisticsFragment());
    }


    /**
     * 根据位置得到对应的 Fragment
     *
     * @param position
     * @return
     */
    private BaseFragment2 getFragment(int position) {
        if (fragments != null && fragments.size() > 0) {
            BaseFragment2 baseFragment = fragments.get(position);
            return baseFragment;
        }
        return null;
    }

    /**
     * 切换Fragment
     *
     * @param fragment
     * @param nextFragment
     */
    private void switchFragment(Fragment fragment, BaseFragment2 nextFragment) {
        if (tempFragment != nextFragment) {
            tempFragment = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //判断nextFragment是否添加成功
                if (!nextFragment.isAdded()) {
                    //隐藏当前的Fragment
                    if (fragment != null) {
                        transaction.hide(fragment);
                    }
                    //添加Fragment
                    transaction.add(R.id.frameLayout, nextFragment).commit();
                } else {
                    //隐藏当前Fragment
                    if (fragment != null) {
                        transaction.hide(fragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }

    @Override
    public void setMessage(String message) {
//        textView.setText(message);
        mqttService = serviceConnection.getMqttService();
        mqttService.toCreateNotification(message);
    }

    @Override
    protected void onDestroy() {
        unbindService(serviceConnection);
        super.onDestroy();
    }


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



    @OnClick({R.id.btn_change_data, R.id.btn_change_pwd, R.id.btn_change_username, R.id.btn_exit, R.id.btn_about})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_change_data:

                intentMethod.startMethodTwo(this,ChangePersonDataActivity.class);

                idDrawerlayout.closeDrawers();
                break;
            case R.id.btn_change_pwd:

                intentMethod.startMethodTwo(this,ChangePwdActivity.class);

                idDrawerlayout.closeDrawers();
                break;
            case R.id.btn_change_username:



                idDrawerlayout.closeDrawers();
                break;
            case R.id.btn_exit:



                idDrawerlayout.closeDrawers();
                break;
            case R.id.btn_about:

                intentMethod.startMethodTwo(this,AboutActivity.class);
                idDrawerlayout.closeDrawers();
                break;
        }
    }


    public class MyServiceConnection implements ServiceConnection {

        private MQTTService mqttService;
        private IGetMessageCallBack IGetMessageCallBack;

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mqttService = ((MQTTService.CustomBinder)iBinder).getService();
            mqttService.setIGetMessageCallBack(IGetMessageCallBack);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }

        public MQTTService getMqttService(){
            return mqttService;
        }

        public void setIGetMessageCallBack(IGetMessageCallBack IGetMessageCallBack){
            this.IGetMessageCallBack = IGetMessageCallBack;
        }
    }

}
