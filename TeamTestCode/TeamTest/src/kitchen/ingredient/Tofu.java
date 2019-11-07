package kitchen.ingredient;

/**
 * 子类豆腐
 * @author 谢康
 */
public class Tofu extends Ingredient {

    /**
     * Default constructor
     */
    public Tofu() {
    }

    /**
     * 腐烂速度
     */
    private double staleSpeed = 0.5;

    /**
     * @return 名称
     */
    @Override
    public String getName(){
        return("豆腐");
    }

    /**
     * @return 种类
     */
    @Override
    public IngredientType getIngredientType(){
        return IngredientType.TOFU;

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