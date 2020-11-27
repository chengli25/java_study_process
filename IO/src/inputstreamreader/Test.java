package inputstreamreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author TIMI
 * @Date 2020/11/26 - 23:37
 */
public class Test {
    public static void main(String[] args) throws Exception {
        //将字节流转换为字符流
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     String s = br.readLine();
        System.out.println("您从控制台输入的是：" + s);
    }
}
