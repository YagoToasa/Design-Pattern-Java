import coupons.*;

/**
 * @className: BridgeDemo
 * @description: 桥梁模式测试程序
 * @author: Shidan Cheng
 * @date: 3:04 上午 2019/10/22
 * @version: v1.0
 */
public class BridgeDemo {
    public static void main(String[] args) {
        System.out.println("START =========================== Bridge Demo ==========================");
        Discount discount30off = new DiscountRateThree();
        Discount discount50off = new DiscountRateFive();
        Discount discount70off = new DiscountRateSeven();
        Coupon drinksCoupon = new DrinksCoupon(discount30off);
        drinksCoupon.discribeCouponInfo();
        drinksCoupon = new DrinksCoupon(discount50off);
        drinksCoupon.discribeCouponInfo();
        drinksCoupon = new DrinksCoupon(discount70off);
        drinksCoupon.discribeCouponInfo();
        System.out.println("---");
        Coupon pastryCoupon = new PastryCoupon(discount30off);
        pastryCoupon.discribeCouponInfo();
        pastryCoupon = new PastryCoupon(discount50off);
        pastryCoupon.discribeCouponInfo();
        pastryCoupon = new PastryCoupon(discount70off);
        pastryCoupon.discribeCouponInfo();
        System.out.println("---");
        Coupon snacksCoupon = new SnacksCoupon(discount30off);
        snacksCoupon.discribeCouponInfo();
        snacksCoupon = new SnacksCoupon(discount50off);
        snacksCoupon.discribeCouponInfo();
        snacksCoupon = new SnacksCoupon(discount70off);
        snacksCoupon.discribeCouponInfo();
        System.out.println("E N D =========================== Bridge Demo ==========================");

    }
}
