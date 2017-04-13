package com.example;

public class SyncThreadTest {

    public static void main(String args[]) {

        final SynchronizedOtherBank bank = new SynchronizedOtherBank();
        Thread tAdd = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    bank.addMoney(100);
                    bank.lookMoney();
                    System.out.println("\n");
                }
            }
        });

        Thread tSub = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    bank.subMoney(100);
                    bank.lookMoney();
                    System.out.println("\n");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        tSub.start();
        tAdd.start();
    }

}
