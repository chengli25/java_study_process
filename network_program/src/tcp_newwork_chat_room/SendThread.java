package tcp_newwork_chat_room;

import sun.misc.OSEnvironment;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2020/12/17 - 9:15
 */
public class SendThread extends Thread {
    private Socket s1;

    public SendThread(Socket s){
        this.s1 = s;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                OutputStream os = s1.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
                String content = sc.nextLine();
                bw.write(content);
                bw.newLine();
                bw.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
