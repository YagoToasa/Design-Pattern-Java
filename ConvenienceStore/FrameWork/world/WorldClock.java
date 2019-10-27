package world;


import foods.Food;
import utils.enums.SeasonType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @className: WorldClock
 * @author: Shidan Cheng
 * @description: 世界时钟
 * @designPattern: Singleton, Observer
 * @date: 7:59 下午 2019/10/21
 */
public class WorldClock {
    private int day = 1;                                                    //世界天数
    private SeasonType season;
    private Set<WorldObserver> worldObserversSet = new HashSet<>();         //观测者列表

    private static class WorldClockHolder {
        private static final WorldClock INSTANCE = new WorldClock();
    }

    private WorldClock() {
        this.day = 1;
        this.season = (SeasonType.values())[(this.day / 20) % 3];
    }

    /**
     * 获取世界时钟单例
     *
     * @methodName: getInstance
     * @return: World.WorldClock
     */
    public static final WorldClock getInstance() {
        return WorldClockHolder.INSTANCE;
    }


    /**
     * 获取世界时钟
     *
     * @methodName: getDay
     * @return: int
     */
    public int getDay() {
        return day;
    }

    /**
     * 设置世界时钟
     *
     * @methodName: setDay
     * @param day: int 天数
     * @return: void
     */
    public void setDay(int day) {
        this.day = day;
    }


    /**
     * 添加观测者
     *
     * @methodName: addObserver
     * @param observer: WorldObserver
     * @return: boolean
     */
    public boolean addObserver(WorldObserver observer) {
        if (worldObserversSet.add(observer)) {
            return true;
        }
        return false;
    }

    /**
     * 移除指定观测者
     *
     * @methodName: deleteObserver
     * @param observer: WorldObserver
     * @return: boolean
     */
    public boolean deleteObserver(WorldObserver observer) {
        if (worldObserversSet.remove(observer)) {
            return true;
        }
        return false;
    }

    /**
     * 更新世界信息
     *
     * @methodName: updateTheWorld
     * @return: void
     */
    public void updateTheWorld() {
        this.day++;
        this.season = (SeasonType.values())[(this.day / 20) % 3];
        for (WorldObserver observer : worldObserversSet) {
            observer.update();
        }
    }

    /**
     * 刷新观测者列表
     *
     * @methodName: refreshObserverSet
     * @param: []
     * @return: void
     */
    public void refreshObserverSet(List<Food> foodList) {
        worldObserversSet = new HashSet<>(foodList);
    }

    public SeasonType getSeason() {
        return season;
    }
}