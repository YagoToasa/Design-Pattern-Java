package shopping;

import foods.Food;
import utils.info.ConstantTable;

/**
 * @className: ShoppingCart
 * @author: Shidan Cheng
 * @description: 购物车容器类
 * @designMethod: Iterator
 * @date: 10:12 下午 2019/10/21
 */
public class ShoppingCart {

    private Food[] foods;                           //食品容器
    private int maxSize;                            //购物车最大容量
    private int currentSize;                        //购物车当前容量


    /**
     * 默认构造函数，购物车默认大小为10
     *
     * @methodName: ShoppingCart
     * @throws: Exception
     */
    public ShoppingCart() throws Exception {
        this(ConstantTable.SHOPPING_CART_DEFAULT_SIZE);
    }

    /**
     * 指定购物车最大容量的构造函数
     *
     * @methodName: ShoppingCart
     * @param maxSize: int
     * @throws: Exception
     */
    public ShoppingCart(int maxSize) throws Exception {
        if (maxSize > 0) {
            this.maxSize = maxSize;
            this.foods = new Food[maxSize];
            this.currentSize = 0;
        } else {
            throw new Exception("> 抱歉, 不提供该尺寸的购物车!");
        }
        if (ConstantTable.TEST_PROGRAM) {
            if (ConstantTable.TEST_PROGRAM) {
                System.out.printf("> 获取 购物车[容量:%d] * 1\n", this.maxSize);
            }
        }

    }

    /**
     * 获取购物车的最大容量
     *
     * @methodName: getMaxSize
     * @return: int
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * 设置购物车的最大容量
     *
     * @methodName: setMaxSize
     * @param maxSize : int
     * @return: void
     */
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * 获取购物车当前容量
     *
     * @methodName: getCurrentSize
     * @return: int
     */
    public int getCurrentSize() {
        return currentSize;
    }

    /**
     * 向购物车中添加食品
     *
     * @methodName: addFood
     * @param food : Food.FoodPrototype
     * @return: boolean
     */
    public boolean addFood(Food food) {
        if (currentSize < maxSize) {
            this.foods[currentSize++] = food;
            System.out.println("[√]");
            return true;
        } else {
            System.out.println("[x]");
            System.out.println(">>> 购物车已满, 不可再添加商品!");
            return false;
        }
    }

    /**
     * 从购物车中移除食品
     *
     * @methodName: removeFood
     * @param food : Food.FoodPrototype
     * @return: boolean
     */
    public boolean removeFood(Food food) {
        for (int i = 0; i < currentSize - 1; i++) {
            if (foods[i] == food) {
                return removeFoodByIndex(i);
            }
        }
        return false;
    }

    /**
     * 按照索引移除购物车中的食品
     *
     * @methodName: removeFoodByIndex
     * @param index: int
     * @return: boolean
     */
    public boolean removeFoodByIndex(int index) {
        if (index < 0 || index >= currentSize) {
            return false;
        } else {
            if (currentSize == 1 || currentSize == maxSize - 1) {
                foods[index] = null;
            } else {
                foods[index] = foods[currentSize - 1];
                foods[currentSize - 1] = null;
            }
            currentSize--;
        }
        if (ConstantTable.TEST_PROGRAM) {
            System.out.println("成功删除购物车中的商品!");
        }
        return true;
    }

    /**
     * 按照索引获取购物车中的食品
     *
     * @methodName: getFoodByIndex
     * @param index: int
     * @return: Food.FoodPrototype
     */
    public Food getFoodByIndex(int index) {
        return foods[index];
    }

    /**
     * 新建购物车对应的迭代器
     *
     * @methodName: createIterator
     * @return: Shopping.ShoppingCartIterator
     */
    public ShoppingCartIterator createIterator() {
        return new ShoppingCartIterator(this);
    }

}