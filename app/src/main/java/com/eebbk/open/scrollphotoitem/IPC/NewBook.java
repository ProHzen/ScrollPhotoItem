package com.eebbk.open.scrollphotoitem.IPC;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/2 19:52
 * Email:  369013520@qq.com
 */

public class NewBook implements Parcelable{

    private int bookId;
    private String bookName;

    public NewBook(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    protected NewBook(Parcel in) {
        bookId = in.readInt();
        bookName = in.readString();
    }

    public static final Creator<NewBook> CREATOR = new Creator<NewBook>() {
        @Override
        public NewBook createFromParcel(Parcel in) {
            return new NewBook(in);
        }

        @Override
        public NewBook[] newArray(int size) {
            return new NewBook[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(bookId);
        dest.writeString(bookName);
    }

    @Override
    public String toString() {
        return "NewBook{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
