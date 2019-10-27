package person;

import pay.flow.Alipay;
import pay.flow.Cash;
import pay.flow.CheckOutHandler;
import pay.flow.WeChat;
import utils.enums.PersonType;
import utils.info.ConstantTable;
import store.message.Mediator;

import java.util.Scanner;

import store.message.CustomerMessageBoard;


/**
 * @className: Customer
 * @author: Wenyue Li
 * @description: 顾客 具体类
 * @designPattern: AbstractFactory
 * @date: 7:09 下午 2019/10/22
 * @version: v1.1
 */
public class Customer extends Person {
    private int expense;
    private int cash;
    private int balanceInAlipay;
    private int balanceInWeChat;
    private int checkOutFlowType;

    private CheckOutHandler cashHandler = new Cash();
    private CheckOutHandler alipayHandler = new Alipay();
    private CheckOutHandler wechatHandler = new WeChat();

    private int buyType = 0;


    /** @update: 更新了构造器的形式 - Shidan Cheng */
    public Customer(String name) {
        super(name, PersonType.Customer);
        this.cash = ConstantTable.CUSTOMER_CASH_BALANCE;
        this.balanceInAlipay = ConstantTable.CUSTOMER_ALIPAY_BALANCE;
        this.balanceInWeChat = ConstantTable.CUSTOMER_WECHAT_BALANCE;
    }

    public int getCash() {
        return cash;
    }

    public int getBalanceInAlipay() {
        return balanceInAlipay;
    }

    public int getBalanceInWeChat() {
        return balanceInWeChat;
    }

    /** @update: 重载了另一种Customer的构造函数，以处理FilterDemo - Yinan Cheng */
    public Customer(String name, int expense) {
        this(name);
        this.expense = expense;
    }

    /** @update: 获得某个客户的年花销 - Yinan Cheng */
    public int getExpense() {
        return expense;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void setBalanceInAlipay(int balanceInAlipay) {
        this.balanceInAlipay = balanceInAlipay;
    }

    public void setBalanceInWeChat(int balanceInWeChat) {
        this.balanceInWeChat = balanceInWeChat;
    }

    /**
     * 用来测试责任链模式的辅助方法
     *
     * @methodName: printBalanceInfo
     * @return: void
     */
    public void printBalanceInfo() {
        System.out.printf("%s\n", this.name);
        System.out.printf("现金    :%d元;\n", this.cash);
        System.out.printf("支付宝  :%d元;\n", this.balanceInAlipay);
        System.out.printf("微信    :%d元;\n", this.balanceInWeChat);
        System.out.println("--------------------");

    }

    /**
     *此人通过该方法写下留言
     *
     * @methodName: sendMessage
     * @author: Xian Zhou
     * @date:2019/10/25
     * @param:Mediator
     * @return:void
     */

    /** @update: 修改实现方式，以满足游戏要求 -- Shidan Cheng */
    public void sendMessage(String message) {
        this.getMediator().getMessage(message, this.name, this.type);
    }


    /**
     * 为完善游戏流程而设置,设置付款顺序
     *
     * @methodName: setCheckOutFlow
     * @author: Shidan Cheng
     * @date: 8:25 下午 2019/10/27
     * @param: [type]
     * @return: void
     */
    public void setCheckOutFlow(int checkOutFlowType) {
        this.checkOutFlowType = checkOutFlowType;
        if (checkOutFlowType == 0) {
            //付款顺序为: 余额->支付宝->微信
            cashHandler.setNextHandle(alipayHandler);
            alipayHandler.setNextHandle(wechatHandler);
            wechatHandler.setNextHandle(null);
        } else if (checkOutFlowType == 1) {
            //付款顺序为: 支付宝->微信->余额
            alipayHandler.setNextHandle(wechatHandler);
            wechatHandler.setNextHandle(cashHandler);
            cashHandler.setNextHandle(null);
        } else {
            //付款顺序为: 微信->余额->支付宝
            wechatHandler.setNextHandle(cashHandler);
            cashHandler.setNextHandle(alipayHandler);
            alipayHandler.setNextHandle(null);
        }
    }


    /**
     * 获取付款顺序
     *
     * @methodName: getCheckoutFlow
     * @author: Shidan Cheng
     * @date: 8:30 下午 2019/10/27
     * @return: java.lang.String
     */
    public String getCheckoutFlow() {
        switch (checkOutFlowType) {
            case 1:
                return "付款顺序为: 余额->支付宝->微信";
            case 2:
                return "付款顺序为: 支付宝->微信->余额";
            default:
                return "付款顺序为: 微信->余额->支付宝";
        }
    }

    /**
     * 设置顾客购买物品
     *
     * @methodName: setBuyType
     * @author: Shidan Cheng
     * @date: 9:28 下午 2019/10/27
     * @return: void
     */
    public void setBuyType(int type) {
        this.buyType = type;
    }

    /**
     * 获取顾客购买物品
     *
     * @methodName: getBuyType
     * @author: Shidan Cheng
     * @date: 9:30 下午 2019/10/27
     * @return: int
     */
    public int getBuyType() {
        return this.buyType;
    }

    public void buy(int payCount) {
        switch (checkOutFlowType) {
            case 1:
                cashHandler.checkOut(payCount, this);
                break;
            case 2:
                alipayHandler.checkOut(payCount, this);
                break;
            default:
                wechatHandler.checkOut(payCount, this);
                break;
        }
    }
}


