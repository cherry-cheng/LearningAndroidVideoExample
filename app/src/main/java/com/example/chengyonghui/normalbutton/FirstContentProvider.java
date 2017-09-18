package com.example.chengyonghui.normalbutton;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

import com.example.chengyonghui.normalbutton.db.DatabaseHelper;

import java.util.HashMap;

/**
 * Created by chengyonghui on 2017/9/18.
 */
public class FirstContentProvider extends ContentProvider {

    public static final UriMatcher uriMatcher;
    public static final int INCOMING_USER_COLLECTION =1;
    public static final int INCOMING_USER_SINGLE = 2;
    private DatabaseHelper dh;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(FirstProviderMetaData.AUTHORITY, "/users",
                INCOMING_USER_COLLECTION);
        uriMatcher.addURI(FirstProviderMetaData.AUTHORITY, "/users/#",
                INCOMING_USER_SINGLE);
    }

    public static HashMap<String, String> userProjectionMap;
    //给表里的列起别名
    static {
        userProjectionMap = new HashMap<String, String>();
        userProjectionMap.put(FirstProviderMetaData.UserTableMetaData._ID, FirstProviderMetaData.UserTableMetaData._ID);
        userProjectionMap.put(FirstProviderMetaData.UserTableMetaData.USER_NAME, FirstProviderMetaData.UserTableMetaData.USER_NAME);
    }

    @Override
    public int delete(Uri arg0, String arg1, String[] arg2) {
        System.out.println("delete");
        return 0;
    }

    //根据传入的URI，返回该URI所表示的数据类型
    @Override
    public String getType(Uri uri) {
        System.out.println("getType");
        switch (uriMatcher.match(uri)) {
            case INCOMING_USER_COLLECTION:
                return FirstProviderMetaData.UserTableMetaData.CONTENT_TYPE;
            case INCOMING_USER_SINGLE:
                return FirstProviderMetaData.UserTableMetaData.CONTENT_TYPE_ITEM;
            default:
                throw new IllegalArgumentException("Unknown URI" + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        System.out.println("insert");
        SQLiteDatabase db= dh.getWritableDatabase();
        long rowId = db.insert(FirstProviderMetaData.UserTableMetaData.TABLE_NAME, null, values);
        if (rowId > 0) {
            Uri insertedUserUri = ContentUris.withAppendedId(FirstProviderMetaData.UserTableMetaData.CONTENT_URI, rowId);
            //通知监听器，数据已经改变
            getContext().getContentResolver().notifyChange(insertedUserUri, null);
            //返回新数据的uri
            return insertedUserUri;
        }
        throw new SQLiteException("Failed to insert row into" + uri);
    }
    //在ContentProvider创建的时候执行
    @Override
    public boolean onCreate() {
        dh = new DatabaseHelper(getContext(), FirstProviderMetaData.DATABASE_NAME);
        System.out.println("oncreate");
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder) {
        //创建查询语句Sy
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        switch (uriMatcher.match(uri)) {
            case INCOMING_USER_SINGLE:
                qb.setTables(FirstProviderMetaData.UserTableMetaData.TABLE_NAME);
                qb.setProjectionMap(userProjectionMap);
                //添加一个where子句
                //getPathSegments(),去掉path部分的斜杠，eg:user=1；
                qb.appendWhere(FirstProviderMetaData.UserTableMetaData._ID + "=" + uri.getPathSegments().get(1));
                break;
            case INCOMING_USER_COLLECTION:
                qb.setTables(FirstProviderMetaData.UserTableMetaData.TABLE_NAME);
                qb.setProjectionMap(userProjectionMap);
                break;
        }
        String orderBy;
        if (TextUtils.isEmpty(sortOrder)) {
            orderBy = FirstProviderMetaData.UserTableMetaData.DEFAULT_SORT_ORDER;
        } else {
            orderBy = sortOrder;
        }
        SQLiteDatabase db = dh.getWritableDatabase();
        Cursor c = qb.query(db, projection, selection, selectionArgs, null, null, orderBy);
        c.setNotificationUri(getContext().getContentResolver(), uri);
        System.out.println("query");
        return c;
    }

    @Override
    public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
        System.out.println("update");
        return 1;
    }

}
