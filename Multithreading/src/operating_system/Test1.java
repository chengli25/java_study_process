package operating_system;

/**
 * @author TIMI
 * @Date 2020/11/27 - 14:10
 */
public class Test1 {
    public static void main(String[] args) {
        Runnable r = new MyRunnable();
        Thread T = new Thread(r);
        T.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("我是主线程：" + i);

        }
    }
}
