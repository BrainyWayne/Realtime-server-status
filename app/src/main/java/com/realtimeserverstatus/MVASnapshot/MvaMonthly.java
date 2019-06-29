package com.realtimeserverstatus.MVASnapshot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.realtimeserverstatus.MVASnapshot.MvaAdapters.MvaMonthlyAdapter;
import com.realtimeserverstatus.MVASnapshot.MvaUtil.MvaModels;
import com.realtimeserverstatus.R;
import com.realtimeserverstatus.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

public class MvaMonthly extends AppCompatActivity {

    TextView title, currentPath;
    RecyclerView recyclerView;
    MvaMonthlyAdapter mvaMonthlyAdapter;
    private List<MvaModels> mvaModelsList = new ArrayList<>();
    String gottenYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mva_monthly);

        gottenYear =  getIntent().getStringExtra("year");

        setYearTitle();
        setCurrentPath();


        recyclerView = findViewById(R.id.recycler_view);

        mvaMonthlyAdapter = new MvaMonthlyAdapter(mvaModelsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mvaMonthlyAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                MvaModels mvaModels = mvaModelsList.get(position);
                openWeekly(mvaModels.getYear());
            }

            private void openWeekly(String year) {
                Intent intent = new Intent(getApplicationContext(), MvaWeekly.class);
                intent.putExtra("menu", getIntent().getStringExtra("menu"));
                intent.putExtra("year", gottenYear);
                intent.putExtra("month", year);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        loadMonths();
    }

    private void loadMonths() {
        MvaModels mvaModels = new MvaModels("January", 69874);
        mvaModelsList.add(mvaModels);

        mvaModels = new MvaModels("Febuary", 54541);
        mvaModelsList.add(mvaModels);

        mvaModels = new MvaModels("March", 54541);
        mvaModelsList.add(mvaModels);

        mvaModels = new MvaModels("April", 54541);
        mvaModelsList.add(mvaModels);

        mvaModels = new MvaModels("May", 54541);
        mvaModelsList.add(mvaModels);

        mvaModels = new MvaModels("June", 54541);
        mvaModelsList.add(mvaModels);

        mvaModels = new MvaModels("July", 54541);
        mvaModelsList.add(mvaModels);

        mvaModels = new MvaModels("August", 54541);
        mvaModelsList.add(mvaModels);

        mvaModels = new MvaModels("September", 54541);
        mvaModelsList.add(mvaModels);

        mvaModels = new MvaModels("October", 54541);
        mvaModelsList.add(mvaModels);

        mvaModels = new MvaModels("November", 54541);
        mvaModelsList.add(mvaModels);

        mvaModels = new MvaModels("December", 54541);
        mvaModelsList.add(mvaModels);


        mvaMonthlyAdapter.notifyDataSetChanged();


}




    private void setCurrentPath() {
        currentPath = findViewById(R.id.current_path);
        currentPath.setText(getIntent().getStringExtra("menu") + " / " + getIntent().getStringExtra("year"));
    }

    private void setYearTitle() {
        title = findViewById(R.id.title);
        title.setText("Year " + gottenYear);
    }
}
