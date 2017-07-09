package com.eebbk.open.scrollphotoitem.Realm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.eebbk.open.scrollphotoitem.R;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/12 10:37
 * Email:  369013520@qq.com
 */

public class RealmActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipc_first);
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        User user = realm.createObject(User.class);
        user.setAge(15).setName("John");
        realm.commitTransaction();


        Realm realm1 = Realm.getDefaultInstance();
        final User user1 = new User("John");

    }
}
