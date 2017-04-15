package DesignPatterns.StrategyMode;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 15:47
 * Email:  369013520@qq.com
 */

public class DefaultActivityStrategy implements ActivityStrategy {
    @Override
    public String getActivityPrice() {
        return  "没有活动";
    }
}
