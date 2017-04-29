package LOLDesignPatterns.MethodFactory;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/28 17:44
 * Email:  369013520@qq.com
 */

public class SummoneCanyon {

    private HeroInterface mHeroInterface;

    public SummoneCanyon setHeroInterface(HeroInterface heroInterface) {
        mHeroInterface = heroInterface;
        return this;
    }

    public Hero makeHero() {
        if (mHeroInterface == null) {
            throw new NullPointerException("mHeroInterface should not null");
        }
        return mHeroInterface.makeHero();
    }

    public static void main(String[] args) {

        SummoneCanyon summoneCanyon = new SummoneCanyon();

        summoneCanyon.setHeroInterface(new MasterFactory());
        System.out.println(summoneCanyon.makeHero().makeHero());

        summoneCanyon.setHeroInterface(new WarriorFactory());
        System.out.println(summoneCanyon.makeHero().makeHero());

        summoneCanyon.setHeroInterface(new SupportFactory());
        System.out.println(summoneCanyon.makeHero().makeHero());
    }
}
