package com.jawg.electricalshow.adapter;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jawg.electricalshow.Entries.DeleteDevice;
import com.jawg.electricalshow.Entries.DeviceInfo;
import com.jawg.electricalshow.R;
import com.jawg.electricalshow.utils.ToastUtil;
import com.jawg.electricalshow.utils.Url;
import com.jawg.electricalshow.utils.http.HttpTool;
import com.jawg.electricalshow.utils.http.SMObjectCallBack;
import com.lidroid.xutils.http.RequestParams;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MituAdapter extends BaseAdapter {

    private Context context;
    private List<DeviceInfo.ResultBean> mituList;
    private ViewHolder mViewHolder;


    public MituAdapter(Context context, List<DeviceInfo.ResultBean> mituList) {
        this.context = context;
        this.mituList = mituList;
    }

    @Override
    public int getCount() {
        return mituList.size();
    }

    @Override
    public DeviceInfo.ResultBean getItem(int position) {
        return mituList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.mitu_item, null);

            mViewHolder = new ViewHolder(convertView);

            convertView.setTag(mViewHolder);

        } else {

            mViewHolder = (ViewHolder) convertView.getTag();

        }

        final DeviceInfo.ResultBean mituItem = mituList.get(position);

        mViewHolder.tvMituID.setText(mituItem.getMitu_id());
        mViewHolder.tvPort.setText("端口" + mituItem.getPort());
        mViewHolder.tvTime.setText(mituItem.getUpdate_time());
        mViewHolder.tvFac.setText(mituItem.getFac_type());
        mViewHolder.tvCity.setText(mituItem.getCity());
        mViewHolder.tvUnit.setText(mituItem.getUnit_name());
        mViewHolder.tvConstructionOrMicroStation.setText(mituItem.getConstruction_name());
        mViewHolder.tvPostionOrFireCar.setText(mituItem.getPosition());
        String facTypeID = mituItem.getFac();
        String value = mituItem.getMitu_value();
        mViewHolder.tvValueUnit.setText("");
        if (facTypeID.equals("8")) {   //负荷电流
            mViewHolder.tvValueUnit.setText("A");
            if (!value.equals("")) {
                value = String.format("%.0f", Float.parseFloat(value));
            }
        } else if (facTypeID.equals("16")) {    //剩余电流
            if (value.equals("1")) {
                value = "报警";
            } else {
                value = "未报警";
            }
            mViewHolder.tvValueUnit.setText("");
        } else if (facTypeID.equals("15")) {   //线路温度
            mViewHolder.tvValueUnit.setText("℃");

        }
        mViewHolder.tvValue.setText(value);

        mViewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            showNormalDialog(mituList.get(position).getId());

            }
        });

        mViewHolder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ToastUtil.showToast("这是修改",context);

            }
        });


        return convertView;
    }




    private void showNormalDialog(final String id) {
        /* @setIcon 设置对话框图标
         * @setTitle 设置对话框标题
         * @setMessage 设置对话框消息提示
         * setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        AlertDialog normalDialog = new AlertDialog.Builder(context)
                .setIcon(R.mipmap.jawg_logo_256)
                .setTitle("删除")
                .setMessage("您是否要删除此设备信息?")
                .setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            delateDevice(id);
                            }
                        })
                .setNegativeButton("取消",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {


                            }
                        }).create();
        // 显示
        normalDialog.show();

        normalDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(context.getResources().getColor(R.color.blue));
        normalDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(context.getResources().getColor(R.color.black));



    }


    private void delateDevice(String deviceId){

        RequestParams params=new RequestParams();
        params.addBodyParameter("id",deviceId);

        HttpTool.getInstance(context).httpWithParams(Url.DELATE_MITU_DEVICE, params, new SMObjectCallBack<DeleteDevice>() {

            @Override
            public void onSuccess(DeleteDevice deleteDevice) {

                if(deleteDevice.getInfo().equals("success")){

                    ToastUtil.showToast("删除成功",context);

                    notifyDataSetChanged();

                }else{

                    ToastUtil.showToast("删除失败",context);

                }


            }

            @Override
            public void onSuccessArray(List<DeleteDevice> t) {

            }

            @Override
            public void onError(int error, String msg) {

            }
        });





    }





    static class ViewHolder {
        @BindView(R.id.tvMituID)
        TextView tvMituID;
        @BindView(R.id.tvPort)
        TextView tvPort;
        @BindView(R.id.tvTime)
        TextView tvTime;
        @BindView(R.id.tvFac)
        TextView tvFac;
        @BindView(R.id.tvValue)
        TextView tvValue;
        @BindView(R.id.tvValueUnit)
        TextView tvValueUnit;
        @BindView(R.id.tvCity)
        TextView tvCity;
        @BindView(R.id.tvUnit)
        TextView tvUnit;
        @BindView(R.id.tvConstructionOrMicroStation)
        TextView tvConstructionOrMicroStation;
        @BindView(R.id.tvPostionOrFireCar)
        TextView tvPostionOrFireCar;
        @BindView(R.id.main)
        LinearLayout main;
        @BindView(R.id.delete)
        Button delete;
        @BindView(R.id.update)
        Button update;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
