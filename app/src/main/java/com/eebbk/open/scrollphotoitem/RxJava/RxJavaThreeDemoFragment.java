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
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


/**
 * Desc:   http://www.jianshu.com/p/128e662906af  操作符
 * Author: YangShangZhen
 * Time:   2017/6/8 17:13
 * Email:  369013520@qq.com
 */

public class RxJavaThreeDemoFragment extends Fragment {

    private static final String TAG = RxJavaThreeDemoFragment.class.getSimpleName();

    public static RxJavaThreeDemoFragment newInstance() {
        RxJavaThreeDemoFragment fragment = new RxJavaThreeDemoFragment();
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

        //map
        Observable.create((ObservableOnSubscribe<Integer>) e -> {
            e.onNext(1);
            e.onNext(2);
            e.onNext(3);
        }).map(integer -> "this is a " + integer).subscribe(s -> Log.d(TAG, s));

        //flatMap
        Observable.create((ObservableOnSubscribe<Integer>) e -> {
            e.onNext(1);
            e.onNext(2);
            e.onNext(3);
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(@NonNull Integer integer) throws Exception {
                final List<String> list = new ArrayList<String>();
                for (int i = 0; i < 3; i++) {
                    list.add("I am value = " + i);
                }
                return Observable.fromIterable(list).delay(10, TimeUnit.MILLISECONDS);
            }
        }).subscribe(s -> Log.d(TAG, (String) s));

        Observable.create((ObservableOnSubscribe<Integer>) e -> {
            e.onNext(1);
            e.onNext(2);
            e.onNext(3);
        })
                .flatMap(integer -> {
                    final List<String> list = new ArrayList<String>();
                    for (int i = 0; i < 3; i++) {
                        list.add("I am value = " + i);
                    }
                    return Observable.fromIterable(list).delay(10, TimeUnit.MILLISECONDS);
                })
                .subscribe(s -> Log.d(TAG, (String) s));


        //concatMap
        Observable.create((ObservableOnSubscribe<Integer>) e -> {
            e.onNext(1);
            e.onNext(2);
            e.onNext(3);
        })
                .concatMap(integer -> {
                    final List<String> list = new ArrayList<String>();
                    for (int i = 0; i < 3; i++) {
                        list.add("I am contact value = " + i);
                    }
                    return Observable.fromIterable(list).delay(10, TimeUnit.MILLISECONDS);
                }).subscribe(s -> Log.d(TAG, (String) s));


        //zip
        Observable<Integer> observable1 = Observable.create((ObservableOnSubscribe<Integer>) e -> {
            Log.i(TAG, " zip observable1 value = " + 1);
            e.onNext(1);
            Thread.sleep(1000);

            Log.i(TAG, " zip observable1 value = " + 2);
            e.onNext(2);
            Thread.sleep(1000);

            Log.i(TAG, " zip observable1 value = " + 3);
            e.onNext(3);
            Thread.sleep(1000);

            Log.i(TAG, " zip observable1 value = " + 4);
            e.onNext(4);
            try {
                Thread.sleep(1000);
                Log.i(TAG, " zip observable1 complete1");
                e.onComplete();
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }).subscribeOn(Schedulers.io());

        Observable<String> observable2 = Observable.create((ObservableOnSubscribe<String>) e -> {
            Log.i(TAG, " zip observable2 value = " + "A");
            e.onNext("A");
            Thread.sleep(1000);

            Log.i(TAG, " zip observable2 value = " + "B");
            e.onNext("B");
            Thread.sleep(1000);

            Log.i(TAG, " zip observable2 value = " + "C");
            e.onNext("C");
            Thread.sleep(1000);

            Log.i(TAG, " zip observable2 complete2");
            e.onComplete();
        }).subscribeOn(Schedulers.io());

        Observable.zip(observable1, observable2, (integer, s) -> integer + s).subscribe(new Observer<String>() {

            private Disposable mDisposable;

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mDisposable = d;
                Log.i(TAG, "onSubscribe");
            }

            @Override
            public void onNext(@NonNull String r) {
                Log.i(TAG, "onNext = " + r);

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete");
                mDisposable.dispose();
            }
        });


        //背压


//        Observable<Integer> backObservable = Observable.create((ObservableOnSubscribe<Integer>)e -> {
//            for (int i = 0; ; i++) {
//                e.onNext(i);
//            }
//        }).subscribeOn(Schedulers.io());
//
//        Observable<String> backObservable2 = Observable.create((ObservableOnSubscribe<String>)e -> {
//            e.onNext("A");
//        }).subscribeOn(Schedulers.io());
//
//        Observable.zip(backObservable, backObservable2, ((integer, s) -> (integer + s)))
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(s -> Log.d(TAG, "string: " + s), t -> Log.d(TAG, "throwable: " + t));


        Observable.create((ObservableOnSubscribe<Integer>)e -> {
            for (int i = 0; ; i++) {
                e.onNext(i);
            }
        }).subscribeOn(Schedulers.io())
//                .filter(integer -> integer % 10 == 0)
                .sample(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> Log.d(TAG, "" + integer));


        //Flowable
//        Flowable<Integer> upstream = Flowable.create()




















    }
}
