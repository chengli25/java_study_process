package homework.work_of_12_21;

import java.util.Arrays;

/**
 * @author TIMI
 * @Date 2020/12/21 - 23:04
 */
public class TransformArr {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int[] b = transform(arr);
        System.out.println(Arrays.toString(b));
    }

    public static int[] transform(int[] arr) {
        int[] a = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = arr[i] * 2;
        }
        return a;
    }
}
