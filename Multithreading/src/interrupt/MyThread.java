package interrupt;

/**
 * @author TIMI
 * @Date 2020/11/27 - 15:39
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("我要睡觉了");
        try {
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            System.out.println("为什么不让睡了");
        }
        System.out.println("醒了");
    }
}
