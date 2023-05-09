package com.example.sleepy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    ArrayList barArrayList;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        BarChart barChart = findViewById(R.id.bar_chart);
        getData();
        BarDataSet barDataSet = new BarDataSet(barArrayList, "Days of the Week");
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);
        barChart.getDescription().setEnabled(true);

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();
            }
        });
    }

    private void getData()
        {

            Bundle bundle = getIntent().getExtras();
            int monday = Integer.parseInt(bundle.get("monday").toString());
            int tuesday = Integer.parseInt(bundle.get("tuesday").toString());
            int wednesday = Integer.parseInt(bundle.get("wednesday").toString());
            int thursday = Integer.parseInt(bundle.get("thursday").toString());
            int friday = Integer.parseInt(bundle.get("friday").toString());
            int saturday = Integer.parseInt(bundle.get("saturday").toString());
            int sunday = Integer.parseInt(bundle.get("sunday").toString());

            barArrayList = new ArrayList<>();
            barArrayList.add(new BarEntry(0, monday));
            barArrayList.add(new BarEntry(1, tuesday));
            barArrayList.add(new BarEntry(2, wednesday));
            barArrayList.add(new BarEntry(3, thursday));
            barArrayList.add(new BarEntry(4, friday));
            barArrayList.add(new BarEntry(5, saturday));
            barArrayList.add(new BarEntry(6, sunday));

            BarDataSet barDataSet = new BarDataSet(barArrayList, "Weekly Data");
            BarData barData = new BarData(barDataSet);

            BarChart barChart = findViewById(R.id.bar_chart);

            XAxis xAxis = barChart.getXAxis();
            xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"}));

            barChart.setData(barData);
            barChart.invalidate();
        }

    public void openActivity1() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}