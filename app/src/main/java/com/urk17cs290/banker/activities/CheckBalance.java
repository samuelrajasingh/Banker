/*
 * Copyright (c) 2020. created by suraj kumar
 */

package com.urk17cs290.banker.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.urk17cs290.banker.R;

public class CheckBalance extends AppCompatActivity {
    TextView setBalance;
    Button checkBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_balance);
        setBalance = findViewById(R.id.showBalance); // textview
        checkBalance = findViewById(R.id.check_balance_button); // button
        checkBalance.setOnClickListener(view -> {
            /*TODO
             * get balance
             * set as a string
             * */
        });
    }
}
