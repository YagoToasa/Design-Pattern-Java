package kitchen.ingredient.state;
import kitchen.ingredient.*;

/**
 * 子类新鲜
 * 此状态表示未用，未腐烂
 * @author 谢康
 */
public class Fresh implements State {

    /**
     * Default constructor
     */
    public Fresh() {
    }

    /**
     * @return 名称
     */
    public String toString() {
        return "新鲜";
    }

    /**
     * 返回是否已用
     * 
     * @param ingredient 
     * @return false
     */
    @Override
    public boolean isCooked(Ingredient ingredient){return false;}

    /**
     * 返回是否腐烂
     * 
     * @param ingredient 
     * @return false
     */
    @Override
    public boolean isStale(Ingredient ingredient){return false;}

}