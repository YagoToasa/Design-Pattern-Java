package kitchen.ingredient;

/**
 * 子类青菜
 * @author 谢康
 */
public class Vegetables extends Ingredient {

    /**
     * Default constructor
     */
    public Vegetables() {
    }

    /**
     * 腐烂速度
     */
    private double staleSpeed = 0.3;

    /**
     * @return 名称
     */
    @Override
    public String getName(){
        return("青菜");
    }

    /**
     * @return 种类
     */
    @Override
    public IngredientType getIngredientType(){
        return IngredientType.VEGETABLES;

    }

    /**
     * 时间更新，进行腐烂
     */
    @Override
    public void update()
    {
        if(isState())
        {
            fresh -= staleSpeed;
            if(fresh<=0)
                setStale();
        }
    }
}