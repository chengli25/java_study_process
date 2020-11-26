package OiFlow;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author TIMI
 * @Date 2020/11/26 - 21:22
 */
public class TestFileWriter {
    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("a.txt",true);
        fw.write("大家都很帅哦");
        fw.flush();
        fw.close();
    }
}
