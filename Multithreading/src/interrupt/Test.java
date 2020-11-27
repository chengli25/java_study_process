package interrupt;

/**
 * @author TIMI
 * @Date 2020/11/27 - 15:41
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread();
        mt.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        mt.interrupt();
        mt.join();
        System.out.println("哈哈哈哈");
    }
}
