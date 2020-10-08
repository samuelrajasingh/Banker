package com.urk17cs290.banker.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.urk17cs290.banker.R;

public class SplashScreen extends AppCompatActivity {
Intent myintent;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash_screen);
    myintent = new Intent(getApplicationContext(),display.class);
  }
}
