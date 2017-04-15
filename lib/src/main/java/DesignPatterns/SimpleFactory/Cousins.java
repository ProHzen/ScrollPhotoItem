package DesignPatterns.SimpleFactory;

import DesignPatterns.FactoryMethod.CokeMachine;
import DesignPatterns.FactoryMethod.IBeverageMachine;
import DesignPatterns.FactoryMethod.OrangeJuiceMachine;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 14:48
 * Email:  369013520@qq.com
 */

public class Cousins {

//    public static Drink create(String drinkType) {
//        switch (drinkType) {
//            case "橙汁":
//                return new OrangeJuice();
//            case "可乐":
//                return new Coke();
//            case "酸梅汤":
//                return new PlumJuice();
//            default:
//                return new OrangeJuice();
//        }
//    }

    private IBeverageMachine mBeverageMachine;

    private void setBeverageMachine(IBeverageMachine machine) {
        mBeverageMachine = machine;
    }

    private Drink takeDrink() {
        if (mBeverageMachine == null) {
            throw new NullPointerException("Should set Beverage Machine firstly.");
        }
        return mBeverageMachine.makeDrink();
    }

    public static void main(String[] args) {
        Cousins cousins = new Cousins();
        cousins.setBeverageMachine(new OrangeJuiceMachine());
        Drink orange = cousins.takeDrink();
        System.out.println(orange);

        cousins.setBeverageMachine(new CokeMachine());
        Drink coke = cousins.takeDrink();
        System.out.println(coke);
    }

}
