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
import androidx.lifecycle.ViewModelProvider;

import com.urk17cs290.banker.R;
import com.urk17cs290.banker.entities.Account;
import com.urk17cs290.banker.viewmodels.AccountViewModel;

public class CheckBalance extends AppCompatActivity {
    TextView textViewBalance;
    Button checkBalance;
    SharedPreferences myprefs;
    int password;
    boolean isLoggedin;
    int accountNumber;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_balance);
        textViewBalance = findViewById(R.id.showBalance); // textview
        myprefs = getSharedPreferences("myprefs", MODE_PRIVATE);
        checkBalance = findViewById(R.id.check_balance_button); // button
        isLoggedin = myprefs.getBoolean("isLoggedin", false);
        accountNumber = myprefs.getInt("accountNumber", 000);
        password = myprefs.getInt("password", 000);
        intent = new Intent(getApplicationContext(), Login.class);
        checkBalance.setOnClickListener(view -> {
            Log.e("TAG", "balance button clicked, is Loggedin: " + isLoggedin);
            /*
             * get balance
             * */
            if (isLoggedin) {

                AccountViewModel accountViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(AccountViewModel.class);
                Account account = accountViewModel.search(accountNumber);
                Log.e("TAG", "onCreate: accounts " + account.getBalance());
                textViewBalance.setText(String.valueOf(account.getBalance()));

            } else {
                Toast.makeText(this, "Login again", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }


        });
    }
}
