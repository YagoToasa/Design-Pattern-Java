package person;

import store.message.CustomerMessageBoard;
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

    /**
     *记下留言，给客户回复，给店员回复
     *
     * @methodName: sendMessage,giveReply,giveThanks
     * @author: Xian Zhou
     * @date:2019/10/25
     * @param:Mediator
     * @return:void
     */
    public void giveReply(){
        CustomerMessageBoard.addMessage("您的想法我们已经收到，谢谢您的留言。");
    }

    public void giveThanks(){
        CustomerMessageBoard.addMessage("我们已解决一些问题，请及时查看");
    }

    public void sendMessage(String message) {

        Scanner s = new Scanner(System.in);
        System.out.println(this.name+"你好！请在留言板中记下您的留言");

        message = s.nextLine();

        System.out.println("正在将留言录入留言板");

        this.getMediator().getMessage(message, this.name);

        System.out.println("留言成功");
    }

