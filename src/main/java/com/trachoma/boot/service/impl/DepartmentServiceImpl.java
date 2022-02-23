package com.trachoma.boot.service.impl;

import com.trachoma.boot.bean.Department;
import com.trachoma.boot.mapper.DepartmentMapper;
import com.trachoma.boot.service.DepartmentService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
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

    public Counter counter;

    public DepartmentServiceImpl(MeterRegistry meterRegistry) {
        counter = meterRegistry.counter("departmentService.saveDept.count");
    }

    @Override
    public Department getDeptById(Integer id) {
        return departmentMapper.getById(id);
    }

    @Override
    public void saveDept(Department department) {
        counter.increment();
        departmentMapper.insert(department);
    }
}
