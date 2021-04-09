package test.practice;

import test.preparedstatement.crud.util.JDBCUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author TIMI
 * @Date 2021/2/26 - 15:28
 */
public class Test01 {

    //主函数测试
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, IllegalAccessException, NoSuchFieldException {
        Test01 test1 = new Test01();
        //test1.logIn();
        //test1.insert();
        //test1.query();
        //test1.delete();
        test1.query();

    }

    private void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要删除的id：");
        int id = sc.nextInt();

        String sql = "delete from examstudent where FlowID =?";
        boolean bl = Delete(sql,id);
        if(bl == true ){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

    }

    private boolean Delete(String sql,Object...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.closeResource(conn,ps);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }


    public void query() {
        String sql = "select FlowID id,Type,IDCard,ExamCard,StudentName,Location,Grade from examstudent";
        List<?> list = Query(sql,ExamStudent.class);
        System.out.println("查询结果如下：");
        Iterator it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public List<?> Query(String sql,Class<?> clazz,Object...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<Object> list = new ArrayList<>();
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int col = rsmd.getColumnCount();
            while(rs.next()) {
                Object cust = clazz.newInstance();

                for (int i = 0; i < col; i++) {
                    Object value = rs.getObject(i+1);
                    String label = rsmd.getColumnLabel(i+1);
                    Field field = ExamStudent.class.getDeclaredField(label);
                    field.setAccessible(true);
                    field.set(cust,value);
                }
                list.add(cust);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.closeResource(conn,ps,rs);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    //登录验证
    public void logIn() throws ClassNotFoundException, SQLException, NoSuchFieldException, IllegalAccessException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        String sql = "select * from customers where name = ? and email = ?";
        authentication(sql,username,password);

    }
    //数据插入

    public void insert() {
        Scanner sc  = new Scanner(System.in);
        //System.out.println("请输入用户名：");
        //String name = sc.nextLine();
        //System.out.println("请输入邮箱：");
        //String email = sc.nextLine();
        //System.out.println("请输入生日");
        //String birthday = sc.nextLine();
        //String sql = "insert into customers(name,email,birth) values(?,?,?)";
        //boolean bl = Insert(sql,name,email,birthday);
        System.out.println("请输入考试类型：");
        String type = sc.nextLine();
        System.out.println("请输入准考证号：");
        String idcard = sc.nextLine();
        System.out.println("请输入考试号：");
        String examid = sc.nextLine();
        System.out.println("请输入考生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入考生所在城市：");
        String location = sc.nextLine();
        System.out.println("请输入成绩：");
        int grade = sc.nextInt();
        String sql = "insert into examstudent(Type,IDCard,ExamCard,StudentName,Location,Grade) values(?,?,?,?,?,?)";
        boolean bl = Insert(sql,type,idcard,examid,name,location,grade);
        if(bl == true) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }

    }

    //登录验证
    public void authentication(String sql, Object...args){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            if(rs.next()) {
                System.out.println("登录成功");
            } else {
                System.out.println("用户名或者密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtils.closeResource(conn,ps,rs);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    //数据插入
    public boolean Insert(String sql, Object...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            ps.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtils.closeResource(conn,ps);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return false;
    }


}
