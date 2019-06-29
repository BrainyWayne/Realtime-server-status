package com.realtimeserverstatus.ServerStatus;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.realtimeserverstatus.R;

import java.util.ArrayList;
import java.util.List;

public class ServerDetails extends AppCompatActivity {

    private TextView name, description;
    PieChart cpuPie, memoryPie;
    int usedCpu, usedMemory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_details);

        name = findViewById(R.id.servername);
        description = findViewById(R.id.serverdescription);





        name.setText(getIntent().getStringExtra("name"));
        description.setText(getIntent().getStringExtra("description"));
        /*cpu.setText("cpu: " + getIntent().getIntExtra("cpu",0) + "%");
        memory.setText(getIntent().getStringExtra("memory"));
        pingStatus.setText(getIntent().getStringExtra("pingstatus"));
*/




        cpuPie = findViewById(R.id.cpu_pie);
        memoryPie = findViewById(R.id.memory_pie);
        setPieChart();




        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    private void setPieChart() {

        int total = 100;
        usedCpu = getIntent().getIntExtra("cpu",0);
        int unusedCpu = total - usedCpu;


        cpuPie.setUsePercentValues(true);
        cpuPie.getDescription().setEnabled(true);
        cpuPie.setExtraOffsets(5, 10, 5, 5);
        cpuPie.setDragDecelerationFrictionCoef(0.9f);
        cpuPie.setTransparentCircleRadius(61f);
        cpuPie.setCenterText("CPU Usage");
        cpuPie.setHoleColor(Color.WHITE);
        cpuPie.animateY(1000, Easing.EaseInBack);


        ArrayList<PieEntry> cpuyValues = new ArrayList<>();
        cpuyValues.add(new PieEntry(usedCpu, "Used"));
        cpuyValues.add(new PieEntry(unusedCpu, "Unused"));

        PieDataSet cpudataSet = new PieDataSet(cpuyValues, "CPU Usage");
        cpudataSet.setSliceSpace(3f);
        cpudataSet.setSelectionShift(9f);
        cpudataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData cpupieData = new PieData((cpudataSet));
        cpupieData.setValueTextSize(10f);
        cpupieData.setValueTextColor(Color.YELLOW);
        cpuPie.setData(cpupieData);


        usedMemory = getIntent().getIntExtra("memory",0);
        int unUsedMemory = total - usedMemory;

        memoryPie.setUsePercentValues(true);
        memoryPie.getDescription().setEnabled(true);
        memoryPie.setExtraOffsets(5, 10, 5, 5);
        memoryPie.setDragDecelerationFrictionCoef(0.9f);
        memoryPie.setTransparentCircleRadius(61f);
        memoryPie.setCenterText("Memory Usage");
        memoryPie.setHoleColor(Color.WHITE);
        memoryPie.animateY(1000, Easing.EaseInBack);

        ArrayList<PieEntry> memoryyValues = new ArrayList<>();
        memoryyValues.add(new PieEntry(usedMemory, "Used"));
        memoryyValues.add(new PieEntry(unUsedMemory, "Unused"));

        PieDataSet memorydataSet = new PieDataSet(memoryyValues, "Memory Usage");
        memorydataSet.setSliceSpace(3f);
        memorydataSet.setSelectionShift(5f);
        memorydataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData memorypieData = new PieData((memorydataSet));
        memorypieData.setValueTextSize(10f);
        memorypieData.setValueTextColor(Color.YELLOW);
        memoryPie.setData(memorypieData);
    }
}
