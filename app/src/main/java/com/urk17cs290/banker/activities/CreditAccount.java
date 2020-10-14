package com.urk17cs290.banker.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.urk17cs290.banker.MainActivity;
import com.urk17cs290.banker.R;
import com.urk17cs290.banker.viewmodels.AccountViewModel;

public class CreditAccount extends AppCompatActivity {
    Button b;
    TextInputLayout input;
    Intent myintent;
    SharedPreferences myprefs;
    SharedPreferences.Editor editor;

    int password;
    Boolean isLoggedin;
    long accountNumber;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_account);
        b = findViewById(R.id.creditButton);
        input = findViewById(R.id.credit);
        myintent = new Intent(getApplicationContext(), MainActivity.class);
        myprefs = getSharedPreferences("myprefs",MODE_PRIVATE);
        editor =  myprefs.edit();
        isLoggedin = myprefs.getBoolean("isLoggedin",false);
        accountNumber = myprefs.getLong("accountNumber",000000);
        password = myprefs.getInt("password",000);
        intent = new Intent(getApplicationContext(),Login.class);
        b.setOnClickListener(view -> {

            if(isLoggedin){
                 /*todo
                     * reduce balance from datbase for the specified account   Number and update the database
                     * */


            }else{
                Toast.makeText(this, "Login again", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
            finish();
        });
    }
}
