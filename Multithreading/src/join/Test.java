package join;

/**
 * @author TIMI
 * @Date 2020/11/27 - 15:21
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread();
        mt.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程：" + i);
        }
        mt.join();
        System.out.println("哈哈哈哈");
    }
}
