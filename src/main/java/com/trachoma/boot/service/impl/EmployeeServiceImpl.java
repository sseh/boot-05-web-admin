package com.trachoma.boot.service.impl;

import com.trachoma.boot.bean.Employee;
import com.trachoma.boot.mapper.EmployeeMapper;
import com.trachoma.boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @create 2022-02-22 21:24
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    public EmployeeMapper employeeMapper;

    @Override
    public Employee getEmpById(Integer empno) {
        return employeeMapper.getEmployee(empno);
    }
}
