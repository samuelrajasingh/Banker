/*
 * Copyright (c) 2020. Created by Rajasingh Samuel.
 */

package com.urk17cs290.banker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.urk17cs290.banker.activities.Accounts;
import com.urk17cs290.banker.activities.CheckBalance;
import com.urk17cs290.banker.activities.CreateAccount;
import com.urk17cs290.banker.activities.CreditAccount;
import com.urk17cs290.banker.activities.DebitAccount;
import com.urk17cs290.banker.activities.TransferAmount;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.button_create_account:
        Intent a = new Intent(this, CreateAccount.class);
        startActivity(a);
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
      default:
        break;
    }
  }
}
