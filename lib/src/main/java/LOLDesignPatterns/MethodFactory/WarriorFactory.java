package LOLDesignPatterns.MethodFactory;

/**
 * Desc:   战士工厂
 * Author: YangShangZhen
 * Time:   2017/4/28 17:27
 * Email:  369013520@qq.com
 */

public class WarriorFactory implements HeroInterface {

    @Override
    public Hero makeHero() {
        return new Jax();
    }
}
