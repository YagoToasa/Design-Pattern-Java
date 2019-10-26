package world;

/**
 * @className: LockDemo
 * @description: 线程锁对应线程
 * @author: 罗臻
 * @date: 11:39 上午 2019/10/26
 * @designPattern: Double Click Lock, Private Data
 */
public class WordLockThread extends Thread{
    public static int[] taskNums = {1,2,3};
    private static String[] taskLabel = {"task1", "task2", "task3"};
    private static int loopNum = 50;

    private int taskNum;

    public WordLockThread(int taskNum){
        this.taskNum = taskNum;
    }

    /**
     * 线程1：修改世界时钟
     *
     * @methodName: asynOperateClock1
     * @param day: 天数
     */
    synchronized public void asynOperateClock1(int day){
        System.out.println(taskLabel[0] + " 占用世界时钟！");
        WorldClock clock = WorldClock.getInstance();
        System.out.println(taskLabel[0] + ">>>设置时钟[DAY]为["+day+"]");
        clock.setDay(day);

        System.out.println(taskLabel[0] + " 释放世界时钟！");
    }

    /**
     * 线程2：查看世界时钟
     *
     * @methodName: asynOperateClock2
     */
    synchronized public void asynOperateClock2(){
        System.out.println(taskLabel[1] + " 占用世界时钟！");
        WorldClock clock = WorldClock.getInstance();
        System.out.println(taskLabel[1] + ">>>查看时钟值  ");
        System.out.println(">>> 世界时钟-DAY: " + clock.getDay());

        System.out.println(taskLabel[1] + " 释放世界时钟！");
    }

    /**
     * 线程3：修改世界时钟
     *
     * @methodName: asynOperateClock3
     * @param day: 天数
     */
    synchronized public void asynOperateClock3(int day){
        System.out.println(taskLabel[2] + " 占用世界时钟！");
        WorldClock clock = WorldClock.getInstance();
        System.out.println(taskLabel[2] + ">>>设置时钟[DAY]为["+day+"]");
        clock.setDay(day);

        System.out.println(taskLabel[2] + " 释放世界时钟！");
    }

    @Override
    public void run() {
        int count = 0;
        if(taskNum == taskNums[0]){
            while(count++<loopNum){
                asynOperateClock1(count);
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else if(taskNum == taskNums[1]){
            while(count++<loopNum){
                asynOperateClock2();
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else if(taskNum == taskNums[2]){
            while(count++<loopNum){
                asynOperateClock3(loopNum - count);
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
