package com.trachoma.boot.service.impl;

import com.trachoma.boot.bean.Department;
import com.trachoma.boot.mapper.DepartmentMapper;
import com.trachoma.boot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @create 2022-02-22 21:49
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    public DepartmentMapper departmentMapper;

    @Override
    public Department getDeptById(Integer id) {
        return departmentMapper.getById(id);
    }

    @Override
    public void saveDept(Department department) {
        departmentMapper.insert(department);
    }
}
