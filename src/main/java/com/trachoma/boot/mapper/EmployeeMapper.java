package com.trachoma.boot.mapper;

import com.trachoma.boot.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Administrator
 * @create 2022-02-22 21:03
 */
@Mapper
public interface EmployeeMapper {

    public Employee getEmployee(Integer empno);
}
