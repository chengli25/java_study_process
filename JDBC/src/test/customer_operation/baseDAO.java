package test.customer_operation;

import test.preparedstatement.crud.util.JDBCUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TIMI
 * @Date 2021/2/28 - 15:54
 */
public abstract class baseDAO<T> {

    /**
     * @Description //TODO 增删改的通用操作
     * @Author Linduse
     * @Date 13:42 2021/3/1
     * @param conn
     * @param sql
     * @param args
     * @return void
     **/
    private Class<T> clazz;
    public baseDAO(){
        /**
         * @Description //TODO 通过构造器获取父类（也就是baseDAO的泛型的对象）的泛型对象
         * @Author Linduse
         * @Date 14:27 2021/3/1
         * @param
         * @return
         **/
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] types = parameterizedType.getActualTypeArguments();
        clazz = (Class<T>) types[0];
    }
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
    public  T getInstance(Connection conn, String sql, Object...args) throws SQLException {
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
    public List<T> getAll(Connection conn, String sql, Object...args) {
        /**
         * @Description //TODO 由于本功能类是用于具体实现customers数据表的，所以不用在传参customer的对象（其中所需要的对象通过在功能类中用构造方法来获取这个泛型类）在功能类中指定泛型
         * 在实现类中指定泛型的具体类型，然后在父类的功能类中指定本该传送过去的对象类的实例（也就是获取具体的对象类，让其在功能实现方法中被需要能够得到满足）；
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
