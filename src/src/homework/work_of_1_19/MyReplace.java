package homework.work_of_1_19;

/**
 * @author TIMI
 * @Date 2021/1/19 - 14:33
 */
public class MyReplace {
    public static void main(String[] args) {
        String s = "abcdefg";

        String s1 ="bc";
        String s2 ="he";
        String s3 = replaceChar(s,s1,s2);
        System.out.println(s3);
    }

    public  static  String  replaceChar(String s,String t,String r){
        String string = null;
        try {
            char s1 [] = s.toCharArray();
            char t1 [] = t.toCharArray();
            char r1 [] = r.toCharArray();
            int i = 0,j = 0;
            while(i<s1.length  && j<t1.length){
                if(s1[i] == t1[j]){
                    i++;
                    j++;
                    if(j==t1.length){
                        int a = 0;
                        for (int k = i-t1.length; k <i ; k++) {
                            s1 [k] = r1[a];
                            a++;
                        }
                        j=0;
                    }
                }else{
                    i = i-j+1;
                    j = 0;

                }
            }
            string = new String(s1);

        }catch (Exception e){
            e.printStackTrace();
        }
        return string;
    }
}
