package homework.work_of_1_19;

/**
 * @author TIMI
 * @Date 2021/1/19 - 20:31
 */
public class MyindexOf {
    public static void main(String[] args) {
        String s = "abdedfghijklmn";
        String s1 = "lmn";
        int index = myindexOf(s,s1);
        if(index == -1){
            System.out.println("不存在");
        }else{
            System.out.println("位置是：" + index);
        }
    }
    public static int myindexOf(String s, String s1) {
        char[] str = s.toCharArray();
        char[] str1 = s1.toCharArray();
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            for (int k = i; j < s1.length(); k++) {
                if (str[k] == str1[j++]) {
                    if (j == s1.length()) {
                        return i;
                    }
                    continue;
                } else {
                    j = 0;
                    break;
                }

            }
        }
        return -1;
    }
}
