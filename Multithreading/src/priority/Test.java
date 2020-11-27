package priority;

/**
 * @author TIMI
 * @Date 2020/11/27 - 14:34
 */
public class Test {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread("A线程");
        MyThread mt2 = new MyThread("B线程");
        mt1.setPriority(10);//有优先级，但不代表独占CPU
        mt2.setPriority(1);
        mt1.start();
        mt2.start();
    }
}
