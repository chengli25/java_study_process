package work_of_1_26.coperation;

import work_of_1_26.Book;
import work_of_1_26.BookList;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2021/1/27 - 21:07
 */
public class Return implements IOperation {
    public void work(List bookList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要归还图书的信息：");
        String name = sc.next();
        Iterator<Book> it = bookList.iterator();
        while(it.hasNext()) {
            Book bk = it.next();
            if(bk.getName().equals(name)) {
                bk.setBorrowed(false);
                System.out.println("还书成功");
            } else {
                continue;
            }
        }

    }
}
