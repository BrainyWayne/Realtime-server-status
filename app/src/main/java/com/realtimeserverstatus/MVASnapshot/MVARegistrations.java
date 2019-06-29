package com.realtimeserverstatus.MVASnapshot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.realtimeserverstatus.R;

public class MVARegistrations extends AppCompatActivity {

    LinearLayout layout2016, layout2017,layout2018,layout2019;
    String gottenMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvaregistrations);

        gottenMenu = getIntent().getStringExtra("menu");
        layout2016 = findViewById(R.id.year2016_layout);
        layout2017 = findViewById(R.id.year2017_layout);
        layout2018 = findViewById(R.id.year2018_layout);
        layout2019 = findViewById(R.id.year2019_layout);


        layout2016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MvaMonthly.class);
                intent.putExtra("menu", gottenMenu);
                intent.putExtra("year", "2016");

                startActivity(intent);
            }
        });

        layout2017.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MvaMonthly.class);
                intent.putExtra("menu", gottenMenu);
                intent.putExtra("year", "2017");

                startActivity(intent);
            }
        });

        layout2018.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MvaMonthly.class);
                intent.putExtra("menu", gottenMenu);
                intent.putExtra("year", "2018");

                startActivity(intent);
            }
        });

        layout2019.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MvaMonthly.class);
                intent.putExtra("menu", gottenMenu);
                intent.putExtra("year", "2019");

                startActivity(intent);
            }
        });

    }
}