package test;


import java.util.Scanner;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;

/**
 * @author TIMI
 * @Date 2021/1/26 - 18:56
 */
public class Log_In {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

            System.out.println("请输入用户名：");
            String username = sc.nextLine();
            System.out.println("请输入密码：");
            String pwd = sc.nextLine();

            if(!username.equals("G.EM") || !pwd.equals("1234")){
                throw new MyException("异常");
            }
            else {
                System.out.println("登录成功");
            }
        

        
        
    }
}

class MyException extends Exception {
   public MyException(String error) {
        super(error);
    }
}