package com.eebbk.open.scrollphotoitem.IPC;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/2 11:35
 * Email:  369013520@qq.com
 */

public class Book implements Parcelable {

    private String name;

    public String getName() {
        return name;
    }

    protected Book(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
}
