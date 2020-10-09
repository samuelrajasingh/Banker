/*
 * Copyright (c) 2020. Created by Rajasingh Samuel.
 */

package com.urk17cs290.banker.utlis;

import androidx.room.TypeConverter;

public class Converters {
    @TypeConverter
    public static AccountType toAccountType(String value) {
        return (value == null) ? null : new AccountType(value);
    }

    @TypeConverter
    public static String fromAccountType(AccountType type) {
        return type == null ? null : type.toString();
    }
}
