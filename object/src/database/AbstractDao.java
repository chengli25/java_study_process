package database;

/**
 * @author TIMI
 * @Date 2020/11/24 - 21:27
 */
public abstract class AbstractDao implements Idao {
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
