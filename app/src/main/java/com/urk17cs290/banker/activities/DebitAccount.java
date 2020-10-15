package com.urk17cs290.banker.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.urk17cs290.banker.R;

public class DebitAccount extends AppCompatActivity {
    Button b;
    TextInputLayout input;
    SharedPreferences myprefs;
    SharedPreferences.Editor editor;
    int password;
    Boolean isLoggedin;
    int accountNumber;
    Intent intent;

    //hey suraj do u hv ur phone in silent no
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit_account);
        myprefs = getSharedPreferences("myprefs", MODE_PRIVATE);
        editor = myprefs.edit();
        b = findViewById(R.id.debitButton);
        input = findViewById(R.id.debit);
        isLoggedin = myprefs.getBoolean("isLoggedin", false);
        accountNumber = myprefs.getInt("accountNumber", 000000);
        password = myprefs.getInt("password", 000);
        intent = new Intent(getApplicationContext(), Login.class);

        b.setOnClickListener(view -> {

            if (isLoggedin) {
                /*TODO
                 * diplay a toast debited successfully
                 * update to database
                 * */

                Log.i("boolean",isLoggedin.toString());
            } else {
                Toast.makeText(this, "Login again", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
            finish();
        });
    }
}
