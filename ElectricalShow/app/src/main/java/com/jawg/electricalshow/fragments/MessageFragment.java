package com.jawg.electricalshow.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jawg.electricalshow.R;
import com.jawg.electricalshow.activities.AlarmAndTipsMessageActivity;
import com.jawg.electricalshow.common.BaseFragment2;
import com.jawg.electricalshow.mInterface.Mycontants;
import com.jawg.electricalshow.view.PingFangTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MessageFragment extends BaseFragment2 {
    @BindView(R.id.top_name)
    PingFangTextView topName;
    @BindView(R.id.back_btn)
    LinearLayout backBtn;
    Unbinder unbinder;
    @BindView(R.id.tv_alarm_tip)
    TextView tvAlarmTip;
    @BindView(R.id.tv_alarm_msg_data)
    TextView tvAlarmMsgData;
    @BindView(R.id.tv_alarm_time)
    TextView tvAlarmTime;
    @BindView(R.id.tv_alarm_num)
    PingFangTextView tvAlarmNum;
    @BindView(R.id.ll_alarm_msg)
    LinearLayout llAlarmMsg;
    @BindView(R.id.tv_tips_tip)
    TextView tvTipsTip;
    @BindView(R.id.tv_tips_msg_data)
    TextView tvTipsMsgData;
    @BindView(R.id.tv_tips_time)
    TextView tvTipsTime;
    @BindView(R.id.tv_tips_num)
    PingFangTextView tvTipsNum;
    @BindView(R.id.ll_tips_msg)
    LinearLayout llTipsMsg;
    Unbinder unbinder1;
    Context context;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        unbinder = ButterKnife.bind(this, view);
        topName.setText("消息");
        context=getActivity();
        return view;
    }

    @Override
    public void initData() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }




    @OnClick({R.id.ll_alarm_msg, R.id.ll_tips_msg,R.id.back_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_alarm_msg:

                intentMethod.startMethodWithString(context, AlarmAndTipsMessageActivity.class,"messageType", Mycontants.ALARM_MESSAGE);

                break;
            case R.id.ll_tips_msg:

                intentMethod.startMethodWithString(context, AlarmAndTipsMessageActivity.class,"messageType", Mycontants.TIPS_MESSAGE);
                break;
            case R.id.back_btn:


                break;
        }
    }
}
