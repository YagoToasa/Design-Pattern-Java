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

    private String duty;
    /** @update: 更新了构造器的形式 - Shidan Cheng */
    public ShopAssistant(String name) {
        super(name, PersonType.ShopAssistant);
    }
    /** @update: 更新了构造器的形式，添加了店员的职责 - Lanxin Liu */
    public ShopAssistant(String name, String duty) {
        super(name, PersonType.ShopAssistant);
        this.duty = duty;
    }
    /**
     *
     *
     * @methodName: getDuty()
     * @author: Lanxin Liu
     * @date: 20:29 下午 2019/10/25
     * @param:
     * @return: String
     */
    public String getDuty() {
        return duty;
    }
    /**
     *
     *
     * @methodName: dealProblem()
     * @author: Lanxin Liu
     * @date: 20:29 下午 2019/10/25
     * @param:
     * @return:
     */
    public void dealProblem() {
        if(duty == "收银") {
            System.out.println("结账完毕了！");
        }
        else if(duty == "清洁") {
            System.out.println("清洁完毕了！");
        }
        else if(duty == "会计") {
            System.out.println("算账完毕了！");
        }
    }

}