package com.eebbk.open.scrollphotoitem.RxJava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eebbk.open.scrollphotoitem.R;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Desc:   http://www.jianshu.com/p/8818b98c44e2  切换线程
 * Author: YangShangZhen
 * Time:   2017/6/8 17:13
 * Email:  369013520@qq.com
 */

public class RxJavaTwoDemoFragment extends Fragment {

    private static final String TAG = RxJavaTwoDemoFragment.class.getSimpleName();

    public static RxJavaTwoDemoFragment newInstance() {
        RxJavaTwoDemoFragment fragment = new RxJavaTwoDemoFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one_rxjava, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    private void initData() {
        Observable.create((ObservableOnSubscribe<Integer>) e -> {
            Log.d(TAG, "Observable thread is = " + Thread.currentThread().getName());
            Log.d(TAG, "emit 1");
            e.onNext(1);
        }).subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(integer -> {
                    Log.d(TAG, " Observable thread doOnNext first is = " + Thread.currentThread().getName());
                })
                .observeOn(Schedulers.io())
                .doOnNext(integer -> {
                    Log.d(TAG, " Observable thread doOnNext second is = " + Thread.currentThread().getName());
                })
                .subscribe(integer -> {
                    Log.d(TAG, "Observable thread is = " + Thread.currentThread().getName());
                    Log.d(TAG, " onNext = " + integer);
                });
    }
}
