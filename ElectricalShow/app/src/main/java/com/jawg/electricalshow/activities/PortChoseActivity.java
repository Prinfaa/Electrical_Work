package com.jawg.electricalshow.activities;


import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.jawg.electricalshow.R;
import com.jawg.electricalshow.common.BaseActivity;

public class PortChoseActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvCode;
    private Spinner spPortType, spPort;
    private String code, portType, port;
    private String[] portTypes = {"模拟量", "开关量"};
    private String[] ports = new String[32];
    private ArrayAdapter adapterPort, adapterPortType;
    private Button btnCancel, btnOK;
    private String portFirstWord = "";
    @Override
    public void initViews() {
        setContentView(R.layout.activity_port_chose);
    }

    @Override
    public void initData() {
        code = getIntent().getStringExtra("code");
    }

    @Override
    public void initEvents() {

        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnOK = (Button) findViewById(R.id.btnOK);
        btnCancel.setOnClickListener(this);
        btnOK.setOnClickListener(this);

        tvCode = (TextView) findViewById(R.id.tvCode);
        tvCode.setText(code);

        spPortType = (Spinner) findViewById(R.id.spPortType);

        adapterPortType = new ArrayAdapter<String>(PortChoseActivity.this, R.layout.my_spinner, portTypes);
        //设置下拉列表的风格
        adapterPortType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter 添加到spinner中
        spPortType.setAdapter(adapterPortType);


        spPortType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        portFirstWord = "a";
                        ports = getPorts(portFirstWord);
                        break;
                    case 1:
                        portFirstWord = "s";
                        ports = getPorts(portFirstWord);
                        break;
                    default:
                        break;
                }
                adapterPort = new ArrayAdapter<String>(PortChoseActivity.this, R.layout.my_spinner, ports);
                //设置下拉列表的风格
                adapterPort.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                //将adapter 添加到spinner中
                spPort.setAdapter(adapterPort);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        spPort = (Spinner) findViewById(R.id.spPort);

        String portFirstWord = "a";
        ports = getPorts(portFirstWord);

        adapterPort = new ArrayAdapter<String>(PortChoseActivity.this, R.layout.my_spinner, ports);
        //设置下拉列表的风格
        adapterPort.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter 添加到spinner中
        spPort.setAdapter(adapterPort);

    }

    private String[] getPorts(String portFirstWord) {
        String[] ports = new String[32];
        for (int i = 0; i < 32; i++) {
            String port = portFirstWord + String.valueOf(i);
            ports[i] = port;
        }
        return ports;
    }

    @Override
    public void onClick(View view) {
        if (view == btnCancel) {
            finish();
        } else if (view == btnOK) {
            int indexPortType = spPortType.getSelectedItemPosition();
            portType = portTypes[indexPortType];
            int indexPort = spPort.getSelectedItemPosition();
            port = ports[indexPort];

            Intent intent = new Intent();
            intent.putExtra("code", code);//设备号
            intent.putExtra("portType", portType);// {"模拟量", "开关量", "累积量", "地理位置坐标"};
            intent.putExtra("port", port);// a0  s0  c0
            intent.putExtra("portFirstWord" ,portFirstWord);//a s c gps

            Log.e("abcd", "onClick:port===> "+port+"   ==portfirstword===>>"+portFirstWord );

            intent.setClass(PortChoseActivity.this, FacChoseActivity.class);
            startActivity(intent);
            finish();
        }
    }






















}
