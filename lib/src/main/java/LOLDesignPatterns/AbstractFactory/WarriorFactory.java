package LOLDesignPatterns.AbstractFactory;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/29 14:41
 * Email:  369013520@qq.com
 */

public class WarriorFactory implements HeroFactory {

    @Override
    public Attributes attributes() {
        return new WarriorAttributes();
    }

    @Override
    public Arms arms() {
        return new WarriorArms();
    }
}
