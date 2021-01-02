package homework.work_of_12_21;

/**
 * @author TIMI
 * @Date 2020/12/21 - 23:08
 */
public class PrintArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        printArr(arr);
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
