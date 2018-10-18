package com.jawg.electricalshow.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jawg.electricalshow.R;
import com.jawg.electricalshow.view.PingFangTextView;
import com.tubb.calendarselector.library.CalendarSelector;
import com.tubb.calendarselector.library.FullDay;
import com.tubb.calendarselector.library.IntervalSelectListener;
import com.tubb.calendarselector.library.MonthView;
import com.tubb.calendarselector.library.SCDateUtils;
import com.tubb.calendarselector.library.SCMonth;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CalendarSelectorActivity extends AppCompatActivity {

    private static final String TAG = "mv";

    CalendarSelector selector;
    RecyclerView rvCalendar;
    List<SCMonth> data;
    @BindView(R.id.btn_back)
    ImageButton btnBack;
    @BindView(R.id.tv_title)
    PingFangTextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        ButterKnife.bind(this);
        if (savedInstanceState != null)
            selector = savedInstanceState.getParcelable("selector");
        rvCalendar = (RecyclerView) findViewById(R.id.rvCalendar);
        rvCalendar.setLayoutManager(new LinearLayoutManager(this));
        ((SimpleItemAnimator) rvCalendar.getItemAnimator()).setSupportsChangeAnimations(false);
        data = getData();
//        segmentMode();
        intervalMode();

        tvTitle.setText("日期");
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

    }

    /**
     * segment mode 选择一段时间 时间段
     */


    /**
     * interval mode 选择 时间点
     */
    private void intervalMode() {
        data = getData();
        selector = new CalendarSelector(data, CalendarSelector.INTERVAL);
//        selector.addSelectedInterval(new ArrayList<FullDay>(){
//            {
////                add(new FullDay(2016, 2, 4));
////                add(new FullDay(2016, 3, 4));
////                add(new FullDay(2016, 3, 5));
////                add(new FullDay(2016, 4, 4));
//            }
//        });
        selector.setIntervalSelectListener(new IntervalSelectListener() {
            @Override
            public void onIntervalSelect(List<FullDay> selectedDays) {


                Intent intent = new Intent();
                intent.putExtra("selectListYear", selectedDays.get(0).getYear());
                intent.putExtra("selectListMonth", selectedDays.get(0).getMonth());
                intent.putExtra("selectListDay", selectedDays.get(0).getDay());

                setResult(2, intent);

                finish();

            }

            @Override
            public boolean onInterceptSelect(List<FullDay> selectedDays, FullDay selectingDay) {
                if (selectedDays.size() > 1) {
                    Toast.makeText(CalendarSelectorActivity.this, "Selected days can't more than 1", Toast.LENGTH_LONG).show();
                    return true;
                }
                return super.onInterceptSelect(selectedDays, selectingDay);
            }
        });
        rvCalendar.setAdapter(new CalendarAdpater(data));
    }

    public List<SCMonth> getData() {
        return SCDateUtils.generateMonths(2018, 2020, SCMonth.SUNDAY_OF_WEEK);
    }

    class CalendarAdpater extends RecyclerView.Adapter<CalendarViewHolder> {

        List<SCMonth> months;

        public CalendarAdpater(List<SCMonth> months) {
            this.months = months;
        }

        @Override
        public CalendarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new CalendarViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_calendar, parent, false));
        }

        @Override
        public void onBindViewHolder(CalendarViewHolder holder, int position) {
            SCMonth scMonth = months.get(position);
            holder.tvMonthTitle.setText(String.format("%d-%d", scMonth.getYear(), scMonth.getMonth()));
            holder.monthView.setSCMonth(scMonth);
            selector.bind(rvCalendar, holder.monthView, position);
        }

        @Override
        public int getItemCount() {
            return months.size();
        }
    }

    class CalendarViewHolder extends RecyclerView.ViewHolder {

        TextView tvMonthTitle;
        MonthView monthView;

        public CalendarViewHolder(View itemView) {
            super(itemView);
            tvMonthTitle = (TextView) itemView.findViewById(R.id.tvMonthTitle);
            monthView = (MonthView) itemView.findViewById(R.id.ssMv);
        }
    }


}
