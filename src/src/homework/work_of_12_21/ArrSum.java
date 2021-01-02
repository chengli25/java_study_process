package homework.work_of_12_21;

/**
 * @author TIMI
 * @Date 2020/12/21 - 23:01
 */
public class ArrSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        System.out.println(result);
    }
}
