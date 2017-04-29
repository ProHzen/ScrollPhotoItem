package LOLDesignPatterns.Singleton;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/29 15:05
 * Email:  369013520@qq.com
 */

public class SingletonDCL {

    private static volatile SingletonDCL singletonDCL;
    private SingletonDCL() {}
    public static SingletonDCL getInstance() {
        if (singletonDCL == null) {
            synchronized (SingletonDCL.class) {
                if (singletonDCL == null) {
                    singletonDCL = new SingletonDCL();
                }
            }
        }
        return singletonDCL;
    }
}
