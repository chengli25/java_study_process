package homework.work_of_1_2;

import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2021/1/2 - 19:46
 */
public class BinarySort {
    public static void main(String[] args) {
        int[] a = {1,2,3,5,7,8,12,45,78};
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入要查找的值");
        int n = sc.nextInt();
        boolean index = binaryFind(a,n);
        if(index){
            System.out.println("找到到了" + n);
        }
        else {
            System.out.println("没有找到");
        }
    }

    public static boolean binaryFind(int[] a,int n) {
        int i = 0, j = a.length-1;
        while(i<=j){
            int mid = (i + j) / 2;
            if(a[mid] < n){
                i = mid + 1;
            }
            else if(a[mid] > n){
                j = mid - 1;
            }
            else return true;
        }
        return false;
    }
}
