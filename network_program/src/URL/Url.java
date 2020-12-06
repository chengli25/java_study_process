package URL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author TIMI
 * @Date 2020/11/30 - 21:26
 */
public class Url {

    public static void main(String[] args) throws Exception{
        URL u = new URL("http://5b0988e595225.cdn.sohucs.com/images/20170825/92b5798987ac454387479d4354290145.jpeg");

        URLConnection uc = u.openConnection();//打开链接

        InputStream is = uc.getInputStream();//读取字节流
        FileOutputStream fos = new FileOutputStream(new File("程序员.jpg"));//创建文件输出流

        byte[] bs = new byte[1024];//用一个字节数组存入字节信息
        int len;
        while((len = is.read(bs))!=-1){
            fos.write(bs,0,len);//将字节数组中的信息写入文件中
        }
        fos.flush();//更新
        fos.close();//关闭
        is.close();//关闭输入流
        System.out.println("下载完毕...");
    }
}
