import java.net.UnknownHostException;

import static java.net.InetAddress.getLocalHost;

/**
 * @author TIMI
 * @Date 2020/12/4 - 17:25
 */
public class TestArrays {
    private int a;
    public static void main(String[] args) throws UnknownHostException {
       //short a = 128;
       //byte b = (byte)a;
       // System.out.println(a);
       // System.out.println(b);
       // double x=2.0; int y=4; x/=++y;
       // System.out.println(x);

        //获取本机地址以及本机地址名称分离
        //InetAddress ia = getLocalHost();
        //System.out.println(ia.toString());
        //String s = ia.getHostAddress();
        //System.out.println(s);
        //String s1 = ia.getHostName();
        //System.out.println(s1);
        int[] a = new int[]{1,2,3,4,6,7,3};
        for(int x : a){
            System.out.println(x);
        }


        //整数和字符串输入，输入输出流不能关闭
        //Scanner sc = new Scanner(System.in);
        //int i = sc.nextInt();
        //System.out.println(i);
        //sc.nextLine();
        //String s = sc.nextLine();
        //System.out.println(s);
        //String s = sc.next();
        // System.out.println(s);

        //Arrays复制数组
        //int[] a = new int[]{1,2,3,4,5,6};
        //int[] b = Arrays.copyOfRange(a,0,5);
        //for(int x:b)
        //System.out.println(x);

        //判断两个数组是否相等
        //int[] a = new int[]{1,2,3,4,5,6,7,8,9};
        //int[] b = Arrays.copyOfRange(a,0,a.length);
        //boolean bl = Arrays.equals(a,b);
        //System.out.println(bl);

        //
        //String[] a = new String[]{"1231","13242"};
        //String[] b = Arrays.copyOfRange(a,0,a.length);
        //boolean s = Arrays.equals(a,b);
        //System.out.println(s);

        //数组排序可以指定范围
        //int[] a = new int[]{1,432,546,7,43,8,65,8,8,6956,3,54};
        //Arrays.sort(a,0,6);
        //for(int x:a){
        //    System.out.println(x);
        //}

        //将数组以字符串的形式输出
        //int[] a = new int[]{1,32,5,34,6,4,7,5,8,65,8,6};
        //String s =Arrays.toString(a);
        //System.out.println(s);

                            //Arrays类中的所有方法全是静态方法，用类名调用
    }
}
