package kitchen.cooker;

import java.util.*;
import kitchen.ingredient.*;

/**
 * 炒锅类
 * 设计模式：模版模式
 * @author Vector Xie
 */
public class Wok extends Cooker {

    public Wok() {
        //设置优先级
        this.priority=Cooker.THIRD;
        availableTypes = new ArrayList<>(Arrays.asList(
                IngredientType.TOFU,
                IngredientType.VEGETABLES));
        name = "锅";
    }

    @Override
    protected void startCooking(Ingredient ingredient) {
        System.out.println("用锅开始烹饪 【" + ingredient.getName() + "】 ...");
    }

    @Override
    protected void finishCooking(Ingredient ingredient) {
        ingredient.setCooked();
        FancyCut fancyCut = new FancyCut(ingredient);
        System.out.println("香喷喷~ 【" + ingredient.getName() + "】 熟啦！");
    }

    @Override
    protected void startCooking(ArrayList<Ingredient> ingredientList) {
        for (Ingredient ingredient : ingredientList) {
            System.out.println("用锅开始烹饪 【" + ingredient.getName() + "】 ...");
        }
    }

    @Override
    protected void finishCooking(ArrayList<Ingredient> ingredientList) {
        for (Ingredient ingredient : ingredientList) {
            ingredient.setCooked();
            FancyCut fancyCut = new FancyCut(ingredient);
            System.out.println("香喷喷~ 【" + ingredient.getName() + "】 熟啦！");
        }
    }

}