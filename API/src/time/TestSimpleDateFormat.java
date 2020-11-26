package time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author TIMI
 * @Date 2020/11/26 - 9:27
 */
public class TestSimpleDateFormat {


    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = sdf.format(d);
        System.out.println(s);
    }
}

