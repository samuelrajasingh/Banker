/*
 * Copyright (c) 2020. Created by Rajasingh Samuel.
 */

package com.urk17cs290.banker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.urk17cs290.banker.activities.Accounts;
import com.urk17cs290.banker.activities.CheckBalance;
import com.urk17cs290.banker.activities.CreateAccount;
import com.urk17cs290.banker.activities.CreditAccount;
import com.urk17cs290.banker.activities.DebitAccount;
import com.urk17cs290.banker.activities.Login;
import com.urk17cs290.banker.activities.SplashScreen;
import com.urk17cs290.banker.activities.TransferAmount;

public class MainActivity extends AppCompatActivity {
    SharedPreferences myprefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout view_frame = findViewById(R.id.view_frame);
        FrameLayout login_frame = findViewById(R.id.login_frame);
        myprefs = getSharedPreferences("myprefs", MODE_PRIVATE);
        if (!SplashScreen.isAdmin)
            view_frame.setVisibility(View.GONE);
        else if(SplashScreen.isAdmin) login_frame.setVisibility(View.VISIBLE);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_create_account:
                Intent a = new Intent(this, CreateAccount.class);
                startActivity(a);
                break;
            case R.id.button_login:
                Intent l = new Intent(this, Login.class);
                startActivity(l);
                break;
            case R.id.button_check_balance:
                Intent b = new Intent(this, CheckBalance.class);
                startActivity(b);
                break;
            case R.id.button_credit:
                Intent c = new Intent(this, CreditAccount.class);
                startActivity(c);
                break;
            case R.id.button_debit:
                Intent d = new Intent(this, DebitAccount.class);
                startActivity(d);
                break;
            case R.id.button_transfer:
                Intent e = new Intent(this, TransferAmount.class);
                startActivity(e);
                break;
            case R.id.button_view_all:
                Intent i = new Intent(this, Accounts.class);
                startActivity(i);
                break;
            case R.id.button_logout:
                logout();
                break;
            default:
                break;
        }
    }

    private void logout() {
        boolean isLoggedin = myprefs.getBoolean("isLoggedin", false);
        if (isLoggedin){
            SharedPreferences.Editor editor = myprefs.edit();
            editor.putBoolean("isLoggedin", false);
            boolean commit = editor.commit();
            editor.apply();
            if (commit)
                Toast.makeText(MainActivity.this, "Logged out Successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
