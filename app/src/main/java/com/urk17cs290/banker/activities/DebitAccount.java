package com.urk17cs290.banker.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;
import com.urk17cs290.banker.R;
import com.urk17cs290.banker.entities.Account;
import com.urk17cs290.banker.viewmodels.AccountViewModel;

public class DebitAccount extends AppCompatActivity {
    Button b;
    TextInputLayout input;
    SharedPreferences myprefs;
    SharedPreferences.Editor editor;
    int password;
    boolean isLoggedin;
    int accountNumber;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit_account);
        myprefs = getSharedPreferences("myprefs", MODE_PRIVATE);
        b = findViewById(R.id.debitButton);
        input = findViewById(R.id.debit);
        isLoggedin = myprefs.getBoolean("isLoggedin", false);
        accountNumber = myprefs.getInt("accountNumber", 000);
        password = myprefs.getInt("password", 000);
        intent = new Intent(getApplicationContext(), Login.class);

        b.setOnClickListener(view -> {

            if (isLoggedin) {
                int amount = Integer.parseInt(input.getEditText().getText().toString());
                // reduce balance to database for the specified account Number and update the database
                AccountViewModel accountViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(AccountViewModel.class);
                accountNumber = myprefs.getInt("accountNumber", 000);
                Account account = accountViewModel.search(accountNumber);
                account.setBalance(account.getBalance() - amount);
                accountViewModel.update(account);

                Toast.makeText(this, "Account "+accountNumber+" debitted by " + amount, Toast.LENGTH_SHORT).show();

                Log.i("boolean", String.valueOf(isLoggedin));
            } else {
                Toast.makeText(this, "Login again", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
            finish();
        });
    }
}
