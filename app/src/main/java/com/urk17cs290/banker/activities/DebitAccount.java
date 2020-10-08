package com.urk17cs290.banker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.urk17cs290.banker.MainActivity;
import com.urk17cs290.banker.R;

public class DebitAccount extends AppCompatActivity {
  Button b ;
  EditText input;
  Intent myintent;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_debit_account);
    b = findViewById(R.id.debitButton);
    input = findViewById(R.id.debit);
    myintent = new Intent(getApplicationContext(), MainActivity.class);
    b.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        /*TODO
         * diplay a toast debited successfully
         * update to database
         * */
        startActivity(myintent);
      }
    });
  }
}
