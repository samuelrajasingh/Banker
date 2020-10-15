package com.urk17cs290.banker.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.urk17cs290.banker.R;

public class TransferAmount extends AppCompatActivity {
    Button b;
    TextInputLayout amount, pin, accountNumber;
    SharedPreferences myprefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_amount);
        myprefs = getSharedPreferences("myprefs", MODE_PRIVATE);
//        editor = myprefs.edit();
        amount = findViewById(R.id.transfer);
        pin = findViewById(R.id.pin);
        b = findViewById(R.id.transferButton);
        accountNumber = findViewById(R.id.to);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        /*TODO
        match pin and a/c number
         * diplay a toast transferred successfully
         * update to database
         * */
                finish();
            }
        });
    }
}
