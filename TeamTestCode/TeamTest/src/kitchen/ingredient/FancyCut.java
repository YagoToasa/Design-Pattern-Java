package kitchen.ingredient;

/**
 * 处理方法类。
 * 设计模式：装饰器模式。
 * @author 谢康
 */
public class FancyCut implements CutInterface  {
    
    /**
     * 实例
     */
    private Ingredient ingredient;

    /**
     * Default constructor
     * @param obj 传入的实例
     */
    public FancyCut(Ingredient obj)
    {
        ingredient = obj;
    }


     /**
     * 显示对应的处理方法
     */
    @Override
    public void displayCut() {
        if(ingredient.getIngredientType() == IngredientType.EGG)
        {
            System.out.println("厨师使用神来一击，对"+ingredient.getName()+"完成了打碎以及搅拌。");
        }
        else if(ingredient.getIngredientType() == IngredientType.FLOUR)
        {
            System.out.println("厨师使用推拿掌法，将"+ingredient.getName()+"和成活面。");
        }
        else
        {
            System.out.println("厨师使用刀法飞龙在天，对"+ingredient.getName()+"完成了切片。");
        }
    }

    @Override
    public boolean isCut() {
        return true;
    }
}
