package com.eebbk.open.scrollphotoitem.IPC;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.eebbk.open.scrollphotoitem.R;

import java.util.List;

import static com.eebbk.open.scrollphotoitem.IPC.messenger.MyConstants.MSG_NEW_BOOK_ARRIVED;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/2 20:14
 * Email:  369013520@qq.com
 */

public class NewBookManagerActivity extends AppCompatActivity {

    private static final String TAG = NewBookManagerActivity.class.getSimpleName();
    private NewBookManager newBookManager;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_NEW_BOOK_ARRIVED:
                    Log.d(TAG, " receiver new book :" + msg.obj);
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    };

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            newBookManager = NewBookManager.Stub.asInterface(service);
            try {
                service.linkToDeath(mDeathRecipient, 0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            try {
                List<NewBook> newBookList = newBookManager.getNewBook();
//                Log.i(TAG, "query book list, list type:" + newBookList.getClass().getCanonicalName());
//                Log.i(TAG, "query book list: " + newBookList.toString());
                NewBook newBook = new NewBook(3, "安卓开发艺术探索");
                newBookManager.addNewBook(newBook);
                List<NewBook> newBookList1 = newBookManager.getNewBook();
//                Log.i(TAG, "query book newBookList1: " + newBookList1.toString());
                newBookManager.registerListener(mNewBookArrivedListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            newBookManager = null;
            Log.i(TAG, " onServiceDisconnected process name = " + IPCUtils.getProcessName(NewBookManagerActivity.this));
            Log.e(TAG, "binder died");
        }
    };

    private IOnNewBookArrivedListener mNewBookArrivedListener = new IOnNewBookArrivedListener.Stub() {
        @Override
        public void onNewBookArrived(NewBook newBook) throws RemoteException {
            mHandler.obtainMessage(MSG_NEW_BOOK_ARRIVED, newBook).sendToTarget();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipc_first);
        Intent intent = new Intent(this, BookManagerService.class);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
        findViewById(R.id.btn_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    newBookManager.getNewBook();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (newBookManager != null && newBookManager.asBinder().isBinderAlive()) {
            try {
                Log.i(TAG, "unregister listener:" + mNewBookArrivedListener);
                newBookManager.unregisterListener(mNewBookArrivedListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        unbindService(mServiceConnection);
    }

    private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() {
        @Override
        public void binderDied() {
            Log.i(TAG, " binderDied process name = " + IPCUtils.getProcessName(NewBookManagerActivity.this));
            if (newBookManager == null) {
                return;
            }
            newBookManager.asBinder().unlinkToDeath(mDeathRecipient, 0);
            newBookManager = null;
            Intent intent = new Intent(NewBookManagerActivity.this, BookManagerService.class);
            bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
        }
    };
}
