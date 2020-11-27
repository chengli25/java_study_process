package IoTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author TIMI
 * @Date 2020/11/26 - 21:28
 */
public class Test {
    public static void main(String[] args) throws Exception {
        File f = new File("JAVA学习笔记.txt");//打开一个文件

        FileInputStream fis = new FileInputStream(f);//创建一个输入流
        FileOutputStream fo = new FileOutputStream(new File("G:/图片/张国荣.jpeg"));//创建一个输出流
        byte[] bs = new byte[1025];//用一个字节数组保存输入的字节
        int len = 0;
        while((len = fis.read(bs))!= -1){
            fo.write(bs,0,len);//将每次输入的字节都输出到输出的文件
        }
        fis.close();//关闭输入的文件
        fo.flush();//更新
        fo.close();//关闭写入的文件
        f.delete();//删除文件
    }
}
