package homework.work_of_1_19;

import java.util.Arrays;

/**
 * @author TIMI
 * @Date 2021/1/19 - 13:35
 */
public class Exchange {
    public static void main(String[] args) {
        int[] str ={1,2,3,4,5,6,7,8};
        int[] arr = {10,11,13,12,14,15};
        System.out.println("交换前：");
        System.out.println(Arrays.toString(str));
        System.out.println(Arrays.toString(arr));
        String[] a = exchange(str,arr);
        System.out.println("交换后：");
        System.out.println(a[0].toCharArray());
        System.out.println(a[1].toCharArray());
    }

    public static String[] exchange(int[] str, int[] arr) {
        int[] a = str;
        str = arr;
        arr = a;
        String[] str1={Arrays.toString(str),Arrays.toString(arr)};
        return str1;

    }
}
