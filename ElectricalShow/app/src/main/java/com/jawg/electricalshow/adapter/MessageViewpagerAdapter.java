package com.jawg.electricalshow.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jawg.electricalshow.fragments.msgFragment.ElectricalFragment;
import com.jawg.electricalshow.fragments.msgFragment.SurplusFragment;
import com.jawg.electricalshow.fragments.msgFragment.TemperatureFragment;

public class MessageViewpagerAdapter extends FragmentPagerAdapter {

    private String[] fragmentName=new String[]{"负荷电流", "设备温度","剩余电流"};

    public MessageViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new TemperatureFragment();
        } else if (position == 2) {
            return new SurplusFragment();
        }
        return new ElectricalFragment();

    }

    @Override
    public int getCount() {
        return fragmentName.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentName[position];
    }

}
