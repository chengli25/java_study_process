package test.practice;

/**
 * @author TIMI
 * @Date 2021/2/27 - 12:54
 */

import org.junit.Test;
import test.preparedstatement.crud.Customer;
import test.preparedstatement.crud.util.JDBCUtils;

import java.io.*;
import java.sql.*;

/**
 * 使用preparedstatement操作blob类型的数据
 */
public class ReadPicture {

    //向数据表插入blob字段
    @Test
    public void testInsert() throws Exception {

        Connection conn = JDBCUtils.getConnection();
        String sql = "update customers set photo = ? where id = 40";
        PreparedStatement ps = conn.prepareStatement(sql);
        //ps.setObject(1,"张三");
        //ps.setObject(2,"zhangsan@.com");
        //ps.setObject(3,"1992-03-04");
        File f = new File("G:\\JAVA\\code\\JAVA_study_process\\JDBC\\src\\test\\practice\\邓紫棋6.jpg");
        //System.out.println(f.exists());
        //System.out.println(f.getParent());
        FileInputStream is = new FileInputStream(f);
        ps.setBlob(1, is);
        ps.execute();
        JDBCUtils.closeResource(conn,ps);

    }
    //查询数据库中的blob字段
    @Test
    public void testQuery() throws Exception {
        InputStream is = null;
        FileOutputStream fos = null;

        Connection conn = JDBCUtils.getConnection();
        String sql = "select id,name,email,birth,photo from customers where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,40);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            Date birth = rs.getDate(4);
            Customer cust = new Customer(id,name,email,birth,null);
            System.out.println(cust);
            //将blob下载保存到本地
            Blob photo = rs.getBlob("photo");
            is = photo.getBinaryStream();
            fos = new FileOutputStream("邓紫棋.jpg");
            byte[] bytes = new byte[1024];
            int len;
             while(((len = is.read(bytes))) != -1) {
                 fos.write(bytes,0,len);
             }
        }
        is.close();
        fos.close();
        JDBCUtils.closeResource(conn,ps,rs);

    }

}
