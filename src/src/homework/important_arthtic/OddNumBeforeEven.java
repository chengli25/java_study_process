package homework.important_arthtic;

import java.util.Arrays;

/**
 * @author TIMI
 * @Date 2020/12/19 - 23:25
 */
public class OddNumBeforeEven {
    public static void main(String[] args) {
        int []arr={1,2,3,4,5,6,7,8,9,10};
        int[]b = a(arr);

        System.out.println(Arrays.toString(b));

    }

    private static int[] a(int[] arr) {
        int i = 0, j = arr.length - 1;
        while(i < j){
            while(arr[i] % 2 != 0){
                i++;
            }
            while(arr[j] % 2 == 0){
                j--;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }
        return arr;
    }
}
