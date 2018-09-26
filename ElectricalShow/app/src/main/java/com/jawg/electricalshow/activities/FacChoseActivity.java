package com.jawg.electricalshow.activities;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jawg.electricalshow.Entries.MituType;
import com.jawg.electricalshow.R;
import com.jawg.electricalshow.adapter.FacAdapter;
import com.jawg.electricalshow.common.BaseActivity;
import com.jawg.electricalshow.utils.ToastUtil;
import com.jawg.electricalshow.utils.Url;
import com.jawg.electricalshow.utils.http.HttpTool;
import com.jawg.electricalshow.utils.http.SMObjectCallBack;
import com.lidroid.xutils.http.RequestParams;

import java.util.ArrayList;
import java.util.List;

public class FacChoseActivity extends BaseActivity {

    private ListView lvFac;
    private List<MituType> facItemList = new ArrayList<>();
    private FacAdapter facAdapter;
    private String code, portType, port, portFirstWord;

    @Override
    public void initViews() {
        setContentView(R.layout.activity_fac_chose);
    }

    @Override
    public void initData() {

        code = getIntent().getStringExtra("code");
        portType = getIntent().getStringExtra("portType");
        port = getIntent().getStringExtra("port");
        portFirstWord =getIntent().getStringExtra("portFirstWord");

    }

    @Override
    public void initEvents() {

        lvFac = (ListView) findViewById(R.id.lvFac);
        facAdapter = new FacAdapter(this, facItemList);
        lvFac.setAdapter(facAdapter);

        lvFac.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MituType facMITUItem = facItemList.get(i);
                Intent intent = new Intent();
                intent.putExtra("code", code);
                intent.putExtra("portType", portType);
                intent.putExtra("port", port);
                intent.putExtra("facTypeID", facMITUItem.getId());
                intent.putExtra("type", facMITUItem.getType());
                intent.putExtra("valueType", facMITUItem.getValueType());
                intent.putExtra("valueUnit", facMITUItem.getValueUnit());
                String facTypeID = facMITUItem.getId();
                Log.e("abcd", "\nonClick:port===> "+port+
                                "   \n==portfirstword===>>"+portFirstWord +
                                "    \n==portType==?>"+portType+
                                "   \n==code==>"+code+
                                "    \n==facTypeID=>"+facMITUItem.getId()+
                                "    \n==type=>"+facMITUItem.getType()+
                                "   \n==valueType=>"+facMITUItem.getValueType()+
                                "   \n==valueUnit==>"+facMITUItem.getValueUnit()
                );
               if(facTypeID.equals("16")){//剩余电流
//                    intent.setClass(FacChoseActivity.this, MituAlarmAdd.class);
                }else if(facTypeID.equals("8")||facTypeID.equals("15")){//负荷电流
                    intent.setClass(FacChoseActivity.this, MituElectricActivity.class);
               }
                startActivity(intent);
                finish();
            }
        });


        getDeviceType();


    }


    private void getDeviceType(){


        RequestParams params=new RequestParams();
        params.addBodyParameter("fac","8,15,16");
        HttpTool.getInstance(this).httpWithParams(Url.GET_DEVICE_TYPE,params, new SMObjectCallBack<MituType>() {

            @Override
            public void onSuccessArray(List<MituType> t) {

                facItemList.clear();

               if(t!=null&&t.size()>0){

                  facItemList=t;
                   facAdapter = new FacAdapter(FacChoseActivity.this, facItemList);
                   lvFac.setAdapter(facAdapter);

               }else{


                   ToastUtil.showToast("无数据",FacChoseActivity.this);

               }

            }

            @Override
            public void onError(int error, String msg) {



            }


        });



    }



}
