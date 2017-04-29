package LOLDesignPatterns.SimapleFactory;


/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/28 16:32
 * Email:  369013520@qq.com
 */

public class HeroFactory {

    public HeroInterface getHero(String name) {
       switch (name) {
           case "阿卡丽":
               return new Akali();
           case "辛德拉":
               return new Syndra();
           case "李青":
               return new LeeSin();
           default:
               return null;
       }
    }

}
