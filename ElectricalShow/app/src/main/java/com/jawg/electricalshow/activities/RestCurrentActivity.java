package com.jawg.electricalshow.activities;

import android.os.Bundle;
import android.os.Vibrator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.jawg.electricalshow.Entries.CityItem;
import com.jawg.electricalshow.Entries.ConstructionItem;
import com.jawg.electricalshow.Entries.FacItem;
import com.jawg.electricalshow.R;
import com.jawg.electricalshow.common.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestCurrentActivity extends BaseActivity {


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
    @BindView(R.id.btnDealFire)
    Button btnDealFire;
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
    @BindView(R.id.tvMsg)
    TextView tvMsg;
    @BindView(R.id.btnBack)
    Button btnBack;
    @BindView(R.id.btnEdit)
    Button btnEdit;

    private String address, addressDescription, cityID, city, county, community, lat, lng, unitID, unitName, layer, height, buildingArea, constructionTypeID, constructionType, structureTypeID, structureType;
    private String facTypeID, facType, valueType, valueUnit, code, portType, port;
    private ArrayList<FacItem> facItemList = new ArrayList<>();
    private String URL_GET_CONSTRUCTION_INFO = "http://dndzl.cn/newStart/construction_id.php?construction_id=";
    private String URL_GET_CITY_LIST = "http://dndzl.cn/newStart/true_false.php";
    private String URL_GET_CONSTRUCTION_LIST = "http://dndzl.cn/newStart/getConstructionList.php";
    private String URL_GET_PER_MITU_INFO = "http://dndzl.cn/newStart/getPerMituInfo.php";
    private String URL_ADD_NEW_MITU = "http://dndzl.cn/newStart/insert_mitu.php";
    private String URL_DEAL_FIRE = "http://dndzl.cn/newStart/update_per_fire.php";
    private String originalValue;
    private List<CityItem> cityItemList = new ArrayList<CityItem>();
    private String constructionID = "";
    private String oldCityID = "";
    private ArrayAdapter adapterConstructionName;
    private List<ConstructionItem> constructionItemList = new ArrayList<ConstructionItem>();
    private String[] constructionNameArr;
    private String value;
    private int GET_CITY_LIST = 1000;
    private int GET_CONSTRUCTION_LIST = 1001;
    private int GET_CONSTRUCTION_INFO = 1002;
    private int GET_PER_MITU_INFO = 1003;
    private int ADD_NEW_MITU = 1004;
    private int DEAL_FIRE = 1005;
    private boolean isAct = true;
    private Vibrator vibrator;
    @Override
    public void initViews() {
        setContentView(R.layout.activity_rest_current);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvents() {

    }


}
