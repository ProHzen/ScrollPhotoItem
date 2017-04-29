package LOLDesignPatterns.MethodFactory;

/**
 * Desc:   法师工厂
 * Author: YangShangZhen
 * Time:   2017/4/28 17:23
 * Email:  369013520@qq.com
 */

public class MasterFactory implements HeroInterface{

    @Override
    public Hero makeHero() {
        return new Akali();
    }

}
