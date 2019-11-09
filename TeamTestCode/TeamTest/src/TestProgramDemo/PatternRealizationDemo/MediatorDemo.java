package TestProgramDemo.PatternRealizationDemo;

/**
 * @className: MediatorDemo
 * @author: Xian Zhou
 * @description:
 * @date: 10:25 2019/11/9
 * @version: v1.0 版本
 */
public class MediatorDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("START ========================== Mediator Demo ==========================");
        kitchen.staff.chef.Chef chef = kitchen.staff.chef.Chef.getInstance();
        kitchen.staff.Waiter waiter = kitchen.staff.Waiter.getInstance();
        kitchen.order.orderform.Order order = new kitchen.order.orderform.Order();
        //中介者注册order与chef
        waiter.register(order);
        waiter.register(chef);

        //拿到服务员给的菜名后，厨师开始做菜，做完菜后通知服务员取菜
        chef.processMerchs(chef.getDishes());
        System.out.println("E N D ========================== Mediator Demo ==========================");

    }



}
