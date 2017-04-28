package LOLDesignPatterns.AbstractBuilder;

import LOLDesignPatterns.AbstractBuilder.Store;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/28 8:24
 * Email:  369013520@qq.com
 */

public class Store6300 implements Store {

    @Override
    public int price() {
        return 6300;
    }

    @Override
    public String toString() {
        return  " 价格: " + price();
    }
}
