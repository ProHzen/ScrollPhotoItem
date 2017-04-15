package DesignPatterns.SimpleFactory;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 14:42
 * Email:  369013520@qq.com
 */

public class PlumJuice extends Drink {
    @Override
    protected String getInstantPackage() {
        return "速溶酸梅粉";
    }

    @Override
    protected String getName() {
        return "酸梅汤";
    }

//    @Override
//    String getInstantPackage() {
//        return "速溶酸梅粉";
//    }
}
