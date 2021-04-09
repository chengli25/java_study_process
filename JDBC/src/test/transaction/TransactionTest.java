package test.transaction;

import org.junit.Test;
import test.preparedstatement.crud.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author TIMI
 * @Date 2021/2/27 - 17:16
 */
public class TransactionTest {
    /**
     * 模拟转账update user_table set balance = balance -100 where  user = 'AA';
     *         update user_table set balance = balance +100 where  user = 'AA';
     *
     */
    @Test
    public void test () {
        String sql1 = "update user_table set balance = balance -100 where  user = ?";
        Update(sql1,"AA");

        //网络异常
        System.out.println(10/0);

        String sql2 = "update user_table set balance = balance +100 where  user = ?";
        Update(sql2,"BB");
        System.out.println("转账成功");
    }


    public void Update(String sql, Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);

            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.closeResource(conn,ps);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 事务实现转账
     * //保证连接不会关闭，否则会自动提交
     * 关闭自动提交
     */
    @Test
    public void testupdate() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();

            //取消自动提交
            conn.setAutoCommit(false);
            String sql1 = "update user_table set balance = balance -100 where  user = ?";
            Update1(conn,sql1,"AA");

            ////网络异常
            //System.out.println(10/0);

            String sql2 = "update user_table set balance = balance +100 where  user = ?";
            Update1(conn,sql2,"BB");
            System.out.println("转账成功");

            //提交数据
            conn.commit();
        } catch (Exception e) {

            System.out.println("转账失败，请稍后重试");
            e.printStackTrace();
            //一旦报错就会回滚数据
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        } finally {
            try {

                //恢复其自动提交
                conn.setAutoCommit(true);
                //关闭连接
                JDBCUtils.closeResource(conn,null);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }


    public void Update1(Connection conn,String sql,Object...args) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);

            }
            ps.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtils.closeResource(null,ps);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
