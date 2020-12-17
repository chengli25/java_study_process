package homework;

import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2020/12/16 - 18:52
 */
public class LogIn {
    public static void main(String[] args) {
        String password = "123456";

        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.println("请输入密码(您有三次输入机会)：");
        while(sc.hasNext()){

            String s = sc.nextLine();
            if(s.equals(password)){
                System.out.println("登录成功");
                break;
            }else {
                System.out.println("输入错误，请重新输入");
                i++;
            }
            if(i==3){
                System.out.println("您已经三次输入错误，即将自动退出程序");
                break;
            }
        }


    }
}
