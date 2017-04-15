package DesignPatterns.FactoryMethod;

import DesignPatterns.SimpleFactory.Drink;
import DesignPatterns.SimpleFactory.OrangeJuice;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 14:59
 * Email:  369013520@qq.com
 */

public class OrangeJuiceMachine implements IBeverageMachine {

    @Override
    public Drink makeDrink() {
        return new OrangeJuice().make();
    }
}
