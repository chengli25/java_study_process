package database;

/**
 * @author TIMI
 * @Date 2020/11/24 - 21:30
 */
public class mysqlDao extends AbstractDao{
    @Override
    public void connect() {
        System.out.println("这是MySQL");
    }
}
