package objectflow;

import java.io.*;

/**
 * @author TIMI
 * @Date 2020/11/27 - 12:02
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        //File f = new File("Test.dat");
        //BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        //
        //if(!f.exists()){
        //    f.createNewFile();
        //    String str = "1 张三 19";
        //    bw.write(str);
        //    bw.flush();
        //    bw.close();
        //}
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("Test.dat")));
        Object obj = ois.readObject();
        Test p = (Test)obj;
        System.out.println("学号：" + p.getId() + " " + "姓名：" + p.getName() + "  " +  "年龄：" + p.getAge() + ";");
    }
}
