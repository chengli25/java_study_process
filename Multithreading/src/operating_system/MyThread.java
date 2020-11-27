package operating_system;

/**
 * @author TIMI
 * @Date 2020/11/27 - 13:48
 */
public class MyThread extends Thread {
    @Override
    public void run() {
       //要把子线程执行的内容写在run里
        for (int i = 0; i < 1000; i++) {
            System.out.println("我是子线程:" + i);
        }
    }
}
