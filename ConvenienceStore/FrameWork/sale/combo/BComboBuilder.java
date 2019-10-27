package sale.combo;

import factory.FoodFactoryA;
import foods.Food;
import foods.FoodProxyA;
import utils.info.PriceTable;

/**
 * @className: BComboBuilder
 * @author: Shidan Cheng
 * @description: B套餐 矿泉水+蛋黄酥+巧克力 具体Builder类
 * @designPattern: Builder
 * @date: 7:53 上午 2019/10/22
 * @version: v1.0
 */
public class BComboBuilder extends ComboBuilder {
    FoodProxyA foodProxyA = new FoodProxyA(FoodFactoryA.getInstance());


    public BComboBuilder() {
        super(PriceTable.B_COMBO_REDUCE_PRICE);
    }

    @Override
    protected void addDrink() {
        Food food = foodProxyA.createFood("矿泉水");
        System.out.printf(">>> B套餐-添加-饮品: %s", food.getName());
        this.foodCombo.addItem(food);
        this.comboPrice += food.getPrice();
    }

    @Override
    protected void addPastry() {
        Food food = foodProxyA.createFood("蛋黄酥");
        System.out.printf(">>> B套餐-添加-糕点: %s", food.getName());
        this.foodCombo.addItem(food);
        this.comboPrice += food.getPrice();
    }

    @Override
    protected void addSnack() {
        Food food = foodProxyA.createFood("巧克力");
        System.out.printf(">>> B套餐-添加-零食: %s", food.getName());
        this.foodCombo.addItem(food);
        this.comboPrice += food.getPrice();
    }
}