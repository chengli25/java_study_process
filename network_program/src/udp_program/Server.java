package udp_program;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2020/11/29 - 22:36
 */
public class Server {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket(7890);
  
        byte[] by = new byte[1024];
        DatagramPacket dp = new DatagramPacket(by,1024);//用来接收数据的
        ds.receive(dp);//接收数据

        String s = new String(by,0,dp.getLength());
        System.out.println("接收到的数据是：" + s);


        //发送一条数据给客户端
        byte[] bs = sc.nextLine().getBytes();
        DatagramPacket dp2 = new DatagramPacket(bs,bs.length, InetAddress.getByName("localhost"),9999);
        ds.send(dp2);//发送数据
    }

}
