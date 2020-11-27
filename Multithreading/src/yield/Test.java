package yield;

/**
 * @author TIMI
 * @Date 2020/11/27 - 15:29
 */
public class Test {
    public static void main(String[] args) {
        MyThread mt = new MyThread("A线程" );
        MyThread mt1 = new MyThread("B线程" );
        mt.start();
        mt1.start();
    }
}
