package LOLDesignPatterns.Builder;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/28 9:01
 * Email:  369013520@qq.com
 */

public class HeroTeamBuilder {

    public HeroTeam prepareAkali() {
        HeroTeam heroTeam = new HeroTeam();
        heroTeam.addHero(new Akali());
        heroTeam.addHero(new LeeSin());
        return heroTeam;
    }

    public HeroTeam prepareSyndra() {
        HeroTeam heroTeam = new HeroTeam();
        heroTeam.addHero(new Syndra());
        heroTeam.addHero(new JarvanIV());
        return heroTeam;
    }

}
