package LOLDesignPatterns.Singleton;

/**
 * Desc:   不要求线程安全，在多线程不能正常工作
 * Author: YangShangZhen
 * Time:   2017/4/29 14:51
 * Email:  369013520@qq.com
 */

public class SingletonLazy {

    private static SingletonLazy singletonLazy;

    public void SingletonLazy() {

    }

    public static SingletonLazy getInstance() {
        if (singletonLazy == null) {
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }


}
