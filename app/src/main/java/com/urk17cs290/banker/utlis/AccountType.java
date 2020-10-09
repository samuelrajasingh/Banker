/*
 * Copyright (c) 2020. Created by Rajasingh Samuel.
 */

package com.urk17cs290.banker.utlis;

public enum AccountType {

  /** Specify Account type as Current Account */
  CURRENT_ACCOUNT("Current Account"),
    FIXED_DEPOSIT("Fixed deposit"),
    NRI_ACCOUNT("Nri Account"),
    SAVINGS_ACCOUNT("Savings Account");

  private final String text;

   AccountType(String s) {
    this.text=s;

  }
  public String getText() {
    return text;
  }
}
