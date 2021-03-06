package com.eebbk.open.scrollphotoitem.IPC.ChatRoom;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.eebbk.open.scrollphotoitem.IPC.IPCUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/3 21:34
 * Email:  369013520@qq.com
 */

public class TcpServerService extends Service {

    private boolean mIsServiceDestoryed = false;
    private String[] mDefinedMessages = new String[]{
            "你好呀，哈哈", "请问你叫什么名字",
            "今天天气不错", "你知道吗？我可以跟很多人同时聊天",
            "给你讲个笑话吧"
    };

    @Override
    public void onCreate() {
        new Thread(new TcpServer()).start();
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mIsServiceDestoryed = true;
    }

    private class TcpServer implements Runnable {

        @Override
        public void run() {
            ServerSocket socket = null;
            try {
                socket = new ServerSocket(8688);
            } catch (IOException e) {
                System.out.println("establish tcp server failed, port:8688");
                e.printStackTrace();
                return;
            }

            while (!mIsServiceDestoryed) {
                try {
                    final Socket client = socket.accept();
                    System.out.println("accept");
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                responseClient(client);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private void responseClient(Socket client) throws IOException{
        // 接收客户端消息
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        // 向客户端发送消息
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
        out.println("欢迎来到聊天室");
        while (!mIsServiceDestoryed) {
            String str = in.readLine();
            System.out.println("msg from client: " + in);
            if (str == null) {
                break;
            }
            int i = new Random().nextInt(mDefinedMessages.length);
            String msg = mDefinedMessages[i];
            out.println(msg);
            System.out.println("send : " + msg);
            System.out.println("client quit.");
        }
//        IPCUtils.close(out);
//        IPCUtils.close(in);
        client.close();
    }
}
