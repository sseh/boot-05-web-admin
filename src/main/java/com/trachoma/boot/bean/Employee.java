package com.trachoma.boot.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Administrator
 * @create 2022-02-22 21:04
 */
@Data
public class Employee {

    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private BigDecimal sal;
    private BigDecimal comm;
    private Integer deptno;
}
