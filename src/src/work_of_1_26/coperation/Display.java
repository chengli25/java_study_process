package work_of_1_26.coperation;

import work_of_1_26.Book;
import work_of_1_26.BookList;

import java.util.Iterator;
import java.util.List;

/**
 * @author TIMI
 * @Date 2021/1/27 - 21:02
 */
public class Display implements IOperation {
    @Override
    public void work(List bookList) {

        System.out.println("共有" + bookList.size() + "本书如下：");
        //for(int i = 0; i < bookList.size(); i++) {
        //    System.out.println(bookList.get(i));
        //}
        Iterator<Book> it = bookList.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
