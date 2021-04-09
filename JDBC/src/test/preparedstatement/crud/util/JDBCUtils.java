package test.preparedstatement.crud.util;

/**
 * @author TIMI
 * @Date 2021/2/22 - 18:21
 */

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 操作数据库的工具类
 */
public class JDBCUtils {
    /**
     * @Description 获取数据库的连接
     * @return Connection
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
        //读取配置文件中的四个信息
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();

        pros.load(is);
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");
        //加载驱动
        Class.forName(driverClass);
        //获取连接
        Connection connection = DriverManager.getConnection(url, user,password);
        return connection;
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
}
