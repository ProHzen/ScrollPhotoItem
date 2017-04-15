package DesignPatterns.StrategyMode;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 15:46
 * Email:  369013520@qq.com
 */

public class ChristmasStrategy implements ActivityStrategy {
    @Override
    public String getActivityPrice() {
        return "(圣诞节)买热干面+饮品套餐, 送大苹果一个";
    }
}
