package store.house;

/**
 * @className: Light
 * @author: Shidan Cheng
 * @description: 灯
 * @designPattern: Composite Entity
 * @date: 8:26 上午 2019/10/26
 * @version: v1.0
 */
public class Light {
    private String type;

    public Light(){
        this("普通日光灯");
    }

    public Light(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
