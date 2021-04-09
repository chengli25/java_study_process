package test.practice;

import org.junit.Test;
import test.preparedstatement.crud.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author TIMI
 * @Date 2021/2/27 - 13:56
 */

/**
 * 使用preparedstatement实现批量插入
 */
public class BatchOperation {
    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();
            String sql = "insert into goods(name) values(?)";
            ps = conn.prepareStatement(sql);
            for(int i = 1; i <= 20000; i++) {
                ps.setObject(1,"name_" + i);
                ps.execute();
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.closeResource(conn,ps);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 批量从插入的优化
     * 默认情况下mysql是不支持批量处理的，需要手动开启（在URL后面加上?rewriteBatchedStatements=true）
     * 使用更新的mysql驱动：1.37；
     */
    @Test
    public void testInsert2() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();
            String sql = "insert into goods(name) values(?)";
            ps = conn.prepareStatement(sql);
            for(int i = 1; i <= 1000000; i++) {
                ps.setObject(1,"name_" + i);
                //攒SQL语句
                ps.addBatch();
                if(i % 500 ==0) {
                    //执行batch
                    ps.executeBatch();
                    //清空batch
                    ps.clearParameters();
                }

            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.closeResource(conn, ps);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 终极优化方案
     * 不允许自动提交，在最后全部插入后再插入
     */
    @Test
    public void testInsert3() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();
            //关闭自动提交
            conn.setAutoCommit(false);
            String sql = "insert into goods(name) values(?)";
            ps = conn.prepareStatement(sql);
            for(int i = 1; i <= 1000000; i++) {
                ps.setObject(1,"name_" + i);
                //攒SQL语句
                ps.addBatch();
                if(i % 500 ==0) {
                    //执行batch
                    ps.executeBatch();
                    //清空batch
                    ps.clearParameters();
                }
            }
            //提交数据
            conn.commit();
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.closeResource(conn, ps);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
