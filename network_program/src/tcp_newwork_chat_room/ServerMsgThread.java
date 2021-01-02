package tcp_newwork_chat_room;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TIMI
 * @Date 2020/12/18 - 8:53
 */
public class ServerMsgThread extends Thread {
    private Socket s;
    private List<Socket> socketList ;

    public ServerMsgThread(Socket s,List<Socket> socketList){
        this.s = s;
        this.socketList = socketList;
    }

    @Override
    public void run() {

        while (true){
            //接收消息
            String msg = Util.rece(this.s);
            //把收到的消息分发给每一个客户端
            for(Socket s:socketList){
                if(s.equals(this.s)){
                    continue;
                }
                Util.send(s,msg);
            }
        }
    }
}
