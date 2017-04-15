package DesignPatterns.Build;

/**
 * Desc:   建造者模式之热干面
 * Author: YangShangZhen
 * Time:   2017/4/13 17:26
 * Email:  369013520@qq.com
 */

public class HotDryNoodles {

    private boolean addShallot;
    private boolean addParsley;
    private boolean addChili;
    private boolean addSauerkraut;

    public HotDryNoodles(boolean addShallot, boolean addParsely, boolean addChili, boolean addSauerkraut) {
        this.addShallot = addShallot;
        this.addParsley = addParsely;
        this.addChili = addChili;
        this.addSauerkraut = addSauerkraut;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder("A bowl of hot-dry noodles has:");
        if (this.addShallot) {
            builder.append("葱花.");
        }
        if (this.addParsley) {
            builder.append("香菜.");
        }
        if (this.addChili) {
            builder.append("辣椒.");
        }
        if (this.addSauerkraut) {
            builder.append("酸菜.");
        }
        return builder.toString();
    }

}
