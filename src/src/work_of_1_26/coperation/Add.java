package work_of_1_26.coperation;

import work_of_1_26.Book;
import work_of_1_26.BookList;

import java.util.List;
import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2021/1/27 - 20:54
 */
//新增数据
public class Add implements IOperation {
    @Override
    public void work(List bookList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要增加图书的数量：");
        int count = sc.nextInt();
        for(int i = 0; i < count; i++) {
            System.out.println("请输入图书名称：");
            String name = sc.next();
            System.out.println("请输入作者名称：");
            String author = sc.next();
            System.out.println("请输入图书价格：");
            double price = sc.nextDouble();
            System.out.println("请输入图书的类型：");
            String type = sc.next();
            bookList.add(new Book(name,author,price,type));
            System.out.println(bookList.get(bookList.size()-1));
            System.out.println(name + "增加成功");
        }
    }
}
