package test.test1.test3;

/**
 * @author TIMI
 * @Date 2020/11/25 - 11:07
 */
public class Test {
    String name;
    String color;

    public Test(String name, String color ){
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Test t = new Test("小花","红色");
        String str1 = "小红";
        String str2 = "小红";
        String str3 = new String("杠精");
        String str5 = "杠精";
        String str4;
        str3 = "小红";
        System.out.println(t);
        //System.out.println(str1==str2);
        //System.out.println(str1.equals(str2));
        //System.out.println(str1==str3);
        //System.out.println(str5==str3);
        //System.out.println(str1==str4);
    }
}
