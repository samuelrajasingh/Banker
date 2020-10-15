package com.urk17cs290.banker.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;
import com.urk17cs290.banker.R;
import com.urk17cs290.banker.entities.Account;
import com.urk17cs290.banker.viewmodels.AccountViewModel;

public class TransferAmount extends AppCompatActivity {
    Button b;
    TextInputLayout amount;
    TextInputLayout pin;
    TextInputLayout toNumber;
    SharedPreferences myprefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_amount);
        myprefs = getSharedPreferences("myprefs", MODE_PRIVATE);
        amount = findViewById(R.id.transfer);
        pin = findViewById(R.id.pin);
        b = findViewById(R.id.transferButton);
        toNumber = findViewById(R.id.to);


        b.setOnClickListener(view -> {

            try {
                int amt = Integer.parseInt(amount.getEditText().getText().toString());
                int toAccountNo = Integer.parseInt(toNumber.getEditText().getText().toString());
                AccountViewModel accountViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(AccountViewModel.class);
                int fromAcc = myprefs.getInt("accountNumber", 000);
                Account fromAccount = accountViewModel.search(fromAcc);
                Account toAccount = accountViewModel.search(toAccountNo);
                toAccount.setBalance(toAccount.getBalance() + amt);
                fromAccount.setBalance(fromAccount.getBalance()- amt);
                accountViewModel.update(toAccount);
                accountViewModel.update(fromAccount);


                Toast.makeText(this, "Account " + toAccountNo + " credited with " + amt + "from"+fromAcc, Toast.LENGTH_SHORT).show();

                finish();
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}
