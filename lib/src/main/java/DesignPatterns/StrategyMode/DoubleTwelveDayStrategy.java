package DesignPatterns.StrategyMode;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 15:46
 * Email:  369013520@qq.com
 */

public class DoubleTwelveDayStrategy implements ActivityStrategy {

    @Override
    public String getActivityPrice() {
        return "(双十二)满12立减2元";
    }
}
