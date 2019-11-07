package kitchen.merch;

import kitchen.staff.Visitor;
/**
 * 创建一个抽象的菜品生成过程的Builder接口，所有具体的菜都通过此接口生成
 */
public interface DishBuilder {
    /**
     * 以下的方法分别是设置菜品的名字、餐具、价格、原料、原料数目、厨具
     */
    void setName();
    void setPack();
    void setPrice();
    void setMaterial();
    void setCooker();
    void setCount();
    /**
     * 调用菜品的函数
     */
    Dish getDish();
    /**
     * visitor的接受函数
     */
    void accept(Visitor visitor);
}
