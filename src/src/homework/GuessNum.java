package homework;

import java.util.Random;
import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2020/12/16 - 15:39
 */
public class GuessNum {
    public static void main(String[] args) {
        Random a = new Random();
        int num = a.nextInt(100);
        //System.out.println(num);
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            if(n == num){
                System.out.println("恭喜您，您猜对了！！！");
                break;
            }else if(n < num){
                System.out.println("猜小了");
            }else {
                System.out.println("猜大了");
            }
        }
    }
}
