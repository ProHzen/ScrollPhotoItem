package com.eebbk.open.scrollphotoitem.expandablelayout.multitype;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2018/1/25 8:58
 * Email:  369013520@qq.com
 */

public class Data {


    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;

    public @SerializedName("title") String title;
    public @SerializedName("type")int type;


    public Data(@NonNull String title, int type) {
        this.title = title;
        this.type = type;
    }

}
