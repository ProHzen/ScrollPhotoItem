package com.eebbk.open.scrollphotoitem.IPC;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.eebbk.open.scrollphotoitem.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/2 8:54
 * Email:  369013520@qq.com
 */

public class FirstActivity extends AppCompatActivity{

    private static final String TAG = FirstActivity.class.getSimpleName();
    public static int sUserId = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipc_first);

        findViewById(R.id.btn_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this, SecondActivity.class));
            }
        });

        User user = new User();
        user.setMale(true).setUserId(0).setUserName("tom");
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(getFilesDir(), "cache.txt")));
            out.writeObject(user);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
