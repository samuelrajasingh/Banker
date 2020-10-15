/*
 * Copyright (c) 2020. Created by Rajasingh Samuel.
 */

package com.urk17cs290.banker.repos;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.urk17cs290.banker.dao.AccountDao;
import com.urk17cs290.banker.databases.AccountDatabase;
import com.urk17cs290.banker.entities.Account;

import java.util.List;

/*
 * Account Repository is used to do Crud operations asynchronously and get the desired output
 */
public class AccountRepository {
    private AccountDao accountDao;
    private LiveData<List<Account>> allAccounts;

    public AccountRepository(Application application) {
        AccountDatabase database = AccountDatabase.getInstance(application);
        accountDao = database.accountDao();
        allAccounts = accountDao.getAllAccounts();
    }

    public void insert(Account account) {
        new InsertAccountAsyncTask(accountDao).execute(account);
    }

    public void update(Account account) {
        new UpdateAccountAsyncTask(accountDao).execute(account);
    }

    public void delete(Account account) {
        new DeleteAccountAsyncTask(accountDao).execute(account);
    }

    public void deleteAllAccounts() {
        new DeleteAllAccountsAsyncTask(accountDao).execute();
    }

    public LiveData<List<Account>> getAllAccounts() {
        return allAccounts;
    }

    public Account search(int accountNumber) {

        return accountDao.search(accountNumber);

    }

    private static class InsertAccountAsyncTask extends AsyncTask<Account, Void, Void> {
        private AccountDao accountDao;

        private InsertAccountAsyncTask(AccountDao accountDao) {
            this.accountDao = accountDao;
        }

        @Override
        protected Void doInBackground(Account... accounts) {
            accountDao.insert(accounts[0]);
            return null;
        }
    }

    private static class UpdateAccountAsyncTask extends AsyncTask<Account, Void, Void> {
        private AccountDao accountDao;

        private UpdateAccountAsyncTask(AccountDao accountDao) {
            this.accountDao = accountDao;
        }

        @Override
        protected Void doInBackground(Account... accounts) {
            accountDao.update(accounts[0]);
            return null;
        }
    }


    private static class DeleteAccountAsyncTask extends AsyncTask<Account, Void, Void> {
        private AccountDao accountDao;

        private DeleteAccountAsyncTask(AccountDao accountDao) {
            this.accountDao = accountDao;
        }

        @Override
        protected Void doInBackground(Account... accounts) {
            accountDao.delete(accounts[0]);
            return null;
        }
    }

    private static class DeleteAllAccountsAsyncTask extends AsyncTask<Void, Void, Void> {
        private AccountDao accountDao;

        private DeleteAllAccountsAsyncTask(AccountDao accountDao) {
            this.accountDao = accountDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            accountDao.deleteAllAccounts();
            return null;
        }
    }
}
