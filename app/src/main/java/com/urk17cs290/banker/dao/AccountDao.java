/*
 * Copyright (c) 2020. Created by Rajasingh Samuel.
 */

package com.urk17cs290.banker.dao;

import android.database.Cursor;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.urk17cs290.banker.entities.Account;

import java.util.List;

@Dao
public interface AccountDao {

    @Insert
    void insert(Account account);

    @Update
    void update(Account account);

    @Query("SELECT * FROM account_table WHERE accountNumber=:num")
    Account search(int num);

    @Delete
    void delete(Account account);

    @Query("DELETE FROM account_table")
    void deleteAllAccounts();

    @Query("SELECT * FROM account_table")
    LiveData<List<Account>> getAllAccounts();


}
