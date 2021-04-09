package work_of_1_26.coperation;

import work_of_1_26.BookList;

import java.util.List;

/**
 * @author TIMI
 * @Date 2021/1/27 - 21:44
 */
public class Exit implements IOperation{
    public void work(List bookList) {
        System.out.println("退出程序");
        System.exit(0);
    }
}
