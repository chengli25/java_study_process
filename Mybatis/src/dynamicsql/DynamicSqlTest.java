package dynamicsql;

import com.test.mybatis.Employees;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Linduse
 * @Date: 2021/3/7 - 16:16
 * @since: jdk 1.8
 */
public class DynamicSqlTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String source = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(source);
        return new SqlSessionFactoryBuilder().build(is);

    }
    @Test
    /**
     * @Description //TODO 根据条件动态拼装查询条件的个数
     *                     可能会存在SQL语句编写问题：可以在where后面加上一个1=1，这样就可以避免and在前面的问题
     *                     另外用where标签将所有if条件包含就可以,这样就不用写where这个关键词
     *                     测试if
     * @Author Linduse
     * @Date 16:39 2021/3/7
     * @param
     * @return void
     **/
    public void test1() throws IOException {
         SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
         SqlSession opensqlsession = sqlSessionFactory.openSession();
        try {
            EmployeesMapperDynamicSql mapper = opensqlsession.getMapper(EmployeesMapperDynamicSql.class);
            Employees employees = new Employees("程立","男","chengli@.com");
            List<Employees> emps = mapper.getEmpsByConditionIf(employees);
            for (Employees emp :
                    emps) {
                System.out.println(emp);
            }
        } finally {
            opensqlsession.close();
        }
    }
    /**
     * @Description //TODO 测试trim(可以在trim标签中拼串的结果加上去掉前缀或者后缀)
     * @Author Linduse
     * @Date 16:53 2021/3/7
      * @param
     * @return 
     **/
    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession opensqlsession = sqlSessionFactory.openSession();
        try {
            EmployeesMapperDynamicSql mapper = opensqlsession.getMapper(EmployeesMapperDynamicSql.class);
            Employees employees = new Employees(0,"%x%",null,"chengli@.com");
            //List<Employees> emps = mapper.getEmpsByConditionTrim(employees);
            //for (Employees emp :
            //        emps) {
            //    System.out.println(emp);

            //测试set标签（用于更新数据的时候将所有的更改的内容放入字段中，封装更改条件）
            //mapper.updateEmp(employees);
            //opensqlsession.commit();

            //测试trim(在trim标签中的拼串结果加上或者去掉前缀后者是后缀)
            //List<Employees> emps = mapper.getEmpsByConditionTrim(employees);
            //for (Employees emp :
            //        emps) {
            //    System.out.println(emp);
            //}

            //测试choose（只会进入一个分支）
            //List<Employees> emps = mapper.getEmpsByConditionChoose(employees);
            //for (Employees emp :
            //        emps) {
            //    System.out.println(emp);
            //}

            //测试使用foreach进行批量插入（对于values的时候，可以用foreach进行去除list中的所有的单个对象，将其插入）
            List<Employees> emps = new ArrayList<>();
            emps.add(new Employees("tom","男","mapper@.com"));
            emps.add(new Employees("cache","女","cache@.com"));
            mapper.addEmps(emps);
            opensqlsession.commit();

            //测试param内置参数以及bind标签(将某个变量的值绑定到另一个变量中，方便后面对这个变量进行引用)
            //Employees employees1 = new Employees();
            //employees1.setLastName("x");
            //System.out.println(employees1);
            //List<Employees> emps = mapper.getEmpTestInnerParameter(employees1);
            //for (Employees emp :
            //        emps) {
            //    System.out.println(emp);
            //}
        } finally {
            opensqlsession.close();
        }

    }

}

