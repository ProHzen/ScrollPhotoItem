package DesignPatterns.ProxyMode;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 16:46
 * Email:  369013520@qq.com
 */

public class Singing {

    public static void main(String[] args) {
        DaLong daLong = new DaLong(new XiaoGuang());
        daLong.signing(120);
        daLong.signing(100);
        daLong.signing(80);
    }

}
