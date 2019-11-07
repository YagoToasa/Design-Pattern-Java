package kitchen.container;

import kitchen.ingredient.IngredientType;

import java.util.*;

/**
 * 子类橱柜
 * 此类只可放入青菜、面粉、鸡蛋
 * 设计模式：迭代器模式。
 * @author 谢康
 */
public class Cabinet extends Container {

    /**
     * Default constructor
     */
    public Cabinet() {
        if (instance == null) {
            instance = this;
            availableTypes = new ArrayList<>(Arrays.asList(
                    IngredientType.VEGETABLES,
                    IngredientType.FLOUR,
                    IngredientType.EGG));
        } else {
            throw new IllegalStateException("Already initialized.");
        }
    }

    /**
     * 返回实例
     */
    private static Cabinet instance;

    /**
     * 返回单例
     * 
     * @return 实例
     */
    public static synchronized Cabinet getInstance() {
        if (instance == null) {
            instance = new Cabinet();
        }
        return instance;
    }

    /**
     * @return 名称
     */
    @Override
    public String getName()
    {
        return("橱柜");
    }
}