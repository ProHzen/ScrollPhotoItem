package com.eebbk.open.scrollphotoitem.Realm;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/12 10:35
 * Email:  369013520@qq.com
 */

public class User extends RealmObject {

    private String          name;
    private int             age;

    @PrimaryKey
    private String id;

    public User() {
    }

    public User(String john) {

    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }


    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }
}
