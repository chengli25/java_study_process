package tcp_newwork_chat_room;

import java.io.IOException;
import java.net.Socket;

/**
 * @author TIMI
 * @Date 2020/12/17 - 9:05
 */
public class Client {
    Socket s = new Socket("localhost",9997);
    public Client() throws IOException {
            //第一个线程负责接受数据
            ResThread rt = new ResThread(s);
            rt.start();
            //第二个线程负责发送数据
            SendThread st = new SendThread(s);
            st.start();
    }

    public void sendToOtherClient(String msg){
        Util.send(s,msg);
    }

    public static void main(String[] args) {

    }
}