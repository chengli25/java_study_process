package tcp_program;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2020/11/28 - 18:33
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost",9999);
        System.out.println("客户端链接服务器成功！");
        Scanner sc = new Scanner(System.in);
        while(true) {
            //从客户端发送数据给服务器
            OutputStream os = socket.getOutputStream();//建立一个写出流
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));//将输出的字节流转换为字符流并且加上缓冲流
            bw.write(sc.nextLine());//写入数据
            bw.newLine();//保证对方能用readline来接受数据

            bw.flush();//更新管道
            //单向不能关闭通道

            //客户端接受数据
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str = br.readLine();
            System.out.println("小爱：\n" + str);
        }
    }
}
