package kitchen.ingredient.state;
import kitchen.ingredient.*;

/**
 * 子类已用
 * 此状态表示已用，未腐烂
 * @author 谢康
 */
public class Cooked implements State {

    /**
     * Default constructor
     */
    public Cooked() {
    }

    /**
     * @return 名称
     */
    public String toString() {
        return "已用";
    }

    /**
     * 返回是否已用
     * 
     * @param ingredient 
     * @return true
     */
    @Override
    public boolean isCooked(Ingredient ingredient){return true;}

    /**
     * 返回是否新鲜
     * 
     * @param ingredient 
     * @return true
     */
    @Override
    public boolean isStale(Ingredient ingredient){return false;}

}