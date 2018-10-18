package com.jawg.electricalshow.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.jawg.electricalshow.R;
import com.jawg.electricalshow.common.BaseFragment2;
import com.jawg.electricalshow.view.PingFangTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class StatisticsFragment extends BaseFragment2 {
    @BindView(R.id.top_name)
    PingFangTextView topName;
    @BindView(R.id.back_btn)
    LinearLayout backBtn;
    @BindView(R.id.btn_search)
    ImageButton btnSearch;
    Unbinder unbinder;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.ll_date)
    LinearLayout llDate;
    @BindView(R.id.piechat)
    PieChart piechat;
    @BindView(R.id.ll_statistic_electrical)
    LinearLayout llStatisticElectrical;
    @BindView(R.id.ll_statistic_temperature)
    LinearLayout llStatisticTemperature;
    @BindView(R.id.ll_statistic_surplus)
    LinearLayout llStatisticSurplus;
    Unbinder unbinder1;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {

        View view = inflater.inflate(R.layout.fragment_statistics, container, false);
        unbinder = ButterKnife.bind(this, view);
        btnSearch.setVisibility(View.VISIBLE);
        topName.setText("统计");


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



    @OnClick({R.id.back_btn, R.id.btn_search, R.id.ll_date, R.id.ll_statistic_electrical, R.id.ll_statistic_temperature, R.id.ll_statistic_surplus})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_btn:
                break;
            case R.id.btn_search:
                break;
            case R.id.ll_date:
                break;
            case R.id.ll_statistic_electrical:
                break;
            case R.id.ll_statistic_temperature:
                break;
            case R.id.ll_statistic_surplus:
                break;
        }
    }
}
