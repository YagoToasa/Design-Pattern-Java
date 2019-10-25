package store.message;

import person.Person;
import person.Customer;
import person.ShopAssistant;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * @className: CustomerMessageBoard
 * @author: Xian Zhou
 * @description: 留言板
 * @designPattern: Mediator
 * @date: 2019/10/25
 * @version: v1.0
 */
public class CustomerMessageBoard implements Mediator {
    //存储有哪些人可能会用到该留言板
    private HashMap<String, Person> personMap;
    //内部使用统计每一种type都有哪些人名
    private HashMap<String, String> interMap;
    //留言板
    private static ArrayList<String> messages;

    public CustomerMessageBoard() {
        personMap = new HashMap<String, Person>();
        interMap = new HashMap<String, String>();
        messages = new ArrayList<>();
    }


    /**
     * 注册，一个人可能会开始使用留言板
     *
     * @methodName: Register
     * @param: String personName, Person person
     * @return: void
     */
    @Override
    public void register(String personName, Person person) {

        personMap.put(personName, person);
        if (person instanceof Customer) {
            interMap.put("Customer", personName);
        } else if (person instanceof ShopAssistant) {
            interMap.put("ShopAssistant", personName);
        }
    }


    /**
     * 将留言存入留言板并且通过留言板这个中介者告诉店员有人留言了需给以回复
     *
     * @methodName: GetMessage
     * @param: String message, String personName
     * @return: void
     */
    @Override
    public void getMessage(String message, String personName) {
        //将留言存入留言板
        messages.add(new Date().toString()
                + " [" + personName + "] : " + message);
        //通过中介者告诉店员有客户留言了需给以回复
        if (personMap.get(personName) instanceof Customer) {

            ((ShopAssistant) (personMap.get(interMap
                    .get("ShopAssistant")))).giveReply();
            //通过中介者告诉店员有店员留言了需给以回复
        } else if (personMap.get(personName) instanceof ShopAssistant) {

            ((ShopAssistant) (personMap.get(interMap.get("ShopAssistant"))))
                    .giveThanks();
        }

    }

    /**
     * 将回复内容也加入留言板
     *
     * @methodName: addMessage
     * @param: String message
     * @return: void
     */
    public static void addMessage(String message) {

        messages.add(new Date().toString()
                + " 官方回复： " + message);

    }

    /**
     * 展示留言板
     *
     * @methodName: showMessages
     * @param: null
     * @return: void
     */
    public void showMessages() {

        System.out.println("-------------------------- Message Bord ------------------------------\n");
        for (String m : messages) {
            System.out.println(m);
        }
        System.out.println("\n----------------------------------------------------------------------\n\n");
    }


}