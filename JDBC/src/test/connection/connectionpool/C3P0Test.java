package test.connection.connectionpool;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: Linduse
 * @Date: 2021/3/1 - 15:04
 * @since: jdk 1.8
 */
public class C3P0Test {
    @Test
    /**
     * @Description //TODO 方式一：获取C3P0数据库连接池
     * @Author Linduse
     * @Date 15:11 2021/3/1
      * @param 
     * @return void
     **/
    public void testGetConnection() throws PropertyVetoException, SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://123.57.220.238:3306/test?characterEncoding=utf8&rewriteBatchedStatements=true");
        cpds.setUser("root");
        cpds.setPassword("chl252599");
        //设置初始时数据库连接池中的连接数
        cpds.setInitialPoolSize(10);
        Connection conn = cpds.getConnection();
        System.out.println(conn);
        //销毁连接池（一般不用）
        DataSources.destroy(cpds);
    }


    @Test
    /**
     * @Description //TODO 方式二：通过配置文佳能获取c3p0连接池
     * @Author Linduse
     * @Date 15:44 2021/3/1
     * @param
     * @return void
     **/
    public void testGetConnection1() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
        Connection conn = cpds.getConnection();
        System.out.println(conn);

    }
}
