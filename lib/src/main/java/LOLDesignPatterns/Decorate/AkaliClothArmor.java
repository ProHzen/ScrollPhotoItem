package LOLDesignPatterns.Decorate;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/29 16:38
 * Email:  369013520@qq.com
 */

public class AkaliClothArmor extends AkaliClothes {

    public AkaliClothArmor(Hero hero) {
        super(hero);
    }

    @Override
    String getCloth() {
        return "穿着一件盔甲";
    }
}
