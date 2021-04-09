package test.connection.connectionpool;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author: Linduse
 * @Date: 2021/3/1 - 19:52
 * @since: jdk 1.8
 */
public class DruidTest {
    @Test
    public void getConnection2() throws Exception {

        Properties pros = new Properties();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        pros.load(is);
        DataSource source = DruidDataSourceFactory.createDataSource(pros);
        Connection conn = source.getConnection();
        System.out.println(conn);

    }
}
