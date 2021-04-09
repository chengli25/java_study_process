package com.test.mybatis;

import org.apache.ibatis.annotations.Select;

/**
 * @author: Linduse
 * @Date: 2021/3/2 - 20:58
 * @since: jdk 1.8
 */
public interface EmployeesMapperAnnotation {
    @Select("select * from employees where id = #{id}")
    Employees getEmpById(int id);
}
