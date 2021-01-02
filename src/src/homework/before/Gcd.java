package homework.before;

import java.util.Random;

/**
 * @author TIMI
 * @Date 2020/12/16 - 18:37
 */
public class Gcd {
    public static void main(String[] args) {

        int m = (int)(Math.random()*100);
        int n = (int)(Math.random()*100);
        System.out.println(m);
        System.out.println(n);
        if(m<n){
            int tem=m;
            m=n;
            n=tem;
        }
        while(n != 0){
            int k = m % n;
            m = n;
            n = k;
        }
        System.out.println("最大公因数为：" + m);
    }
}
