package test.connection.connectionpool;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author: Linduse
 * @Date: 2021/3/1 - 18:59
 * @since: jdk 1.8
 */
public class DBCPTest {
    /**
     * @Description //TODO 方式一：DBCP数据库连接池技术
     * @Author Linduse
     * @Date 19:00 2021/3/1
     * @param
     * @return
     **/
    @Test
    public void testGetConnection() throws SQLException {
        //创建一个DBCP的数据库连接池
        BasicDataSource source = new BasicDataSource();
        //设置连接的四个基本属性
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://123.57.220.238:3306/test");
        source.setUsername("root");
        source.setPassword("chl252599");
        //设置其他数据库连接池管理属性
        source.setInitialSize(10);
        source.setMaxActive(10);

        Connection conn = source.getConnection();
        System.out.println(conn);
    }


    @Test
    /**
     * @Description //TODO 使用DBCP数据库连接池获取连接
     * @Author Linduse
     * @Date 19:19 2021/3/1
     * @param
     * @return void
     **/
    public void testGetConnection1() throws Exception {
        Properties pros = new Properties();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
        pros.load(is);
        DataSource source = BasicDataSourceFactory.createDataSource(pros);
        Connection conn = source.getConnection();
        System.out.println(conn);
    }

}
