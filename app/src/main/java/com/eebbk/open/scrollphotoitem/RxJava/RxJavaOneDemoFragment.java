package com.eebbk.open.scrollphotoitem.RxJava;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eebbk.open.scrollphotoitem.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;


/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/6/8 17:13
 * Email:  369013520@qq.com
 */

public class RxJavaOneDemoFragment extends Fragment {

    private static final String TAG = RxJavaOneDemoFragment.class.getSimpleName();

    public static RxJavaOneDemoFragment newInstance() {
        RxJavaOneDemoFragment fragment = new RxJavaOneDemoFragment();
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
            e.onNext(1);
            e.onNext(2);
            e.onNext(3);
            e.onNext(4);
            e.onComplete();
        }).subscribe(new Observer<Integer>() {

            private Disposable mDisposable;
            private int i;

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "subscribe");
                mDisposable = d;
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.d(TAG, "onNext = " + integer);
                i++;
                if (i == 2) {
                    Log.d(TAG, " dispose ");
                    mDisposable.dispose();
                    Log.d(TAG, " isDisposed = " + mDisposable.isDisposed());
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        });


        Observable.create((ObservableOnSubscribe<Integer>) e -> {
            e.onNext(1);
            e.onNext(2);
            e.onNext(3);
            e.onNext(4);
            e.onComplete();
        }).subscribe(integer -> {Log.d(TAG, "integer = " + integer);});

        Observable.create((ObservableOnSubscribe<Integer>) e -> {
            e.onNext(1);
            e.onNext(2);
            e.onNext(3);
            e.onNext(4);
            e.onComplete();
        }).subscribe(integer -> {

        }, throwable -> {

        }, () -> {

        }, disposable -> {

        });

        List<String> strings = new ArrayList<>();
        strings.add("111");
        strings.add("222");
        strings.add("333");
        strings.add("444");
        Observable.just(strings).flatMap(new Function<List<String>, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(List<String> strings) throws Exception {
                return Observable.fromIterable(strings);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.i("flatMap", "s = " + s);
            }
        });

        Observable.just(strings)
                .flatMap(Observable::fromIterable)
                .subscribe(s -> Log.i("flatMap", "s = " + s));
    }
}
