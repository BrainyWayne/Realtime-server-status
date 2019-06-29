package com.realtimeserverstatus;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUserName;
    private LinearLayout entriesLayout;
    private RelativeLayout mainContent;
    private Button btnLogin;
    private EditText editTextPassword;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUserName = findViewById(R.id.editTextUsername);
        entriesLayout = findViewById(R.id.entriesLayout);
        mainContent = findViewById(R.id.main_content);
        btnLogin = findViewById(R.id.btnLogin);
        editTextPassword = findViewById(R.id.editTextPassword);
        logo = findViewById(R.id.logo);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TransitionManager.beginDelayedTransition(mainContent);
                entriesLayout.setVisibility(View.VISIBLE);
            }
        }, 2000);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), LoginSuccess.class);
                intent.putExtra("username", editTextUserName.getText().toString().trim());
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(MainActivity.this, logo, "logo");
                startActivity(intent, options.toBundle());

            }
        });

    }

}


