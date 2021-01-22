package test;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.sqrt;

/**
 * @author TIMI
 * @Date 2020/12/6 - 11:24
 */
public class TestString {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        /**
         * String中的toString()可以用来复制对象;（可以很好的复制new出来的对象）
         */
    //    int a = 1;
    //    a = a << 33;
    //    System.out.println(a);
    //    String s = new String ("asd");
    //    String s1 = s.toString();
    //    String s2 = "asd";
    //    if(s==s1){
    //        System.out.println("YES");
    //    }
    //    else{
    //        System.out.println("NO");
    //    }
        //System.out.println(s.toString());

        /**
         * getByte()方法
         */
        //String s = "zxcvbn";
        //byte[] by = new byte[100];
        //by = s.getBytes();
        //System.out.println(Arrays.toString(by));
        //for(byte x : by){
        //    System.out.println(x);
        //}
        ////Calendar d = Calendar.getInstance();
        //Scanner sc = new Scanner(System.in);
        //char ch = sc.nextLine().charAt(0);
        //System.out.println(ch);
        //
        //String s = sc.nextLine();
        //System.out.println(s);
        //    Scanner sc = new Scanner(System.in);
        //    while(true) {
        //        int a = sc.nextInt();
        //        for (int i = 0; i < a; i++) {
        //            for (int j = 0; j < a; j++) {
        //                if (i == j || i + j == a - 1) {
        //                    System.out.print("*");
        //                    continue;
        //                }
        //                System.out.print(" ");
        //            }
        //            System.out.println();
        //        }
        //    }
        //Scanner sc = new Scanner(System.in);
        //while(!sc.hasNextInt(1)){
        //    System.out.println(sc.next());
        //}
        ////System.out.println(sc.next());

        //try (Scanner sc = new Scanner(new File("唐诗三百首.txt"))) {
        //    File f = new File("a.txt");
        //    BufferedWriter os = new BufferedWriter(new FileWriter(f,true));
        //
        //    while(sc.hasNext()){
        //        String s = sc.nextLine();
        //        if(!f.exists()){
        //            f.createNewFile();
        //        }
        //        os.write(s);
        //        os.newLine();
        //    }
        //    os.flush();
        //    os.close();
        //
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
        //手动将创建的字符串加入到常量池中，如果常量池中已经有该字符串就把常量池中的地址给引用S，否则inter就将整个字符串加入到常量池中，并且返回相应的地址。
        //String s2 = "hello";
        //String s = new String("hello").intern();
        //System.out.println(s2==s);true
        //String s1 = "hello";
        //System.out.println(s1==s);

        //通过反射方式修改hello的内容
        String s = "hello";
        //第一步获取到String的类对象
        //根据"value" 这个字段的名字，在类对象中拿到对应的字段（仍然是图纸的一部分，相当于局部放大图纸）；
        Field valueField = String.class.getDeclaredField("value");
        //让里面的private能够被访问
        valueField.setAccessible(true);
        //根据图纸，把str 这个对象拆开，取出里面的零件
        char[] value = (char[]) valueField.get(s);
        //修改零件的内容
        value[4]='a';
        System.out.println(s);
    }




}
