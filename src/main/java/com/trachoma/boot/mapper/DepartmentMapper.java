package com.trachoma.boot.mapper;

import com.trachoma.boot.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Administrator
 * @create 2022-02-22 21:45
 */
@Mapper
public interface DepartmentMapper {

    @Select("select * from dept where deptno = #{id}")
    public Department getById(Integer id);

    public void insert(Department department);
}
