package modifyfile;

import java.io.*;

/**
 * @author TIMI
 * @Date 2020/11/27 - 12:22
 */
public class Test {
    public static void main(String[] args) throws Exception {
        File res = new File("唐诗三百首.txt");
        File another = new File("副本唐诗三百首.txt");
        BufferedReader br = new BufferedReader(new FileReader(res));
        BufferedWriter bw = new BufferedWriter(new FileWriter(another));
        String s ="";
        while((s=br.readLine())!= null){
            s = s.replace("杜甫","程立");
            bw.write(s);
            bw.newLine();//另起一行
        }
        br.close();
        bw.flush();
        bw.close();
        res.delete();
        another.renameTo(res);
    }

}
