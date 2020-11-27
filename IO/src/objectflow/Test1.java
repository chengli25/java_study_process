package objectflow;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author TIMI
 * @Date 2020/11/27 - 11:52
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream OOS =new ObjectOutputStream(new FileOutputStream(new File("Test.dat")));

        Test t = new Test(001 ,"张三",20 );
        OOS.writeObject(t);
        OOS.flush();
        OOS.close();
    }
}
