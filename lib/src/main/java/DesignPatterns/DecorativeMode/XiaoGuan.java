package DesignPatterns.DecorativeMode;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 16:22
 * Email:  369013520@qq.com
 */

public class XiaoGuan {

    public static void main(String[] args) {
        Ice ice = new Ice(new Coke());
        System.out.println(ice.make());
    }
}
