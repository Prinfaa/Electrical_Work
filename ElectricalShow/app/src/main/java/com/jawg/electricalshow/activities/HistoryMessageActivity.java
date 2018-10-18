package com.jawg.electricalshow.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;

import com.jawg.electricalshow.R;
import com.jawg.electricalshow.adapter.MessageViewpagerAdapter;
import com.jawg.electricalshow.common.BaseActivity;
import com.jawg.electricalshow.mInterface.Mycontants;
import com.jawg.electricalshow.utils.ToastUtil;
import com.jawg.electricalshow.view.PingFangTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryMessageActivity extends BaseActivity {


    @BindView(R.id.btn_back)
    ImageButton btnBack;
    @BindView(R.id.btn_date)
    ImageButton btnDate;
    @BindView(R.id.tl_msg_type)
    TabLayout tlMsgType;
    @BindView(R.id.vp_message)
    ViewPager vpMessage;
    @BindView(R.id.tv_title)
    PingFangTextView tvTitle;
    String messageType;
    private MessageViewpagerAdapter myFragmentPagerAdapter;
    private final static int REQUESTCODE = 1; // 返回的结果码

    @Override
    public void initViews() {
        setContentView(R.layout.activity_history_message);
        ButterKnife.bind(this);
        messageType = getIntent().getStringExtra("messageType");
        if (messageType.equals(Mycontants.ALARM_MESSAGE)) {//报警消息

            tvTitle.setText("历史消息（报警）");
            btnDate.setVisibility(View.VISIBLE);
        } else if (messageType.equals(Mycontants.TIPS_MESSAGE)) {//提示消息

            tvTitle.setText("历史消息(提示)");
            btnDate.setVisibility(View.VISIBLE);

        }


    }

    @Override
    public void initData() {

        myFragmentPagerAdapter = new MessageViewpagerAdapter(getSupportFragmentManager());
        vpMessage.setAdapter(myFragmentPagerAdapter);
        tlMsgType.setupWithViewPager(vpMessage);

    }

    @Override
    public void initEvents() {

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                intentMethod.startMethodTwo(HistoryMessageActivity.this,CalendarSelectorActivity.class);

                Intent intent = new Intent(HistoryMessageActivity.this,
                        CalendarSelectorActivity.class);
                startActivityForResult(intent, REQUESTCODE);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==2){

            if(requestCode==REQUESTCODE){


                int year=data.getIntExtra("selectListYear",0);
                int month=data.getIntExtra("selectListMonth",0);
                int day=data.getIntExtra("selectListDay",0);


                ToastUtil.showToast(year+"-"+month+"-"+day,this);


            }




        }




    }
}
