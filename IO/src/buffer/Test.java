package buffer;

import java.io.*;

/**
 * @author TIMI
 * @Date 2020/11/26 - 23:14
 */
public class Test {
    public static void main(String[] args) throws Exception {
        File f = new File("JAVA学习笔记.txt");
        File f1 = new File("a.txt");
        if(!f.exists()){
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f,true);
            fo.write("你是狗".getBytes());
        }
       //BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
       // bis.read()
        BufferedReader br = new BufferedReader(new FileReader(f),512);
        BufferedWriter fw = new BufferedWriter(new FileWriter(f1));
        //System.out.println(br.readLine());//读取一个文本最好的方法
        String str ="";
        while((str = br.readLine())!= null){
            fw.write(str);
            fw.newLine();
            System.out.println(str);
        }
        fw.close();
        br.close();
    }
}
