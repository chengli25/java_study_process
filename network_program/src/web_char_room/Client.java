package web_char_room;

import java.io.IOException;
import java.net.Socket;

/**
 * @author TIMI
 * @Date 2020/11/29 - 0:39
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost",9999);

        //启动两个线程，一个接受信息，一个发送信息，不能重复
        ResThread mt = new ResThread(s,"服务器");
        mt.start();

        SendThread st = new SendThread(s);
        st.start();

    }
}
