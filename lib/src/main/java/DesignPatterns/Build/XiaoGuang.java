package DesignPatterns.Build;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/13 17:29
 * Email:  369013520@qq.com
 */

public class XiaoGuang {

    public static void main(String[] args) {
        HotDryNoodles noodlesA = new HotDryNoodles(true, true, false, false);
        System.out.println("Customer A wants: " + noodlesA);

        HotDryNoodles noodlesB = new HotDryNoodles(true, false, false, true);
        System.out.println("Customer A wants: " + noodlesB);

        HotDryNoodlesWithBuilder noodlesWithBuilderA = new HotDryNoodlesWithBuilder.Builder()
                .withChili()
                .withParsley()
                .build();
        System.out.println("Customer A wants: " + noodlesWithBuilderA);

        HotDryNoodlesWithBuilder noodlesWithBuilderB = new HotDryNoodlesWithBuilder.Builder()
                .withSauerkraut()
                .withShallot()
                .build();
        System.out.println("Customer A wants: " + noodlesWithBuilderB);

    }
}
