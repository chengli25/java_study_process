package homework.important_arthtic;

/**
 * @author TIMI
 * @Date 2021/1/19 - 21:16
 */
public class BF {
    public static void main(String[] args) {
        String s = "asdjkljfska";
        String s1 = "jl";
        int result = Bf(s,s1);
        if(result == 0) {
            System.out.println("匹配失败");
        }
        else {
            System.out.println("匹配成功");
        }
    }
    public static int Bf(String s, String s1) {
        char[] str = s.toCharArray();
        char[] str1 = s1.toCharArray();
        int i = 0, j = 0;
        while(i < str.length && j < str1.length) {
            if(str[i] == str1[j]) {
                ++i;
                ++j;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if(j == str1.length) {
            return i-str1.length;//匹配成功
        } else {
            return 0;//匹配失败
        }
    }
}
