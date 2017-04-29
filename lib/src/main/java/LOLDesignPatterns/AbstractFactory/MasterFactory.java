package LOLDesignPatterns.AbstractFactory;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/29 14:20
 * Email:  369013520@qq.com
 */

public class MasterFactory implements HeroFactory {

    @Override
    public Attributes attributes() {
        return new MasterAttributes();
    }

    @Override
    public Arms arms() {
        return new MasterArms();
    }
}
