package com.realtimeserverstatus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.realtimeserverstatus.MVASnapshot.MVAHomePage;
import com.realtimeserverstatus.ServerStatus.HomePage;

public class LoginSuccess extends AppCompatActivity {

    private static final String MY_PREFS_NAME = "com.realtimeservicestatus";
    private TextView username;
    private TextView hi, welcome;
    private RelativeLayout mainContent;
    SharedPreferences.Editor editor;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_success);
        username = findViewById(R.id.username);
        mainContent = findViewById(R.id.main_content);


        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();

        String name = getIntent().getStringExtra("username");

        TransitionManager.beginDelayedTransition(mainContent);
        username.setText(name + "!");

        editor.putString("username", name);
        editor.apply();


        logo = findViewById(R.id.logo);

        findViewById(R.id.btnProceed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomePage.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(LoginSuccess.this, logo, "logo");
                startActivity(intent, options.toBundle());
            }
        });

        findViewById(R.id.btnMVA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MVAHomePage.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(LoginSuccess.this, logo, "logo");
                startActivity(intent, options.toBundle());
            }
        });

    }
}
