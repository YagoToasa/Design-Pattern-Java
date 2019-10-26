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
        //店员初始化
        ShopAssistant mshopassiatant = new ShopAssistant("Alex");
        mshopassiatant.addMediator(mediator);

        String message="";
        //顾客留言
        mcustomer.sendMessage(message);
        ((CustomerMessageBoard) mediator).showMessages();
        //店员留言
        mshopassiatant.sendMessage(message);
        ((CustomerMessageBoard) mediator).showMessages();
        System.out.println("E N D ========================== Mediator Demo ==========================\n");
    }
}
