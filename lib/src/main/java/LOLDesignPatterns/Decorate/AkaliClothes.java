package LOLDesignPatterns.Decorate;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/29 16:36
 * Email:  369013520@qq.com
 */

public abstract class AkaliClothes implements Hero {

    private Hero mHero;
    public AkaliClothes(Hero hero) {
        mHero = hero;
    }

    @Override
    public String make() {
        return mHero.make() + getCloth();
    }

     abstract String getCloth();
}
