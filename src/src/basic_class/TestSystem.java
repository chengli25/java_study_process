package basic_class;

import java.util.Random;

/**
 * @author TIMI
 * @Date 2021/1/29 - 19:27
 */
public class TestSystem {
    public static void main(String[] args) {
        System.out.println("当前时间：" + System.currentTimeMillis());
        //对于随机函数的种子，我们可以用当前的时间作为随机数的种子，就不会重复
        int i = 0;
        Random rd = new Random(System.currentTimeMillis());
        while(i <= 10) {
            int m = rd.nextInt(200);
            System.out.println(m);
            i++;
        }

    }
}
