package checkvideo;

import java.util.concurrent.BlockingDeque;

/**
 * @author TIMI
 * @Date 2020/11/28 - 12:44
 */
public class SendVideo extends Thread {
    private BlockingDeque<Video> videoQueue;
    public SendVideo(BlockingDeque<Video> videoQueue){
        this.videoQueue = videoQueue;
    }
    @Override
    public void run() {
        while(true){
            try {
                Video v = videoQueue.take();
                System.out.println("我是发送的地方，我发现了一个视屏：" + v.getName());
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
