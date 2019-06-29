package com.realtimeserverstatus.MVASnapshot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.realtimeserverstatus.MVASnapshot.MvaAdapters.MvaDailyAdapter;
import com.realtimeserverstatus.MVASnapshot.MvaUtil.MvaModels;
import com.realtimeserverstatus.R;
import com.realtimeserverstatus.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

public class MvaDaily extends AppCompatActivity {
    
    TextView title, currentPath;
    RecyclerView recyclerView;
    MvaDailyAdapter mvaDailyAdapter;
    private List<MvaModels> mvaModelsList = new ArrayList<>();
    String gottenYear, gottenMonth, gottenMenu, gottenWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mva_daily);

        gottenYear = getIntent().getStringExtra("year");
        gottenMonth = getIntent().getStringExtra("month");
        gottenMenu = getIntent().getStringExtra("menu");
        gottenWeek = getIntent().getStringExtra("week");
        setYearTitle();
        setCurrentPath();


        recyclerView = findViewById(R.id.recycler_view);

        mvaDailyAdapter = new MvaDailyAdapter(mvaModelsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mvaDailyAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                MvaModels mvaModels = mvaModelsList.get(position);
                openWeekly(mvaModels.getYear());
            }

            private void openWeekly(String year) {
                /*Intent intent = new Intent(getApplicationContext(), MvaWeekly.class);
                intent.putExtra("menu", gottenMenu);
                intent.putExtra("year", gottenYear);
                intent.putExtra("month", year);
                startActivity(intent);*/
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        loadWeeks();
    }

    private void loadWeeks() {
        MvaModels mvaModels = new MvaModels("Day 1", 69874);
        mvaModelsList.add(mvaModels);

        mvaModels = new MvaModels("Day 2", 54541);
        mvaModelsList.add(mvaModels);


        mvaModels = new MvaModels("Day 3", 54541);
        mvaModelsList.add(mvaModels);

        mvaModels = new MvaModels("Day 4", 54541);
        mvaModelsList.add(mvaModels);

        mvaModels = new MvaModels("Day 5", 54541);
        mvaModelsList.add(mvaModels);

        mvaModels = new MvaModels("Day 6", 54541);
        mvaModelsList.add(mvaModels);

        mvaModels = new MvaModels("Day 7", 54541);
        mvaModelsList.add(mvaModels);



        mvaDailyAdapter.notifyDataSetChanged();


    }




    private void setCurrentPath() {
        currentPath = findViewById(R.id.current_path);
        currentPath.setText(gottenMenu+ " / " + gottenYear + " / " + gottenMonth + " / " + gottenWeek);
    }

    private void setYearTitle() {
        title = findViewById(R.id.title);
        title.setText(gottenMonth);
    }
}
