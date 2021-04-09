package test.preparedstatement.crud;

import org.junit.Test;
import test.connection.TestConnection;
import test.preparedstatement.crud.util.JDBCUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author TIMI
 * @Date 2021/2/22 - 16:48
 */
/**
 * 使用preparedStatement替换statement，实现对数据表的增删改查
 *
 */
public class TestUpdate {
    //向表中增加一条记录
    @Test
    public void testConnction5() throws IllegalAccessException, InstantiationException, SQLException, IOException, ClassNotFoundException, ParseException {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            //读取配置文件中的四个信息
            InputStream is = TestConnection.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties pros = new Properties();
            pros.load(is);
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driverClass = pros.getProperty("driverClass");
            //加载驱动
            Class.forName(driverClass);
            //获取连接
            connection = null;
            ps = null;
            connection = DriverManager.getConnection(url, user,password);
            //预编译SQL语句，返回preparedstatement实例
            String sql = "insert into  customers(name,email,birth) values(?,?,?)";
            ps = connection.prepareStatement(sql);
            //填充占位符
            ps.setString(1,"邓紫棋");
            ps.setString(2,"1444171773@qq.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("1000-01-01");
            //将当前时间作为出生日期
            java.util.Date date1 = new java.util.Date();
            ps.setDate(3,new Date(date1.getTime()));
            //执行SQL
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            //资源关闭
            try {
                if(ps != null) {
                    ps.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    //修改一条记录
    @Test
    public void testmodify() throws SQLException, IOException, ClassNotFoundException {
        //获取数据库连接
        Connection connection = JDBCUtils.getConnection();
        //预编译SQL语句，返回preparedstatement实例
        String sql = "update customers set name = ? where id =?";
        PreparedStatement ps = connection.prepareStatement(sql);
        //填充占位符
        ps.setString(1,"贝多芬");
        ps.setInt(2,16);
        //执行
        ps.execute();
        //资源关闭
        JDBCUtils.closeResource(connection,ps);
    }


    //通用的增删改操作
    @Test
    public void testupdate() throws SQLException, IOException, ClassNotFoundException {
        String sql = "delete from `customers` where id between ? and  ?";
        update(sql,21,32);
    }

    /**
     * 通用的更新
     * @param sql
     * @param args
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void update(String sql, Object...args) throws SQLException, IOException, ClassNotFoundException {
            Connection conn = null;
            PreparedStatement ps = null;
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i+1,args[i]);
        }
        ps.execute();
        JDBCUtils.closeResource(conn,ps);
    }

    /**
     * 通用的查询
     * 步骤：
     * 首先建立连接；
     * 然后用这个连接去发送参数中的SQL语句
     * 然后将用循环将不定参数进行setobject操作
     * 用prepardstatement去exqutequery并且用一个resultset保存结果集
     * 接下来处理结果集：当结果集.next为真的时候，用结果集.getInt()保存这些结果
     * 然后将这些保存的结果封装为一个类（ORM编程思想：一个表对应一个java类；一条数据对应一个对象，一个字段对应一个对象的属性）
     * 重写tostring方法后打印这个这个对象
     *
     * 补充：当字段名和属性名不一样的时候，需要给字段名取别名；
     * 获取字段名的时候需要用getcolumnlabel来获取别名
     */
    @Test
    public void testQuery() throws SQLException, IOException, ClassNotFoundException {
        //String sql = "select id,name,birth,email from customers";
        //List<?> list = query(Customer.class,sql);
        String sql1 = "select order_id orderid,order_name ordername from `order`";
        //调用函数返回一个list集合
        List list1 = query(order.class,sql1);
        try {
            //用迭代器进行迭代输出
            Iterator it = list1.iterator();
            if(!it.hasNext()) {
                System.out.println("没有查询到任何相关信息！");
            }
            while(it.hasNext()){
                System.out.println(it.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<?> query(Class<?> cl,String sql, Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        List<Object> list = new ArrayList<>();

        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            //执行并返回结果集
            resultSet = ps.executeQuery();
            //获取结果集的元数据：resultsetmetadata
            ResultSetMetaData rsmd = resultSet.getMetaData();
            //通过resultsetmetadata获取结果集中的列数
            int col = rsmd.getColumnCount();
            //处理结果集
            while(resultSet.next()) {
                //获取当前这条数据的各个字段的值
                /*int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);*/
                //处理结果集中的每一个列（创建一个空对象，取出每个字段的值value，然后根据结果集依次返回列数中的每个字段名，使用反射根据字段名拿出每个字段，然后将字段设置为true，然后将value赋值给当前对象的对应字段）
                Object cust = cl.newInstance();
                for (int i = 0; i < col; i++) {
                    Object value = resultSet.getObject(i + 1);
                    //获取每个列的列名（将value赋给对应的列名）
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    //给cust对象指定的colname属性，赋值为value，通过反射
                    //根据字段名获取到字段
                    Field field = cl.getDeclaredField(columnLabel);

                    //将字段权限更改
                    field.setAccessible(true);
                    //将value赋给该字段
                    field.set(cust,value);
                }
                list.add(cust);
            }
            //Iterator it = list.iterator();
            //while(it.hasNext()) {
            //    System.out.println(it.next());
            //}
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                JDBCUtils.closeResource(conn,ps,resultSet);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
