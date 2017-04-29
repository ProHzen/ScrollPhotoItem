package LOLDesignPatterns.MethodFactory;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/28 17:13
 * Email:  369013520@qq.com
 */

public abstract class Hero {

    private String name;
    private String skin;

    public Hero makeHero() {
        this.name = getName();
        this.skin = getSkin();
        return this;
    }

    abstract String getName();
    abstract String getSkin();

    @Override
    public String toString() {
        return getName() + "穿着--" + getSkin();
    }
}
