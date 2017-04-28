package LOLDesignPatterns.AbstractBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/28 8:46
 * Email:  369013520@qq.com
 */

public class HeroTeam {

    List<Hero> mHeros = new ArrayList<>();

    public void addHero(Hero hero) {
        if (mHeros.size() < 5) {
            mHeros.add(hero);
        } else {
            System.out.println("最多只能有五个英雄");
        }
    }

    public void showHero() {
        for (Hero hero : mHeros) {
            System.out.println(hero.toString());
        }
        System.out.println("");
    }
}
