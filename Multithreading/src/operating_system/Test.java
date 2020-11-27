package operating_system;

/**
 * @author TIMI
 * @Date 2020/11/27 - 14:00
 */
public class Test {
    public static void main(String[] args) {//主线程
        //创建线程对象
        MyThread mt = new MyThread();
        //调用start方法（）启动线程
        mt.start();//启动一个线程用start

    }
}
