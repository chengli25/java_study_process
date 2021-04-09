package basic_class;

import java.util.Date;

/**
 * @author TIMI
 * @Date 2021/1/29 - 19:44
 */
public class TestDate {
    public static void main(String[] args) {
        //时间类
        Date d = new Date();
        //输出当前时间
        System.out.println(d);
        //获取当前时间对应的long型整数
        long l = d.getTime();
        System.out.println(l);
        //另一种date的构造方法，就是传入一个long型的整数，会生成与之对应的日期信息
        Date da = new Date(l);
        System.out.println(da);
        //设置当前时间，将当前的date对象改为long型参数对应的日期
        da.setTime(1611922298432L);
        System.out.println(da);


    }


}


