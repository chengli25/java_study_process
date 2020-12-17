import java.io.*;

/**
 * @author TIMI
 * @Date 2020/12/16 - 14:30
 */
public class HuffmenCode {
    public static void main(String[] args) throws IOException {
        File f = new File("H:/桌面/translation.txt");
        File f1 = new File("H:/桌面/sourse.txt");
        if(!f1.exists()){
            f1.createNewFile();
        }
        BufferedReader br = new BufferedReader(new FileReader(f),512);
        BufferedWriter fw = new BufferedWriter(new FileWriter(f1));
        //System.out.println(br.readLine());//读取一个文本最好的方法
        String str ="";
        while((str = br.readLine())!= null){
            System.out.println(str);
            fw.write(str);
            fw.newLine();
        }
        fw.flush();
        fw.close();
        br.close();
        f.delete();
        //f.renameTo(f1);

    }
}
