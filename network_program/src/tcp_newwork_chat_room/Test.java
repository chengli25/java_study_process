package tcp_newwork_chat_room;

import java.io.IOException;

/**
 * @author TIMI
 * @Date 2020/12/18 - 16:09
 */
public class Test {
    static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            try {
                Sever server = new Sever();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(100);
        for (int i = 0; i < 200; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    //synchronized (lock){
                        Client client = new Client();
                        for (int j = 0; j < 10; j++) {
                            client.sendToOtherClient(finalI+"发送");
                        }
                    //}
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }
}
