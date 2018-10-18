package com.jawg.electricalshow.activities;


import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jawg.electricalshow.Entries.LoginData;
import com.jawg.electricalshow.R;
import com.jawg.electricalshow.common.BaseActivity;
import com.jawg.electricalshow.mInterface.Mycontants;
import com.jawg.electricalshow.mInterface.Url;
import com.jawg.electricalshow.utils.BaseUtils;
import com.jawg.electricalshow.utils.Sptools;
import com.jawg.electricalshow.utils.ToastUtil;
import com.jawg.electricalshow.utils.http.HttpTool;
import com.jawg.electricalshow.utils.http.SMObjectCallBack;
import com.lidroid.xutils.http.RequestParams;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


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
    @BindView(R.id.ed_phone_num)
    EditText edPhoneNum;
    @BindView(R.id.ed_phone_pwd)
    EditText edPhonePwd;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_forget_pwd)
    Button btnForgetPwd;
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

        String username = Sptools.getString(this, Mycontants.USER_NAME, "");
        String password = Sptools.getString(this, Mycontants.PASS_WORD, "");

        if (!TextUtils.isEmpty(username)) {

            edPhoneNum.setText(username);

        }
        if (!TextUtils.isEmpty(password)) {

            edPhonePwd.setText(password);
        }

    }

    @Override
    public void initEvents() {

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



    @OnClick({R.id.btn_login, R.id.btn_forget_pwd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:

//                intentMethod.startMethodOne(this,MainActivity.class);


                String username = edPhoneNum.getText().toString().trim();
                String password = edPhonePwd.getText().toString().trim();

                if (TextUtils.isEmpty(username)) {

                    ToastUtil.showToast("用户名不能为空", this);

                } else if (TextUtils.isEmpty(password)) {

                    ToastUtil.showToast("密码不能为空", this);

                } else if (!BaseUtils.isMobiles(username)) {

                    ToastUtil.showToast("请输入正确手机号", LoginActivity.this);

                } else if (!BaseUtils.validatePhonePass(password)) {

                    ToastUtil.showToast("请输入6-16位字母和数字的组合", LoginActivity.this);

                } else {

                    getdata(username, password);
                }




                break;
            case R.id.btn_forget_pwd:

                intentMethod.startMethodWithString(this,ForgetPwdActivity.class, Mycontants.FWD_EVERY_STEP_KEY,Mycontants.FWD_FIRST_STEP_VALUE);


                break;
        }
    }






    private void getdata(final String username , final String password){

        RequestParams params=new RequestParams();
        params.addBodyParameter("u_name",username);
        params.addBodyParameter("u_passwd",password);

        HttpTool.getInstance(this).httpWithParams(Url.USER_LOGIN, params, new SMObjectCallBack<LoginData>() {

            @Override
            public void onSuccess(LoginData login) {

                if(login.getCode()==200){

                    Sptools.putString(LoginActivity.this, Mycontants.COMPANY_ID, login.getResult().getCom_id());
                    Sptools.putString(LoginActivity.this, Mycontants.U_ID, login.getResult().getU_id());
                    Sptools.putString(LoginActivity.this, Mycontants.USER_NAME, username);
                    Sptools.putString(LoginActivity.this, Mycontants.PASS_WORD, password);
                    Sptools.putString(LoginActivity.this, Mycontants.API_TOKEN, login.getResult().getApi_token());
                    Sptools.putString(LoginActivity.this, Mycontants.U_PHOTO, login.getResult().getU_photo());
                    Sptools.putString(LoginActivity.this, Mycontants.BLOC, login.getResult().getBloc());
                    Sptools.putString(LoginActivity.this, Mycontants.PHONE, login.getResult().getPhone());

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                    finish();

                }else {



                }





            }

            @Override
            public void onError(int error, String msg) {

            }
        });



    }






}
