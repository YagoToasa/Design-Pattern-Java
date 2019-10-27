package GameProgram;

import GameProgram.Thread.CustomerThread;
import GameProgram.Thread.ShopkeeperThread;
import utils.info.ConstantTable;


/**
 * @className: Game Application
 * @author: Shidan Cheng
 * @description: 游戏主程序
 * @date: 1:30 下午 2019/10/27
 * @version: v1.0
 */
public class GameApplication {


    public static void main(String[] args) {
        ConstantTable.TEST_PROGRAM = false;
        Thread shopkeeperThread = new Thread(new ShopkeeperThread());
        Thread customerThread = new Thread(new CustomerThread());
        shopkeeperThread.start();
        customerThread.start();
    }
}