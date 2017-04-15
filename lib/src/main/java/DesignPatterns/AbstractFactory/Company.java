package DesignPatterns.AbstractFactory;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 17:50
 * Email:  369013520@qq.com
 */

public class Company {

    private Store mStore;
    private Checkstand mCheckstand;
    private Tableware mTableware;

    public Company(Store store, Checkstand stand, Tableware tableware) {
        mStore = store;
        mCheckstand = stand;
        mTableware = tableware;
    }

    @Override
    public String toString() {
        return "分店{" + "地址:" + mStore.getAddress() + ", 名字:" + mStore.getName()
                + ", 收银账户:" + mCheckstand.getAccount()
                + ", 杯具餐具标签:" + mTableware.getLabel() + "}";
    }
}
