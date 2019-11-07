package kitchen.ingredient;

/**
 * 子类鱼
 * @author 谢康
 */
public class Fish extends Ingredient {

    /**
     * Default constructor
     */
    public Fish() {
    }

    /**
     * 腐烂速度
     */
    private double staleSpeed = 1;

    /**
     * @return 名称
     */
    @Override
    public String getName(){
        return("鱼");
    }

    /**
     * 返回种类
     */
    @Override
    public IngredientType getIngredientType(){
        return IngredientType.FISH;
    }

    /**
     * 时间更新，进行腐烂
     */
    @Override
    public void update(){
        if(isState())
        {
            fresh -= staleSpeed;
            if(fresh<=0)
                setStale();
        }
    }

}