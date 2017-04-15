package DesignPatterns.AbstractFactory;


/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 17:48
 * Email:  369013520@qq.com
 */

public class XiaoGuang {

    public static void main(String[] args) {
        CompanyFactory companyFactory = new SbiCompanyFactory();
        Company sbiCompany = new Company(companyFactory.createStore(), companyFactory.createCheckStand(), companyFactory.createTableware());
        System.out.println(sbiCompany);
    }

}
