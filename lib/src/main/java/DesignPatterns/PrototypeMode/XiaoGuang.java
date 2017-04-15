package DesignPatterns.PrototypeMode;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 17:22
 * Email:  369013520@qq.com
 */

public class XiaoGuang {

    public static void main(String[] args) {
        Company ovCompany = new OpticalValleyCompany();
        System.out.println("光谷店: " + ovCompany);

        // 在光谷店的基础上clone SBI店
        Company sbiCompany = ovCompany.clone();
        sbiCompany.setName("创业街分店");

        // 给SBI店新增一款饮品
        sbiCompany.addDrink("雪碧");
        System.out.println("SBI店: " + sbiCompany);

        // 打印下光谷店ovCompany
        System.out.println("光谷店: " + ovCompany);


    }

}
