package homework.before;

import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2020/12/19 - 23:02
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入n：");
        int n = sc.nextInt();
        int m = printFibnacci(n);
        System.out.println(m);
    }

    public static int printFibnacci(int n) {
        int s;
        if(n==1||n==2){
            s=1;
        }else{
            s = printFibnacci(n-1) + printFibnacci(n-2);
        }
        return s;
    }
}
