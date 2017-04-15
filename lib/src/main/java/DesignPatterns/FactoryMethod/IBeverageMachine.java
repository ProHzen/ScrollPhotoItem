package DesignPatterns.FactoryMethod;

import DesignPatterns.SimpleFactory.Drink;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 14:57
 * Email:  369013520@qq.com
 */

public interface IBeverageMachine {
    Drink makeDrink();
}
