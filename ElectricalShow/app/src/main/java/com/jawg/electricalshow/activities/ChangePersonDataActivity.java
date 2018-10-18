package com.jawg.electricalshow.activities;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jawg.electricalshow.R;
import com.jawg.electricalshow.common.BaseActivity;
import com.jawg.electricalshow.view.PingFangTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangePersonDataActivity extends BaseActivity {


    @BindView(R.id.btn_back)
    ImageButton btnBack;
    @BindView(R.id.tv_title)
    PingFangTextView tvTitle;
    @BindView(R.id.iv_photo_image)
    ImageView ivPhotoImage;
    @BindView(R.id.rl_user_photo)
    RelativeLayout rlUserPhoto;
    @BindView(R.id.btn_history)
    Button btnHistory;
    @BindView(R.id.et_nick_name)
    EditText etNickName;
    @BindView(R.id.et_user_num)
    EditText etUserNum;

    @Override
    public void initViews() {
        setContentView(R.layout.activity_change_person_data);
        ButterKnife.bind(this);

        btnHistory.setVisibility(View.VISIBLE);
        tvTitle.setText("修改资料");
        btnHistory.setText("保存");


    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvents() {

    }


    @OnClick({R.id.btn_back, R.id.rl_user_photo, R.id.btn_history})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.rl_user_photo:

                intentMethod.startMethodTwo(this, ChangePhotoActivity.class);

                break;

            case R.id.btn_history:


                break;
        }
    }



}
