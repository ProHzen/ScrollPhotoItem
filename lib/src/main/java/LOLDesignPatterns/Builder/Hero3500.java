package LOLDesignPatterns.Builder;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/28 8:33
 * Email:  369013520@qq.com
 */

public abstract class Hero3500 implements Hero {

    @Override
    public Store heroPrice() {
        return new Store3500();
    }

    @Override
    public abstract String name();

    @Override
    public String toString() {
        return "名字: " + name() + " 属性: " + attributes() + " 位置: " + position() + heroPrice();
    }
}
