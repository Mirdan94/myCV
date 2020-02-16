package com.example.test_aleksandr_month.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.test_aleksandr_month.App;
import com.example.test_aleksandr_month.R;
import com.example.test_aleksandr_month.ui.main.MainActivity;
import com.example.test_aleksandr_month.ui.onboard.OnBoardActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashStart();
    }

    private void splashStart() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(SplashActivity.this, OnBoardActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, 1500);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
