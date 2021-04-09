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
public class Find implements IOperation {
    @Override
    public void work(List bookList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查询的书籍名称：");
        String name = sc.next();
        Iterator<Book> it = bookList.iterator();
        int i = 0;
        boolean bl = false;
        while(it.hasNext()) {
            Book bk = it.next();
            if(!bk.getName().equals(name) ) {
                i++;
            } else {
                bl = true;
                break;
            }
        }
        if(bl) {
            System.out.println(bookList.get(i));
        } else {
            System.out.println("没有找到，请重新查询");
        }

    }
}
