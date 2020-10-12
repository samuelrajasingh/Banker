package com.urk17cs290.banker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;
import com.urk17cs290.banker.MainActivity;
import com.urk17cs290.banker.R;
import com.urk17cs290.banker.entities.Account;
import com.urk17cs290.banker.viewmodels.AccountViewModel;

public class CreateAccount extends AppCompatActivity {
    Button createAccountButton;
    TextInputLayout name;
    TextInputLayout email;
    TextInputLayout password;
    TextInputLayout mobile;
    TextInputLayout account_num,acc_balance;
    Spinner accounttype;
//    Intent myintent;
    String ac_type_value;
    private AccountViewModel accountViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        name = findViewById(R.id.text_view_account_name);
        email = findViewById(R.id.text_view_account_email);
        password = findViewById(R.id.text_view_account_password);
        mobile = findViewById(R.id.text_view_account_mobile);
        accounttype = findViewById(R.id.spinner_account_type);
        account_num = findViewById(R.id.text_view_account_number);
        acc_balance=findViewById(R.id.text_view_account_balance);
        createAccountButton = findViewById(R.id.createAccount);

        accounttype.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        ac_type_value = ((TextView) view).getText().toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        accounttype.setSelection(0);
                        ac_type_value = "Savings Account";
                    }
                });

        createAccountButton.setOnClickListener(
                view -> {
                    try {
                        String name1 = name.getEditText().getText().toString();
                        String email1 = email.getEditText().getText().toString();
                        int password1 = Integer.parseInt(password.getEditText().getText().toString());
                        String mobile1 = mobile.getEditText().getText().toString();
                        int acc_num=Integer.parseInt(account_num.getEditText().getText().toString());
                        int acc_bal =Integer.parseInt(acc_balance.getEditText().getText().toString());
                        String accounttype1 = ac_type_value;

                        accountViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(AccountViewModel.class);
                        Account account = new Account(name1,acc_num,acc_bal,accounttype1,email1,mobile1,password1);
                        accountViewModel.insert(account);
                        Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show();
                        finish();
//                    myintent = new Intent(getApplicationContext(), MainActivity.class);
//                    startActivity(myintent);
                    }catch (NullPointerException e){
                        Log.e("TAG", "TextView is Empty " );
                        Toast.makeText(this, "Please insert a values on all textboxes", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
