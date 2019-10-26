package foods.lookup.base;

import foods.Food;

/**
 * @interfaceName: Specification
 * @author: Shidan Cheng
 * @description: 规范接口
 * @designPattern: Specification
 * @date: 11:25 下午 2019/10/25
 * @version: v1.0
 */
public interface Specification {
    //与
    public Specification and(Specification and);
    //或
    public Specification or(Specification or);
    //非
    public Specification not();

    public boolean isSatisfiedBy(Food food);

}
