package sale.combo;

import factory.FoodFactory;
import foods.Food;
import foods.FoodProxy;
import utils.enums.FoodType;
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
    FoodProxy foodProxy = new FoodProxy(FoodFactory.getInstance());


    public BComboBuilder() {
        super(PriceTable.B_COMBO_REDUCE_PRICE);
    }

    @Override
    public void addDrink() {
        Food food = foodProxy.createFood("矿泉水", FoodType.Drink);
        System.out.printf(">>> B套餐-添加-饮品: %s", food.getName());
        this.foodCombo.addItem(food);
        this.comboPrice += food.getPrice();
    }

    @Override
    public void addPastry() {
        Food food = foodProxy.createFood("蛋黄酥", FoodType.Pastry);
        System.out.printf(">>> B套餐-添加-糕点: %s", food.getName());
        this.foodCombo.addItem(food);
        this.comboPrice += food.getPrice();
    }

    @Override
    public void addSnack() {
        Food food = foodProxy.createFood("巧克力", FoodType.Snack);
        System.out.printf(">>> B套餐-添加-零食: %s", food.getName());
        this.foodCombo.addItem(food);
        this.comboPrice += food.getPrice();
    }
}