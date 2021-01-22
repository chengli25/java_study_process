package homework.work_of_1_19;

import java.util.Arrays;

/**
 * @author TIMI
 * @Date 2021/1/19 - 14:02
 */
public class Achieve {
    public static void main(String[] args) {
        String s = "192.168.0.1";
        String[] s1 = mySplit(s);
        System.out.println(Arrays.toString(s1));
    }
    public static String[] mySplit(String s) {
        char[] s1 = s.toCharArray();
        String[] str= {null,null,null,null};
        int j = 0, k = 0;
        for(int i = 0; i < s.length(); i++){
            if(s1[i] == '.'){
                str[j++]=s.substring(k, i);
                k = i + 1;
            }
        }
        if(k == s.length() - 1)
            str[j] = s.substring(k);
        return str;
    }
}
