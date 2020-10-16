/*
 * Copyright (c) 2020. Created by Rajasingh Samuel.
 */

package com.urk17cs290.banker.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.urk17cs290.banker.entities.Account;
import com.urk17cs290.banker.repos.AccountRepository;

import java.util.List;

/**
 * This class is used to pull and push data to the repository
 */
public class AccountViewModel extends AndroidViewModel {
    private AccountRepository repository;
    private LiveData<List<Account>> allAccounts;

    public AccountViewModel(Application application) {
        super(application);
        repository = new AccountRepository(application);
        allAccounts = repository.getAllAccounts();
    }

    /*
     * function to insert a account object from the room database.
     */
    public void insert(Account account) {
        repository.insert(account);
    }

    /*
     * function to update a account object from the room database.
     */
    public void update(Account account) {
        repository.update(account);
    }

    /*
     * function to delete a account object from the room database.
     */
    public Account search(int accountNumber) {
        return repository.search(accountNumber);

    }

    /*
     * function to delete a account object on the database.
     */
    public void delete(Account account) {
        repository.delete(account);
    }

    /**
     * function to delete all accounts object on the database.
     */
    public void deleteAllAccounts() {
        repository.deleteAllAccounts();
    }

    /*
     * LiveData object to get all account objects from the database.
     */
    public LiveData<List<Account>> getAllAccounts() {
        return allAccounts;
    }
}
