package Excutor;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/5/8 18:08
 * Email:  369013520@qq.com
 */

public class Excutor {

    private static final AtomicLong l = new AtomicLong(0) ;

    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        ExecutorService singleThreadScheduledPool = Executors.newSingleThreadScheduledExecutor();

//        excutorService(scheduledThreadPool);

        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                System.out.println(" schedule  threadName = " + threadName);
            }
        }, 2, TimeUnit.SECONDS);

        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                long i =  l.getAndAdd(1) ;
                System.out.println("scheduleAtFixedRate start " + i);

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("scheduleAtFixedRate end " + i);
            }
        }, 1, 2, TimeUnit.SECONDS);

        scheduledThreadPool.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                long i =  l.getAndAdd(1) ;
                System.out.println("scheduleWithFixedDelay start " + i);

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("scheduleWithFixedDelay end " + i);
            }
        }, 1, 2, TimeUnit.SECONDS);

    }

    private static void excutorService(ExecutorService pool) {
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    String threadName = Thread.currentThread().getName();
                    System.out.println(" threadName = " + threadName + " 正在执行第 " + index + " 个任务");
                    try {
                        long time = index * 500;
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}
