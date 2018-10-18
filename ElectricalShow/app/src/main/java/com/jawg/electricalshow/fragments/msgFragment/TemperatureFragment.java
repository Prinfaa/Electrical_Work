package com.jawg.electricalshow.fragments.msgFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jawg.electricalshow.R;
import com.jawg.electricalshow.common.BaseFragment2;

public class TemperatureFragment extends BaseFragment2 {
    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_msg_tamperature, container, false);

        return view;
    }

    @Override
    public void initData() {

    }
}
