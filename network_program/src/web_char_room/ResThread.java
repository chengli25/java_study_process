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
    private String str;

    public ResThread(Socket s,String str){
        this.s = s;
        this.str = str;
    }

    @Override
    public void run() {
        //接受数据的线程
        while(true){
            try {
                InputStream is = s.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String content = br.readLine();
                System.out.println(str + ':' +'\n' + content+'\n');
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
