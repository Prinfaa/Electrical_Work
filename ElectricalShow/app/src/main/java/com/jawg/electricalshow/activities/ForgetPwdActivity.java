package com.jawg.electricalshow.activities;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jawg.electricalshow.R;
import com.jawg.electricalshow.common.BaseActivity;
import com.jawg.electricalshow.mInterface.Mycontants;
import com.jawg.electricalshow.utils.BaseUtils;
import com.jawg.electricalshow.utils.ToastUtil;
import com.jawg.electricalshow.view.PingFangTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgetPwdActivity extends BaseActivity {


    @BindView(R.id.btn_back)
    ImageButton btnBack;
    @BindView(R.id.tv_title)
    PingFangTextView tvTitle;
    @BindView(R.id.tv_title_input_num)
    TextView tvTitleInputNum;
    @BindView(R.id.tv_title_input_code)
    TextView tvTitleInputCode;
    @BindView(R.id.tv_title_set_pwd)
    TextView tvTitleSetPwd;
    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.et_input_num)
    EditText etInputNum;
    @BindView(R.id.et_input_code)
    EditText etInputCode;
    @BindView(R.id.et_input_pwd)
    EditText etInputPwd;
    @BindView(R.id.et_input_sure_pwd)
    EditText etInputSurePwd;
    @BindView(R.id.tv_pwd_format)
    TextView tvPwdFormat;
    @BindView(R.id.btn_forget)
    Button btnForget;

    String fwdValue = "";

    @Override
    public void initViews() {
        setContentView(R.layout.activity_forget_pwd);
        ButterKnife.bind(this);

        tvTitle.setText("忘记密码");

        fwdValue = getIntent().getStringExtra(Mycontants.FWD_EVERY_STEP_KEY);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void initData() {

        all_gone();
        if (fwdValue.equals(Mycontants.FWD_FIRST_STEP_VALUE)) {

            tvTitleInputNum.setTextColor(Color.BLUE);
            etInputNum.setVisibility(View.VISIBLE);
            btnForget.setText("获取验证码");

        }

    }

    @Override
    public void initEvents() {

    }


    @OnClick({R.id.btn_back, R.id.btn_forget})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:

                if(fwdValue.equals(Mycontants.FWD_FIRST_STEP_VALUE)){

                    finish();

                }else if(fwdValue.equals(Mycontants.FWD_SECOND_STEP_VALUE)){

                    all_gone();
                    tvTitleInputNum.setTextColor(Color.BLUE);
                    etInputNum.setVisibility(View.VISIBLE);
                    btnForget.setText("获取验证码");
                    fwdValue = Mycontants.FWD_FIRST_STEP_VALUE;

                }else if(fwdValue.equals(Mycontants.FWD_THIRD_STEP_VALUE)){

                    all_gone();
                    tvTitleInputNum.setTextColor(Color.BLUE);
                    etInputNum.setVisibility(View.VISIBLE);
                    btnForget.setText("获取验证码");
                    fwdValue = Mycontants.FWD_FIRST_STEP_VALUE;


                }

                break;
            case R.id.btn_forget:

                if (fwdValue.equals(Mycontants.FWD_FIRST_STEP_VALUE)) {

                    String phoneNum = etInputNum.getText().toString().trim();

                    if (phoneNum.equals("")) {

                        ToastUtil.showToast("电话号码不能为空", this);

                    } else if (BaseUtils.isMobiles(phoneNum)) {

                        /**
                         * 1.先网络请求短信验证码
                         * 2.成功后显示第二部内容  修改fwdvalue的值
                         */

//                        getMessageCode(phoneNum);//网络请求

                        fwdValue = Mycontants.FWD_SECOND_STEP_VALUE;
                        all_gone();
                        tvTitleInputCode.setTextColor(Color.BLUE);
                        tvMessage.setVisibility(View.VISIBLE);
                        etInputCode.setVisibility(View.VISIBLE);
                        tvMessage.setText("验证短信已发送到 " + phoneNum);
                        btnForget.setText("提交验证码");

                    }else{

                        ToastUtil.showToast("电话号码格式错误", this);

                    }

                } else if (fwdValue.equals(Mycontants.FWD_SECOND_STEP_VALUE)) {

                    String code = etInputCode.getText().toString().trim();

                    //判断验证码是否正确
                    if (true) {//验证码正确

                        all_gone();
                        tvTitleSetPwd.setTextColor(Color.BLUE);
                        etInputPwd.setVisibility(View.VISIBLE);
                        etInputSurePwd.setVisibility(View.VISIBLE);
                        tvPwdFormat.setVisibility(View.VISIBLE);
                        btnForget.setText("完成");
                        fwdValue = Mycontants.FWD_THIRD_STEP_VALUE;


                    } else {


                    }

                } else if (fwdValue.equals(Mycontants.FWD_THIRD_STEP_VALUE)) {

                    String newPwd=etInputPwd.getText().toString().trim();
                    String surePwd=etInputSurePwd.getText().toString().trim();


                    //网络请求修改密码



                } else {


                }


                break;
        }
    }


    private void all_gone() {
        etInputNum.setVisibility(View.GONE);
        etInputCode.setVisibility(View.GONE);
        etInputPwd.setVisibility(View.GONE);
        etInputSurePwd.setVisibility(View.GONE);
        tvMessage.setVisibility(View.GONE);
        tvPwdFormat.setVisibility(View.GONE);
        tvTitleInputNum.setTextColor(Color.parseColor("#101010"));
        tvTitleInputCode.setTextColor(Color.parseColor("#101010"));
        tvTitleSetPwd.setTextColor(Color.parseColor("#101010"));
    }


    private void getMessageCode(String phoneNum) {


    }


}
