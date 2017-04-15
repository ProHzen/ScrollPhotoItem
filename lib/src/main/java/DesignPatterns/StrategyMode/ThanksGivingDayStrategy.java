package DesignPatterns.StrategyMode;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 15:45
 * Email:  369013520@qq.com
 */

public class ThanksGivingDayStrategy implements ActivityStrategy {

    @Override
    public String getActivityPrice() {
        return "(感恩节)所有饮品一律5折";
    }
}
