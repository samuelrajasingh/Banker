package com.urk17cs290.banker.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.urk17cs290.banker.R;

public class CheckBalance extends AppCompatActivity {
    TextView setBalance;
    Button checkBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_balance);
       setBalance = findViewById(R.id.showBalance); //textview
       checkBalance = findViewById(R.id.check_balance_button);//button
       checkBalance.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               /*TODO
               * get balance
               * set as a string
               * */
           }
       });


    }
}