package homework.before;

import java.util.Scanner;

/**
 * @author: Linduse
 * @Date: 2021/3/3 - 19:23
 * @since: jdk 1.8
 */
public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = recurision(n);
        System.out.println(result);
    }
    public static int recurision(int n){
        if(n == 0  || n == 1) {
            return 1;
        }  else {
            return recurision(n - 1) * n;
        }
    }
}
