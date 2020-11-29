package threadsync;

/**
 * @author TIMI
 * @Date 2020/11/27 - 15:57
 */
public class Test {

    public static void main(String[] args) {
        Account acc = new Account(1000);//创建一个账户

        MyThread mt = new MyThread(acc);//创建一个ATM线程
        MyThread guitai = new MyThread(acc);//创建一个柜台的线程

        //开始取钱
        mt.start();
        guitai.start();
    }
}
