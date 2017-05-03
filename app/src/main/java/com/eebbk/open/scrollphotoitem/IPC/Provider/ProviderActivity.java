package com.eebbk.open.scrollphotoitem.IPC.Provider;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.eebbk.open.scrollphotoitem.IPC.Book;
import com.eebbk.open.scrollphotoitem.IPC.NewBook;
import com.eebbk.open.scrollphotoitem.IPC.User;
import com.eebbk.open.scrollphotoitem.R;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/3 11:13
 * Email:  369013520@qq.com
 */

public class ProviderActivity extends Activity {

    private static final String TAG = ProviderActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipc_first);

        Uri bookUri = Uri.parse("content://com.eebbk.open.scrollphotoitem.book.provider/book");
        ContentValues values = new ContentValues();
        values.put("_id", 6);
        values.put("name", "程序设计的艺术");
        getContentResolver().insert(bookUri, values);
        Cursor bookCursor = getContentResolver().query(bookUri, new String[]{"_id", "name"}, null, null, null);
        while (bookCursor.moveToNext()) {
            NewBook book = new NewBook();
            book.bookId = bookCursor.getInt(0);
            book.bookName = bookCursor.getString(1);
            Log.d(TAG, "query book:" + book.toString());
        }
        bookCursor.close();

        Uri userUri = Uri.parse("content://com.eebbk.open.scrollphotoitem.book.provider/user");
        Cursor userCursor = getContentResolver().query(userUri, new String[]{"_id", "name", "sex"}, null, null, null);
        while (userCursor.moveToNext()) {
            User user = new User();
            user.userId = userCursor.getInt(0);
            user.userName = userCursor.getString(1);
            user.isMale = userCursor.getInt(2) == 1;
            Log.d(TAG, "query user:" + user.toString());
        }
        userCursor.close();

        getContentResolver().query(bookUri, null, null, null, null);
        getContentResolver().query(bookUri, null, null, null, null);
        getContentResolver().query(bookUri, null, null, null, null);
    }
}
