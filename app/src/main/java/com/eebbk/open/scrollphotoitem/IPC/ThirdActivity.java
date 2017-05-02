package com.eebbk.open.scrollphotoitem.IPC;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.eebbk.open.scrollphotoitem.R;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/2 8:59
 * Email:  369013520@qq.com
 */

public class ThirdActivity extends AppCompatActivity{

    private static final String TAG = FirstActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipc_first);
        Log.i(TAG + "_ysz", "sUserId = " + FirstActivity.sUserId);
    }
}
