package test.connection;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
     * @author: Linduse
     * @Date: 2021/3/1 - 16:23
     * @since: jdk 1.8
     */

    /**
     * @Description //TODO 使用c3p0数据库连接池获取连接
     * @Author Linduse
     * @Date 19:18 2021/3/1
     * @param
     * @return
     **/
public class JDBCUtils {
    //使用c3p0的数据库连接池技术
    //private static ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
    public static Connection getConnection() throws SQLException {
        //Connection conn = cpds.getConnection();
        //return conn;
        return null;
    }
    /**
     * @Description //TODO 使用DBCP数据库连接池获取连接
     * @Author Linduse
     * @Date 19:19 2021/3/1
     * @param
     * @return void
     **/
        private static DataSource source;
        static {
            Properties pros = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
            try {
                pros.load(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                //创建一个DBCP数据库连接池
                source = BasicDataSourceFactory.createDataSource(pros);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public static Connection getConnection1() throws Exception {
            Connection conn = source.getConnection();
            return conn;
        }

        /**
         * @Description //TODO 使用druid数据库连接池获取连接
         * @Author Linduse
         * @Date 20:24 2021/3/1
         * @param
         * @return java.sql.Connection
         **/
        private static DataSource source1;
        static {
            Properties pros = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            try {
                pros.load(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                source1 = DruidDataSourceFactory.createDataSource(pros);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        public static Connection getConnection2() throws SQLException {
            Connection conn = source1.getConnection();
            return conn;
        }



        /**
         * @description 关闭资源
         * @param conn
         * @param ps
         * @throws SQLException
         */
    public static void closeResource(Connection conn, PreparedStatement ps) throws SQLException {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(ps != null) {
                ps.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 重载关闭资源操作（在查询的时候需要有一个结果集需要保存，所以最后需要关闭结果集，所以需要重载一个方法来关闭资源）
     * @param conn
     * @param ps
     * @param resultSet
     * @throws SQLException
     */
    public static  void closeResource(Connection conn, PreparedStatement ps, ResultSet resultSet) throws SQLException {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(ps != null) {
                ps.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
        public static void closeResource1(Connection conn, PreparedStatement ps , ResultSet rs){
            try {
                DbUtils.close(conn);
                DbUtils.close(ps);
                DbUtils.close(rs);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


}
