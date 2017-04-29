package LOLDesignPatterns.MethodFactory;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/28 17:34
 * Email:  369013520@qq.com
 */

public class SupportFactory implements HeroInterface {

    @Override
    public Hero makeHero() {
        return new Blitzcrank();
    }
}
