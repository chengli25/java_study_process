package homework.work_of_1_2;

import java.util.Arrays;

/**
 * @author TIMI
 * @Date 2021/1/2 - 19:41
 */
public class BullenSort {
    public static void main(String[] args) {
        int[] a = {1,34,56,2,6,7,3,3,2,4,6,2,};
        bullenSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static int[] bullenSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if(a[j] > a[j+1]) {
                    int tem = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tem;
                }
            }

        }
        return a;
    }

}
