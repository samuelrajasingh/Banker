package com.urk17cs290.banker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.urk17cs290.banker.MainActivity;
import com.urk17cs290.banker.R;

public class CreditAccount extends AppCompatActivity {
    Button b;
    TextInputLayout input;
    Intent myintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_account);
        b = findViewById(R.id.creditButton);
        input = findViewById(R.id.credit);
        myintent = new Intent(getApplicationContext(), MainActivity.class);
        b.setOnClickListener(view -> {
            /*TODO
             * diplay a toast credited successfully
             * update to database
             * */
            startActivity(myintent);
        });
    }
}
