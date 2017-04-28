package LOLDesignPatterns.AbstractBuilder;

import LOLDesignPatterns.AbstractBuilder.Hero3500;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/27 9:24
 * Email:  369013520@qq.com
 */

public class Akali extends Hero3500 {

    @Override
    public String name() {
        return "阿卡丽";
    }

    @Override
    public String attributes() {
        return "近战法师";
    }

    @Override
    public String position() {
        return "中路";
    }

}
