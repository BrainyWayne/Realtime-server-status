package com.realtimeserverstatus.ServerStatus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.realtimeserverstatus.R;
import com.realtimeserverstatus.RecyclerTouchListener;
import com.realtimeserverstatus.ServerStatus.models.Server;
import com.realtimeserverstatus.ServerStatus.models.ServerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {

    private static final String MY_PREFS_NAME = "com.realtimeservicestatus";
    SharedPreferences prefs;
    RecyclerView recyclerView;
    ServerAdapter serverAdapter;
    private TextView username;
    private List<Server> serverList = new ArrayList<>();
    private LinearLayout topLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        username = findViewById(R.id.username);
        recyclerView = findViewById(R.id.recycler_view);
        topLinear = findViewById(R.id.topLinear);
        prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);

        username.setText(prefs.getString("username", ""));


        recyclerView = findViewById(R.id.recycler_view);

        serverAdapter = new ServerAdapter(serverList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(serverAdapter);

        loadServers();
        findViewById(R.id.logo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPieActivity();
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Server server = serverList.get(position);
                openServerDetails(server.getName(), server.getDescription(), server.getCpu(), server.getMemory(), server.getPingstatus());
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


    }

    private void openPieActivity() {
        startActivity(new Intent(getApplicationContext(), PieChartActivity.class));
    }

    private void loadServers() {

        for (int i = 1; i <= 15; i++) {
            Server server = new Server("Server " + i, "Server " + i + " handles " + i + " stuff.", i * 10 / 4, i * 9, i / 9);
            serverList.add(server);
        }

        serverAdapter.notifyDataSetChanged();
    }

    private void openServerDetails(String name, String description, int cpu, int memory, int pingstatus) {


        Intent intent = new Intent(getApplicationContext(), ServerDetails.class);
        intent.putExtra("name", name);
        intent.putExtra("description", description);
        intent.putExtra("cpu", cpu);
        intent.putExtra("memory", memory);
        intent.putExtra("pingstatus", pingstatus);
        startActivity(intent);
    }
}
