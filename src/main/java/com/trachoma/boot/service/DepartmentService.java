package com.trachoma.boot.service;

import com.trachoma.boot.bean.Department;
import com.trachoma.boot.bean.Employee;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @create 2022-02-22 21:49
 */
@Service
public interface DepartmentService {

    public Department getDeptById(Integer id);

    void saveDept(Department department);
}
