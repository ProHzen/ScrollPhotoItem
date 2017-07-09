package com.eebbk.open.scrollphotoitem.IPC.ChatRoom;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.eebbk.open.scrollphotoitem.R;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/3 21:53
 * Email:  369013520@qq.com
 */

public class TcpClientActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int MESSAGE_RECEIVE_NEW_MSG = 1;
    private static final int MESSAGE_RSOCKET_CONNCTED = 2;

    private Button mSendButton;
    private TextView mMessageTextView;
    private EditText mMessageEditText;

    private PrintWriter mPrintWriter;
    private Socket mClientSocket;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MESSAGE_RECEIVE_NEW_MSG:
                    mMessageTextView.setText(mMessageTextView.getText() + (String)msg.obj);
                    break;
                case MESSAGE_RSOCKET_CONNCTED:
                    mSendButton.setEnabled(true);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipc_first);
        mSendButton = (Button) findViewById(R.id.btn_first);
        mMessageTextView = (TextView) findViewById(R.id.tv_msg);
        mMessageEditText = (EditText) findViewById(R.id.edt_msg);

        mSendButton.setOnClickListener(this);
        Intent intent = new Intent(this, TcpServerService.class);
        startService(intent);
        new Thread(new Runnable() {
            @Override
            public void run() {
                connectTcpServer();
            }
        }).start();
    }

    private void connectTcpServer() {
        Socket socket = null;
        while (socket == null) {
            try {
                socket = new Socket("localhost", 8688);
                mClientSocket = socket;
                mPrintWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                mHandler.sendEmptyMessage(MESSAGE_RSOCKET_CONNCTED);
                System.out.println("connect server success");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("connect server failed");
            }


        }
    }

    @Override
    public void onClick(View v) {

    }
}
