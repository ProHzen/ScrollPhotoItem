package com.eebbk.open.scrollphotoitem.IPC;

import android.app.Application;
import android.util.Log;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/2 9:30
 * Email:  369013520@qq.com
 */

public class MyApplication extends Application {

    private static final String TAG = MyApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        String processName = IPCUtils.getProcessName(getApplicationContext());
        Log.i(TAG, "processName = " + processName);
    }
}
