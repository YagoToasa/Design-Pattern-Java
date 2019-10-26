package store.house;

/**
 * @className: Door
 * @author: Shidan Cheng
 * @description: 门
 * @designPattern: Composite Entity
 * @date: 8:25 上午 2019/10/26
 * @version: v1.0
 */
public class Door {
    private String type;

    public Door(){
        this("基本大门");
    }

    public Door(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
