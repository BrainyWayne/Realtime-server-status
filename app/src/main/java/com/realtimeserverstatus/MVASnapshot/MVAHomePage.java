package com.realtimeserverstatus.MVASnapshot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.realtimeserverstatus.R;

public class MVAHomePage extends AppCompatActivity {

    RelativeLayout mvaRegistrations, mvaNewRegistratons, mvaServices, mvaNewServices;
    RelativeLayout mvaUniqueVisitors, mvaTotalVisitors, mvaRevenue, mvaTransactions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvahome_page);

        mvaRegistrations = findViewById(R.id.registrations_layout);
        mvaNewRegistratons = findViewById(R.id.new_registrations_layout);
        mvaServices = findViewById(R.id.services_layout);
        mvaNewServices = findViewById(R.id.new_services_layout);
        mvaUniqueVisitors = findViewById(R.id.unique_visitors_layout);
        mvaTotalVisitors = findViewById(R.id.total_visitors_visitors);
        mvaRevenue = findViewById(R.id.revenue_layout);
        mvaTransactions = findViewById(R.id.transactionss_layout);


        //Starting Registrations activity
        mvaRegistrations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MVARegistrations.class);
                intent.putExtra("menu", "Registration");
                startActivity(intent);
            }
        });

        mvaNewRegistratons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MVARegistrations.class);
                intent.putExtra("menu", "New Registration");
                startActivity(intent);
            }
        });

        mvaServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MVARegistrations.class);
                intent.putExtra("menu", "Services");
                startActivity(intent);
            }
        });

        mvaNewServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MVARegistrations.class);
                intent.putExtra("menu", "New Services");
                startActivity(intent);
            }
        });

        mvaUniqueVisitors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MVARegistrations.class);
                intent.putExtra("menu", "Unique Visitors");
                startActivity(intent);
            }
        });

        mvaTransactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MVARegistrations.class);
                intent.putExtra("menu", "Transactions");
                startActivity(intent);
            }
        });

        mvaTotalVisitors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MVARegistrations.class);
                intent.putExtra("menu", "Total Visitors");
                startActivity(intent);
            }
        });

        mvaRevenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MVARegistrations.class);
                intent.putExtra("menu", "Revenue");
                startActivity(intent);
            }
        });


    }
}
