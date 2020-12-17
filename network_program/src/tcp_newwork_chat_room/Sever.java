package tcp_newwork_chat_room;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author TIMI
 * @Date 2020/12/17 - 9:04
 */
public class Sever{
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(9998);
        Socket s = ss.accept();
        //不停的接受发送信息
        //第一个线程负责接受数据
        ResThread rt = new ResThread(s);
        rt.start();
        //第二个线程负责发送数据
        SendThread st = new SendThread(s);
        st.start();
    }

}
