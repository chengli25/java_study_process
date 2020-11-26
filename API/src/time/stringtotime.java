package time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2020/11/26 - 9:37
 */
public class stringtotime {
    /**
     * 字符串转换为时间
     * @param args
     */
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入时间(yyyy-MM-dd HH:mm:ss)");
        String s = sc.nextLine();
        Date d = sdf.parse(s);//字符串转化为时间
        System.out.println(d);
    }
}
