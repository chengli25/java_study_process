package homework.work_of_1_2;

/**
 * @author TIMI
 * @Date 2021/1/2 - 20:08
 */
public class SplitArray {
    public static void main(String[] args) {
        int[] a = {1,2,35,6,67};
        String s = splitArray(a);
        System.out.println(s);
    }

    public static String splitArray(int[] a) {
        String s = "";
        for(int i = 0; i < a.length; i++){
            if(i == 0){
                s += ("[" + a[i]);
            }
            else{
                s += ("," + a[i]);
            }
        }

        s += "]";
        return s;
    }
}
