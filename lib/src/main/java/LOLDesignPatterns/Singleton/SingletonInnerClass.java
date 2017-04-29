package LOLDesignPatterns.Singleton;

/**
 * Desc:   对静态域使用延迟初始化，应使用这种方式而不是双检锁方式
 * Author: YangShangZhen
 * Time:   2017/4/29 15:10
 * Email:  369013520@qq.com
 */

public class SingletonInnerClass {
    private static class SingletonHolder {
        private static final SingletonInnerClass singletonInnerClass = new SingletonInnerClass();
    }

    private SingletonInnerClass() {}

    public static final SingletonInnerClass getInstance() {
        return SingletonHolder.singletonInnerClass;
    }

}
