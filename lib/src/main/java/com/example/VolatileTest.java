package com.example;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/10/27 17:45
 * Email:  369013520@qq.com
 */

public  class VolatileTest {

    private static volatile int number;

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    number++;
                    System.out.print("thread111111" +
                            " name = " + Thread.currentThread().getName() + " number = " + number);
                }
            }
        });
        thread1.start();


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("thread2222222" +
                        " name = " + Thread.currentThread().getName() + " number = " + number);
            }
        });
        thread2.start();

    }

}
