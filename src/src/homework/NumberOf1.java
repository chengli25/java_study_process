package homework;

import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2020/12/16 - 19:25
 */
public class NumberOf1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count =0;
        System.out.println("请输入一个整数：");
        int m = sc.nextInt();
        while(m!=0){
            m=m&(m-1);
            count++;
        }
        System.out.println(count);
    }
}
