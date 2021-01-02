package tcp_newwork_chat_room;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TIMI
 * @Date 2020/12/17 - 9:04
 */
public class Sever{
    public Sever() throws IOException {
        ServerSocket ss = new ServerSocket(9997);
        List<Socket> socketList = new ArrayList<>();

        while(true) {
            Socket s = ss.accept();
            System.out.println("连接成功");
            socketList.add(s);
            //为每一个客户端启动一个线程，用来监听线程是否有消息传递过来
            new ServerMsgThread(s,socketList).start();
        }
    }
    public static void main(String[] args) throws Exception{



    }

}
