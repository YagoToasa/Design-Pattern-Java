package Shopping;

import Food.FoodPrototype;

/**
 * @className: ShoppingCartIterator
 * @author: Shidan Cheng
 * @description: 购物车迭代器
 * @designMethod: Iterator
 * @date: 10:10 下午 2019/10/21
 */
public class ShoppingCartIterator implements Iterator {
    private ShoppingCart shoppingCart;          //对应的购物车容器
    private int cursor;                         //游标
    private int shoppingCartSize;               //购物车的大小

    /**
     * 构造函数
     *
     * @methodName: ShoppingCartIterator
     * @param shoppingCart : Shopping.ShoppingCart 对应的购物车容器
     */
    public ShoppingCartIterator(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
        this.shoppingCartSize = shoppingCart.getCurrentSize();
    }
    
    /**
     * 移除游标对应的食品
     *
     * @methodName: remove
     * @return: boolean
     */
    public boolean remove() {
        boolean result = shoppingCart.removeFoodByIndex(cursor);
        shoppingCartSize = shoppingCart.getCurrentSize();
        cursor--;
        return result;
    }

    @Override
    public boolean hasNext() {
        return cursor != shoppingCartSize;
    }

    @Override
    public FoodPrototype next() {
        if (cursor >= shoppingCartSize) {
            return null;
        } else {
            return shoppingCart.getFoodByIndex(cursor++);
        }
    }

}