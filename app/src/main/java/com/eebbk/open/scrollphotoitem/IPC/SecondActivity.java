package com.eebbk.open.scrollphotoitem.IPC;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.eebbk.open.scrollphotoitem.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/2 8:59
 * Email:  369013520@qq.com
 */

public class SecondActivity extends AppCompatActivity{

    private static final String TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipc_first);
        Log.i(TAG + "_ysz", "sUserId = " + FirstActivity.sUserId);
        findViewById(R.id.btn_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, ThirdActivity.class));
            }
        });

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(getFilesDir(), "cache.txt")));
            User user = (User) in.readObject();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
