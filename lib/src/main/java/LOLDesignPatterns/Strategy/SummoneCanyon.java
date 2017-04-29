package LOLDesignPatterns.Strategy;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/29 17:01
 * Email:  369013520@qq.com
 */

public class SummoneCanyon {

    public static void main(String[] args) {

        CoordinationDecision coordinationDecision = new CoordinationDecision();
        coordinationDecision.decide();

        CoordinationDecision guardDecision = new CoordinationDecision();
        guardDecision.setCoordination(new Guard());
        guardDecision.decide();

        CoordinationDecision radicalDecision = new CoordinationDecision();
        radicalDecision.setCoordination(new Radical());
        radicalDecision.decide();

    }

}
