package test.baseDAO;

import test.preparedstatement.crud.util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TIMI
 * @Date 2021/2/28 - 15:54
 */
public abstract class baseDAO {

    /**
     * @Description //TODO 增删改的通用操作
     * @Author Linduse
     * @Date 13:42 2021/3/1
     * @param conn
     * @param sql
     * @param args
     * @return void
     **/
    public void update(Connection conn, String sql, Object...args) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtils.closeResource(null,ps);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    /**
     * @Description //TODO 根据指令查询一条记录
     * @Author Linduse
     * @Date 10:34 2021/3/1
     * @param conn
     * @param sql
     * @param args
     * @return void
     **/
    public <T> T getInstance(Connection conn, Class<T> clazz, String sql, Object...args) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for(int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int col = rsmd.getColumnCount();
            if(rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < col; i++) {
                    Object value = rs.getObject(i+1);
                    String label = rsmd.getColumnLabel(i+1);
                    Field field = clazz.getDeclaredField(label);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                return t;
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null,ps,rs);
        }
        return null;

    }
    //通用的查询操作
    public <T> List<T> getAll(Connection conn, Class<T> clazz, String sql, Object...args) {
        /**
         * @Description //TODO 
         * @Author Linduse
         * @Date 21:32 2021/2/28
          * @param conn
	 * @param clazz
	 * @param sql
	 * @param args
         * @return java.util.List<java.lang.Object>
         **/
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<>();

        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int col = rsmd.getColumnCount();
            while(rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < col; i++) {
                    Object value = rs.getObject(i+1);
                    String label = rsmd.getColumnLabel(i+1);
                    Field field = clazz.getDeclaredField(label);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                list.add(t);
            }
            return list;

        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtils.closeResource(null,ps,rs);
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }


    //查询特殊值的通用方法
    public <E> E getValue(Connection conn,String sql, Object ...args) {
       /**
        * @Description //TODO 
        * @Author Linduse
        * @Date 21:17 2021/2/28
        * @param conn
        * @param sql
        * @param args
        * @return E
        **/
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            if(rs.next()) {
                return (E) rs.getObject(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtils.closeResource(null,ps,rs);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return null;
    }
}
