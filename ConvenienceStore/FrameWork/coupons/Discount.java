package coupons;

/**
 * @className: Discount
 * @author: Shidan Cheng
 * @description: 折扣信息抽象类 实现化角色
 * @designPattern: Bridge
 * @date: 2:23 上午 2019/10/22
 * @version: v1.0
 */
public abstract class Discount {
    protected float discountOff;


    public float getDiscountOff(){
        return discountOff;
    }

}