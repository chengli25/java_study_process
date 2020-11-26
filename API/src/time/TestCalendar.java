package time;

import java.util.Calendar;

/**
 * @author TIMI
 * @Date 2020/11/26 - 8:54
 */
public class TestCalendar {
    //Calendar 是抽象类不能实例化
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);
        //System.out.println(cal.get(Calendar.YEAR));
        //System.out.println(cal.get(Calendar.MONTH)+1);
        //System.out.println(cal.get(Calendar.DATE));
        //System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        //System.out.println(cal.get(Calendar.MINUTE));
        //System.out.println(cal.get(Calendar.SECOND));
        //更改时间
        cal.set(Calendar.DATE,cal.get(Calendar.DATE)-130);
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH)+1);
        System.out.println(cal.get(Calendar.DATE));

    }
}
