package DesignPatterns.SimpleFactory;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 14:42
 * Email:  369013520@qq.com
 */

public class Coke extends Drink {

//    @Override
//    String getInstantPackage() {
//        return "速溶可乐粉";
//    }

    @Override
    protected String getInstantPackage() {
        return "速溶可乐粉";
    }

    @Override
    protected String getName() {
        return "可乐";
    }
}
