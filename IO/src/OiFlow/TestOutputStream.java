package OiFlow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author TIMI
 * @Date 2020/11/26 - 21:06
 */
public class TestOutputStream {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream(new File("a.txt"),true);
        fos.write("我很帅".getBytes());
        fos.flush();
        fos.close();
    }
}
