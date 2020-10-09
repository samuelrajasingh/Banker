/*
 * Copyright (c) 2020. Created by Rajasingh Samuel.
 */

package com.urk17cs290.banker.entities;

import androidx.annotation.InspectableProperty;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.urk17cs290.banker.utlis.AccountType;
import com.urk17cs290.banker.utlis.Converters;

@Entity(tableName = "account_table")
public class Account {
  private String accountName;
  private int accountNumber;
  private int balance;
  private int mobileNumber;

  private AccountType accountType;
  private String email;
  private int password;

  public AccountType getAccountType() {
    return accountType;
  }

  public void setAccountType(AccountType accountType) {
    this.accountType = accountType;
  }

  public int getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(int mobileNumber) {
    this.mobileNumber = mobileNumber;
  }



  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @PrimaryKey(autoGenerate = true)
  private int id;

  public Account(String accountName, int accountNumber, int balance,AccountType accountType,String email,int mobileNumber,int password) {
    this.accountName = accountName;
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.mobileNumber =mobileNumber;
    this.email=email;
    this.accountType=accountType;
    this.password=password;

  }

  public int getPassword() {
    return password;
  }

  public void setPassword(int password) {
    this.password = password;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public int getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(int accountNumber) {
    this.accountNumber = accountNumber;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }
}
