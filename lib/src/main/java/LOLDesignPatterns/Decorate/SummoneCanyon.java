package LOLDesignPatterns.Decorate;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/29 16:31
 * Email:  369013520@qq.com
 */

public class SummoneCanyon {

    public static void main(String[] args) {

        Akali akali = new Akali();
        System.out.println(akali.make());

        AkaliClothing akaliClothing = new AkaliClothing(akali);
        System.out.println(akaliClothing.make());

        AkaliClothArmor akaliClothArmor = new AkaliClothArmor(akali);
        System.out.println(akaliClothArmor.make());

    }

}
