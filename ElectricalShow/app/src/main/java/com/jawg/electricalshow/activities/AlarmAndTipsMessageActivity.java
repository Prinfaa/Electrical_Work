package com.jawg.electricalshow.activities;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.jawg.electricalshow.R;
import com.jawg.electricalshow.common.BaseActivity;
import com.jawg.electricalshow.utils.MyApplication;
import com.jawg.electricalshow.mInterface.Mycontants;
import com.jawg.electricalshow.view.PingFangTextView;
import com.jawg.electricalshow.view.XListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AlarmAndTipsMessageActivity extends BaseActivity {


    @BindView(R.id.btn_back)
    ImageButton btnBack;
    @BindView(R.id.tv_title)
    PingFangTextView tvTitle;
    @BindView(R.id.btn_history)
    Button btnHistory;
    @BindView(R.id.lv_message)
    XListView lvMessage;

    String messageType;

    @Override
    public void initViews() {
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
        MyApplication.getInstance().addActivity(this);

        messageType=getIntent().getStringExtra("messageType");

        if(messageType.equals(Mycontants.ALARM_MESSAGE)){//报警消息

            btnHistory.setVisibility(View.VISIBLE);
            tvTitle.setText("报警消息");
        }else if(messageType.equals(Mycontants.TIPS_MESSAGE)){//提示消息

            btnHistory.setVisibility(View.VISIBLE);
            tvTitle.setText("提示消息");

        }


    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvents() {

    }



    @OnClick({R.id.btn_back, R.id.btn_history})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:

                finish();

                break;
            case R.id.btn_history:

                intentMethod.startMethodWithString(this,HistoryMessageActivity.class,"messageType",messageType);

                break;
        }
    }
}
