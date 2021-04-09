package cache;

import com.test.mybatis.Employees;
import com.test.mybatis.EmployeesMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: Linduse
 * @Date: 2021/3/8 - 16:16
 * @since: jdk 1.8
 */
public class TestCache {
    //获取sqlsession
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String source = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(source);
        return new SqlSessionFactoryBuilder().build(is);
    }
    /**
     * @Description //TODO 两级缓存：一级缓存（本地缓存）：与数据库同一次会话期间查询到的数据会放在本地缓存中，以后入股偶需要获取相同的数据，直接从换粗那种拿，没必要去查询数据库
     *                     一级缓存失效的情况：
     *                     1.sqlsession改变;
     *                     2.sqlsession相同， 查询条件不同
     *                     3.sqlsession相同，两次查询之间插入了增删改操作（数据库改变）
     *                     4.手动清除了缓存opensession。clearCache();
     *                     二级缓存（全局缓存）：基于namespace级别的缓存，一个namespace对应一个二级缓存；
     *                     工作机制：
     *                     1.一个会话，查询一条数据，这个数据就会被放在当前会话的一次缓存中；
     *                     2.如果会话关闭，一级缓存的数据会被保存到二级缓存中；新的会话查询信息，就可以参照二级缓存进行读取
     *                     3.不同namespace查出的数据会放在自己对应的缓存中
     *                     使用：
     *                     1.开启全局二级缓存配置，setting中开启cacheEnabled
     *                     2.去对应的mapper映射文件中添加cache标签
     *                     3.POJO需要实现序列化接口
     *                     注意：只有会话提交或者关闭，才能放入二级缓存中
     *
     *                     缓存有关的配置
     *                      每个select标签中都有一个useCache="true"；关闭的情况下不会使用二级缓存，使用一次缓存
     *                      开启的情况下会使用二级缓存
     *                      每个增删改查标签，都会清除缓存flushCache="true",查询默认false；
     *                      手动清除不影响二级缓存
     *
     *                第三方缓存整合：
     *                导入ehcache的jar包，然后导入ehcache的适配器包（GitHub上下载）；在xml使用自定义缓存；需要一个xml文件
     *
     * @Author Linduse
     * @Date 16:18 2021/3/8
     * @param
     * @return
     **/
    @Test
    public void testFirstLevleCache() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession opensession = sqlSessionFactory.openSession();
        try {
            EmployeesMapper mapper = opensession.getMapper(EmployeesMapper.class);
            List<Employees> employees = mapper.getEmpByLastNameLike("%x%");
            for (Employees emp :
                    employees) {
                System.out.println(emp);
            }
        } finally {
            opensession.close();
        }
    }
    @Test
    public void testSecondLevelCache() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession opensession = sqlSessionFactory.openSession();
        SqlSession opensession1 = sqlSessionFactory.openSession();
        try{
            EmployeesMapper mapper = opensession.getMapper(EmployeesMapper.class);
            EmployeesMapper mapper1 = opensession1.getMapper(EmployeesMapper.class);
            List<Employees> emps = mapper.getEmpByLastNameLike("%x%");
            opensession.close();
            List<Employees> emps1 = mapper1.getEmpByLastNameLike("%x%");
            opensession1.close();
            System.out.println();
        } finally {

        }

    }
}
