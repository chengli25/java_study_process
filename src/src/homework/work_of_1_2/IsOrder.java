package homework.work_of_1_2;

/**
 * @author TIMI
 * @Date 2021/1/2 - 19:58
 */
public class IsOrder {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,67,8};
        boolean bl = isOrder(a);
        if(bl){
            System.out.println("数组排列有序");
        }else{
            System.out.println("数组排列无序");
        }
    }

    public static boolean isOrder(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if(a[i] > a[i + 1]){
                return false;
            }
        }
        return true;
    }
}
