package com.jawg.electricalshow.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

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

    @OnClick({R.id.back_btn, R.id.btn_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_btn:

                break;
            case R.id.btn_search:

                break;
        }
    }
}
