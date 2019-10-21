package Person;

import utils.Enum.PersonType;

import java.util.*;

/**
 * 
 */
public class Customer extends Person {

    private static int index=0;
    /**
     * @methodName: ShopAssistant
     * @author: Wenyue Li
     * @description: 生成顾客，每次生成顾客++，并打印顾客人数
     * @date: 12:48 上午 2019/10/22
     * @param [name]
     * @return
     **/
    public Customer(String name) {
        setName(name);
        setType(PersonType.Customer);
        index++;
        System.out.print("当前顾客人数为："+ index);
    }


}