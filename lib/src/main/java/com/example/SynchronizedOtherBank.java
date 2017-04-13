package com.example;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/11 20:10
 * Email:  369013520@qq.com
 */

public class SynchronizedOtherBank {

    private int count = 0;

    public void addMoney(int money) {
        synchronized (this) {
            count += money;
        }
        System.out.println(System.currentTimeMillis()+"存进："+money);
    }

    public void subMoney(int money) {
        synchronized (this) {
            if (count - money < 0) {
                System.out.println("余额不足");
                return;
            }
            count -= money;
        }
        System.out.println(System.currentTimeMillis()+"取出："+money);
    }

    public void lookMoney(){
        System.out.println("账户余额："+count);
    }

}
