package kitchen.ingredient.state;
import kitchen.ingredient.*;

/**
 * 子类腐烂
 * 此状态表示未用，已腐烂
 * @author 谢康
 */
public class Stale implements State {

    /**
     * Default constructor
     */
    public Stale() {
    }

    /**
     * @return 名称
     */
    public String toString() {
        return "腐烂";
    }

    /**
     * 返回是否已用
     * 
     * @param ingredient 传入实例
     * @return 未用
     */
    @Override
    public boolean isCooked(Ingredient ingredient){return false;}

    /**
     * 返沪是否腐烂
     * 
     * @param ingredient 传入实例
     * @return 腐烂
     */
    @Override
    public boolean isStale(Ingredient ingredient){return true;}

}