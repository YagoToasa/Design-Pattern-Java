import decoration.command.*;

/**
 * @className: CommandDemo
 * @author: Siqian Wu
 * @description: Command模式测试类
 * @designPattern: Command
 * @date: 0:14 2019-10-24
 * @version: v1.0
 */
public class CommandDemo {
    public static void main(String[] args){
        System.out.println("START ========================= Command Demo =========================");
        Client client = new Client();

        System.out.println("店长想置办一张椅子。");
        client.addChair();
        System.out.println("店长想丢弃一张桌子。");
        client.rmvDesk();
        System.out.println("店长想置办一张桌子。");
        client.addDesk();
        System.out.println("店长想置办一张椅子。");
        client.addChair();
        System.out.println("店长想丢弃一张桌子。");
        client.rmvDesk();
        System.out.println("店长还想丢弃一张桌子。");
        client.rmvDesk();
        System.out.println("店长想丢弃一张椅子。");
        client.rmvChair();

        System.out.println("E N D ========================= Command Demo =========================");
    }
}
