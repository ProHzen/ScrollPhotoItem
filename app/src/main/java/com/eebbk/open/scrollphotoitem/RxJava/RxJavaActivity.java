package com.eebbk.open.scrollphotoitem.RxJava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.eebbk.open.scrollphotoitem.R;

import java.util.Objects;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/6/8 17:10
 * Email:  369013520@qq.com
 */

public class RxJavaActivity extends AppCompatActivity {

    private Button mOneTest;
    private FragmentManager mFragmentManager;
    private RxJavaOneDemoFragment mRxJavaOneDemoFragment;
    private RxJavaTwoDemoFragment mRxJavaTwoDemoFragment;
    private RxJavaThreeDemoFragment mRxJavaThreeDemoFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);

        initView();
        initData();
    }

    private void initData() {
        initOneFragment();
//        initTwoFragment();
//        initThreeFragment();
    }

    private void initOneFragment() {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        if (mRxJavaOneDemoFragment == null) {
            mRxJavaOneDemoFragment = RxJavaOneDemoFragment.newInstance();
            fragmentTransaction.add(R.id.fl_layout, mRxJavaOneDemoFragment);
        } else {
            fragmentTransaction.show(mRxJavaOneDemoFragment);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void initTwoFragment() {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        if (mRxJavaTwoDemoFragment == null) {
            mRxJavaTwoDemoFragment = RxJavaTwoDemoFragment.newInstance();
            fragmentTransaction.add(R.id.fl_layout, mRxJavaTwoDemoFragment);
        } else {
            fragmentTransaction.show(mRxJavaTwoDemoFragment);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void initThreeFragment() {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        if (mRxJavaThreeDemoFragment == null) {
            mRxJavaThreeDemoFragment = RxJavaThreeDemoFragment.newInstance();
            fragmentTransaction.add(R.id.fl_layout, mRxJavaThreeDemoFragment);
        } else {
            fragmentTransaction.show(mRxJavaThreeDemoFragment);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void initView() {
        mOneTest = (Button) findViewById(R.id.btn_one);
        mFragmentManager = getSupportFragmentManager();
    }
}
