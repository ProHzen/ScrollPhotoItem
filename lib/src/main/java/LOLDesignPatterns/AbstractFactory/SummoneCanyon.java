package LOLDesignPatterns.AbstractFactory;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/29 14:21
 * Email:  369013520@qq.com
 */

public class SummoneCanyon {

    public static void main(String[] args) {
        HeroFactory masterFactory = new MasterFactory();
        Hero master = new Hero(masterFactory.attributes(), masterFactory.arms());
        master.makeHero();

        HeroFactory warriorFactory = new WarriorFactory();
        Hero warrior = new Hero(warriorFactory.attributes(), warriorFactory.arms());
        warrior.makeHero();
    }

}
