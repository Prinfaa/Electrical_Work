package com.jawg.electricalshow.activities;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jawg.electricalshow.R;
import com.jawg.electricalshow.common.BaseActivity;
import com.jawg.electricalshow.mInterface.Mycontants;
import com.jawg.electricalshow.view.PingFangTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangePwdActivity extends BaseActivity {


    @BindView(R.id.btn_back)
    ImageButton btnBack;
    @BindView(R.id.tv_title)
    PingFangTextView tvTitle;
    @BindView(R.id.btn_history)
    Button btnHistory;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.et_old_pwd)
    EditText etOldPwd;
    @BindView(R.id.et_new_pwd)
    EditText etNewPwd;
    @BindView(R.id.et_sure_pwd)
    EditText etSurePwd;
    @BindView(R.id.btn_forget_pwd)
    Button btnForgetPwd;

    @Override
    public void initViews() {
        setContentView(R.layout.activity_change_pwd);
        ButterKnife.bind(this);
        btnHistory.setVisibility(View.VISIBLE);
        btnHistory.setText("保存");
        tvTitle.setText("修改密码");
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvents() {

    }


    @OnClick({R.id.btn_back, R.id.btn_history, R.id.btn_forget_pwd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:

                finish();

                break;
            case R.id.btn_history:


                break;
            case R.id.btn_forget_pwd:

                intentMethod.startMethodWithString(this,ForgetPwdActivity.class, Mycontants.FWD_EVERY_STEP_KEY,Mycontants.FWD_FIRST_STEP_VALUE);
                break;
        }
    }
}
