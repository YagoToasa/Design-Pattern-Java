package Coupons;

/**
 * @className: SnacksCoupon
 * @author: Shidan Cheng
 * @description: 零食优惠券 修正抽象化角色
 * @designPattern: Bridge
 * @date: 2:28 上午 2019/10/22
 */
public class SnacksCoupon extends Coupon {

    public SnacksCoupon(Discount discount) {
        super(discount);
        this.type="零食";
    }

    @Override
    public void discribeCouponInfo() {
        System.out.println("类型: "+this.type+", 折扣: "+(int)(discount.getDiscountOff()*100)+"%off");
    }
}