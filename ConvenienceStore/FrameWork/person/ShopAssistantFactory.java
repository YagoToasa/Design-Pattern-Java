package person;

/**
 * @className: ShopAssistantFactory
 * @author: Wenyue Li
 * @description: 店员工厂
 * @designPattern: Singleton
 * @date: 8:42 下午 2019/10/21
 * @version: v1.1
 */
public class ShopAssistantFactory{
    /** @update: 更新了单例模式的实现形式 - Shidan Cheng */
    private static class ShopAssistantFactoryHolder {
        private static final ShopAssistantFactory INSTANCE = new ShopAssistantFactory();
    }

    private ShopAssistantFactory() {
    }

    public static final ShopAssistantFactory getInstance() {
        return ShopAssistantFactoryHolder.INSTANCE;
    }

    public ShopAssistant createShopAssistant(String name) {
        return new ShopAssistant(name);
    }

}