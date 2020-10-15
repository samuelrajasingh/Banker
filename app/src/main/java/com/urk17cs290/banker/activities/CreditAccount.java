package com.urk17cs290.banker.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;
import com.urk17cs290.banker.MainActivity;
import com.urk17cs290.banker.R;
import com.urk17cs290.banker.entities.Account;
import com.urk17cs290.banker.viewmodels.AccountViewModel;

import java.util.Objects;

public class CreditAccount extends AppCompatActivity {
    Button b;
    TextInputLayout input;
    Intent myintent;
    SharedPreferences myprefs;
    SharedPreferences.Editor editor;

    int password;
    Boolean isLoggedin;
    int accountNumber;
    Intent intent;
    private AccountViewModel accountViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_account);
        b = findViewById(R.id.creditButton);
        input = findViewById(R.id.credit);

        myintent = new Intent(getApplicationContext(), MainActivity.class);
        myprefs = getSharedPreferences("myprefs", MODE_PRIVATE);
        isLoggedin = myprefs.getBoolean("isLoggedin", false);

        password = myprefs.getInt("password", 000);
        intent = new Intent(getApplicationContext(), Login.class);
        b.setOnClickListener(view -> {
            String amtStr = input.getEditText().getText().toString() ;
            int amount = Integer.parseInt(amtStr);
            if (isLoggedin) {
                // add balance to database for the specified account Number and update the database
                accountViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(AccountViewModel.class);
                accountNumber = myprefs.getInt("accountNumber", 000);
                Account account = accountViewModel.search(accountNumber);
                account.setBalance(account.getBalance() + amount);
                accountViewModel.update(account);

                Toast.makeText(this, "Account "+accountNumber+" credited with " + amount, Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Login again", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
            finish();
        });
    }
}
