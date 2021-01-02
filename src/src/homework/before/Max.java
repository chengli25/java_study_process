package homework.before;

import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2020/12/19 - 23:36
 */
public class Max {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入三个数：");
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }
        int ma4 = max3(arr[0],arr[1],arr[2]);
        System.out.println("最大值是：" + ma4);
    }

    public static int max3(int i, int i1, int i2) {
        int ma1 = max2(i,i1);
        int ma2 = max2(i,i2);
        int ma3 = max2(i1,i2);
        if(ma1 == ma2 || ma1 == ma3){
            return ma1;
        }
        else {
            return ma2;
        }

    }

    public static int max2(int m,int n) {
        if(m >= n){
            return m;
        }else{
            return n;
        }
    }
}
