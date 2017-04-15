package DesignPatterns.DecorativeMode;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 16:17
 * Email:  369013520@qq.com
 */

public abstract class Stuff implements Drink {

    private Drink mDrink;

    public Stuff(Drink drink) {
        mDrink = drink;
    }

    @Override
    public String make() {
        return mDrink.make() + stuffName();
    }

    abstract String stuffName();
}
