package tcp_newwork_chat_room;

import java.io.*;
import java.net.Socket;

/**
 * @author TIMI
 * @Date 2020/12/18 - 8:38
 */

/**
 * 这是一个工具类*
 * 用来实现接收和发送消息两个方法
 */
public class Util {
    //发送消息
    public static void send(Socket s,String msg){
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bw.write(msg);
            bw.newLine();
            bw.flush();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String rece(Socket s){
        try {
            InputStream is = s.getInputStream();
            BufferedReader bi = new BufferedReader(new InputStreamReader(is));
            String content = bi.readLine();
           return content;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
