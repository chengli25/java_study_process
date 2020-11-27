package operating_system;

/**
 * @author TIMI
 * @Date 2020/11/27 - 14:10
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("子线程：" + i);

        }
    }
}
