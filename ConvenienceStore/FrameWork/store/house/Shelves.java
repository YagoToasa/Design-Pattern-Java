package store.house;

/**
 * @className: Shelves
 * @author: Shidan Cheng
 * @description: 货架
 * @designPattern: Composite Entity
 * @date: 8:35 上午 2019/10/26
 * @version: v1.0
 */
public class Shelves {
    private String type;

    public Shelves(){
        this("基本货架");
    }

    public Shelves(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
