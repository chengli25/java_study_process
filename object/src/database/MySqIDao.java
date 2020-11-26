package database;

/**
 * @author TIMI
 * @Date 2020/11/24 - 21:23
 */
public class MySqIDao implements Idao {
    public MySqIDao() {
        super();
    }

    @Override
    public void connect() {
        System.out.println("mysql的链接....");
    }

    @Override
    public void add() {
        System.out.println("增加");
    }

    @Override
    public void del() {
        System.out.println("删除");
    }

    @Override
    public void upd() {
        System.out.println("修改");
    }

    @Override
    public void sel() {
        System.out.println("查询");
    }
}
