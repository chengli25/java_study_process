package file;

import java.io.*;
import java.text.DecimalFormat;

/**
 * @author TIMI
 * @Date 2020/11/27 - 12:38
 */
public class practice {
    public static void main(String[] args) throws Exception {

        DecimalFormat df = new DecimalFormat(".00");//数字的格式化为字符串

        //能从文件中读取水果信息
        File f1 = new File("fruit.txt");//打开一个文件
        File f2 = new File("副本fruit.txt");//打开需要写入的文件
        BufferedReader bf = new BufferedReader(new FileReader(f1));//给源文件开一个输入缓冲流
        BufferedWriter bw = new BufferedWriter(new FileWriter(f2));//给目标文件开一个输出缓冲流
        String title = bf.readLine();//读取表头
        bw.write(title + "_总价");//对表头再造成需要的样子
        bw.newLine();//新开一行

        String content ="";
        while((content=bf.readLine())!= null){//依次读取每一行
            String[] fs = content.split("_");//将每一行的数字和文字分隔开
            double price = Double.parseDouble(fs[1]);//将分隔开的字符串价格转换为double类型的数据
            double num = Double.parseDouble(fs[2]);//将分隔开的字符串数量转换为double类型的数据
            double totle = price*num;//计算出总价
            String toString = df.format(totle);//将总价格式为字符串
            content += "_" + toString;//将总价连接在读出的字符串后面
            bw.write(content);//将字符串写入新的文件
            bw.newLine();//写入一行就开启下一行
        }
        bf.close();//关闭输入缓冲流
        bw.flush();//更新写入缓冲流
        bw.close();//关闭写入缓冲流
        f1.delete();//删除源文件
        f2.renameTo(f1);//重命名副本文件

    }
}
