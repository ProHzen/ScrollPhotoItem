package DesignPatterns.SimpleFactory;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 14:40
 * Email:  369013520@qq.com
 */

public abstract class Drink {

//  public void make() {
//        System.out.println("拿出一次性饮料杯");
//
//        System.out.println("加入:" + getInstantPackage());
//
//        System.out.println("加水冲兑");
//
//        System.out.println("加盖,打包");
//    }

//    abstract String getInstantPackage();

    private String name;
    private String instantPackage;

    public Drink make() {
        this.name = getName();
        this.instantPackage = getInstantPackage();
        return this;
    }

    protected abstract String getInstantPackage();

    protected abstract String getName();

    @Override
    public String toString() {
        return "This is a cup of " + this.name;
    }
}
