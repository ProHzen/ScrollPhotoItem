package LOLDesignPatterns.SimapleFactory;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/28 16:54
 * Email:  369013520@qq.com
 */

public class SummoneCanyon {

    public static void main(String[] args) {

        HeroInterface akali = new Akali();
        System.out.println(akali.name());

        HeroInterface syndra = new Syndra();
        System.out.println(syndra.name());

        HeroInterface leeSin = new LeeSin();
        System.out.println(leeSin.name());

    }

}
