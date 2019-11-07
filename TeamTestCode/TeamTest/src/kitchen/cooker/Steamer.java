package kitchen.cooker;

import java.util.*;
import kitchen.ingredient.IngredientType;
import kitchen.ingredient.*;

/**
 * 蒸笼类
 * 设计模式：模版模式
 * @author Vector Xie
 */
public class Steamer extends Cooker {

    public Steamer() {
        //设置优先级
        this.priority=Cooker.FIRST;
        availableTypes = new ArrayList<>(Arrays.asList(
                IngredientType.FLOUR));
        name = "蒸笼";
    }

    @Override
    protected void startCooking(Ingredient ingredient) {
        System.out.println("用蒸笼开始烹饪 【" + ingredient.getName() + "】 ...");
    }

    @Override
    protected void finishCooking(Ingredient ingredient) {
        ingredient.setCooked();
        FancyCut fancyCut = new FancyCut(ingredient);
        System.out.println("热气腾腾~ 【" + ingredient.getName() + "】 熟啦！");
    }

    @Override
    protected void startCooking(ArrayList<Ingredient> ingredientList) {
        for (Ingredient ingredient : ingredientList) {
            System.out.println("用蒸笼开始烹饪 【" + ingredient.getName() + "】 ...");
        }
    }

    @Override
    protected void finishCooking(ArrayList<Ingredient> ingredientList) {
        for (Ingredient ingredient : ingredientList) {
            ingredient.setCooked();
            FancyCut fancyCut = new FancyCut(ingredient);
            System.out.println("热气腾腾~ 【" + ingredient.getName() + "】 熟啦！");
        }
    }

}