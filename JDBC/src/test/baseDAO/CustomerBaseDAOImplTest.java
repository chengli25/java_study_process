package test.baseDAO;

import org.junit.Test;
import test.preparedstatement.crud.Customer;
import test.preparedstatement.crud.util.JDBCUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Linduse
 * @Date: 2021/3/1 - 12:00
 * @since: jdk 1.8
 */
public class CustomerBaseDAOImplTest {
    CustomerBaseDAOImpl cbdi = new CustomerBaseDAOImpl();
    @Test
    public void insert() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Customer cust = new Customer(1, "万语", "wanyu@.com", new Date(3405727584302L),null);
            cbdi.insert(conn,cust);
            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.closeResource(conn,null);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Test
    public void deleteById() {
        //Scanner sc = new Scanner(System.in);
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            //System.out.println("请输入要删除的id：");
            //int id = sc.nextInt();
            cbdi.deleteById(conn,41);
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtils.closeResource(conn,null);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Test
    public void updateById() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Customer cust = new Customer(41, "万语", "wanyu@.com", new Date(240572742582L),null);
            cbdi.updateById(conn,cust.getId(),cust);
            System.out.println("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.closeResource(conn,null);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Test
    public void getCustomerById() throws SQLException, IOException, ClassNotFoundException {
        Connection conn = null;
        conn = JDBCUtils.getConnection();
        System.out.println("查询结果如下：");
        Customer cust = cbdi.getCustomerById(conn,63);
        System.out.println(cust);
        JDBCUtils.closeResource(conn,null);

    }

    @Test
    public void getAllList() throws SQLException, IOException, ClassNotFoundException {
        Connection conn = null;
        conn = JDBCUtils.getConnection();
        List<Customer> list = cbdi.getAllList(conn);
        System.out.println("查询结果如下：");
        Iterator<Customer> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

    }

    @Test
    public void getCount() throws SQLException, IOException, ClassNotFoundException {
        Connection conn = null;
        conn = JDBCUtils.getConnection();
        System.out.println("数据量为：" + cbdi.getCount(conn));

    }

    @Test
    public void getMaxBirth() throws SQLException, IOException, ClassNotFoundException {
        new Scanner(System.in);
        Connection conn = null;
        conn = JDBCUtils.getConnection();
        Date date = cbdi.getMaxBirth(conn);
        System.out.println("年龄最大的为：" + date);
    }
}