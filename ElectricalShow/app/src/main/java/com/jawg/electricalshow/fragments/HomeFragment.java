package com.jawg.electricalshow.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jawg.electricalshow.R;
import com.jawg.electricalshow.activities.AddressListActivity;
import com.jawg.electricalshow.activities.DeviceActivity;
import com.jawg.electricalshow.activities.FWSListActivity;
import com.jawg.electricalshow.common.BaseFragment2;
import com.jawg.electricalshow.mInterface.Mycontants;
import com.jawg.electricalshow.view.ClockView;
import com.jawg.electricalshow.view.PingFangTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class HomeFragment extends BaseFragment2 {
    @BindView(R.id.top_name)
    PingFangTextView topName;
    @BindView(R.id.back_btn)
    LinearLayout backBtn;
    @BindView(R.id.tv_save)
    TextView tvSave;
    @BindView(R.id.btn_search)
    ImageButton btnSearch;
    Unbinder unbinder;
    @BindView(R.id.cv_clock)
    ClockView cvClock;
    @BindView(R.id.btn_alarm_msg)
    Button btnAlarmMsg;
    @BindView(R.id.btn_tips_msg)
    Button btnTipsMsg;
    @BindView(R.id.rl_electrial)
    RelativeLayout rlElectrial;
    @BindView(R.id.rl_temperature)
    RelativeLayout rlTemperature;
    @BindView(R.id.rl_surplus)
    RelativeLayout rlSurplus;
    @BindView(R.id.rl_address)
    RelativeLayout rlAddress;
    Unbinder unbinder1;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void initData() {
        tvSave.setVisibility(View.VISIBLE);
        tvSave.setText("设备");
        topName.setText("经安纬固消防科技");


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }



    @OnClick({R.id.back_btn, R.id.btn_alarm_msg, R.id.btn_tips_msg, R.id.rl_electrial, R.id.rl_temperature, R.id.rl_surplus, R.id.rl_address,R.id.tv_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_btn:


                break;
            case R.id.tv_save:

                intentMethod.startMethodTwo(getActivity(), DeviceActivity.class);


                break;
            case R.id.btn_alarm_msg:


                break;
            case R.id.btn_tips_msg:



                break;
            case R.id.rl_electrial:

            intentMethod.startMethodWithString(getActivity(), FWSListActivity.class,"ValueType", Mycontants.ELECTRICAL_TYPE);

                break;
            case R.id.rl_temperature:

                intentMethod.startMethodWithString(getActivity(), FWSListActivity.class,"ValueType", Mycontants.TEMPERATURE_TYPE);


                break;
            case R.id.rl_surplus:


                intentMethod.startMethodWithString(getActivity(), FWSListActivity.class,"ValueType", Mycontants.SURPLUS_TYPE);

                break;
            case R.id.rl_address:

//                intentMethod.startMethodWithString(getActivity(), FWSListActivity.class,"ValueType", Mycontants.ELECTRICAL_TYPE);

                    intentMethod.startMethodTwo(getActivity(), AddressListActivity.class);
                break;
        }
    }
}
