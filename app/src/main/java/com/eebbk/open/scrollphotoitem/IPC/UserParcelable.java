package com.eebbk.open.scrollphotoitem.IPC;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/2 11:34
 * Email:  369013520@qq.com
 */

public class UserParcelable implements Parcelable {


    public int userId;
    public String userName;
    public boolean isMale;

    public Book book;

    public UserParcelable(int userId, String userName, boolean isMale) {
        this.userId = userId;
        this.userName = userName;
        this.isMale = isMale;
    }

    protected UserParcelable(Parcel in) {
        userId = in.readInt();
        userName = in.readString();
        isMale = in.readByte() != 0;
        book = in.readParcelable(Book.class.getClassLoader());
    }

    public static final Creator<UserParcelable> CREATOR = new Creator<UserParcelable>() {
        @Override
        public UserParcelable createFromParcel(Parcel in) {
            return new UserParcelable(in);
        }

        @Override
        public UserParcelable[] newArray(int size) {
            return new UserParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userId);
        dest.writeString(userName);
        dest.writeInt(isMale ? 1 : 0);
        dest.writeParcelable(book, 0);
    }
}
