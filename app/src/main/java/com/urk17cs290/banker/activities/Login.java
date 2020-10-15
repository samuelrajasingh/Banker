/*
 * Copyright (c) 2020. Created by Rajasingh Samuel.
 */

package com.urk17cs290.banker.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.urk17cs290.banker.MainActivity;
import com.urk17cs290.banker.R;

import java.util.Objects;

public class Login extends AppCompatActivity {
    TextInputLayout editText_name, editText_password;
    Button b;
    Intent intent;
    String email;
    int password;
    Boolean isLoggedin;
    int accountNumber;
    SharedPreferences myprefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText_name = findViewById(R.id.text_view_account_name2);
        editText_password = findViewById(R.id.text_view_account_password2);
        b = findViewById(R.id.button_login2);
        intent = new Intent(getApplicationContext(), MainActivity.class);
        myprefs = getSharedPreferences("myprefs", MODE_PRIVATE);//shared preference
        editor = myprefs.edit();//editor for shared preference
        isLoggedin = false;
        b.setOnClickListener(view -> {

            email = Objects.requireNonNull(editText_name.getEditText()).getText().toString();//email
            String p = Objects.requireNonNull(editText_password.getEditText()).getText().toString();


            try {
                password = Integer.parseInt(p);//password


            } catch (Exception e) {
            }
            /* todo
             * get data from database and match and if true, then store in shared preference
             * */
            if (accountNumber==0 && password == 1234 && !isLoggedin) {
                isLoggedin = true;
//                editor.putString("email",email);
                editor.putInt("password", password);
                editor.putBoolean("isLoggedin", isLoggedin);
                editor.putInt("accountNumber", accountNumber);
                editor.apply();
                Log.i("boolean",isLoggedin.toString());
                startActivity(intent);


            } else {
                Toast.makeText(Login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }


        });
    }
}






