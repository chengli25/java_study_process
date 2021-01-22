package homework.work_of_1_19;

/**
 * @author TIMI
 * @Date 2021/1/19 - 20:59
 */
public class MycompareTo {
    public static void main(String[] args) {
        String s = "abEe";
        String s1 = "abEd";
        int result = mycompareTo(s,s1);
        if(result > 0) {
            System.out.println("s比s1大");
        }
        else if(result < 0){
            System.out.println("s比s1小");
        }
        else {
            System.out.println("s1和s相等");
        }
    }

    public static int mycompareTo(String s, String s1) {
        char[] str = s.toCharArray();
        char[] str1 =s1.toCharArray();
        int len1 = s.length();
        int len2 = s.length();
        int n;
        if(len1 > len2){
            n = len2;
        }else {
            n = len1;
        }
        for(int i = 0; i < n; i++){
            int ind = str[i] - str1[i];
            if(ind == 0) {
                continue;
            } else {
                return ind;
            }
        }
        return 0;
    }

}
