package dynamicsql;

import com.test.mybatis.Employees;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: Linduse
 * @Date: 2021/3/7 - 15:50
 * @since: jdk 1.8
 */
public interface EmployeesMapperDynamicSql {
    //携带了哪个字段，查询条件就带上这个字段你的值
    List<Employees> getEmpsByConditionIf(Employees employees);
    //测试trim
    List<Employees> getEmpsByConditionTrim(Employees employees);
    //测试_parameter（表示所有参数）
    List<Employees> getEmpTestInnerParameter(Employees employees);
    //测试set标签
    void updateEmp(Employees employees);
    //测试choose
    List<Employees> getEmpsByConditionChoose(Employees employees);
    //使用foreach标签批量保存数据
    void addEmps(@Param("emps")List<Employees> emps);
}
