package com.jawg.electricalshow.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jawg.electricalshow.Entries.MituType;
import com.jawg.electricalshow.R;

import java.util.List;


public class FacAdapter extends BaseAdapter {

    private Context context;
    private List<MituType> facList;


    public FacAdapter(Context context, List<MituType> facList) {
        this.context = context;
        this.facList = facList;
    }

    @Override
    public int getCount() {
        return facList.size();
    }

    @Override
    public MituType getItem(int position) {
        return facList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.mitu_fac_item, null);
        }

        MituType facItem = facList.get(position);
        TextView tvFacName = (TextView) convertView.findViewById(R.id.tvFac);
        TextView tvValueType = (TextView) convertView.findViewById(R.id.tvValueType);
        tvFacName.setText(facItem.getType());
        tvValueType.setText(facItem.getValueType());

        if(position%2 == 1){
//            convertView.setBackgroundColor(0x11FFFFFF);
        }

        return convertView;
    }

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
    }

    private int selectItem = 0;


}
