package coupons;

/**
 * @className: DiscountRateFive
 * @author: Shidan Cheng
 * @description: 50%off 具体实现化角色
 * @designPattern: Bridge
 * @date: 2:24 上午 2019/10/22
 * @version: v1.0
 */
public class DiscountRateFive extends Discount {
    public DiscountRateFive(){
        this.discountOff = 0.5f;
    }
}