package work_of_1_26;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2021/1/28 - 18:57
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //准备好一个线性表来装书籍的
        List<Book> booklist = new ArrayList<>();
        //向线性表中装书籍
        BookList bl = new BookList(booklist);

        //创建用户

        Alluser user = login();
        //进入主循环
        while(true) {
            //此时体现的是多态（不需要关注user是那种类型）
            //打印菜单并且获取到用户的选择
            int choice = user.meau();
            //根据对应的选项执行相关的操作
            if(choice <= user.operations.length) {
                user.doOperation(choice,booklist);

            } else {
                System.out.println("输入错误，请重新输入");
                Thread.sleep(1000);
                continue;
            }
        }
    }
    //用户登录
    public static  Alluser login() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入您的姓名：");
            String name = sc.nextLine();
            System.out.println("请输入您的角色：1  管理员，0  普通用户");
            int choice = sc.nextInt();
            System.out.println("请输入您的密码：");

            String pwd = sc.next();
            if(pwd.equals("1234") ){
                if(choice == 1) {
                return new Admin(name);
                } else {
                    return new User(name);
                }
            } else {
                System.out.println("密码错误，请重新登录！");
                Thread.sleep(1000);
            }

        }


        
    }
}

