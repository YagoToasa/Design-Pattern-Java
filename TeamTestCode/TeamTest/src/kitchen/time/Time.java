package kitchen.time;

import java.util.*;

/**
 * 时间类
 * @description 使用了单例模式、观察者模式
 * @author Vector Xie
 */
public class Time {

    private Time() {
    }

    private static Time instance;

    private ArrayList<TimeObserver> timeObservers = new ArrayList<>();

    public static synchronized Time getInstance() {
        if (instance == null) instance = new Time();

        return instance;
    }

    public void update(int ticks) {
        while(ticks>0)
        {
            for (TimeObserver o : timeObservers)  o.update();
            ticks--;
        }

    }

    public void addTimeObserver(TimeObserver o) {
        timeObservers.add(o);
    }

    public void removeTimeObserver(TimeObserver o) {
        timeObservers.remove(o);
    }

}