import shopping.Iterator;
import shopping.ShoppingCart;
import shopping.ShoppingCartIterator;

/**
 * @className: IteratorDemo
 * @description: Iterator 迭代器模式 测试程序
 * @author: Shidan Cheng
 * @date: 11:37 下午 2019/10/21
 * @version: v1.0
 */
public class IteratorDemo {
    public static void main(String[] args) {
        try {

            ShoppingCart shoppingCart = new ShoppingCart(5);
            Iterator iterator = new ShoppingCartIterator(shoppingCart);


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
