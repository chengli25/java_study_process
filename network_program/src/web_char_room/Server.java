package web_char_room;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author TIMI
 * @Date 2020/11/29 - 0:20
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9999);
        Socket s = ss.accept();

        //启动两个线程，一个接受信息，一个发送信息，不能重复
        ResThread mt = new ResThread(s,"客户端");

        mt.start();

        SendThread st = new SendThread(s);
        st.start();


    }
}
