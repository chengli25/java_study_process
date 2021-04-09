package homework.before;

import java.util.Scanner;

/**
 * @author: Linduse
 * @Date: 2021/3/3 - 19:01
 * @since: jdk 1.8
 */
public class NumberSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字：");
        int sum = 0;
        int num = sc.nextInt();
        while(num != 0) {
            int k = num % 10;
            num /=10;
            sum +=k;
        }
        System.out.println(sum);
    }
}
