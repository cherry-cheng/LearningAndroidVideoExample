package com.example.chengyonghui.normalbutton.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.chengyonghui.normalbutton.FirstProviderMetaData;

/**
 * Created by chengyonghui on 2017/9/18.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
    }

    public DatabaseHelper(Context context, String name) {
        this(context, name, VERSION);
    }

    public DatabaseHelper(Context context, String name, int version) {
        this(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + FirstProviderMetaData.USERS_TABLE_NAME
                + "(" + FirstProviderMetaData.UserTableMetaData._ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + FirstProviderMetaData.UserTableMetaData.USER_NAME
                + " varchar(20));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newVersion) {
        System.out.println("update a Database");
    }
}
