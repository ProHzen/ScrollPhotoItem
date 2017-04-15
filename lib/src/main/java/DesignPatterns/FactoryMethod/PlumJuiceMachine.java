package DesignPatterns.FactoryMethod;

import DesignPatterns.SimpleFactory.Drink;
import DesignPatterns.SimpleFactory.OrangeJuice;
import DesignPatterns.SimpleFactory.PlumJuice;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 14:59
 * Email:  369013520@qq.com
 */

public class PlumJuiceMachine implements IBeverageMachine {

    @Override
    public Drink makeDrink() {
        return new PlumJuice().make();
    }
}
