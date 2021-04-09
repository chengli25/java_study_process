package work_of_1_26.coperation;

import work_of_1_26.Book;
import work_of_1_26.BookList;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2021/1/27 - 20:55
 */
public class Delete implements IOperation{
    @Override
    public void work(List bookList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要删除的图书名称：");
        String name = sc.next();
        Iterator<Book> it = bookList.iterator();
        int i = 0;
        while(it.hasNext()) {
            Book bk = it.next();
            if(bk.getName().equals(name)) {
                System.out.println(bookList.get(i));
                bookList.remove(i);
                System.out.println( bk.getName() + "删除成功");
                return;
            }
            else {
                i++;
            }
        }

        System.out.println("没有找到该书籍，请重新输入！");
    }
}
