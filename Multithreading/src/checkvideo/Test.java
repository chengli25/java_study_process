package checkvideo;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author TIMI
 * @Date 2020/11/28 - 12:51
 */
public class Test {
    public static void main(String[] args) {
        BlockingDeque<Video> videos = new LinkedBlockingDeque<Video>();
        //创建三个读取视屏的线程
        ReadVideo rv1 = new ReadVideo(videos);
        ReadVideo rv2 = new ReadVideo(videos);
        ReadVideo rv3 = new ReadVideo(videos);

        //创建两个发送视屏的
        SendVideo se1 = new SendVideo(videos);
        SendVideo se2 = new SendVideo(videos);

        //启动5个线程
        rv1.start();
        rv2.start();
        rv3.start();

        se1.start();
        se2.start();
    }
}
