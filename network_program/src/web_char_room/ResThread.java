package web_char_room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author TIMI
 * @Date 2020/11/29 - 0:24
 */
public class ResThread extends Thread{
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
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String content = br.readLine();
                System.out.println(content);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
