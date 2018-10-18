package com.jawg.electricalshow.activities;

import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.jawg.electricalshow.R;
import com.jawg.electricalshow.adapter.IndicatorExpandableListAdapter;
import com.jawg.electricalshow.common.BaseActivity;
import com.jawg.electricalshow.view.PingFangTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressItemListActivity extends BaseActivity {


    @BindView(R.id.btn_back)
    ImageButton btnBack;
    @BindView(R.id.tv_title)
    PingFangTextView tvTitle;
    @BindView(R.id.btn_diagram)
    ImageButton btnDiagram;
    @BindView(R.id.elv_check_list)
    ExpandableListView elvCheckList;
    IndicatorExpandableListAdapter adapter;

    @Override
    public void initViews() {
        setContentView(R.layout.activity_address_item_list);
        ButterKnife.bind(this);

        tvTitle.setText("");
        btnDiagram.setVisibility(View.VISIBLE);
    }

    @Override
    public void initData() {

//        adapter = new IndicatorExpandableListAdapter(Constant.BOOKS, Constant.FIGURES);
        elvCheckList.setAdapter(adapter);

        // 清除默认的 Indicator
        elvCheckList.setGroupIndicator(null);

        //让每一组数据都展开
//        for (int i = 0; i < Constant.BOOKS.length; i++) {
//
//            elvCheckList.expandGroup(i);
//
//        }

    }

    @Override
    public void initEvents() {

        elvCheckList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
//                Log.d(TAG, "onGroupClick: groupPosition:" + groupPosition + ", id:" + id);
                boolean groupExpanded = parent.isGroupExpanded(groupPosition);
                adapter.setIndicatorState(groupPosition, groupExpanded);
                // 请务必返回 false，否则分组不会展开
                return false;
            }
        });

        //  设置子选项点击监听事件
        elvCheckList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
//                Toast.makeText(IndicatorExpandActivity.this, Constant.FIGURES[groupPosition][childPosition], Toast.LENGTH_SHORT).show();
                return true;
            }
        });


    }


    @OnClick({R.id.btn_back, R.id.btn_diagram})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:

                finish();

                break;
            case R.id.btn_diagram:

                intentMethod.startMethodTwo(this,BrokenLineStatisticsActivity.class);

                break;
        }
    }
}
