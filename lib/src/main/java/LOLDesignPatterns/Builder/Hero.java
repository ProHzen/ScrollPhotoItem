package LOLDesignPatterns.Builder;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/27 9:07
 * Email:  369013520@qq.com
 */

public interface Hero {

    // 名字
    String name();

    // 属性: 法师 战士 坦克
    String attributes();

    // 商店: 英雄价格
    Store heroPrice();

    // 英雄位置: 上路 中路 ...
    String position();

}
