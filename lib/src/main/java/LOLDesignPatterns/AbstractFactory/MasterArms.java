package LOLDesignPatterns.AbstractFactory;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/29 14:18
 * Email:  369013520@qq.com
 */

public class MasterArms implements Arms {

    @Override
    public String arm() {
        return "法杖";
    }

    @Override
    public String toString() {
        return " 武器: " + arm();
    }
}
