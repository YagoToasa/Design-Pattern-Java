package DesignPatterns;

import store.message.CustomerMessageBoard;
import store.message.Mediator;
import person.Person;
import person.ShopAssistant;
import person.Customer;


public class MediatorDemo {

    public static void main(String[] args) {
        System.out.println("START ========================== Mediator Demo ==========================");

        //留言板初始化
        Mediator mediator = new CustomerMessageBoard();
        //顾客初始化
        Customer mcustomer = new Customer("Peter");
        mcustomer.addMediator(mediator);
        //顾客留言
        System.out.println(mcustomer.getName()+"顾客你好！请在留言板中记下您的留言");
        String message1="零食很好吃! 希望下次有优惠！";
        mcustomer.sendMessage(message1);
        System.out.println("留言成功");
        ((CustomerMessageBoard) mediator).showMessages();

        //店员初始化
        ShopAssistant mshopassiatant = new ShopAssistant("Alex");
        mshopassiatant.addMediator(mediator);
        String message2="谢谢评价！优惠可以办理会员卡哟！";
        //店员留言
        mshopassiatant.sendMessage(message2);
        ((CustomerMessageBoard) mediator).showMessages();
        System.out.println("E N D ========================== Mediator Demo ==========================\n");
    }
}
