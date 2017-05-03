package com.eebbk.open.scrollphotoitem.IPC.Provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.net.URI;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/3 11:06
 * Email:  369013520@qq.com
 */

public class BookProvider extends ContentProvider {

    private static final String TAG = BookProvider.class.getSimpleName();

    public static final String AUTHORITY = "com.eebbk.open.scrollphotoitem.book.provider";
    public static final Uri BOOK_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/book");
    public static final Uri USER_CONTENT_URI = Uri.parse("content://" +AUTHORITY + "/user");
    public static final int BOOK_URI_CODE = 0;
    public static final int USER_URI_CODE = 1;
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(AUTHORITY, "book", BOOK_URI_CODE);
        sUriMatcher.addURI(AUTHORITY, "user", USER_URI_CODE);
    }

    private Context mContext;
    private SQLiteDatabase mDatabase;

    @Override
    public boolean onCreate() {
        Log.d(TAG, " onCreate, current thread = " + Thread.currentThread().getName());
        mContext = getContext();
        initProviderData();
        return true;
    }

    private void initProviderData() {
        mDatabase = new DbOpenHelper(mContext).getWritableDatabase();
        mDatabase.execSQL("delete from " + DbOpenHelper.BOOK_TABLE_NAME);
        mDatabase.execSQL("delete from " + DbOpenHelper.USER_TABLE_NAME);
        mDatabase.execSQL("insert into book values(3,'Android');");
        mDatabase.execSQL("insert into book values(4,'Ios');");
        mDatabase.execSQL("insert into book values(5,'Html5');");
        mDatabase.execSQL("insert into user values(1,'jake',1);");
        mDatabase.execSQL("insert into user values(2,'jasmine',0);");
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Log.d(TAG, " query, current thread = " + Thread.currentThread().getName());
        String table = getTableName(uri);
        if (table ==null) {
            throw new IllegalArgumentException("Unsupported uri：" + uri);
        }
        return mDatabase.query(table, projection, selection, selectionArgs, null, null, sortOrder, null);
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        Log.d(TAG, " getType ");
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        Log.d(TAG, " insert ");
        String table = getTableName(uri);
        if (table == null) {
            throw new IllegalArgumentException("Unsupport URI: " + uri);
        }
        mDatabase.insert(table, null, values);
        mContext.getContentResolver().notifyChange(uri, null);
        return uri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        Log.d(TAG, " delete ");
        String table = getTableName(uri);
        if (table == null) {
            throw new IllegalArgumentException("Unsupport URI: " + uri);
        }
        int count = mDatabase.delete(table, selection, selectionArgs);
        if (count > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return count;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        Log.d(TAG, " update ");
        String table = getTableName(uri);
        if (table == null) {
            throw new IllegalArgumentException("Unsupport URI: " + uri);
        }
        int row = mDatabase.update(table, values, selection, selectionArgs);
        if (row > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return row;
    }

    public String getTableName(Uri uri) {
        String tableName = null;
        switch (sUriMatcher.match(uri)) {
            case BOOK_URI_CODE:
                tableName = DbOpenHelper.BOOK_TABLE_NAME;
                break;
            case USER_URI_CODE:
                tableName = DbOpenHelper.USER_TABLE_NAME;
                break;
            default:
                break;
        }
        return tableName;
    }
}
