package DesignPatterns.DecorativeMode;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 16:13
 * Email:  369013520@qq.com
 */

public class Ice extends Stuff {

    public Ice(Drink drink) {
        super(drink);
    }

    @Override
    String stuffName() {
        return "加一块冰";
    }


}
