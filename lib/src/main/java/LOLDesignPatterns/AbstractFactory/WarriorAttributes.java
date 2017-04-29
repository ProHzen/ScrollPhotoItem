package LOLDesignPatterns.AbstractFactory;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/29 14:42
 * Email:  369013520@qq.com
 */

public class WarriorAttributes implements Attributes {

    @Override
    public String name() {
        return "战士";
    }

    @Override
    public String career() {
        return "ADCarry";
    }

    @Override
    public String position() {
        return "下路";
    }

    @Override
    public String toString() {
        return " 名字: " + name() + " 定位: " + career() + " 位置: " + position();
    }
}
