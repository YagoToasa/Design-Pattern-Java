package Coupons;

/**
 * @className: Coupon
 * @author: Shidan Cheng
 * @description: 优惠券抽象类 抽象化角色
 * @designPattern: Bridge
 * @date: 2:26 上午 2019/10/22
 * @version: v1.0
 */
public abstract class Coupon {
    protected Discount discount;
    protected String type;

    public Coupon(Discount discount){
        this.discount = discount;
    }

    public Discount getDiscount(){
        return this.discount;
    }

    public abstract void discribeCouponInfo();
}