package com.jawg.electricalshow.activities;

import android.widget.ImageButton;

import com.jawg.electricalshow.R;
import com.jawg.electricalshow.common.BaseActivity;
import com.jawg.electricalshow.view.PingFangTextView;
import com.jawg.electricalshow.view.XListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressListActivity extends BaseActivity {


    @BindView(R.id.btn_back)
    ImageButton btnBack;
    @BindView(R.id.tv_title)
    PingFangTextView tvTitle;
    @BindView(R.id.lv_address_list)
    XListView lvAddressList;

    @Override
    public void initViews() {
        setContentView(R.layout.activity_check_address_list);
        ButterKnife.bind(this);
        tvTitle.setText("监测位置");

    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvents() {

    }


    @OnClick(R.id.btn_back)
    public void onViewClicked() {

        finish();

    }
}
