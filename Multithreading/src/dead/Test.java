package dead;

/**
 * @author TIMI
 * @Date 2020/11/27 - 16:28
 */
public class Test {
    public static void main(String[] args) {
        DeadLock1 dl1 = new DeadLock1();
        DeadLock2 dl2 = new DeadLock2();
        dl1.start();
        dl2.start();
    }


}
