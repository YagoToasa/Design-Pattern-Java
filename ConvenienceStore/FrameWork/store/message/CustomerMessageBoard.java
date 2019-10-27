package store.message;

import person.Person;
import person.Customer;
import person.ShopAssistant;
import utils.enums.PersonType;
import utils.info.ConstantTable;

import java.text.DateFormat;
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
     * @update: 为了最终游戏的流程更改实现方式
     * @updateBy: Shidan Cheng
     */

    @Override
    public void getMessage(String message, String personName, PersonType personType) {
        //将留言存入留言板
        Date date = new Date();
        String type;
        if (personType.toString().equals("Customer")) {
            type = "顾客";
        } else if (personType.toString().equals("ShopAssistant")) {
            type = "店员";
        } else {
            type = "店长";
        }
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        messages.add(dateFormat.format(date)
                + "  [" + type + "]" + personName + ": " + message);


//        //通过中介者告诉店员有客户留言了需给以回复
//        if (personMap.get(personName) instanceof Customer) {
//
//            ((ShopAssistant) (personMap.get(interMap
//                    .get("ShopAssistant")))).giveReply();
//            //通过中介者告诉店员有店员留言了需给以回复
//        } else if (personMap.get(personName) instanceof ShopAssistant) {
//
//            ((ShopAssistant) (personMap.get(interMap.get("ShopAssistant"))))
//                    .giveThanks();
//        }
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

    /** @update: 更新了输出的格式 -Shidan Cheng */
    @Override
    public void showMessages() {
        if (ConstantTable.TEST_PROGRAM) {
            System.out.println("-------------------------- Message Bord ------------------------------\n");

            for (String m : messages) {
                System.out.println(m);
            }
            System.out.println("\n----------------------------------------------------------------------\n\n");
        } else {
            System.out.println("* ==================  留言板  ================== *");
            if (messages.isEmpty()) {
                System.out.println("            ヾ(´･ω･｀)ﾉ 现在没有留言呢！");
            } else {
                for (String m : messages) {
                    System.out.println(m);
                }
            }
            System.out.println("* ============================================= *");
        }

    }

    @Override
    public void clean() {
        messages.clear();
    }
}