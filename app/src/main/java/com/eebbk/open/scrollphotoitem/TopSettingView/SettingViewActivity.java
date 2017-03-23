package com.eebbk.open.scrollphotoitem.TopSettingView;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.eebbk.open.scrollphotoitem.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/2/20 9:28
 * Email:  369013520@qq.com
 */

public class SettingViewActivity extends AppCompatActivity {

    private SettingLayout mSettingLayout;
    private List<String> mData = new ArrayList<>();


    private Button btnAddLineTwo;
    private Button btnAddLineThree;
    private Button btnAddLineFour;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity);
        LinearLayout ll_parent = (LinearLayout) findViewById(R.id.ll_parent);
        final SettingModeManager modeManager = new SettingModeManager(this, ll_parent);

        findViewById(R.id.btn_add_line_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modeManager.addLineTwo();
            }
        });

        findViewById(R.id.btn_add_line_three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modeManager.addLineThree();
            }
        });

        findViewById(R.id.btn_add_line_four).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modeManager.addLineFour();
            }
        });

    }

}
