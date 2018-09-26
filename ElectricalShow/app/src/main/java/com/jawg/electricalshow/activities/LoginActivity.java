package com.jawg.electricalshow.activities;


import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.jawg.electricalshow.Entries.MituType;
import com.jawg.electricalshow.R;
import com.jawg.electricalshow.common.BaseActivity;
import com.jawg.electricalshow.utils.Url;
import com.jawg.electricalshow.utils.http.HttpTool;
import com.jawg.electricalshow.utils.http.SMObjectCallBack;
import com.lidroid.xutils.http.RequestParams;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.ed_phone_num)
    EditText edPhoneNum;
    @BindView(R.id.ed_phone_pwd)
    EditText edPhonePwd;
    @BindView(R.id.btn_login)
    Button btnLogin;

    private static final int REQUEST_CODE = 0; // 请求码

    // 所需的全部权限
    static final String[] PERMISSIONS = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.ACCESS_WIFI_STATE,
            Manifest.permission.CHANGE_WIFI_STATE,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.WAKE_LOCK,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private PermissionsChecker mPermissionsChecker; // 权限检测器


    @Override
    public void initViews() {

        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mPermissionsChecker = new PermissionsChecker(this);


    }


    @Override
    protected void onResume() {
        super.onResume();

        // 缺少权限时, 进入权限配置页面
        if (mPermissionsChecker.lacksPermissions(PERMISSIONS)) {
            startPermissionsActivity();
        }

    }

    @Override
    public void initData() {



    }

    @Override
    public void initEvents() {

    }


    @OnClick({R.id.ll_back, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                break;

            case R.id.btn_login:

                intentMethod.startMethodOne(this, MainActivity.class);

                break;
        }
    }


    private void startPermissionsActivity() {
        PermissionsActivity.startActivityForResult(this, REQUEST_CODE, PERMISSIONS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 拒绝时, 关闭页面, 缺少主要权限, 无法运行
        if (requestCode == REQUEST_CODE && resultCode == PermissionsActivity.PERMISSIONS_DENIED) {
            finish();
        }
    }





}
