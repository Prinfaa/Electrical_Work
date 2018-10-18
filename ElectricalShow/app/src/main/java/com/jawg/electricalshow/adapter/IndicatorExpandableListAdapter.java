package com.jawg.electricalshow.adapter;

import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jawg.electricalshow.R;
import com.jawg.electricalshow.mInterface.OnGroupExpandedListener;


/**
 * @author Richie on 2017.07.31
 *         改过 Indicator 的 ExpandableListView 的适配器
 */
public class IndicatorExpandableListAdapter extends BaseExpandableListAdapter {
    private static final String TAG = "IndicatorExpandableList";
    private String[] groupData;
    private String[][] childData;
    //                用于存放Indicator的集合
    private SparseArray<ImageView> mIndicators;
    private OnGroupExpandedListener mOnGroupExpandedListener;

    public IndicatorExpandableListAdapter(String[] groupData, String[][] childData) {
        this.groupData = groupData;
        this.childData = childData;
        mIndicators = new SparseArray<>();
    }

    public void setOnGroupExpandedListener(OnGroupExpandedListener onGroupExpandedListener) {
        mOnGroupExpandedListener = onGroupExpandedListener;
    }

    //            根据分组的展开闭合状态设置指示器
    public void setIndicatorState(int groupPosition, boolean isExpanded) {
        if (isExpanded) {
            mIndicators.get(groupPosition).setImageResource(R.mipmap.up);
        } else {
            mIndicators.get(groupPosition).setImageResource(R.mipmap.down);
        }
    }

    @Override
    public int getGroupCount() {
        return groupData.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childData[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupData[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childData[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_address_list_detail_group, parent, false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.tvGroupName = (TextView) convertView.findViewById(R.id.tv_group_name);
            groupViewHolder.ivIndicator= (ImageView) convertView.findViewById(R.id.iv_down_up);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.tvGroupName.setText(groupData[groupPosition]);
        //      把位置和图标添加到Map
        mIndicators.put(groupPosition, groupViewHolder.ivIndicator);
        //      根据分组状态设置Indicator
        setIndicatorState(groupPosition, isExpanded);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View
            convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_address_list_detail_child, parent, false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.tvAddress = (TextView) convertView.findViewById(R.id.tv_address);
            childViewHolder.tvDeviceId = (TextView) convertView.findViewById(R.id.tv_device_id);
            childViewHolder.tvPort = (TextView) convertView.findViewById(R.id.tv_port);
            childViewHolder.tvValue = (TextView) convertView.findViewById(R.id.tv_value);
            childViewHolder.tvTime = (TextView) convertView.findViewById(R.id.tv_time);

            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        childViewHolder.tvAddress.setText(childData[groupPosition][childPosition]);


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        Log.d(TAG, "onGroupExpanded() called with: groupPosition = [" + groupPosition + "]");
        if (mOnGroupExpandedListener != null) {
            mOnGroupExpandedListener.onGroupExpanded(groupPosition);
        }
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        Log.d(TAG, "onGroupCollapsed() called with: groupPosition = [" + groupPosition + "]");
    }

    private static class GroupViewHolder {
        TextView tvGroupName;
        ImageView ivIndicator;
    }

    private static class ChildViewHolder {
        TextView tvAddress;
        TextView tvDeviceId;
        TextView tvPort;
        TextView tvValue;
        TextView tvTime;
    }
}
