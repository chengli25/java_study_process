package work_of_1_26;

import java.util.List;

/**
 * @author TIMI
 * @Date 2021/1/26 - 20:58
 */
public class BookList {


    public BookList(List booklist) {
        booklist.add(new Book("西游记", "吴承恩", 100, "古典小说"));
        booklist.add(new Book("水浒传", "施耐庵", 100, "古典小说"));
        booklist.add(new Book("红楼梦", "曹雪芹", 120, "古典小说"));

    }


}

