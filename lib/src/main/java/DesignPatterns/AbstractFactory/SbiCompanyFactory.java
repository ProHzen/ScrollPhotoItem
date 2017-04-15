package DesignPatterns.AbstractFactory;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 17:47
 * Email:  369013520@qq.com
 */

public class SbiCompanyFactory implements CompanyFactory {

    @Override
    public Store createStore() {
        return new SbiStore();
    }

    @Override
    public Checkstand createCheckStand() {
        return new SbiCheckStand();
    }

    @Override
    public Tableware createTableware() {
        return new SbiTableware();
    }
}
