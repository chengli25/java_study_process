package buffer;

import java.io.*;
import java.lang.management.BufferPoolMXBean;

/**
 * @author TIMI
 * @Date 2020/11/26 - 23:14
 */
public class Test {
    public static void main(String[] args) throws Exception {
        File f = new File("a.txt");
        if(!f.exists()){
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f,true);
            fo.write("你是狗".getBytes());
        }
       //BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
       // bis.read()
        BufferedReader br = new BufferedReader(new FileReader(f));
        System.out.println(br.readLine());//读取一个文本最好的方法
        String str ="";
        while((str = br.readLine())!= null){
            System.out.println(str);
        }
        br.close();
    }
}
