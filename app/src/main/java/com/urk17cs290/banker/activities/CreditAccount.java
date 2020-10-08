package com.urk17cs290.banker.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.urk17cs290.banker.MainActivity;
import com.urk17cs290.banker.R;

public class CreditAccount extends AppCompatActivity {
    Button b;
    EditText input;
        Intent myintent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_account);
        b = findViewById(R.id.creditButton);
        input = findViewById(R.id.credit);
        myintent =  new Intent(getApplicationContext(), MainActivity.class);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String creditAmount = input.getText().toString();
                /*
                * add credit to respective account balance
                * */
                startActivity(myintent);
            }
        });
    }
}