import java.net.InetAddress;
import java.net.UnknownHostException;

import static java.net.InetAddress.getLocalHost;

/**
 * @author TIMI
 * @Date 2020/12/4 - 17:25
 */
public class Test {
    public static void main(String[] args) throws UnknownHostException {
       //short a = 128;
       //byte b = (byte)a;
       // System.out.println(a);
       // System.out.println(b);
       // double x=2.0; int y=4; x/=++y;
       // System.out.println(x);
        //获取本机地址以及本机地址名称分离
        InetAddress ia = getLocalHost();
        System.out.println(ia.toString());
        String s = ia.getHostAddress();
        System.out.println(s);
        String s1 = ia.getHostName();
        System.out.println(s1);
    }
}
