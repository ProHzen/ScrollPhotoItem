package DesignPatterns.AbstractFactory;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 17:45
 * Email:  369013520@qq.com
 */

public class SbiStore implements Store {

    @Override
    public String getAddress() {
        return "关山创业街";
    }

    @Override
    public String getName() {
        return "SBI店";
    }
}
