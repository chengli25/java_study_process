package dead;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * @author TIMI
 * @Date 2020/11/27 - 16:20
 */
public class DeadLock1 extends Thread {
    @Override
    public void run() {
        synchronized (ResourseObject.obj1){
            System.out.println("锁定第一个资源");
        }
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (ResourseObject.obj2){
            System.out.println("锁定第二个资源");
            System.out.println("执行完毕");
        }

    }
}
