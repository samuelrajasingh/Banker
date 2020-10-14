/*
 * Copyright (c) 2020. created by suraj kumar
 */

package com.urk17cs290.banker.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;
import com.urk17cs290.banker.R;
import com.urk17cs290.banker.entities.Account;
import com.urk17cs290.banker.viewmodels.AccountViewModel;

import java.util.Objects;

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
            accountNumber = Integer.parseInt(Objects.requireNonNull(ac.getEditText()).getText().toString());
            int pin;
            pin = Integer.parseInt(Objects.requireNonNull(pass.getEditText()).getText().toString());

            AccountViewModel accountViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(AccountViewModel.class);
            LiveData<Account> account = accountViewModel.search(accountNumber);
            Log.e("TAG", "onCreate: accounts " + account.getValue());
        });
    }
}
