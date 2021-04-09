package test.customer_operation;

import test.preparedstatement.crud.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author TIMI
 * @Date 2021/2/28 - 16:50
 */
public interface customersDAO {


    /**
     * @Description //TODO 向表中插入一条数据
     * @Author Linduse
     * @Date 21:24 2021/2/28
     * @param conn
     * @param cust
     * @return void
     **/
     void insert(Connection conn, Customer cust);


      /**
       * @Description //TODO 针对一个id，去删除表中的一条数据
       * @Author Linduse
       * @Date 21:20 2021/2/28
       * @param conn
       * @param id
       * @return void
       **/
     void deleteById(Connection conn,int id);


      /**
       * @Description //TODO 针对一个id，去修改表中的一条具体的数据
       * @Author Linduse
       * @Date 21:19 2021/2/28
       * @param conn
       * @param id
       * @param cust
       * @return void
       **/
      void updateById(Connection conn,int id,Customer cust);


      /**
       * @Description //TODO 针对特定的id查询得到对应的Customer对象
       * @Author Linduse
       * @Date 21:23 2021/2/28
       * @param conn
       * @param id
       * @return test.preparedstatement.crud.Customer
       **/
      Customer getCustomerById(Connection conn,int id) throws SQLException;


      /**
       * @Description //TODO 查询表中的所有数据
       * @Author Linduse
       * @Date 21:23 2021/2/28
       * @param conn
       * @return java.util.List<test.preparedstatement.crud.Customer>
       **/
      List<Customer> getAllList(Connection conn);

       /**
        * @Description //TODO 返回数据表中数据的条目数
        * @Author Linduse
        * @Date 21:26 2021/2/28
        * @param conn
        * @return java.lang.Long
        **/
      Long getCount(Connection conn);
      
      /**
       * @Description //TODO 返回数据表中的最大的生日
       * @Author Linduse
       * @Date 21:27 2021/2/28
       * @param conn
       * @return java.util.Date
       **/
      Date getMaxBirth(Connection conn);
      /**
       * @Description //TODO 返回数据表中最小生日
       * @Author Linduse
       * @Date 14:46 2021/3/1
       * @param conn
       * @return java.util.Date
       **/
      Date getMinBirth(Connection conn);
}
