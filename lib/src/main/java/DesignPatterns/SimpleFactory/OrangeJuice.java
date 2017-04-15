package DesignPatterns.SimpleFactory;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 14:40
 * Email:  369013520@qq.com
 */

public class OrangeJuice extends Drink{
    @Override
    protected String getInstantPackage() {
        return "速溶橙汁粉";
    }

    @Override
    protected String getName() {
        return "橙汁";
    }

//    @Override
//    String getInstantPackage() {
//        return "速溶橙汁粉";
//    }
}
