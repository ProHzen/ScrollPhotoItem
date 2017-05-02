package com.eebbk.open.scrollphotoitem.IPC;

import java.io.Serializable;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/2 9:41
 * Email:  369013520@qq.com
 */

public class User implements Serializable {

    private static final long serialVersionUID = 5190671237121298773L;

    public int userId;
    public String userName;
    public boolean isMale;

    public int getUserId() {
        return userId;
    }

    public User setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public boolean isMale() {
        return isMale;
    }

    public User setMale(boolean male) {
        isMale = male;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", isMale=" + isMale +
                '}';
    }
}
