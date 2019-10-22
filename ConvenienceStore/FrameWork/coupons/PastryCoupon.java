package coupons;

/**
 * @className: PastryCoupon
 * @author: Shidan Cheng
 * @description: 糕点优惠券 修正抽象化角色
 * @designPattern: Bridge
 * @date: 2:28 上午 2019/10/22
 * @version: v1.0
 */
public class PastryCoupon extends Coupon {

    public PastryCoupon(Discount discount) {
        super(discount);
        this.type = "糕点";
    }

    @Override
    public void discribeCouponInfo() {
        System.out.println("类型: "+this.type+", 折扣: "+(int)(discount.getDiscountOff()*100)+"%off");
    }
}