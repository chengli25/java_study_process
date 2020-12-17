package ThreedPool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author TIMI
 * @Date 2020/12/13 - 13:09
 */
public class TestSchedule {

    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
        ses.schedule(()->{
            System.out.println("我是两秒钟之后和大家见面"); },2, TimeUnit.SECONDS);

        ses.scheduleAtFixedRate(()->{
            System.out.println(new Date());
        },3,1,TimeUnit.SECONDS);
        ses.shutdown();
    }
}
