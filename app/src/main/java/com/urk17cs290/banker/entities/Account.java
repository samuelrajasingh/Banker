/*
 * Copyright (c) 2020. Created by Rajasingh Samuel.
 */

package com.urk17cs290.banker.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "account_table")
public class Account {
    private String account_Name;
    private int account_number;
    private int balance;
    private int mobile_number;
    private String account_type;
    private String email;


    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    private int password;
    @PrimaryKey(autoGenerate = true)
    private int id;

    public Account(String account_Name, int account_number, int balance) {
        this.account_Name = account_Name;
        this.account_number = account_number;
        this.balance = balance;
    }

    public String getAccount_Name() {
        return account_Name;
    }

    public void setAccount_Name(String account_Name) {
        this.account_Name = account_Name;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
