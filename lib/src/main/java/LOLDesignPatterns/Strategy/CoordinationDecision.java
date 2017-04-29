package LOLDesignPatterns.Strategy;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/29 16:59
 * Email:  369013520@qq.com
 */

public class CoordinationDecision {

    private Coordination mCoordination;

    public CoordinationDecision setCoordination(Coordination coordination) {
        mCoordination = coordination;
        return this;
    }

    public CoordinationDecision() {
        mCoordination = new Guard();
    }

    public void decide() {
        System.out.println(mCoordination.adCarryAndSupport());
    }

}
