package com.eebbk.open.scrollphotoitem.GreenDao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.eebbk.open.scrollphotoitem.R;

import java.util.List;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/10 11:36
 * Email:  369013520@qq.com
 */

public class GreenDaoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipc_first);

        DBManager dbManager = new DBManager(this);
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i + 1).setAge(i * 3).setName("第 " + i + " 人");
            dbManager.insertUser(user);
        }
        List<User> userList = dbManager.queryUserList();

        for (User user : userList) {
            Log.e("TAG", "queryUserList--before-->" + user.getId() + "--" + user.getName() +"--"+user.getAge());
            if (user.getId() == 0) {
                dbManager.deleteUser(user);
            }
            if (user.getId() == 3) {
                user.setAge(10);
                dbManager.updateUser(user);
            }
        }
        userList = dbManager.queryUserList();
        for (User user : userList) {
            Log.e("TAG", "queryUserList--after--->" + user.getId() + "---" + user.getName()+"--"+user.getAge());
        }

    }


}
