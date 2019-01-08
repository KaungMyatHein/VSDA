package com.pthlab.kaungmyat.vsda.Activity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

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
import com.pthlab.kaungmyat.vsda.Database.DatabaseHelper;
import com.pthlab.kaungmyat.vsda.Entity.Plant;
import com.pthlab.kaungmyat.vsda.Entity.PostPlant;
import com.pthlab.kaungmyat.vsda.Entity.Preplant;
import com.pthlab.kaungmyat.vsda.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Result extends AppCompatActivity {
    private BarChart chart;
    private DatabaseHelper dbhelper;
    private SQLiteDatabase db;
    private  Intent i;
    private float probability_of_shrimp_faliure;
    private float probability_of_rice_faliure;
    private Preplant preplant;
    private Plant plant;
    private PostPlant postPlant;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        chart = findViewById(R.id.chart);
        i = getIntent();
        int type = i.getIntExtra("type",0);
        dbhelper = new DatabaseHelper(getBaseContext());
        Log.d("Arrive",type+"");
        getDatasFromDb(type);
        setBarDatas();
    }

    private void getDatasFromDb(int type) {
        switch (type)
        {
            case 1:
                bundle = i.getExtras();
                preplant = (Preplant) bundle.getSerializable("value");
                probability_of_rice_faliure =  dbhelper.getPreplantRiceFaliureRate(preplant);
                //Log.d("Arrive",probability_of_rice_faliure+"");
                probability_of_shrimp_faliure = dbhelper.getPreplantShrimpFaliureRate(preplant);
                break;
            case 2 :
                bundle = i.getExtras();
                plant = (Plant) bundle.getSerializable("value");
                probability_of_rice_faliure =  dbhelper.getPlantRiceFaliureRate(plant);
                //Log.d("Arrive",probability_of_rice_faliure+"");
                probability_of_shrimp_faliure = dbhelper.getPlantShrimpFaliureRate(plant);
                break;
            case 3 :
                bundle = i.getExtras();
                postPlant = (PostPlant) bundle.getSerializable("value");
                probability_of_rice_faliure =  dbhelper.getPostPlantRiceFaliureRate(postPlant);
                //Log.d("Arrive",probability_of_rice_faliure+"");
                probability_of_shrimp_faliure = dbhelper.getPostPlantShrimpFaliureRate(postPlant);
                break;
        }

    }

    private void setBarDatas() {

        dbhelper = new DatabaseHelper(this);
        db = dbhelper.openDatabase();

        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 1-probability_of_rice_faliure ,"Shrimp =" + (1-probability_of_shrimp_faliure)));
        entries.add(new BarEntry(1f, 1-probability_of_rice_faliure,"Rice = " + (1-probability_of_rice_faliure)));


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
