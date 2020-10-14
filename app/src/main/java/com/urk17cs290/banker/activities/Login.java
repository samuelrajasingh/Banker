/*
 * Copyright (c) 2020. Created by Rajasingh Samuel.
 */

package com.urk17cs290.banker.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.urk17cs290.banker.R;

public class Login extends AppCompatActivity {
    TextInputLayout editText_name, editText_password;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText_name = findViewById(R.id.text_view_account_name2);
        editText_password = findViewById(R.id.text_view_account_password2);
        b = findViewById(R.id.button_login2);
        b.setOnClickListener(view -> {
            int accountNumber = Integer.parseInt(editText_name.getEditText().getText().toString());//account number
            int pass = Integer.parseInt(editText_password.getEditText().getText().toString());//password
            Log.e("TAG", "account number : "+accountNumber );
            Log.e("TAG", "password : "+pass );
        });
    }
}