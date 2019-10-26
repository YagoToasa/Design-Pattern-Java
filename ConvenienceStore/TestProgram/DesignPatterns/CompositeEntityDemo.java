package DesignPatterns;

import store.ConvenienceStore;

/**
 * @className: CompositeEntityDemo
 * @description: Composite Entity 组合实体模式 测试程序
 * @author: Shidan Cheng
 * @date: 8:59 上午 2019/10/26
 * @version: v1.0
 */
public class CompositeEntityDemo {
    public static void main(String[] args) {
        System.out.println("START ===================== Composite Entity Demo ======================");
        ConvenienceStore store = ConvenienceStore.getInstance();
        System.out.println("> 展示便利店房屋默认装修风格");
        store.showStoreHouseType();
        System.out.println("> 展示便利店房屋默认装修风格 [Completed]");
        System.out.println("---");
        System.out.println("> 设置便利店房屋装修风格为：枫叶门，抛光砖，壁灯，枫木货架，清新实木招牌，米白色枫叶窗，格纹窗帘");
        store.setStoreHouseType("枫木门","抛光砖","壁灯","枫木货架","清新实木招牌","米白色枫叶窗","格纹窗帘");
        store.showStoreHouseType();
        System.out.println("> 修改便利店装修风格 [Completed]");
        System.out.println("---");
        System.out.println("> 设置便利店房屋装修风格为：童趣乐园大门，鹅卵石地砖，星星壁灯，童趣风黄色货架，童趣乐园招牌，饼干风拼色玻璃窗，3色窗帘");
        store.setStoreHouseType("童趣乐园大门","鹅卵石地砖","星星壁灯","童趣风黄色货架","童趣乐园招牌","饼干风拼色玻璃窗","3色窗帘");
        store.showStoreHouseType();
        System.out.println("> 修改便利店装修风格 [Completed]");
        System.out.println("E N D ===================== Composite Entity Demo ======================\n");
    }
}
