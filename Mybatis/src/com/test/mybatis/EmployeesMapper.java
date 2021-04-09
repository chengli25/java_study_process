package com.test.mybatis;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author: Linduse
 * @Date: 2021/3/2 - 16:47
 * @since: jdk 1.8
 */
public interface EmployeesMapper {
      //多个参数时的设置，在参数获取的时候会特殊处理，这样就将参数的key进行设定
      Employees getEmpById(@Param("id") int id,@Param("LastName") String name);
      Long addEmp(Employees employees);
      Integer updateEmp(Employees employees);
      Boolean deleteEmpById(int id);
      //返回一个List封装对象
      List<Employees> getEmpByLastNameLike(String lastName);
      //返回一条记录的map：key就是列名，值就是对应的值
      Map<String ,Object> getEmpByIdReturnMap(Integer id);
      //多条记录封装在map中：Map<Integer,Employees>;键是记录的主键，值是每个对象
      //告诉mybatis封装这个map的时候用哪个属性作为map的key
      @MapKey("id")
      Map<Integer,Employees> getEmpByLastNameReturnMap(String lastname);

}
