/*
 * Copyright (c) 2020. created by suraj kumar
 */

package com.urk17cs290.banker.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;
import com.urk17cs290.banker.R;
import com.urk17cs290.banker.entities.Account;
import com.urk17cs290.banker.viewmodels.AccountViewModel;

public class CheckBalance extends AppCompatActivity {
    TextView setBalance;
    Button checkBalance;
    TextInputLayout ac,pass;
    Button b;
    SharedPreferences myprefs;
    SharedPreferences.Editor editor;
    int password;
    Boolean isLoggedin;
    long accountNumber;
    private AccountViewModel accountViewModel;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_balance);
        myprefs = getSharedPreferences("myprefs",MODE_PRIVATE);
        editor =  myprefs.edit();//ac number and pin number
        setBalance = findViewById(R.id.showBalance); // textview
        ac = findViewById(R.id.enter_acnumber);//ac number
        pass = findViewById(R.id.enter_pin);
        checkBalance = findViewById(R.id.check_balance_button); // button
        isLoggedin = myprefs.getBoolean("isLoggedin",false);
        accountNumber = myprefs.getLong("accountNumber",000000);
        password = myprefs.getInt("password",000);
        intent = new Intent(getApplicationContext(),Login.class);

        checkBalance.setOnClickListener(view -> {

           if(isLoggedin){
               if(accountNumber == Long.parseLong(ac.getEditText().getText().toString()) && password == Integer.parseInt(pass.getEditText().getText().toString())){
                   /*
                   * fetch balance from datbase for the specified account   Number
                   * */
                   setBalance.setText("5.00");
               }else{
                   Toast.makeText(this, "Invalid account number or Pin", Toast.LENGTH_SHORT).show();
                   setBalance.setText("0.00");
               }
           }else{
               Toast.makeText(this, "Login again", Toast.LENGTH_SHORT).show();
               startActivity(intent);
           }


        });
    }
}
