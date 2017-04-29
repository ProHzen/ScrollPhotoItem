package LOLDesignPatterns.AbstractFactory;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/29 14:44
 * Email:  369013520@qq.com
 */

public class WarriorArms implements Arms {

    @Override
    public String arm() {
        return "弓箭";
    }

    public String toString() {
        return " 武器: " + arm();
    }

}
