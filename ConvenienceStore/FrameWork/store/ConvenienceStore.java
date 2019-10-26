package store;

import store.house.StoreHouse;
import store.summary.StoreDailySummary;

/**
 * @className: ConvenienceStore
 * @author: Shidan Cheng
 * @description: 便利店 组合实体 单例类
 * @designPattern: Singleton, CompositeEntity
 * @date: 9:11 下午 2019/10/21
 */
public class ConvenienceStore extends StoreDailySummary {
    private ConvenienceStoreDataClass convenienceStoreData = ConvenienceStoreDataClass.getInstance();
    private StoreHouse storeHouse = new StoreHouse();

    private static class ConvenienceStoreHandle {
        private static final ConvenienceStore INSTANCE = new ConvenienceStore();
    }

    private ConvenienceStore() {

    }

    public static final ConvenienceStore getInstance() {
        return ConvenienceStoreHandle.INSTANCE;
    }


    public void showStoreHouseType() {
        storeHouse.descStoreHouseInfo();
    }

    public void setStoreHouseType(String doorType, String floorType, String lightType, String shelvesType, String signboardType, String windowType, String curtainType) {
        storeHouse.setStoreHouse(doorType, floorType, lightType, shelvesType, signboardType, windowType, curtainType);
    }


}