package file;

import java.io.File;

/**
 * @author TIMI
 * @Date 2020/11/26 - 10:03
 */
public class Test {
    public static void main(String[] args) {
        try{
            File file = new File("chifan.txt");
            System.out.println( file.exists());//查看文件是否存在
            file.createNewFile();//创建一个文件
            file.getParent();//获取上一层文件夹的对象
            file.getParentFile();//获取上层文件的文件名
            file.mkdir();//创建文件夹
            file.mkdirs();//创建多级文件夹
            file.renameTo(new File("abc/def/俗人.txt"));//重命名
            file.delete();//删除文件
            System.out.println( file.exists());//查看文件是否存在

       }catch(Exception e){
            e.printStackTrace();
        }
    }
}
