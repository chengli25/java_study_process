package basic_class;

import java.util.Calendar;

/**
 * @author TIMI
 * @Date 2021/1/29 - 20:15
 */
public class TestCalendar {
    //该类为一个抽象类，不可以实例化，但是其提供了几个静态getinstance（）来获取calendar对象
    public static void main(String[] args) {
        //静态方法获取实例化
        Calendar c = Calendar.getInstance();
        //输出年、月、日(获取到的月份是从0开始的)
        System.out.println(c.get(Calendar.YEAR) + "年" + c.get(Calendar.MONTH) + 1 + "月" + c.get(Calendar.DATE));
        //设置时间



    }
}
