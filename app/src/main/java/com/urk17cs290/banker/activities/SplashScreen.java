package com.urk17cs290.banker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.urk17cs290.banker.MainActivity;
import com.urk17cs290.banker.R;

public class SplashScreen extends AppCompatActivity {
    public static boolean isAdmin = false;
    Intent intent,loginIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        intent = new Intent(getApplicationContext(), MainActivity.class);
        loginIntent = new Intent(getApplicationContext(),Login.class);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_admin:
                isAdmin = true;
                startActivity(intent);
                break;
            case R.id.button_user:
                isAdmin = false;
                startActivity(loginIntent);
                break;
            default:
                break;
        }
    }
}
