package LOLDesignPatterns.Decorate;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/29 16:26
 * Email:  369013520@qq.com
 */

public class AkaliClothing implements Hero {

    private Hero mHero;
    public AkaliClothing(Hero hero) {
        mHero = hero;
    }

    @Override
    public String make() {
        return mHero.make() + "穿着一件布衣";
    }
}
