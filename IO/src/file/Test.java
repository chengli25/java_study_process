package file;

import com.sun.org.apache.xpath.internal.res.XPATHErrorResources_sv;

import java.io.File;
import java.io.IOException;

/**
 * @author TIMI
 * @Date 2020/11/26 - 10:03
 */
public class Test {
    public static void main(String[] args) throws Exception {
       // try{
       //     File file = new File("abc/def/chifan.txt");
       ////     System.out.println( file.exists());//查看文件是否存在
       ////
       ////     System.out.println(file.getParent());//获取上一层文件夹的对象
       ////     System.out.println(file.getParentFile());//获取上层文件的文件名
       ////     file.mkdir();//创建文件夹
       ////     file.mkdirs();//创建多级文件夹
       //     file.createNewFile();//创建一个文件
       ////     file.renameTo(new File("abc/def/俗人.txt"));//重命名
       ////     file.delete();//删除文件
       ////     System.out.println( file.exists());//查看文件是否存在
       ////     System.out.println(file.isAbsolute());//查看文件是否是绝对路径
       ////     System.out.println(file.isDirectory());//查看文件是否是文件夹
       ////     System.out.println(file.isFile());//查看是否是文件
       //     System.out.println(file.length());//查看文件的大小
       //  System.out.println(file.getName());//查看文件夹的名字
       ////
       //}catch(Exception e){
       //     e.printStackTrace();
       // }


        /**
         * 完整创建一个文件路径
         */
        try{
            File file = new File("唐诗三百首.txt");
            //判定上层文件夹是否存在
            //File parentfile = file.getParentFile();//返回的是一个对象
            //if(!parentfile.exists()){//查看文件夹是否存在
            //    parentfile.mkdirs();
            //}
            //创建文件
            file.createNewFile();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
