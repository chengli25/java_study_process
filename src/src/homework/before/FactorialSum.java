package homework.before;

import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2020/12/19 - 23:11
 */
public class FactorialSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入n：");
        int n = sc.nextInt();
        int result = 0;
        for (int i = 1; i <= n; i++) {
            //将每个阶乘相加
            result+=factorial(i);
        }
        System.out.println(result);
    }
    //计算每个值的阶乘
    public static int factorial(int i) {
        int result=1;
        for (int j = 1; j <= i; j++) {
            result *=j;
        }
        return result;
    }
}
