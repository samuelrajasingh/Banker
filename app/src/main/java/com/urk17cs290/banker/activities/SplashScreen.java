package com.urk17cs290.banker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.urk17cs290.banker.MainActivity;
import com.urk17cs290.banker.R;

public class SplashScreen extends AppCompatActivity {
  public static String user_or_admin = "";
  Intent myintent1, myintent2;
  Button b1, b2;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash_screen);
    myintent1 = new Intent(getApplicationContext(), MainActivity.class);
    b1 = findViewById(R.id.containedButton1);
    b2 = findViewById(R.id.containedButton2);

    b1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            user_or_admin = "admin";
            startActivity(myintent1); // change
          }
        });
    b2.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            user_or_admin = "user";
            startActivity(myintent1); // change
          }
        });
  }
}
