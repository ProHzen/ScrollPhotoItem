package DesignPatterns.FactoryMethod;

import DesignPatterns.SimpleFactory.Coke;
import DesignPatterns.SimpleFactory.Drink;
import DesignPatterns.SimpleFactory.OrangeJuice;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 14:59
 * Email:  369013520@qq.com
 */

public class CokeMachine implements IBeverageMachine {

    @Override
    public Drink makeDrink() {
        return new Coke().make();
    }
}
