package kitchen.cooker;

import java.util.ArrayList;
import kitchen.ingredient.IngredientType;
import kitchen.ingredient.*;

/**
 * 厨具抽象基类
 * 设计模式：模版模式、责任链模式
 * @author Vector Xie、吕海军
 */
public abstract class Cooker {

    /**
     * 责任链用到的参数，给厨具排序
     * Steamer:FIRST
     * RiceCooker:SECOND
     * Wok:THIRD
     */
    public static int FIRST=1;
    public static int SECOND=200;
    public static int THIRD=3000;
    protected int priority;   

    /**
     * 获取厨具的优先级
     * @return int
     */
    public int getPriority(){
        return this.priority;
    }

    public Cooker() {
    }

    protected ArrayList<IngredientType> availableTypes;

    protected String name;

    private boolean isIngredientTypeAvailable(IngredientType type) {
        return availableTypes.contains(type);
    }

    private boolean isIngredientTypeAvailable(ArrayList<IngredientType> typeList) {
        for (IngredientType itype:typeList) {
            if(!availableTypes.contains(itype))return false;
        }
        return true;
    }

    public final void cook(Ingredient ingredient) {
        if(!isIngredientTypeAvailable(ingredient.getIngredientType())){
            System.out.println("不能用该厨具烹饪该食材！");
            return;
        }
        startCooking(ingredient);
        finishCooking(ingredient);
    }

    public final void cook(ArrayList<Ingredient> ingredientList) {
        for (Ingredient ingredient:ingredientList) {
            if(!isIngredientTypeAvailable(ingredient.getIngredientType())){
                System.out.println("不能用该厨具烹饪这些食材！");
                return;
            }
        }
        startCooking(ingredientList);
        finishCooking(ingredientList);
    }

    protected abstract void startCooking(Ingredient ingredient);

    protected abstract void finishCooking(Ingredient ingredient);

    protected abstract void startCooking(ArrayList<Ingredient> ingredientList);

    protected abstract void finishCooking(ArrayList<Ingredient> ingredientList);

    public String getName(){return name;}

    public void getAvailableType() {
        for (IngredientType type : availableTypes) {
            System.out.println("可烹饪食材：【"+type.toString()+"】");
        }
    }

}