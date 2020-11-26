package OiFlow;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author TIMI
 * @Date 2020/11/26 - 21:13
 */
public class TestFileReader {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("a.txt");
        //char[] s = new char[4];
        //int len = fr.read(s);
        //System.out.println(new String(s,0,len));
        char[] cs = new char[1024];
        int len;
        while((len = fr.read(cs))!= -1){
            System.out.println(new String(cs,0,len));
        }
        fr.close();
    }
}
