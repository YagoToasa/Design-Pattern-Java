package store.house;

/**
 * @className: Window
 * @author: Shidan Cheng
 * @description: 窗户
 * @designPattern: Composite Entity
 * @date: 8:26 上午 2019/10/26
 * @version: v1.0
 */
public class Window {
    private String type;

    public Window() {
        this("玻璃窗户");
    }

    public Window(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
