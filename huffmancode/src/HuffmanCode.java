import java.io.File;
import java.io.IOException;
/**
 * @author TIMI
 * @Date 2020/12/16 - 14:24
 */
public class HuffmanCode {
    public static void main(String[] args) {
        File f = new File("H:/桌面/sourse.txt");
        File f1 = new File("H:/桌面/code.txt");
        if(!f1.exists()){
            try {
                f1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        f.delete();
        f1.renameTo(f);
    }
}
