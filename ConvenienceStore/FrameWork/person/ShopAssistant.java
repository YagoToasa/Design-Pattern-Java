package person;

import utils.enums.PersonType;

/**
 * 
 */
public class ShopAssistant extends Person {


    private static int index=0;
    /**
     * @methodName: ShopAssistant
     * @author: Wenyue Li
     * @description: 生成店员，每次生成店员++，并打印店员人数
     * @date: 12:48 上午 2019/10/22
     * @param name:
     * @return
     **/
    public ShopAssistant(String name) {
        setName(name);
        setType(PersonType.ShopAssistant);
        index++;
        System.out.print("当前店员人数为："+ index);
    }

}