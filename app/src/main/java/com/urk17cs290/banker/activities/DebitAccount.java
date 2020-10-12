package com.urk17cs290.banker.activities;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.urk17cs290.banker.R;

public class DebitAccount extends AppCompatActivity {
    Button b;
    TextInputLayout input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit_account);
        b = findViewById(R.id.debitButton);
        input = findViewById(R.id.debit);
        b.setOnClickListener(view -> {
            /*TODO
             * diplay a toast debited successfully
             * update to database
             * */
            finish();
        });
    }
}
