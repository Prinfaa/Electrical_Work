package com.jawg.electricalshow.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jawg.electricalshow.R;
import com.jawg.electricalshow.common.BaseFragment2;
import com.jawg.electricalshow.view.PingFangTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MessageFragment extends BaseFragment2 {
    @BindView(R.id.top_name)
    PingFangTextView topName;
    @BindView(R.id.back_btn)
    LinearLayout backBtn;
    Unbinder unbinder;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        unbinder = ButterKnife.bind(this, view);

        topName.setText("消息");



        return view;
    }

    @Override
    public void initData() {

    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.back_btn)
    public void onViewClicked() {
    }
}
