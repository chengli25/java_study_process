package threadsync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author TIMI
 * @Date 2020/11/27 - 15:51
 */
public class Account {
    private  double balance;
    private  Lock lock = new ReentrantLock();//创建一个锁
    public Account(double balance){
        this.balance=balance;
    }
    public  synchronized void getMoey(){    //锁定整个方法
        lock.lock();//上锁
        synchronized (this) {//锁定对象
            if (this.balance <= 0) {
                System.out.println("没钱了。");
                return;
            }
            System.out.println("我要取钱了，目前还剩下：" + this.balance);
            this.balance -= 1000;
            System.out.println("取完了，还剩下：" + this.balance);
            lock.unlock();//去掉锁
        }

    }

}
