package inputstreamreader;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * @author TIMI
 * @Date 2020/11/26 - 23:48
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        Writer wr = new OutputStreamWriter(System.out);
        wr.write("你好");
        wr.flush();
        //某些流是不能关闭的
    }
}
