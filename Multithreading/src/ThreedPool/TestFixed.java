package ThreedPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author TIMI
 * @Date 2020/12/13 - 13:01
 */
public class TestFixed {
    private static AtomicInteger i = new AtomicInteger();
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        for(int j = 0;j < 10; j++) {
            int key = TestFixed.i.incrementAndGet();
            System.out.println("创建子线程" + key);
            es.execute(() -> {
                for (int i = 0; i < 100; i++) {
                    System.out.println("子线程：" + key + "===>>>"+ i);
                }

            });
        }
    }
}
