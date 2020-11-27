package sleep;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author TIMI
 * @Date 2020/11/27 - 15:08
 */
public class Mythread extends Thread{
    @Override
    //让子线程不停的显示系统的时间
    public void run() {
        while(true){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d = new Date();
            System.out.println(sdf.format(d)+'\r');
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) {
        Mythread mt = new Mythread();
        mt.start();

    }
}
