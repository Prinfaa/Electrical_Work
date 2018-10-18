package com.jawg.electricalshow.activities;

import android.view.View;
import android.widget.ImageButton;

import com.jawg.electricalshow.R;
import com.jawg.electricalshow.common.BaseActivity;
import com.jawg.electricalshow.view.PingFangTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutActivity extends BaseActivity {


    @BindView(R.id.btn_back)
    ImageButton btnBack;
    @BindView(R.id.tv_title)
    PingFangTextView tvTitle;

    @Override
    public void initViews() {
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);

        tvTitle.setText("关于我们");

    }

    @Override
    public void initData() {



    }

    @Override
    public void initEvents() {

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });


    }


}
