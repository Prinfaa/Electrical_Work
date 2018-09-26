package com.jawg.electricalshow.activities;


import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.jawg.electricalshow.Entries.CityItem;
import com.jawg.electricalshow.Entries.ConstructionInfo;
import com.jawg.electricalshow.Entries.ConstructionItem;
import com.jawg.electricalshow.Entries.DeleteDevice;
import com.jawg.electricalshow.Entries.FacItem;
import com.jawg.electricalshow.Entries.PerMituInfo;
import com.jawg.electricalshow.R;
import com.jawg.electricalshow.common.BaseActivity;
import com.jawg.electricalshow.utils.BaseUtils;
import com.jawg.electricalshow.utils.ToastUtil;
import com.jawg.electricalshow.utils.Url;
import com.jawg.electricalshow.utils.http.HttpTool;
import com.jawg.electricalshow.utils.http.SMObjectCallBack;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MituElectricActivity extends BaseActivity implements View.OnClickListener{


    @BindView(R.id.spCity)
    Spinner spCity;
    @BindView(R.id.etSearch)
    EditText etSearch;
    @BindView(R.id.ivSearch)
    ImageView ivSearch;
    @BindView(R.id.spConstructionName)
    Spinner spConstructionName;
    @BindView(R.id.tvUnitName)
    TextView tvUnitName;
    @BindView(R.id.tvCity)
    TextView tvCity;
    @BindView(R.id.tvCounty)
    TextView tvCounty;
    @BindView(R.id.tvCommunity)
    TextView tvCommunity;
    @BindView(R.id.tvLat)
    TextView tvLat;
    @BindView(R.id.tvLng)
    TextView tvLng;
    @BindView(R.id.tvAddress)
    TextView tvAddress;
    @BindView(R.id.tvAddressDescription)
    TextView tvAddressDescription;
    @BindView(R.id.llBaseInfo)
    LinearLayout llBaseInfo;
    @BindView(R.id.tvConstructionType)
    TextView tvConstructionType;
    @BindView(R.id.tvStructureType)
    TextView tvStructureType;
    @BindView(R.id.tvLayer)
    TextView tvLayer;
    @BindView(R.id.tvHeight)
    TextView tvHeight;
    @BindView(R.id.tvBuildingArea)
    TextView tvBuildingArea;
    @BindView(R.id.tvFireFac)
    TextView tvFireFac;
    @BindView(R.id.llConstructionInfo)
    LinearLayout llConstructionInfo;
    @BindView(R.id.tvValueType)
    TextView tvValueType;
    @BindView(R.id.tvValue)
    TextView tvValue;
    @BindView(R.id.tvValueUnit)
    TextView tvValueUnit;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.flValue)
    FrameLayout flValue;
    @BindView(R.id.etPosition)
    EditText etPosition;
    @BindView(R.id.tvCode)
    TextView tvCode;
    @BindView(R.id.tvPortType)
    TextView tvPortType;
    @BindView(R.id.tvPort)
    TextView tvPort;
    @BindView(R.id.tvFac)
    TextView tvFac;
    @BindView(R.id.tvMITUOriginalValue)
    TextView tvMITUOriginalValue;
    @BindView(R.id.etMinValue)
    EditText etMinValue;
    @BindView(R.id.etMaxValue)
    EditText etMaxValue;
    @BindView(R.id.tvValueUnitS)
    TextView tvValueUnitS;
    @BindView(R.id.etStandardValue)
    EditText etStandardValue;
    @BindView(R.id.tvValueUnitSS)
    TextView tvValueUnitSS;
    @BindView(R.id.llStandardValue)
    LinearLayout llStandardValue;
    @BindView(R.id.tvMsg)
    TextView tvMsg;
    @BindView(R.id.btnBack)
    Button btnBack;
    @BindView(R.id.btnEdit)
    Button btnEdit;

    private String address, addressDescription, cityID, city, county, community, lat,constructionTypeID,structureTypeID,
            lng, unitID, unitName, layer, height, buildingArea, constructionType, structureType;
    private String facTypeID, facType, valueType, valueUnit, code, portType, port;
    private ArrayList<FacItem> facItemList = new ArrayList<>();
    private String URL_ADD_NEW_MITU = "http://dndzl.cn/newStart/insert_mitu.php";
    private String originalValue;
    private List<CityItem> cityItemList = new ArrayList<>();
    private String constructionID = "";
    private String oldCityID = "";
    private ArrayAdapter adapterConstructionName;
    private List<ConstructionItem> constructionItemList = new ArrayList<>();
    private String[] constructionNameArr;
    private String value;
    private String referValue;
    private boolean isAct = true;
    private Handler handler=new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if(msg.obj.toString().equals("search")){
                ivSearch.setImageResource(R.drawable.search);
            }


        }
    };

    @Override
    public void initViews() {
        setContentView(R.layout.mitu_electric_add);
        ButterKnife.bind(this);
        getcityList();
    }

    @Override
    public void initData() {
        code = getIntent().getStringExtra("code");
        portType = getIntent().getStringExtra("portType");
        port = getIntent().getStringExtra("port");
        facTypeID = getIntent().getStringExtra("facTypeID");
        facType = getIntent().getStringExtra("type");
        valueType = getIntent().getStringExtra("valueType");
        valueUnit = getIntent().getStringExtra("valueUnit");


        Log.e("abcd", "\nonClick:port===> "+port+
                "    \n==portType==?>"+portType+
                "   \n==code==>"+code+
                "    \n==facTypeID=>"+facTypeID+
                "    \n==type=>"+facType+
                "   \n==valueType=>"+valueType+
                "   \n==valueUnit==>"+valueUnit
        );


    }

    @Override
    public void initEvents() {
        thread.start();
        etSearch.setBackgroundResource(R.drawable.edit_selector);
        etPosition.setBackgroundResource(R.drawable.edit_selector);
        etMinValue.setBackgroundResource(R.drawable.edit_selector);
        etMaxValue.setBackgroundResource(R.drawable.edit_selector);
        etStandardValue.setBackgroundResource(R.drawable.edit_selector);
        if (facTypeID.equals("1") || facTypeID.equals("2")) {
            etStandardValue.setText("0.1");
            llStandardValue.setVisibility(View.VISIBLE);
        } else if (facTypeID.equals("7")) {
            etStandardValue.setText("0.05");
            llStandardValue.setVisibility(View.VISIBLE);
        }
        etMinValue.addTextChangedListener(pressWatcher);
        etMaxValue.addTextChangedListener(pressWatcher);
        ivSearch.setOnClickListener(this);
        tvFac.setText(facType);
        tvValueType.setText(valueType);
        tvValueUnit.setText(valueUnit);
        tvCode.setText(code);
        tvPortType.setText(portType);
        tvPort.setText(port);
        spCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cityID = cityItemList.get(i).getCityid();
                if (oldCityID != cityID) {
                    oldCityID = cityID;
                    constructionNameArr = null;
                    constructionNameArr = new String[1];
                    constructionNameArr[0] = "";
                    adapterConstructionName = new ArrayAdapter<>(MituElectricActivity.this, R.layout.my_spinner, constructionNameArr);
                    //设置下拉列表的风格
                    adapterConstructionName.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    //将adapter 添加到spinner中
                    spConstructionName.setAdapter(adapterConstructionName);
                    adapterConstructionName.notifyDataSetChanged();
                    clearView();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spConstructionName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                llBaseInfo.setVisibility(View.GONE);
                llConstructionInfo.setVisibility(View.GONE);
                if (constructionNameArr[i].equals("")) {
                    clearView();
                } else {
                    constructionID = constructionItemList.get(i).getId();
                    getConsructionInfo(constructionID);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnBack.setOnClickListener(this);
        btnEdit.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {

        if (view == btnBack) {
            finish();
        } else if (view == btnEdit) {
            if (constructionID.equals("")) {
                String msg = "请选择建筑";
                msgDialog(msg);
            } else if (etPosition.getText().toString().equals("")) {
                String msg = "请输入安装位置";
                msgDialog(msg);
            } else {
                saveDialog();
            }
        } else if (view == ivSearch) {
            String searchName=etSearch.getText().toString().trim();
            if(cityID.equals("")){
                ToastUtil.showToast("CityId参数为空",this);
            }else if(searchName.equals("")){
                ToastUtil.showToast("请输入搜索内容",this);
            }else{
                getConstructionList(cityID,searchName);
            }
            ivSearch.setImageResource(R.drawable.search_sel);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                        Message msg = new Message();
                        msg.obj = "search";
                        handler.sendMessage(msg);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        isAct = true;
    }
    @Override
    protected void onPause() {
        super.onPause();
        isAct = false;
    }
    @Override
    protected void onStop() {
        super.onStop();
        isAct = false;
    }




    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            while (isAct) {
                try {
                    if(code.equals("")){
                        ToastUtil.showToast("code参数完整",MituElectricActivity.this);
                    }else if(port.equals("")){
                        ToastUtil.showToast("port参数不完整",MituElectricActivity.this);
                    }else{
                        getPerMituInfo(code,port);
                    }
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });




    private void clearView() {
        etSearch.setText("");
        tvUnitName.setText("");
        tvCity.setText("");
        tvCounty.setText("");
        tvCommunity.setText("");
        tvLat.setText("");
        tvLng.setText("");
        tvAddress.setText("");
        tvAddressDescription.setText("");
        tvConstructionType.setText("");
        tvStructureType.setText("");
        tvLayer.setText("");
        tvHeight.setText("");
        tvBuildingArea.setText("");
        tvFireFac.setText("");
        etPosition.setText("");
    }
    private void showConstructionInfo() {
        llBaseInfo.setVisibility(View.VISIBLE);
        llConstructionInfo.setVisibility(View.VISIBLE);
        tvUnitName.setText(unitName);
        tvAddress.setText(address);
        tvAddressDescription.setText(addressDescription);
        tvCity.setText(city);
        tvCounty.setText(county);
        tvCommunity.setText(community);
        tvLat.setText(lat);
        tvLng.setText(lng);
        tvConstructionType.setText(constructionType);
        tvStructureType.setText(structureType);
        tvLayer.setText(layer + "层");
        tvHeight.setText(height + "米");
        tvBuildingArea.setText(buildingArea + "平方米");

        String strFac = "\u3000\u3000";
        for (int i = 0; i < facItemList.size(); i++) {
            if (i == 0) {
                strFac = strFac + facItemList.get(i).getType();
            } else {
                strFac = strFac + "、" + facItemList.get(i).getType();
            }
        }
        tvFireFac.setText(strFac);
    }

    private void showValue() {
        flValue.setVisibility(View.VISIBLE);
        tvValueUnitS.setText(valueUnit);
        tvValueUnitSS.setText(valueUnit);
        showWaterPressValue();
    }
    private void showWaterPressValue() {
        if(originalValue!=null){
            float min = Float.parseFloat(etMinValue.getText().toString());
            float max = Float.parseFloat(etMaxValue.getText().toString());
            float valueF = Float.parseFloat(originalValue) * (max - min) / 10000 + min;
            value = String.valueOf((float) (Math.round(valueF * 1000) / 1000.0));
            referValue = String.valueOf(max);
            tvValue.setText(value);
        }
    }
    protected void msgDialog(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MituElectricActivity.this);

        builder.setMessage(msg);
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
    private TextWatcher pressWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (!etMinValue.getText().toString().equals("") && !etMaxValue.getText().toString().equals("") && !etMinValue.getText().toString().equals(".") && !etMaxValue.getText().toString().equals(".")) {
                showWaterPressValue();
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
        }

    };
    protected void saveDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MituElectricActivity.this);
        builder.setMessage("确认保存设备信息吗？");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String url = URL_ADD_NEW_MITU + "?mitu_id=" + code +
                        "&unit_id=" + unitID +
                        "&port=" + port +
                        "&fac=" + facTypeID +
                        "&position=" + etPosition.getText().toString() +
                        "&refer_value=" + referValue +
                        "&standard_value=" + etStandardValue.getText().toString() +
                        "&mitu_value=" + value +
                        "&lat=" + lat +
                        "&lng=" + lng +
                        "&construction_id=" + constructionID;
                addDevice(url);
                btnEdit.setEnabled(false);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    /**
     * 网络请求部分
     * @param code
     * @param port
     */
    private void getPerMituInfo(String code ,String port ){

        HttpTool.getInstance(MituElectricActivity.this).httpGet( Url.GET_PER_MITU_INFO+code+"&port=" + port, new SMObjectCallBack<PerMituInfo>() {

            @Override
            public void onSuccess(PerMituInfo perMituInfo) {

                if (perMituInfo.getInfo().equals("need params")) {
                    Toast.makeText(MituElectricActivity.this, "缺少参数，发生错误", Toast.LENGTH_LONG).show();
                    return;
                } else {

                    int count = perMituInfo.getResult().getCount();
                    if (count == 0) {
                        tvMsg.setText("FIS系统未收到该设备数据\n本次操作无法保证设备安装成功");
                        tvMsg.setVisibility(View.VISIBLE);
                        return;
                    } else {
                        originalValue=perMituInfo.getResult().getData().get(0).getOriginal_value();
                        if(originalValue!=null){
                            String time = BaseUtils.getStrTime4(perMituInfo.getResult().getData().get(0).getTimestamp());
                            tvMITUOriginalValue.setText(originalValue);
                            tvTime.setText(time);
                            if (!etMinValue.getText().toString().equals("") && !etMaxValue.getText().toString().equals("") && !etMinValue.getText().toString().equals(".") && !etMaxValue.getText().toString().equals(".")) {
                                showValue();
                            }
                            tvMsg.setVisibility(View.INVISIBLE);
                        }else {
                            tvMsg.setText("FIS系统未收到该设备数据\n本次操作无法保证设备安装成功");
                            tvMsg.setVisibility(View.VISIBLE);
                        }
                    }
                }

            }

            @Override
            public void onError(int error, String msg) {

            }
        });

    }

    private void getcityList(){

        HttpTool.getInstance(this).http(Url.GET_CITY_LIST, new SMObjectCallBack<CityItem>() {

            @Override
            public void onSuccessArray(List<CityItem> citys) {

                cityItemList.clear();
                if(citys!=null&&citys.size()>0){
                    cityItemList=citys;
                    String[] nameArr = new String[citys.size()];
                    for (int i = 0; i <citys.size() ; i++) {
                        nameArr[i]=citys.get(i).getCity();
                    }
                    cityID = cityItemList.get(0).getCityid();
                    oldCityID = cityID;
                    ArrayAdapter adapter = new ArrayAdapter<>(MituElectricActivity.this, R.layout.my_spinner, nameArr);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spCity.setAdapter(adapter);
                }

            }

            @Override
            public void onError(int error, String msg) {

            }
        });

    }

    private void getConstructionList(String cityId,String cityName){

        HttpTool.getInstance(this).httpGet(Url.GET_CONSTRICTION_LIST + cityId + "&name=" + cityName, new SMObjectCallBack<ConstructionItem>() {


            @Override
            public void onSuccessArray(List<ConstructionItem> t) {

                constructionItemList.clear();
                if(t!=null&&t.size()>0){

                    constructionItemList=t;
                    for (int i = 0; i <t.size() ; i++) {
                        constructionNameArr[i] = t.get(i).getName();
                    }
                    constructionID = constructionItemList.get(0).getId();
                    adapterConstructionName = new ArrayAdapter<>(MituElectricActivity.this, R.layout.my_spinner, constructionNameArr);
                    adapterConstructionName.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spConstructionName.setAdapter(adapterConstructionName);
                }

            }

            @Override
            public void onError(int error, String msg) {

            }
        });
    }

    private void getConsructionInfo(String constructionId){

        HttpTool.getInstance(this).httpGet(Url.GET_CONSTRUCTION_INFO+constructionId, new SMObjectCallBack<ConstructionInfo>() {

            @Override
            public void onSuccessArray(List<ConstructionInfo> t) {

                if(t!=null){
                for (int i = 0; i < t.size(); i++) {
                    ConstructionInfo object = t.get(i);
                    constructionID = object.getConstruction_id();
                    cityID = object.getCity_id();
                    city = object.getCity();
                    county = object.getArea();
                    community = object.getShort_county();
                    address = object.getLocation();
                    addressDescription = object.getAddress_description();
                    lat = object.getLati();
                    lng = object.getLongX();
                    unitID = object.getUnit_id();
                    unitName = object.getCom_name();
                    layer = object.getFloor();
                    height = object.getHeight();
                    buildingArea = object.getBuild_area();
                    constructionTypeID = object.getConstruction_type_id();
                    constructionType = object.getConstruction_type();
                    structureTypeID = object.getStructure_type_id();
                    structureType = object.getStructure_type();
                    List<ConstructionInfo.BuildingareaFirefacBean> fac = object.getBuildingarea_firefac();
                    facItemList.clear();
                    for (int j = 0; j < fac.size(); j++) {
                        String facID = fac.get(j).getId();
                        String facType = fac.get(j).getType();
                        facItemList.add(new FacItem(facID, facType));
                    }
                }
                showConstructionInfo();
            }
            }
            @Override
            public void onError(int error, String msg) {

            }
        });





    }

    private void addDevice(String url){

        HttpTool.getInstance(this).httpGet(url, new SMObjectCallBack<DeleteDevice>() {

            @Override
            public void onSuccess(DeleteDevice deleteDevice) {

                String info=deleteDevice.getInfo();

                if (info.equals("success")) {
                    Toast.makeText(MituElectricActivity.this, "设备信息保存成功！", Toast.LENGTH_LONG).show();
                    MituElectricActivity.this.finish();
                } else {
                    Toast.makeText(MituElectricActivity.this, "出错了！", Toast.LENGTH_LONG).show();
                    btnEdit.setEnabled(true);
                }

            }

            @Override
            public void onError(int error, String msg) {

            }
        });




    }


}
