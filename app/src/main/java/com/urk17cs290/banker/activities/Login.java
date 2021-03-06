/*
 * Copyright (c) 2020. Created by Rajasingh Samuel.
 */

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

public class Login extends AppCompatActivity {
	TextInputLayout inputlayoutAccNum, inputLayoutPassword;
	Intent intent;
	Boolean isLoggedin;
	SharedPreferences myprefs;
	SharedPreferences.Editor editor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		inputlayoutAccNum = findViewById(R.id.text_view_account_number);
		inputLayoutPassword = findViewById(R.id.text_view_account_password);
		Button b = findViewById(R.id.login);
		intent = new Intent(getApplicationContext(), MainActivity.class);
		myprefs = getSharedPreferences("myprefs", MODE_PRIVATE);//shared preference
		isLoggedin = false;
		b.setOnClickListener(view -> {

			int accNum = Integer.parseInt(Objects.requireNonNull(inputlayoutAccNum.getEditText()).getText().toString());//email
			int p = Integer.parseInt(Objects.requireNonNull(inputLayoutPassword.getEditText()).getText().toString());

			AccountViewModel accountViewModel
					= new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(AccountViewModel.class);

			Account account = accountViewModel.search(accNum);


			if (account.getPassword() == p) {
				editor = myprefs.edit();//editor for shared preference
				isLoggedin = true;
				editor.putInt("password", p);
				editor.putBoolean("isLoggedin", isLoggedin);
				editor.putInt("accountNumber", accNum);
				editor.apply();
				Toast.makeText(Login.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
				startActivity(intent);
				finish();
			} else {
				Toast.makeText(Login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
			}


		});
	}
}






