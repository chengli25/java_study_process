package homework.work_of_12_21;

/**
 * @author TIMI
 * @Date 2020/12/21 - 22:48
 */
public class avg_arr {
    public static void main(String[] args) {
        int[] arr = {1,2,34,6,7,8,7};
        double a = avg(arr);
        System.out.println(a);
    }

    public static double avg(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        double b = (double)result/arr.length;
        return b;
    }
}
