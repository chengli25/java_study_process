package tcp_program;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2020/11/28 - 18:29
 */
public class Server {
    public static void main(String[] args) throws Exception {
        //创建服务器端对象
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("服务器端启动成功，等待连接！");
        //等待客户端链接
        Socket s = ss.accept();    //   阻塞
        System.out.println("客户端链接成功");

        Scanner sc = new Scanner(System.in);
        while(true) {
            //服务器接收数据
            InputStream is = s.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str = br.readLine();
            System.out.println("Siri\n" + str);

            //给客户端发送一条信息
            OutputStream os = s.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            bw.write(sc.nextLine());
            bw.newLine();
            bw.flush();

        }

    }

}
