package OiFlow;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author TIMI
 * @Date 2020/11/26 - 20:19
 */
public class TestFileInputStream {

    public static void main(String[] args) throws Exception {
        ////创建流
        FileInputStream fis = new FileInputStream(new File("Java学习笔记.txt"));
        System.out.println((char)fis.read());
        //int b = fis.read();//读取一个字节
        //System.out.println((char)b);
        //byte[] a = new byte[4];
        //int len = fis.read(a);//读取一个数组
        //System.out.println(new String(a,0,len));

        //完整的去读一个文件
        //byte[] by = new byte[13];
        //int len =0;
        //while((len = fis.read(by))!=-1){
        //    String s = new String(by,0,len);
        //    System.out.println(s);
        //}
        fis.close();

    }
}
