package test.baseDAO;

/**
 * @author: Linduse
 * @Date: 2021/2/28 - 21:28
 * @since: jdk 1.8
 */

import test.preparedstatement.crud.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @Description //TODO 继承DAO并且实现customersDAO接口中的具体功能
 * @Author Linduse
 * @Date 21:32 2021/2/28
 * @param
 * @return
 **/
public class CustomerBaseDAOImpl extends baseDAO implements customersDAO {


    @Override
    public void insert(Connection conn, Customer cust) {
        String sql = "insert into customers(name,email,birth) values(?,?,?)";
        update(conn,sql, cust.getName(),cust.getEmail(),cust.getBirth());
    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from customers where id = ?";
        update(conn,sql,id);
    }

    @Override
    public void updateById(Connection conn, int id, Customer cust) {
        String sql = "update customers set name = ?,email = ?,birth=? where id = ?";
        update(conn,sql,cust.getName(),cust.getEmail(),cust.getBirth(),cust.getId());
    }

    @Override
    public Customer getCustomerById(Connection conn, int id) throws SQLException {
        String sql = "select id,name,email,birth from customers where id = ?";
        Customer customer = getInstance(conn,Customer.class,sql,id);
        return customer;
    }

    @Override
    public List<Customer> getAllList(Connection conn) {
        String sql = "select id,name,email,birth from customers";
        List<Customer> list = getAll(conn,Customer.class,sql);
        return list;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from customers";
        return getValue(conn,sql);

    }

    @Override
    public Date getMaxBirth(Connection conn) {
        String sql = "select min(birth) from customers";
        Date date = getValue(conn,sql);
        return date;
    }


}
