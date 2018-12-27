package com.pthlab.kaungmyat.vsda.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.pthlab.kaungmyat.vsda.R;

import java.util.ArrayList;
import java.util.List;

public class Result extends AppCompatActivity {
    BarChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        chart = findViewById(R.id.chart);

        setBarDatas();
    }

    private void setBarDatas() {
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 30f ,"Shrimp"));
        entries.add(new BarEntry(1f, 80f,"Rice"));


        chart.getAxisLeft().setDrawLabels(false);
        chart.getAxisRight().setDrawLabels(false);
        chart.getXAxis().setDrawLabels(false);

        chart.getDescription().setEnabled(false);

        BarDataSet set = new BarDataSet(entries, "BarDataSet");

        BarData data = new BarData(set);
        data.setBarWidth(0.5f); // set custom bar width

        set.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return entry.getData().toString();

            }
        });


        chart.setData(data);
        chart.setFitBars(true); // make the x-axis fit exactly all bars
        chart.animateXY(1000, 1500);
        chart.invalidate();
    }
}
