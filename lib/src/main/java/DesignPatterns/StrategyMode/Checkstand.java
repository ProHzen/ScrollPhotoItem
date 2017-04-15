package DesignPatterns.StrategyMode;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 15:47
 * Email:  369013520@qq.com
 */

public class Checkstand {

    private ActivityStrategy mActivityStrategy;

    public Checkstand() {
        mActivityStrategy =  new DefaultActivityStrategy();
    }

    public Checkstand(ActivityStrategy activityStrategy) {
        mActivityStrategy = activityStrategy;
    }

    public Checkstand setActivityStrategy(ActivityStrategy activityStrategy) {
        mActivityStrategy = activityStrategy;
        return this;
    }

    public void printBill() {
        System.out.println("本次账单活动:" + mActivityStrategy.getActivityPrice());
    }
}
