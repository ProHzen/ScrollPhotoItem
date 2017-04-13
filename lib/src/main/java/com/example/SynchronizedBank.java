package com.example;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/11 20:10
 * Email:  369013520@qq.com
 */

public class SynchronizedBank {

    private int count = 0;

    public synchronized void addMoney(int money) {
        count += money;
        System.out.println(System.currentTimeMillis()+"存进："+money);
    }

    public synchronized void subMoney(int money) {
        if (count - money < 0) {
            System.out.println("余额不足");
            return;
        }
        count -= money;
        System.out.println(System.currentTimeMillis()+"取出："+money);
    }

    public void lookMoney(){
        System.out.println("账户余额："+count);
    }

}
