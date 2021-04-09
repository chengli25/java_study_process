package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author: Zero
 * @Date: 2021/3/18 - 19:36
 * @since: jdk 1.8
 */

public class DBHelper {

    private static DataSource source1;
    static {
        Properties pros = new Properties();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("Filejdbc.properties");
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
    //获取数据库连接
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        return conn = source1.getConnection();
    }
    //关闭连接
    public static void close(Connection conn) {
        if(conn != null) {
            try {
                conn.close();
                System.out.println("关闭成功");
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
    }
    public static void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws Exception {

            Connection conn = DBHelper.getConnection();
            //DBHelper.close(conn);
            if(conn != null) {
                System.out.println(conn);
                System.out.println("连接正常");
            } else{
                System.out.println("连接失败");
            }


    }
}
