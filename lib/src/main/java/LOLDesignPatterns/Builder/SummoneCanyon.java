package LOLDesignPatterns.Builder;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/27 9:29
 * Email:  369013520@qq.com
 */

public class SummoneCanyon {

    public static void main(String args[]) {
        HeroTeamBuilder heroTeamBuilder = new HeroTeamBuilder();

        HeroTeam akaliTeam = heroTeamBuilder.prepareAkali();
        System.out.println("阿卡丽队伍");
        akaliTeam.showHero();

        HeroTeam syndraTeam = heroTeamBuilder.prepareSyndra();
        System.out.println("辛德拉队伍");
        syndraTeam.showHero();
    }

}

