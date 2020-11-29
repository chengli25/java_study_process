package checkvideo;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author TIMI
 * @Date 2020/11/28 - 12:35
 */
public class ReadVideo extends Thread{

    private static AtomicInteger i = new AtomicInteger();//原子类型，线程安全

    private BlockingDeque<Video> videoQueue;//声明一个队列

    public ReadVideo(BlockingDeque videoQueue){//构造方法
        this.videoQueue =videoQueue;
    }

    @Override
    public void run() {
        while(true){
            String name = "苍老师" + i.incrementAndGet();
            Video v = new Video(name);//相当于i++

            try {
                videoQueue.put(v);
                System.out.println("发现了一个视屏：" + name);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
