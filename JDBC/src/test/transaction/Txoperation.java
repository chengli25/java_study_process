package test.transaction;

import org.junit.Test;
import test.preparedstatement.crud.util.JDBCUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author TIMI
 * @Date 2021/2/27 - 18:21
 */
public class Txoperation {
    //隔离级别
    @Test
    public void test() throws SQLException, IOException, ClassNotFoundException {
        Connection conn = null;
        conn = JDBCUtils.getConnection();
        //获取当前数据库的隔离级别
        System.out.println(conn.getTransactionIsolation());
        //设置数据库的隔离级别
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        //取消自动提交
        conn.setAutoCommit(false);
        String sql = "select user,password,balance from user_table where user = ?";
        getinstance(conn, User_Table.class,sql,"CC");
        conn.setAutoCommit(true);
        JDBCUtils.closeResource(conn,null);
    }

    @Test
    public void testupdate() throws SQLException, IOException, ClassNotFoundException {
        Connection conn = null;
        conn = JDBCUtils.getConnection();
        String sql = "update user_table set balance = ? where user = ?";

    }


    public void getinstance(Connection conn,Class<?> clazz, String sql,Object...args) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Object> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            for(int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);

            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int col = rsmd.getColumnCount();
            while(rs.next()) {
                Object object = clazz.newInstance();
                for (int i = 0; i < col; i++) {
                    Object value = rs.getObject(i+1);
                    String label = rsmd.getColumnLabel(i+1);
                    Field field = clazz.getClass().getDeclaredField(label);

                    field.setAccessible(true);
                    field.set(object,value);

                }
                list.add(object);

            }
            Iterator it = list.iterator();
            while(it.hasNext()) {
                System.out.println(it.next());
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null,ps,rs);

        }


    }
}
