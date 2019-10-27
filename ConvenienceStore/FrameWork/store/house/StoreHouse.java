package store.house;

/**
 * @className: StoreHouse
 * @author: Shidan Cheng
 * @description: 便利店房子的粗粒度对象
 * @designPattern: Composite Entity
 * @date: 8:24 上午 2019/10/26
 * @version: v1.0
 */
public class StoreHouse {
    private Door door = new Door();
    private Floor floor = new Floor();
    private Light light = new Light();
    private Shelves shelves = new Shelves();
    private Signboard signboard = new Signboard();
    private Window window = new Window();
    private Curtain curtain = new Curtain();


    public void setStoreHouse(String doorType, String floorType, String lightType, String shelvesType, String signboardType, String windowType, String curtainType) {
        this.door.setType(doorType);
        this.floor.setType(floorType);
        this.light.setType(lightType);
        this.shelves.setType(shelvesType);
        this.signboard.setType(signboardType);
        this.window.setType(windowType);
        this.curtain.setType(curtainType);
    }

    public void descStoreHouseInfo() {
        System.out.println("| 店门类型:" + door.getType());
        System.out.println("| 窗户类型:" + window.getType());
        System.out.println("| 窗帘类型:" + curtain.getType());
        System.out.println("| 地板类型:" + floor.getType());
        System.out.println("| 灯光类型:" + light.getType());
        System.out.println("| 货架类型:" + shelves.getType());
        System.out.println("| 招牌类型:" + signboard.getType());

    }
}
