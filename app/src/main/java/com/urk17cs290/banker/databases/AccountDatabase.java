/*
 * Copyright (c) 2020. Created by Rajasingh Samuel.
 */

package com.urk17cs290.banker.databases;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.urk17cs290.banker.dao.AccountDao;
import com.urk17cs290.banker.entities.Account;

public abstract class AccountDatabase extends  RoomDatabase{
    private static AccountDatabase instance;
    public abstract AccountDao accountDao();
    public static synchronized AccountDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AccountDatabase.class, "Account_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private AccountDao accountDao;
        private PopulateDbAsyncTask(AccountDatabase db) {
            accountDao = db.accountDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            accountDao.insert(new Account("User 1", 101, 100));
            accountDao.insert(new Account("User 2", 102, 200));
            accountDao.insert(new Account("User 3", 103, 300));
            return null;
        }
    }
}
