package LOLDesignPatterns.AbstractFactory;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/29 14:16
 * Email:  369013520@qq.com
 */

public class MasterAttributes implements Attributes{

    @Override
    public String name() {
        return "法师";
    }

    @Override
    public String career() {
        return "刺客法师";
    }

    @Override
    public String position() {
        return "上路";
    }

    @Override
    public String toString() {
        return " 名字: " + name() + " 定位: " + career() + " 位置: " + position();
    }
}
