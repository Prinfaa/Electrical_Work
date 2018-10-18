package com.jawg.electricalshow.fragments.msgFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jawg.electricalshow.R;
import com.jawg.electricalshow.common.BaseFragment2;

import butterknife.ButterKnife;

public class ElectricalFragment extends BaseFragment2 {



    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_msg_electrical, container, false);

        return view;
    }

    @Override
    public void initData() {

    }
}
