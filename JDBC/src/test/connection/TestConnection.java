package test.connection;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author TIMI
 * @Date 2021/2/20 - 21:21
 */

/**
 * 笔记：要想能够连接服务器上的数据库，就得授权mysql被允许远程访问（授权root用户）==>grant all privileges on *.* to root@'%' identified by '密码' with grant option;
 * 然后刷新权限：flush  privileges；
 *
 */
public class TestConnection {
    @Test
    //方式一：
    public void testConnection1() throws SQLException {
        //创建一个Driver实例类
        Driver driver = new com.mysql.jdbc.Driver();
        //jdbc:mysql:指的是协议
        //localhost:ip地址
        //3306/test指的是端口和数据库名
        String url = "jdbc:mysql://localhost:3306/test";
        //将用户名和密码封装在properties里面
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","chl252599");
        Connection conn =  driver.connect(url,info);
        System.out.println(conn);
    }

    //方式二：
    //反射实现Driver实现类对象：反射实现（尽量不使用第三方提供的API，让程序更具有可移植性）
    @Test
    public void testConnection2() throws Exception {
        //获取一个driver实现类对象（使用反射）
        Class c1 = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) c1.newInstance();
        //提供要连接数据库的信息
        String url = "jdbc:mysql://localhost:3306/test";
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","chl252599");
        //连接数据库
        Connection connection = driver.connect(url,info);
        System.out.println(connection);
    }

    //方式三：使用DriverManager替换Driver
    @Test
    public void testConnction3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        //获取Driver实现类对象
        Class c2 = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) c2.newInstance();
        ////获取数据库信息
        //String url = "jdbc:mysql://localhost:3306/test";
        //String password = "chl252599";
        //String user = "root";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password","chl252599");
        String url = "jdbc:mysql://localhost:3306/test";
        //注册驱动
        DriverManager.registerDriver(driver);
        //获取连接
        Connection connection = DriverManager.getConnection(url,info);
        System.out.println(connection);
       /* //注册驱动
        DriverManager.registerDriver(driver);
        //获取连接
        Connection connetction = DriverManager.getConnection(url,user, password);
        System.out.println(connetction);*/

    }

    //方式四：因为在Driver的反射获取过程中，已经有了静态代码块进行注册驱动，所以不用再注册驱动
    @Test
    public void testConnction4() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "chl252599");
        String url = "jdbc:mysql://localhost:3306/test";
        /*//获取数据库信息
        String url = "jdbc:mysql://localhost:3306/test";
        String password = "chl252599";
        String user = "root";*/

        //获取Driver实现类对象
        Class c2 = Class.forName("com.mysql.jdbc.Driver");
        //Driver driver = (Driver) c2.newInstance();

        //注册驱动
        //DriverManager.registerDriver(driver);
        //获取连接
        Connection connection = DriverManager.getConnection(url, info);
        System.out.println(connection);
    }
    //方式五（最终版）：将数据库连接需要的信息写到一个配置文件中通过读取配置文件;(实现了代码和数据分离)
    @Test
    public void testConnction5() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException, IOException {
        //读取配置文件中的四个信息
        InputStream is = TestConnection.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //获取Driver实现类对象并且加载驱动
        Class c2 = Class.forName(driverClass);
        //Driver driver = (Driver) c2.newInstance();

        //注册驱动
        //DriverManager.registerDriver(driver);
        //获取连接
        Connection connection = DriverManager.getConnection(url, user,password);
        System.out.println(connection);
    }

}
