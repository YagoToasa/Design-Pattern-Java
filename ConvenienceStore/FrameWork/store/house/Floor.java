package store.house;

/**
 * @className: Floor
 * @author: Shidan Cheng
 * @description: 地板
 * @designPattern: Composite Entity
 * @date: 8:26 上午 2019/10/26
 * @version: v1.0
 */
public class Floor {
    private String type;

    public Floor(){
        this("基本地砖");
    }

    public Floor(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
