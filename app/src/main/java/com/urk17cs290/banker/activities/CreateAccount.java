package com.urk17cs290.banker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.urk17cs290.banker.MainActivity;
import com.urk17cs290.banker.R;

public class CreateAccount extends AppCompatActivity {
  Button createAccountButton;
  TextInputLayout name;
    TextInputLayout email;
    TextInputLayout password;
    TextInputLayout mobile;
  Spinner accounttype;
  Intent myintent;
  String ac_type_value;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create_account);

    name = findViewById(R.id.name);
    email = findViewById(R.id.email);
    password = findViewById(R.id.password);
    mobile = findViewById(R.id.phone);
    accounttype = findViewById(R.id.accounttype);
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

              String name1 = name.getEditText().getText().toString();
              String email1 = email.getEditText().getText().toString();
              String password1 = password.getEditText().getText().toString();
              String mobile1 = mobile.getEditText().getText().toString();
              String accounttype1 = ac_type_value;

              /*todo
              save values to database
               */
              myintent = new Intent(getApplicationContext(), MainActivity.class);
              startActivity(myintent);
            });
  }
}
