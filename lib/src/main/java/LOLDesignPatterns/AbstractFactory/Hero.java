package LOLDesignPatterns.AbstractFactory;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/29 14:25
 * Email:  369013520@qq.com
 */

public class Hero {

    private Attributes mAttributes;
    private Skin mSkin;
    private Arms mArms;

    public Hero (Attributes attributes, Arms arms) {
        mAttributes = attributes;
        mArms = arms;
    }

    public void makeHero() {
        System.out.println(mAttributes.toString() +  mArms.toString());
    }

}
