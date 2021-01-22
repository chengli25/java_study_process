package homework.work_of_1_19;

/**
 * @author TIMI
 * @Date 2021/1/19 - 20:54
 */
public class Mycontains {
    public static void main(String[] args) {
        String s = "abcdefghi";
        String s1 = "b";
        boolean bl = mycontains(s,s1);
        if(bl) {
            System.out.println("包含");
        }else {
            System.out.println("不包含");
        }

    }

    public static boolean mycontains(String s, String s1) {
        char[] str = s.toCharArray();
        char[] str1 = s1.toCharArray();
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            for (int k = i; j < s1.length(); k++) {
                if (str[k] == str1[j++]) {
                    if (j == s1.length()) {
                        return true;
                    }
                    continue;
                } else {
                    j = 0;
                    break;
                }

            }
        }
        return false;
    }
}
