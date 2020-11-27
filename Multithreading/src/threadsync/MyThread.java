package threadsync;

/**
 * @author TIMI
 * @Date 2020/11/27 - 15:54
 */
public class MyThread extends Thread{
    private  Account acc;
    public MyThread(Account acc){
        this.acc = acc;//保证柜台和ATM用的是同一个账户
    }
    @Override
    public void run() {
        acc.getMoey();
    }
}
