package time;

import java.util.Calendar;
import java.util.Date;

/**
 * @author TIMI
 * @Date 2020/11/26 - 8:44
 */
public class test {


    public static void main(String[] args) {
        //Date a = new Date();//系统时间
        //System.out.println(a);
        ////System.out.println(a.getYear()+1900);
        //System.out.println(a.getTime());

        //日历和日期之间的转化
        Date d = new Date();
        Calendar cal = Calendar.getInstance();

        cal.setTime(d);//把时间转化为Calendar

        System.out.println(cal.get(Calendar.MONTH)+1);
        System.out.println(cal.getTime());
    }
}
