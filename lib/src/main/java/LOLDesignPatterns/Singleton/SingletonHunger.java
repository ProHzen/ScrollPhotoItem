package LOLDesignPatterns.Singleton;

/**
 * Desc:   类加载时就初始化，浪费内存。
 * Author: YangShangZhen
 * Time:   2017/4/29 15:00
 * Email:  369013520@qq.com
 */

public class SingletonHunger  {

    private static SingletonHunger singletonHunger = new SingletonHunger();
    private SingletonHunger() {}
    public static SingletonHunger getInstance() {
        return singletonHunger;
    }

}
