package work_of_1_26;

import work_of_1_26.coperation.*;

import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2021/1/26 - 20:48
 */
public class Admin extends Alluser {
    public Admin(String name) {
        this.name = name;
        this.operations = new IOperation[]{
             new Find(),
             new Add(),
             new Delete(),
             new Display(),
             new Exit()
        };
    }
    @Override
    public int meau() {
        System.out.println("==========================");
        System.out.println("hello！" + name + "欢迎使用我们的图书管理系统");
        System.out.println("1.查阅书籍信息");
        System.out.println("2.新增书籍信息");
        System.out.println("3.删除书籍信息");
        System.out.println("4.打印书籍列表");
        System.out.println("5.退出系统");
        System.out.println("==========================");
        System.out.println("请输入您的选择：");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        return choice;
    }


}
