package homework;

import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2020/12/16 - 19:29
 */
public class PrintItem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] str = new int[100];
        int i = 0;
        System.out.println("请输入一个数字：");
        int m = sc.nextInt();
        while(m != 0){
            int k = m % 10;
            m /= 10;
            str[i] = k;
            i++;
        }
        for(int j = i-1;j >= 0;j--){
            System.out.println(str[j]);
        }
    }
}
