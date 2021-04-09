package com.test.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author: Linduse
 * @Date: 2021/3/2 - 16:16
 * @since: jdk 1.8
 */
/**
 * @Description //TODO 1、接口式编程
 *                     原生：     接口 DAO      =====>   DAOImpl
 *                     mybatis：  接口Mapper    =====>   xxxxMapper.xml（就是将SQL映射文件和接口进行绑定，这将就会自动创建一个代理对象）
 *                     SQLsession就是代表和数据库的一次会话，用完必须进行关闭；
 *                     sqlsession和connection是非线程安全的，每次使用都应该去获取新的对象
 *                     mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象
 *                     两个重要的配置文件
 *                                      mybatis全局配置文件（mybatis-config.xml）：包含数据库连接池信息，事务器管理信息等
 *                                      SQL映射文件：保存了每个SQL语句的映射信息，将SQL抽取出来；
 * @Author Linduse
 * @Date 19:04 2021/3/2
 * @param
 * @return
 **/
public class MybatisTest {
    @Test
    /**
     * @Description //TODO 1.根据xml配置文件（全局配置文件mybatis-config.xml）创建一个SqlSessionFactory对象
     *                     2.sql映射文件：配置了每个SQL以及SQL的封装规则
     *                     3.将SQL映射文件注册在全局配置文件中
     *                     4.写代码：
     *                              1）根据全局配置文件得到sqlsessionFactory;
     *                              2）使用sqlsession工厂，获取到sqlsession对象来执行增删改查
     *                              一个sqlsession就是代表和数据库的一次会话，用完需要关闭
     *                              3）使用SQL的唯一标识来告诉mybatis执行哪个SQL，SQL都是保存在SQL映射文件中（唯一是名称空间加上唯一标识，防止其他配置文件中的唯一标识重复）
     * @Author Linduse
     * @Date 16:19 2021/3/2
     * @param
     * @return void
     **/

    /**
     * @Description //TODO 这是一个根据配置文件创建sqlsessionFactory的方法；
     * @Author Linduse
     * @Date 18:54 2021/3/2
     * @param
     * @return org.apache.ibatis.session.SqlSessionFactory
     **/
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(is);
    }

    public void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =  new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlsession实例，能直接执行已经映射的SQL语句
        SqlSession openSession = sqlSessionFactory.openSession();
        //参数1：唯一标识
        //参数2：SQL语句汇总需要的参数
        try {
            Employees employees = openSession.selectOne("com.test.mybatis.EmployeesMapper.selectEmp", 1);
            System.out.println(employees);
        } finally {
            //关闭sqlsession实例
            openSession.close();
        }
    }

    @Test
    public void test1() throws IOException {
        //获取sqlsessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //获取sqlsession实例对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            //获取接口的实现类
            //只要将接口和xml进行动态绑定，那么mybatis就会自动为接口创建一个代理对象，让代理对象去执行增删改查方法
            EmployeesMapper employeesMapper = openSession.getMapper(EmployeesMapper.class);
            Employees employees = employeesMapper.getEmpById(10,"小红");
            System.out.println(employees);
        } finally {
            openSession.close();
        }
    }
    @Test
    public void test2() throws IOException {
        //获取sqlsessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //获取sqlsession实例对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            //获取接口的实现类
            //只要将接口和xml进行动态绑定，那么mybatis就会自动为接口创建一个代理对象，让代理对象去执行增删改查方法
            EmployeesMapperAnnotation employeesMapper = openSession.getMapper(EmployeesMapperAnnotation.class);
            Employees employees = employeesMapper.getEmpById(2);
            System.out.println(employees);
        } finally {
            openSession.close();
        }
    }

    /**
     * @Description //TODO 测试增删改
     *                     允许直接定义以下返回值类型：Integer,Long,Boolean，void
     *                     注意：获取到的sqlsession不会自动提交，在里面传参true就会自动提交
     *                     当借口方法中有多个参数的时候：传入的参数会被封装成map，他的key是param1，param2
     *                          采用命名参数：明确指定参数时map的key：@Param("id")在每个参数前面用注解指定他的索引key，这样在SQL语句中参数的获取就能通过指定的参数了
     *                         可能参数时业务模型中的属性，可以直接用属性值
     *                         map：如果多个参数不是业务模型中的数据，没有对应的pojo，我们也可以传入map，使用#{KEY}:取出map中对应的值
     * @Author Zero
     * @Date 12:11 2021/3/3
      * @param
     * @return
     **/
    @Test
    public void test3() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //由于不会自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeesMapper employees =  sqlSession.getMapper(EmployeesMapper.class);
            Employees emp = new Employees("xiaofang","女","xiaohong@.com" );
            //测试添加
            employees.addEmp(emp);
            //测试修改
            //employees.updateEmp(emp);
            //测试删除
            employees.deleteEmpById(2);
            sqlSession.commit();
            System.out.println("修改成功");
        } finally {
            sqlSession.close();
        }
    }
    /**
     * @Description //TODO 测试返回List
     * @Author Linduse
     * @Date 14:12 2021/3/3
      * @param
     * @return
     **/
    @Test
    public void test4() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession opsession = sqlSessionFactory.openSession();
        try {
            EmployeesMapper mapper = opsession.getMapper(EmployeesMapper.class);
            List<Employees> list =  mapper.getEmpByLastNameLike("%xiao%");

            for (Employees e :
                    list) {
                System.out.println(e);
            }
        } finally {
            opsession.close();
        }
    }

    /**
     * @Description //TODO 测试返回map（可以返回多个数据，也可以返回单挑数据）
     * @Author Linduse
     * @Date 14:12 2021/3/3
     * @param
     * @return
     **/
    @Test
    public void test5() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession opsession = sqlSessionFactory.openSession();
        try {
            EmployeesMapper mapper = opsession.getMapper(EmployeesMapper.class);
            Map<Integer,Employees> map =  mapper.getEmpByLastNameReturnMap("%xiao%");
            System.out.println("打印如下：" + map);
        } finally {
            opsession.close();
        }

    }
}
