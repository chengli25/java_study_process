package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author TIMI
 * @Date 2020/11/25 - 12:42
 */
public class Test1 {
    public static  void  read(){
        try{
            InputStream is = new FileInputStream(new File("哈哈哈"));
        }catch(Exception e){
            System.out.println("出错了");
        }
    }

    public static void main(String[] args) {
        Test1 t = new Test1();
        t.read();
    }
}
