package com.eebbk.open.scrollphotoitem.IPC;

import android.app.ActivityManager;
import android.content.Context;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/2 9:33
 * Email:  369013520@qq.com
 */

public class IPCUtils {

    public static String getProcessName(Context context) {
        int pid = android.os.Process.myPid();//获取进程pid
        String processName = null;
        ActivityManager am = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);//获取系统的ActivityManager服务
        for (ActivityManager.RunningAppProcessInfo appProcess : am.getRunningAppProcesses()){
            if(appProcess.pid == pid){
                processName = appProcess.processName;
                break;
            }
        }
        return processName;
    }

}
