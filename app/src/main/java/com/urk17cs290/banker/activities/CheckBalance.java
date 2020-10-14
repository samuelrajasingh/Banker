/*
 * Copyright (c) 2020. created by suraj kumar
 */

package com.urk17cs290.banker.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;
import com.urk17cs290.banker.R;
import com.urk17cs290.banker.entities.Account;
import com.urk17cs290.banker.viewmodels.AccountViewModel;

public class CheckBalance extends AppCompatActivity {
    TextView setBalance;
    Button checkBalance;
    TextInputLayout ac, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_balance);
        setBalance = findViewById(R.id.showBalance); // textview
        ac = findViewById(R.id.enter_acnumber);//ac number
        pass = findViewById(R.id.enter_pin);
        checkBalance = findViewById(R.id.check_balance_button); // button
        checkBalance.setOnClickListener(view -> {
            /*TODO
             * get balance
             * set as a string
             * */
            int accountNumber;
            accountNumber = Integer.parseInt(String.valueOf(ac.getEditText().getText()));
            int pin;
            pin = Integer.parseInt(String.valueOf(pass.getEditText().getText()));

            AccountViewModel accountViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(AccountViewModel.class);
            Account account = accountViewModel.search(accountNumber);
            Log.e("TAG", "onCreate: accounts " + account);
        });
    }
}
