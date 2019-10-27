package sale.combo;

import factory.FoodFactoryA;
import foods.Food;
import foods.FoodProxyA;
import utils.info.PriceTable;

/**
 * @className: AComboBuilder
 * @author: Shidan Cheng
 * @description: A套餐 可乐+蛋挞+薯片 具体Builder类
 * @designPattern: Builder
 * @date: 7:53 上午 2019/10/22
 * @version: v1.0
 */
public class AComboBuilder extends ComboBuilder {
    FoodProxyA foodProxyA = new FoodProxyA(FoodFactoryA.getInstance());

    public AComboBuilder() {
        super(PriceTable.A_COMBO_REDUCE_PRICE);
    }

    @Override
    protected void addDrink() {
        Food food = foodProxyA.createFood("可乐");
        System.out.printf(">>> A套餐-添加-饮品: %s", food.getName());
        this.foodCombo.addItem(food);
        this.comboPrice += food.getPrice();
    }

    @Override
    protected void addPastry() {
        Food food = foodProxyA.createFood("蛋挞");
        System.out.printf(">>> A套餐-添加-糕点: %s", food.getName());
        this.foodCombo.addItem(food);
        this.comboPrice += food.getPrice();
    }

    @Override
    protected void addSnack() {
        Food food = foodProxyA.createFood("薯片");
        System.out.printf(">>> A套餐-添加-零食: %s", food.getName());
        this.foodCombo.addItem(food);
        this.comboPrice += food.getPrice();
    }
}