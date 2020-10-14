/*
 * Copyright (c) 2020. Created by Rajasingh Samuel.
 */

package com.urk17cs290.banker.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.urk17cs290.banker.R;

public class Login extends AppCompatActivity {
TextInputLayout editText_name,editText_password;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText_name = findViewById(R.id.text_view_account_name2);
        editText_password = findViewById(R.id.text_view_account_password2);
        b = findViewById(R.id.button_login2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String email = editText_name.getEditText().toString();//email
            String p = editText_password.getEditText().toString();
            int password = Integer.parseInt(p);//password
            }
        });
    }
}