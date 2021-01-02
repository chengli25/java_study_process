package test;

import java.util.Arrays;

/**
 * @author TIMI
 * @Date 2020/12/18 - 21:26
 */
public class Test {
    //public static void main(String[] args) {
    //    int[] arr ={1,2,3,4};
    //    int[] a = reserver(arr);
    //    System.out.println(Arrays.toString(arr));
    //    System.out.println(Arrays.toString(a));
    //}
    //
    //public static int[] reserver(int[] arr) {
    //    int[] a = Arrays.copyOfRange(arr,0, arr.length);
    //
    //    for (int i = 0; i < a.length; i++) {
    //        a[i] *= 2;
    //    }
    //    for(int x:a){
    //        x = x * 2;
    //    }
    //    //System.out.println(Arrays.toString(a));
    //    return a;
    //}
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
        for(int x : arr){
            x *= x;
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
        System.out.println(Arrays.toString(arr));
    }
}
