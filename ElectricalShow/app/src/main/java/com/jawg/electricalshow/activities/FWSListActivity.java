package com.jawg.electricalshow.activities;

import android.view.View;
import android.widget.ImageButton;

import com.jawg.electricalshow.R;
import com.jawg.electricalshow.common.BaseActivity;
import com.jawg.electricalshow.mInterface.Mycontants;
import com.jawg.electricalshow.view.PingFangTextView;
import com.jawg.electricalshow.view.XListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FWSListActivity extends BaseActivity {

    @BindView(R.id.btn_back)
    ImageButton btnBack;
    @BindView(R.id.tv_title)
    PingFangTextView tvTitle;
    @BindView(R.id.btn_search)
    ImageButton btnSearch;
    @BindView(R.id.lv_fwslist)
    XListView lvFwslist;
    String type;

    @Override
    public void initViews() {
        setContentView(R.layout.activity_fwslist);
        ButterKnife.bind(this);
        btnSearch.setVisibility(View.VISIBLE);
        type=getIntent().getStringExtra("ValueType");

        if(type.equals(Mycontants.ELECTRICAL_TYPE)){//负荷电流

            tvTitle.setText("负荷电流");

        }else if(type.equals(Mycontants.TEMPERATURE_TYPE)){//设备温度

            tvTitle.setText("设备温度");

        }else if(type.equals(Mycontants.SURPLUS_TYPE)){//剩余电流

            tvTitle.setText("剩余电流");

        }




    }

    @Override
    public void initData() {




    }

    @Override
    public void initEvents() {




    }


    @OnClick({R.id.btn_back, R.id.btn_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:

                finish();

                break;
            case R.id.btn_search:


                if(type.equals(Mycontants.ELECTRICAL_TYPE)){//负荷电流

                    intentMethod.startMethodWithString(FWSListActivity.this,FWSSearchActivity.class,"TypeValue",Mycontants.ELECTRICAL_TYPE);

                }else if(type.equals(Mycontants.TEMPERATURE_TYPE)){//设备温度

                    intentMethod.startMethodWithString(FWSListActivity.this,FWSSearchActivity.class,"TypeValue",Mycontants.TEMPERATURE_TYPE);

                }else if(type.equals(Mycontants.SURPLUS_TYPE)){//剩余电流

                    intentMethod.startMethodWithString(FWSListActivity.this,FWSSearchActivity.class,"TypeValue",Mycontants.SURPLUS_TYPE);

                }




                break;
        }
    }
}
