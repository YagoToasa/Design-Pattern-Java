package coupons;

/**
 * @className: DrinksCoupon
 * @author: Shidan Cheng
 * @description: 饮品优惠券 修正抽象化角色
 * @designPattern: Bridge
 * @date: 2:27 上午 2019/10/22
 * @version: v1.0
 */
public class DrinksCoupon extends Coupon {

    public DrinksCoupon(Discount discount) {
        super(discount);
        this.type = "饮品";
    }

    @Override
    public void discribeCouponInfo() {
        System.out.println("类型: "+this.type+", 折扣: "+(int)(discount.getDiscountOff()*100)+"%off");
    }
}