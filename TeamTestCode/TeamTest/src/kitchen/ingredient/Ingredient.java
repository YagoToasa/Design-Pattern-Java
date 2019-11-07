package kitchen.ingredient;
import kitchen.time.*;
import kitchen.ingredient.state.*;

/**
 * 原料抽象类。
 * 拥有新鲜度、食物状态两个参数。
 * 可以获取名称。
 * 设计模式：观察者模式，
 * @author 谢康
 */
public abstract class Ingredient implements TimeObserver {

    /**
     * state = 0 为变质，= -1 为用掉，其他情况为新鲜
     * 
     * Default constructor
     */
    public Ingredient() {
        fresh = 100;
        state = new Fresh();
        Time.getInstance().addTimeObserver(this);
    }

    /**
     * 新鲜度
     */
    protected float fresh;

    /**
     * 食材状态
     */
    protected State state;

    /**
     * 是否可用
     * 
     * @return 新鲜为ture，其他为false。
     */
    public boolean isState() {
        return !(state.isStale(this) || state.isCooked(this));
    }

    /**
     * 设定已用
     */
    public void setCooked() {
        state = new Cooked();
    }

    /**
     * 设定腐烂
     */
    public void setStale() {
        state = new Stale();
    }

    /**
     * 获取状态字符串
     */
    public String getStateName(){
        return state.toString();
    }
    
    /**
     * @return 名称
     */
    public abstract String getName();

    /**
     * 返回原料种类
     */
    public abstract IngredientType getIngredientType();

    /**
     * 用于观察者模式的腐败更新
     */
    public abstract void update();

}
