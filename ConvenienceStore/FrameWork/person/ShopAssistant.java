package person;

import utils.enums.PersonType;

/**
 * @className: ShopAssistant
 * @author: Wenyue Li
 * @description: 店员类
 * @designPattern: AbstractFactory
 * @date: 12:48 上午 2019/10/22
 * @version: v1.1
 **/
public class ShopAssistant extends Person {

    /** @update: 更新了构造器的形式 - Shidan Cheng */
    public ShopAssistant(String name) {
        super(name, PersonType.ShopAssistant);
    }

}