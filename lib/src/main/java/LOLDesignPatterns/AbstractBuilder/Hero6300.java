package LOLDesignPatterns.AbstractBuilder;

import LOLDesignPatterns.AbstractBuilder.Hero;
import LOLDesignPatterns.AbstractBuilder.Store;
import LOLDesignPatterns.AbstractBuilder.Store6300;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/28 8:34
 * Email:  369013520@qq.com
 */

public abstract class Hero6300 implements Hero {

    @Override
    public Store heroPrice() {
        return new Store6300();
    }

    public abstract String name();

    @Override
    public String toString() {
        return "名字: " + name() + " 属性: " + attributes() + " 位置: " + position() + heroPrice();
    }
}
