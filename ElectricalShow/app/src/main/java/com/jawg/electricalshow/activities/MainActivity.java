package com.jawg.electricalshow.activities;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.jawg.electricalshow.Entries.DeleteDevice;
import com.jawg.electricalshow.Entries.DeviceInfo;
import com.jawg.electricalshow.R;
import com.jawg.electricalshow.adapter.MituAdapter;
import com.jawg.electricalshow.common.BaseActivity;
import com.jawg.electricalshow.listview.SwipeListView;
import com.jawg.electricalshow.utils.StatusColorSetting;
import com.jawg.electricalshow.utils.Url;
import com.jawg.electricalshow.utils.http.HttpTool;
import com.jawg.electricalshow.utils.http.SMObjectCallBack;
import com.lidroid.xutils.http.RequestParams;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.lvMitu)
    SwipeListView lvMitu;
    @BindView(R.id.btnAddNewMitu)
    Button btnAddNewMitu;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    private MituAdapter adapter;
    private String code;

    @Override
    public void initViews() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        StatusColorSetting.getInstance().setStatusBar(this, true, false);
    }

    @Override
    public void initData() {


        swipeRefresh.setColorSchemeColors(Color.RED);

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefresh.setRefreshing(false);
                        getdata("8,16,15");
                    }
                }, 1000);
            }
        });

        getdata("8,16,15");

    }

    @Override
    public void initEvents() {

    }


    private void getdata(String fac) {

        RequestParams params = new RequestParams();
        params.addBodyParameter("fac", "" + fac);

        HttpTool.getInstance(this).httpWithParams(Url.GET_DEVICE_LIST, params, new SMObjectCallBack<DeviceInfo>() {

            @Override
            public void onSuccess(DeviceInfo deviceInfo) {

                if (deviceInfo.getResult() != null && deviceInfo.getResult().size() > 0) {

                    adapter = new MituAdapter(MainActivity.this, deviceInfo.getResult());

                    lvMitu.setAdapter(adapter);

                }

            }

            @Override
            public void onError(int error, String msg) {

            }
        });


    }


    @OnClick(R.id.btnAddNewMitu)
    public void onViewClicked() {

        Intent openCameraIntent = new Intent(MainActivity.this, CaptureActivity.class);
        startActivityForResult(openCameraIntent, 0);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //处理扫描结果（在界面上显示）
        if (requestCode == 0 && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            code = bundle.getString("result");
//            String url = URL_USABILITY + "?mitu_id=" + code;
//            HttpUtils.getJSON(url, handler, USABILITY);
            if(!code.equals("")){

                upLoadDeviceId(code);

            }

        }

    }


    private void upLoadDeviceId(String mitu_id){


        HttpTool.getInstance(this).httpGet(Url.UPLOAD_DEVICE_ID+mitu_id, new SMObjectCallBack<DeleteDevice>() {

            @Override
            public void onSuccess(DeleteDevice deleteDevice) {

                if(deleteDevice.getInfo().equals("success")){
                    Intent intent = new Intent();
                    intent.putExtra("code", code);
                    intent.setClass(MainActivity.this, PortChoseActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "此设备不可用", Toast.LENGTH_LONG).show();
                }
            }



            @Override
            public void onError(int error, String msg) {

            }
        });



    }


}
