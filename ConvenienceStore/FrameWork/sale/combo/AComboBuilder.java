package sale.combo;

import factory.AbstractFactory;
import factory.FoodFactory;
import foods.Food;
import foods.FoodProxy;
import foods.Pastry;
import utils.enums.FoodType;
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
    FoodProxy foodProxy = new FoodProxy(FoodFactory.getInstance());

    public AComboBuilder() {
        super(PriceTable.A_COMBO_REDUCE_PRICE);
    }

    @Override
    public void addDrink() {
        Food food = foodProxy.createFood("可乐", FoodType.Drink);
        System.out.printf(">>> A套餐-添加-饮品: %s", food.getName());
        this.foodCombo.addItem(food);
        this.comboPrice += food.getPrice();
    }

    @Override
    public void addPastry() {
        Food food = foodProxy.createFood("蛋挞", FoodType.Pastry);
        System.out.printf(">>> A套餐-添加-糕点: %s", food.getName());
        this.foodCombo.addItem(food);
        this.comboPrice += food.getPrice();
    }

    @Override
    public void addSnack() {
        Food food = foodProxy.createFood("薯片", FoodType.Snack);
        System.out.printf(">>> A套餐-添加-零食: %s", food.getName());
        this.foodCombo.addItem(food);
        this.comboPrice += food.getPrice();
    }
}