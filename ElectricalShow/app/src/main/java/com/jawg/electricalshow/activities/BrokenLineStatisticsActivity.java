package com.jawg.electricalshow.activities;

import android.graphics.Color;
import android.util.Log;
import android.widget.ImageButton;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.jawg.electricalshow.R;
import com.jawg.electricalshow.common.BaseActivity;
import com.jawg.electricalshow.view.PingFangTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BrokenLineStatisticsActivity extends BaseActivity {


    @BindView(R.id.btn_back)
    ImageButton btnBack;
    @BindView(R.id.tv_title)
    PingFangTextView tvTitle;
    @BindView(R.id.MP_electrical)
    LineChart MPElectrical;
    @BindView(R.id.MP_temperature)
    LineChart MPTemperature;

    @Override
    public void initViews() {
        setContentView(R.layout.activity_broken_line_statistics);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {

        initElectricalChart();
        initTemperatureChart();

        initElectricalLineData();


    }

    @Override
    public void initEvents() {

    }


    //设置electricalChart基本属性
    private void initElectricalChart() {
        //描述信息
        Description description = new Description();
        description.setText("我是描述信息");
        //设置描述信息
        MPElectrical.setDescription(description);
        //设置没有数据时显示的文本
        MPElectrical.setNoDataText("没有数据喔~~");
        //设置是否绘制chart边框的线
        MPElectrical.setDrawBorders(true);
        //设置chart边框线颜色
        MPElectrical.setBorderColor(Color.GRAY);
        //设置chart边框线宽度
        MPElectrical.setBorderWidth(1f);
        //设置chart是否可以触摸
        MPElectrical.setTouchEnabled(true);
        //设置是否可以拖拽
        MPElectrical.setDragEnabled(true);
        //设置是否可以缩放 x和y，默认true
        MPElectrical.setScaleEnabled(false);
        //设置是否可以通过双击屏幕放大图表。默认是true
        MPElectrical.setDoubleTapToZoomEnabled(false);
        //设置chart动画
        MPElectrical.animateXY(1000, 1000);

        //=========================设置图例=========================
        // 像"□ xxx"就是图例
        Legend legend = MPElectrical.getLegend();
        //设置图例显示在chart那个位置 setPosition建议放弃使用了
        //设置垂直方向上还是下或中
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        //设置水平方向是左边还是右边或中
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        //设置所有图例位置排序方向
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        //设置图例的形状 有圆形、正方形、线
        legend.setForm(Legend.LegendForm.CIRCLE);
        //是否支持自动换行 目前只支持BelowChartLeft, BelowChartRight, BelowChartCenter
        legend.setWordWrapEnabled(true);

        //=======================设置X轴显示效果==================
        XAxis xAxis = MPElectrical.getXAxis();
        //是否启用X轴
        xAxis.setEnabled(true);
        //是否绘制X轴线
        xAxis.setDrawAxisLine(true);
        //设置X轴上每个竖线是否显示
        xAxis.setDrawGridLines(true);
        //设置是否绘制X轴上的对应值(标签)
        xAxis.setDrawLabels(true);
        //设置X轴显示位置
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //设置竖线为虚线样式
        // xAxis.enableGridDashedLine(10f, 10f, 0f);
        //设置x轴标签数
        xAxis.setLabelCount(24, true);
        //图表第一个和最后一个label数据不超出左边和右边的Y轴
        // xAxis.setAvoidFirstLastClipping(true);

        //设置限制线 12代表某个该轴某个值，也就是要画到该轴某个值上
        LimitLine limitLine = new LimitLine(12);
        //设置限制线的宽
        limitLine.setLineWidth(1f);
        //设置限制线的颜色
        limitLine.setLineColor(Color.RED);
        //设置基线的位置
        limitLine.setLabelPosition(LimitLine.LimitLabelPosition.LEFT_TOP);
        limitLine.setLabel("马丹我是基线，也可以叫我水位线");
        //设置限制线为虚线
        limitLine.enableDashedLine(10f, 10f, 0f);
        //=================设置左边Y轴===============
        YAxis axisLeft = MPElectrical.getAxisLeft();
        //左边Y轴添加限制线
        axisLeft.addLimitLine(limitLine);
        //是否启用左边Y轴
        axisLeft.setEnabled(true);
        //设置最小值（这里就按demo里固死的写）
        axisLeft.setAxisMinimum(0);
        //设置最大值（这里就按demo里固死的写了）
        axisLeft.setAxisMaximum(50);
        //设置横向的线为虚线
        axisLeft.enableGridDashedLine(10f, 10f, 0f);
        //axisLeft.setDrawLimitLinesBehindData(true);
        //====================设置右边的Y轴===============
        YAxis axisRight = MPElectrical.getAxisRight();
        //是否启用右边Y轴
        axisRight.setEnabled(false);
        //设置最小值（这里按demo里的数据固死写了）
        axisRight.setAxisMinimum(0);
        //设置最大值（这里按demo里的数据固死写了）
        axisRight.setAxisMaximum(100);
        //设置横向的线为虚线
        axisRight.enableGridDashedLine(10f, 10f, 0f);

    }
    //设置TemperatureChart基本属性
    private void initTemperatureChart() {
        //描述信息
        Description description = new Description();
        description.setText("我是描述信息");
        //设置描述信息
        MPTemperature.setDescription(description);
        //设置没有数据时显示的文本
        MPTemperature.setNoDataText("没有数据喔~~");
        //设置是否绘制chart边框的线
        MPTemperature.setDrawBorders(true);
        //设置chart边框线颜色
        MPTemperature.setBorderColor(Color.GRAY);
        //设置chart边框线宽度
        MPTemperature.setBorderWidth(1f);
        //设置chart是否可以触摸
        MPTemperature.setTouchEnabled(true);
        //设置是否可以拖拽
        MPTemperature.setDragEnabled(true);
        //设置是否可以缩放 x和y，默认true
        MPTemperature.setScaleEnabled(false);
        //设置是否可以通过双击屏幕放大图表。默认是true
        MPTemperature.setDoubleTapToZoomEnabled(false);
        //设置chart动画
        MPTemperature.animateXY(1000, 1000);

        //=========================设置图例=========================
        // 像"□ xxx"就是图例
        Legend legend = MPTemperature.getLegend();
        //设置图例显示在chart那个位置 setPosition建议放弃使用了
        //设置垂直方向上还是下或中
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        //设置水平方向是左边还是右边或中
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        //设置所有图例位置排序方向
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        //设置图例的形状 有圆形、正方形、线
        legend.setForm(Legend.LegendForm.CIRCLE);
        //是否支持自动换行 目前只支持BelowChartLeft, BelowChartRight, BelowChartCenter
        legend.setWordWrapEnabled(true);

        //=======================设置X轴显示效果==================
        XAxis xAxis = MPTemperature.getXAxis();
        //是否启用X轴
        xAxis.setEnabled(true);
        //是否绘制X轴线
        xAxis.setDrawAxisLine(true);
        //设置X轴上每个竖线是否显示
        xAxis.setDrawGridLines(true);
        //设置是否绘制X轴上的对应值(标签)
        xAxis.setDrawLabels(true);
        //设置X轴显示位置
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //设置竖线为虚线样式
        // xAxis.enableGridDashedLine(10f, 10f, 0f);
        //设置x轴标签数
        xAxis.setLabelCount(24, true);
        //图表第一个和最后一个label数据不超出左边和右边的Y轴
        // xAxis.setAvoidFirstLastClipping(true);

        //设置限制线 12代表某个该轴某个值，也就是要画到该轴某个值上
        LimitLine limitLine = new LimitLine(12);
        //设置限制线的宽
        limitLine.setLineWidth(1f);
        //设置限制线的颜色
        limitLine.setLineColor(Color.RED);
        //设置基线的位置
        limitLine.setLabelPosition(LimitLine.LimitLabelPosition.LEFT_TOP);
        limitLine.setLabel("马丹我是基线，也可以叫我水位线");
        //设置限制线为虚线
        limitLine.enableDashedLine(10f, 10f, 0f);
        //=================设置左边Y轴===============
        YAxis axisLeft = MPTemperature.getAxisLeft();
        //左边Y轴添加限制线
        axisLeft.addLimitLine(limitLine);
        //是否启用左边Y轴
        axisLeft.setEnabled(true);
        //设置最小值（这里就按demo里固死的写）
        axisLeft.setAxisMinimum(0);
        //设置最大值（这里就按demo里固死的写了）
        axisLeft.setAxisMaximum(50);
        //设置横向的线为虚线
        axisLeft.enableGridDashedLine(10f, 10f, 0f);
        //axisLeft.setDrawLimitLinesBehindData(true);
        //====================设置右边的Y轴===============
        YAxis axisRight = MPTemperature.getAxisRight();
        //是否启用右边Y轴
        axisRight.setEnabled(false);
        //设置最小值（这里按demo里的数据固死写了）
        axisRight.setAxisMinimum(0);
        //设置最大值（这里按demo里的数据固死写了）
        axisRight.setAxisMaximum(100);
        //设置横向的线为虚线
        axisRight.enableGridDashedLine(10f, 10f, 0f);

    }


    //设置数据
    private void initElectricalLineData() {
        List<ILineDataSet> dataSets = new ArrayList<>();

        int[] LineColor= {Color.RED,Color.BLUE,Color.YELLOW,Color.GREEN};
        for (int i = 0; i < 4; i++) {
            //每个点的坐标,自己随便搞点（x,y）坐标就可以了
            ArrayList<Entry> pointValues = new ArrayList<>();
            Log.e("abc", "initData: ===>"+pointValues.size() );
            for (int j = 0; j < 24; j++) {
                int y = (int)( Math.random() * 20);
                pointValues.add(new Entry(j, y));
            }
            //点构成的某条线
            LineDataSet lineDataSet = new LineDataSet(pointValues, "该线标签");
            //设置该线的颜色
            lineDataSet.setColor(LineColor[i]);
            //设置每个点的颜色
            lineDataSet.setCircleColor(Color.GRAY);
            //设置该线的宽度
            lineDataSet.setLineWidth(1f);
            //设置每个坐标点的圆大小
            lineDataSet.setCircleRadius(1f);
            //设置是否画圆
            lineDataSet.setDrawCircles(true);
            // 设置平滑曲线模式
            //  lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            //设置线一面部分是否填充颜色
            lineDataSet.setDrawFilled(true);
            //设置填充的颜色
            lineDataSet.setFillColor(Color.WHITE);
            //设置是否显示点的坐标值
            lineDataSet.setDrawValues(false);
            //线的集合（可单条或多条线）
            dataSets.add(lineDataSet);
        }


        //把要画的所有线(线的集合)添加到LineData里
        LineData lineData = new LineData(dataSets);
        //把最终的数据setData
        MPElectrical.setData(lineData);
        MPTemperature.setData(lineData);

    }



}
