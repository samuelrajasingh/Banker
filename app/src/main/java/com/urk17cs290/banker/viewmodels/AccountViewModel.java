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
    public void delete(Account account) {
        repository.delete(account);
    }

    public void deleteAllAccounts() {
        repository.deleteAllAccounts();
    }

    /*
     * LiveData object to get account objects from the room database.
     */
    public LiveData<List<Account>> getAllAccounts() {
        return allAccounts;
    }
}
