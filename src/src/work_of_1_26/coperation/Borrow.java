package work_of_1_26.coperation;

import work_of_1_26.Book;
import work_of_1_26.BookList;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2021/1/27 - 21:06
 */
public class Borrow implements IOperation {
    public void work(List bookList) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要借阅的图书名称：");
        String name = sc.next();
        int i = 0;
        Iterator<Book> it = bookList.iterator();
        while(it.hasNext()) {
            Book bk = it.next();
            if(bk.getName().equals(name)) {
                System.out.println("图书信息如下：");
                System.out.println(bookList.get(i));
                bk.setBorrowed(true);
                System.out.println("成功借走" + bk.getName());
                Thread.sleep(1000);
                break;
            }
            else {
                i++;
            }
        }
    }

}
