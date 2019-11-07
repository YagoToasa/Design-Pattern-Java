package kitchen.ingredient.state;
import kitchen.ingredient.*;

/**
 * 抽象容器类。
 * 此类设置两个抽象函数。
 * 设计模式：策略模式。
 * @author 谢康
 */
public interface State {

    /**
     * 返回是否已用
     * 
     * @param ingredient 
     * @return 已用ture，未用false
     */
    public abstract boolean isCooked(Ingredient ingredient);

    /**
     * 返回是否腐烂
     * 
     * @param ingredient 
     * @return 腐烂true，未腐烂false
     */
    public abstract boolean isStale(Ingredient ingredient);

}