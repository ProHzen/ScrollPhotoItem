package com.eebbk.open.scrollphotoitem.DesignPatterns;

/**
 * Desc:   建造者模式之热干面
 * Author: YangShangZhen
 * Time:   2017/4/13 17:26
 * Email:  369013520@qq.com
 */

public class HotDryNoodles {

    private boolean addShallot;
    private boolean addParsely;
    private boolean addChili;
    private boolean addSauerkraut;

    public HotDryNoodles(boolean addShallot, boolean addParsely, boolean addChili, boolean addSauerkraut) {
        this.addShallot = addShallot;
        this.addParsely = addParsely;
        this.addChili = addChili;
        this.addSauerkraut = addSauerkraut;
    }

    @Override
    public String toString() {
        return "HotDryNoodles{" +
                "addShallot=" + addShallot +
                ", addParsely=" + addParsely +
                ", addChili=" + addChili +
                ", addSauerkraut=" + addSauerkraut +
                '}';
    }

}
