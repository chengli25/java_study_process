package database;

import jdk.nashorn.internal.ir.LexicalContext;
import jdk.nashorn.internal.ir.LexicalContextNode;

import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2020/11/24 - 21:34
 */
public class Client {
    public Scanner console;
    public static void main(String[] args) {
        System.out.println("请输入您需要链接的数据库是哪一个");
       Scanner scn = new Scanner(System.in);
       int n = scn.nextInt();
       Idao dao;
       if(n == 1){
           dao = new mysqlDao();
       }
       else{
           dao = new Oracle();

       }
       dao.add();
       dao.connect();
       dao.del();
       dao.sel();
       dao.upd();
    }
}
