package join;

import com.sun.deploy.net.proxy.ProxyUnavailableException;

/**
 * @author TIMI
 * @Date 2020/11/27 - 15:20
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("子线程：" + i);
        }
    }
}
