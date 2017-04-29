package LOLDesignPatterns.Singleton;

/**
 * Desc:   必须加锁 synchronized 才能保证单例，但加锁会影响效率。效率很低，99% 情况下不需要同步
 * Author: YangShangZhen
 * Time:   2017/4/29 14:56
 * Email:  369013520@qq.com
 */

public class SingletonLazyThreadSafely {

    private static SingletonLazyThreadSafely singletonLazyThreadSafely;

    public void SingletonLazyThreadSafely() {
    }

    public static synchronized SingletonLazyThreadSafely getSingletonLazyThreadSafely() {
        if (singletonLazyThreadSafely == null) {
            singletonLazyThreadSafely = new SingletonLazyThreadSafely();
        }
        return singletonLazyThreadSafely;
    }
}
