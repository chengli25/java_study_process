package homework;

import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2020/12/16 - 19:04
 */
public class MultiplyTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入口诀表的规模：");
        int n = sc.nextInt();
        for(int i = 1;i <= n;i++){
            printRow(i);
            System.out.println();
        }
    }

    public static void printRow(int i) {
        for(int j = 1;j <= i;j++){
            System.out.print(j + "x" + i + "=" + j*i + "\t");
        }

    }
}
