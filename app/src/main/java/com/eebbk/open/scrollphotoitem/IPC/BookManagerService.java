package com.eebbk.open.scrollphotoitem.IPC;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/2 19:58
 * Email:  369013520@qq.com
 */

public class BookManagerService extends Service {

    private static final String TAG = "BMS";

    private AtomicBoolean mAtomicBoolean = new AtomicBoolean(false);

    private CopyOnWriteArrayList<NewBook> mBooks = new CopyOnWriteArrayList<>();
    private RemoteCallbackList<IOnNewBookArrivedListener> mListeners = new RemoteCallbackList<>();

    private Binder mBinder = new NewBookManager.Stub() {

        @Override
        public List<NewBook> getNewBook() throws RemoteException {
            SystemClock.sleep(5000);
            return mBooks;
        }

        @Override
        public void addNewBook(NewBook newBook) throws RemoteException {
            mBooks.add(newBook);
        }

        @Override
        public void registerListener(IOnNewBookArrivedListener listener) throws RemoteException {
//            if (!mListeners.contains(listener)) {
//                mListeners.add(listener);
//            } else {
//                Log.d(TAG, "already exists");
//            }
            mListeners.register(listener);
            Log.d(TAG, "registerListener, size:" + mListeners.beginBroadcast());
            mListeners.finishBroadcast();
//            Log.d(TAG, "registerListener, size:" + mListeners.size());
        }

        @Override
        public void unregisterListener(IOnNewBookArrivedListener listener) throws RemoteException {
//            if (mListeners.contains(listener)) {
//                mListeners.remove(listener);
//                Log.d(TAG, "unregisterListener listener succeed");
//            } else {
//                Log.d(TAG, "not found, can not unregisterListener");
//            }
            mListeners.unregister(listener);
            Log.d(TAG, "unregisterListener, size:" + mListeners.beginBroadcast());
            mListeners.finishBroadcast();
//            Log.d(TAG, "registerListener, size:" + mListeners.size());
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        mBooks.add(new NewBook(1, "Android"));
        mBooks.add(new NewBook(2, "Ios"));
        new Thread(new ServiceWorker()).start();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        int check = checkCallingOrSelfPermission("com.eebbk.open.scrollphotoitem.permission.ACCESS_BOOK_SERVICE");
        Log.d(TAG, "onbind check = " + check);
        if (check == PackageManager.PERMISSION_DENIED) {
            return null;
        }
        return mBinder;
    }

    public void onNewBookArrived(NewBook newBook) throws RemoteException {
        mBooks.add(newBook);
//        Log.d(TAG, "onNewBookArrived, notify listeners:" + mListeners.size());
//        for (int i = 0; i < mListeners.size(); i++) {
//            IOnNewBookArrivedListener listener = mListeners.get(i);
//            Log.d(TAG, "onNewBookArrived, notify listeners:" + listener);
//            listener.onNewBookArrived(newBook);
//        }
        final int N = mListeners.beginBroadcast();
        Log.d(TAG, "mListener size : " + N );
        for (int i = 0; i < N; i++) {
            IOnNewBookArrivedListener iOnNewBookArrivedListener = mListeners.getBroadcastItem(i);
            if (iOnNewBookArrivedListener != null) {
                try {
                    iOnNewBookArrivedListener.onNewBookArrived(newBook);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        mListeners.finishBroadcast();
    }

    private class ServiceWorker implements Runnable {

        @Override
        public void run() {
            while (!mAtomicBoolean.get()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int bookId = mBooks.size() + 1;
                NewBook newBook = new NewBook(bookId, "new book#" + bookId);
                try {
                    onNewBookArrived(newBook);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
