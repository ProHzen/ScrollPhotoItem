package DesignPatterns.ProxyMode;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 16:48
 * Email:  369013520@qq.com
 */

public class XiaoGuang implements Person{

    @Override
    public void signing(int price) {
        System.out.println("签单" + price);
    }
}
