/*
 * Copyright (c) 2020. created by suraj kumar
 */

package com.urk17cs290.banker.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;
import com.urk17cs290.banker.R;
import com.urk17cs290.banker.entities.Account;
import com.urk17cs290.banker.viewmodels.AccountViewModel;

public class CheckBalance extends AppCompatActivity {
    TextView setBalance;
    Button checkBalance;
    SharedPreferences myprefs;
    SharedPreferences.Editor editor;
    int password;
    Boolean isLoggedin;
    int accountNumber;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_balance);
        setBalance = findViewById(R.id.showBalance); // textview

        checkBalance = findViewById(R.id.check_balance_button); // button
        isLoggedin = myprefs.getBoolean("isLoggedin",false);
        accountNumber = myprefs.getInt("accountNumber",000000);
        password = myprefs.getInt("password",000);
        intent = new Intent(getApplicationContext(),Login.class);
        checkBalance.setOnClickListener(view -> {
            /*TODO
             * get balance
             * set as a string
             * */
            if(isLoggedin){
                /*TODO
                 * diplay a toast debited successfully
                 * update to database
                 * */


                AccountViewModel accountViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(AccountViewModel.class);
                LiveData<Account> account = accountViewModel.search(accountNumber);
                Log.e("TAG", "onCreate: accounts " + account.getValue());

            }else{
                Toast.makeText(this, "Login again", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }


        });
    }
}
