package dead;

/**
 * @author TIMI
 * @Date 2020/11/27 - 16:25
 */
public class DeadLock2 extends Thread{
    @Override
    public void run() {
        synchronized (ResourseObject.obj2){
            System.out.println("锁定资源2");
        }
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (ResourseObject.obj1){
            System.out.println("锁定资源1");
            System.out.println("执行完毕");
        }

    }
}
