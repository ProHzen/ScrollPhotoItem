package DesignPatterns.AbstractFactory;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 17:42
 * Email:  369013520@qq.com
 */

public interface CompanyFactory {
    Store createStore();
    Checkstand createCheckStand();
    Tableware createTableware();
}
