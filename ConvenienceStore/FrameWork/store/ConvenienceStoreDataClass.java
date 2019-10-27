package store;

import utils.info.ConstantTable;
import world.WorldClock;
import world.WorldObserver;

/**
 * @className: ConvenienceStoreDataClass
 * @author:
 * @description: 便利店的数据信息类
 * @designPattern: Private Data Class, Singleton
 * @date: 9:14 下午 2019/10/21
 */
public class ConvenienceStoreDataClass implements WorldObserver {
    private int day;
    private String name = ConstantTable.STORE_NAME;
    private int money  = ConstantTable.STORE_INIT_MONEY;

    @Override
    public void update() {
        this.day = WorldClock.getInstance().getDay();
    }

    private static class ConvenienceStoreDataClassHolder {
        private static final ConvenienceStoreDataClass INSTANCE = new ConvenienceStoreDataClass();
    }

    private ConvenienceStoreDataClass() {
        this.day = WorldClock.getInstance().getDay();
    }

    public static final ConvenienceStoreDataClass getInstance(){
        return ConvenienceStoreDataClassHolder.INSTANCE;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}