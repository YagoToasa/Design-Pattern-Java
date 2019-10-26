package store.house;

/**
 * @className: Curtain
 * @author: Shidan Cheng
 * @description: 窗帘
 * @designPattern: Composite Entity
 * @date: 8:32 上午 2019/10/26
 * @version: v1.0
 */
public class Curtain {
    private String type;

    public Curtain(){
        this("基本窗帘");
    }

    public Curtain(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
