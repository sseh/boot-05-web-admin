package com.trachoma.boot.service;

import com.trachoma.boot.bean.Employee;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @create 2022-02-22 21:21
 */
@Service
public interface EmployeeService {

    public Employee getEmpById(Integer empno);
}
