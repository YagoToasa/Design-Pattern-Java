package store.house;

/**
 * @className: Signboard
 * @author: Shidan Cheng
 * @description: 招牌
 * @designPattern: Composite Entity
 * @date: 8:40 上午 2019/10/26
 * @version: v1.0
 */
public class Signboard {
    private String type;

    public Signboard(){
        this("普通木质招牌");
    }

    public Signboard(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
