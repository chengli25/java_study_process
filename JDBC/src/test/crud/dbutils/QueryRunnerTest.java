package test.crud.dbutils;

/**
 * @author: Linduse
 * @Date: 2021/3/1 - 20:33
 * @since: jdk 1.8
 */

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import test.connection.JDBCUtils;
import test.preparedstatement.crud.Customer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Date;
import java.util.List;

/**
 * @Description //TODO 是Apache组织提供的一个开源jdbc工具类库，封装了针对于数据库的增删改查
 * @Author Linduse
 * @Date 20:34 2021/3/1
 * @param
 * @return
 **/

public class QueryRunnerTest {
    @Test
    //增加数据
    public void testInsert() throws SQLException {
        Connection conn = null;
        try {
            QueryRunner runner  = new QueryRunner();
            conn = JDBCUtils.getConnection2();
            String sql = "insert into customers(name,email,birth) values(?,?,?)";
            int insertCount = runner.update(conn,sql,"程立","chengli@.com",new Date());
            System.out.println("添加了" + insertCount + "条记录");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

    }
    /**
     * @Description //TODO 查询操作
     * BeanHander:是ResultSethandler接口的实现类，用于封装表中的一条记录
     * @Author Linduse
     * @Date 20:55 2021/3/1
     * @param
     * @return 
     **/
    @Test
    public void testQuery1() {
        Connection conn = null;
        try {

            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection2();
            String sql = "select name,email,birth from customers where id = ?";
            BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);
            Customer customer = runner.query(conn,sql,handler,16);
            System.out.println(customer);

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        } finally {

            try {
                JDBCUtils.closeResource(conn,null);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Test
    public void testQuery2() {
        Connection conn = null;
        try {

            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection2();
            String sql = "select name,email,birth from customers";
            BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);
            List<Customer> list = runner.query(conn,sql,handler);

            list.forEach(System.out::println);

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        } finally {

            try {
                JDBCUtils.closeResource(conn,null);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * @Description //TODO 查询一些特殊值
     * @Author Linduse
     * @Date 21:22 2021/3/1
     * @param
     * @return 
     **/
    @Test
    public void testQuery4() {
        Connection conn = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {

            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection2();
            String sql = "select count(*) from customers";
            ScalarHandler scalarHandler = new ScalarHandler();

            Long count = (Long) runner.query(conn,sql,scalarHandler);
            System.out.println(count);

            String sql1 = "select photo from customers where id = ?";
            Blob blob = (Blob) runner.query(conn,sql1,scalarHandler,16);
            is = blob.getBinaryStream();
            fos = new FileOutputStream("朱茵.jpg");
            byte[] bytes = new byte[1024];
            int len = 0;
            while((len = is.read(bytes)) != -1) {
                fos.write(bytes,0,len);
            }
            is.close();
            fos.close();
        } catch (SQLException | FileNotFoundException throwables) {
            throwables.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                JDBCUtils.closeResource(conn,null);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }
    }
    /**
     * @Description //TODO 使用dbutils.jar中提供的DbUtile工具类，实现资源关闭
     * @Author Linduse
     * @Date 21:44 2021/3/1
     * @param
     * @return 
     **/
    public void closeResource1(Connection conn, PreparedStatement ps , ResultSet rs){
        try {
            DbUtils.close(conn);
            DbUtils.close(ps);
            DbUtils.close(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
