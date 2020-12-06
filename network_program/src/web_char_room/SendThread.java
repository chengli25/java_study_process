package web_char_room;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2020/11/29 - 0:34
 */
public class SendThread extends Thread{
    private Socket s;
    private String name;

    public SendThread(Socket s,String name){
        this.s = s;
        this.name = name;
    }

    @Override
    public void run() {
        Scanner sc =new Scanner(System.in);
        while(true){
            try {
                OutputStream os = s.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));


                String con =sc.nextLine();
                bw.write(name);
                bw.newLine();
                bw.flush();
                Thread.sleep(1);
                bw.write(con);
                bw.newLine();
                bw.flush();

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
