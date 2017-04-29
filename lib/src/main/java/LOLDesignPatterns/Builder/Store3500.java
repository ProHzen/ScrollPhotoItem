package LOLDesignPatterns.Builder;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/27 9:19
 * Email:  369013520@qq.com
 */

public class Store3500 implements Store {

    @Override
    public int price() {
        return 3500;
    }

    @Override
    public String toString() {
        return  " 价格: " + price();
    }
}
