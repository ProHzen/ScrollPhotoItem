package DesignPatterns.ProxyMode;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 16:44
 * Email:  369013520@qq.com
 */

public class DaLong implements Person {

    private Person mPerson;

    public DaLong(Person person) {
        mPerson = person;
    }

    @Override
    public void signing(int price) {
        System.out.println("对方报价: " + price);

        if (price > 100) {
            negotiate(price);
        } else {
            this.mPerson.signing(price);
        }

    }

    private void negotiate(int price) {
        System.out.println("不接受, 要求降价" + (price - 80));
    }
}
