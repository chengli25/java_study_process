package udp_program;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2020/11/29 - 22:36
 */
public class Client {


    public static void main(String[] args) throws Exception {
        Scanner sc =new Scanner(System.in);

        //从客户端发送数据
        DatagramSocket da = new DatagramSocket(9999);


        byte[] bs = sc.nextLine().getBytes();
        //创建包裹（传送的必须是字节）
        DatagramPacket dp = new DatagramPacket(bs,bs.length, InetAddress.getByName("localhost"),7890);

        //发送数据
        da.send(dp);
        //客户端接收数据
        byte[] by = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(by,1024);
        da.receive(dp2);
        String content = new String(by,0,dp2.getLength());
        System.out.println("客户端接收到的信息是：" + content);

    }
}
