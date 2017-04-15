package DesignPatterns.PrototypeMode;

import java.util.ArrayList;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/15 17:17
 * Email:  369013520@qq.com
 */

public class Company implements Cloneable {

    private ArrayList<String> drinks = new ArrayList<>();
    private String name;

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public void addDrink(String drink) {
        drinks.add(drink);
    }

    @Override
    protected Company clone() {
        Company company = null;
        try {
            company = (Company) super.clone();
            company.drinks = (ArrayList<String>) this.drinks.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public String toString() {
        return "{" +
                "名字: '" + getName() + '\'' +
                ", 饮品: " + drinks  + '\'' +
                '}';
    }
}
