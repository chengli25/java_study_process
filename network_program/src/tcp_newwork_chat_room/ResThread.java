package tcp_newwork_chat_room;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author TIMI
 * @Date 2020/12/17 - 9:15
 */
public class ResThread extends Thread {
    private Socket s;

    public ResThread(Socket s){
        this.s = s;
    }

    @Override
    public void run() {
        //接受数据的线程
        while(true){
            try {
                InputStream is = s.getInputStream();
                BufferedReader bi = new BufferedReader(new InputStreamReader(is));
                String content = bi.readLine();
                System.out.println("接收到的数据是:" + content);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
