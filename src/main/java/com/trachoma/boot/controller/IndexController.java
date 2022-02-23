package com.trachoma.boot.controller;

import com.trachoma.boot.bean.Department;
import com.trachoma.boot.bean.Employee;
import com.trachoma.boot.bean.User;
import com.trachoma.boot.service.DepartmentService;
import com.trachoma.boot.service.EmployeeService;
import com.trachoma.boot.service.impl.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author trachoma
 * @create 2022-02-20 19:02
 */
@Slf4j
@Controller
public class IndexController {

    @Autowired
    public EmployeeService employeeService;

    @Autowired
    public DepartmentService departmentService;

//    @Autowired
    public StringRedisTemplate redisTemplate;

    @ResponseBody
    @PostMapping("/dept")
    public Department saveDept(Department department) {
        departmentService.saveDept(department);
        return department;
    }

    @ResponseBody
    @GetMapping("/emp")
    public Employee getById(@RequestParam Integer empno) {
        return employeeService.getEmpById(empno);
    }

    @ResponseBody
    @GetMapping("/dept")
    public Department getDeptById(@RequestParam Integer deptno) {
        return departmentService.getDeptById(deptno);
    }

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromEmp(){
        String string = jdbcTemplate.queryForObject("select count(*) from emp", String.class);
        return string;
    }

    @GetMapping(value = {"/", "login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if (StringUtils.hasText(user.getUserName()) && "123".equals(user.getPassword())) {
            session.setAttribute("loginUser", user);
            return "redirect:/index.html";
        } else {
            model.addAttribute("msg", "账号密码错误");
            return "login";
        }
    }

    @GetMapping("/index.html")
    public String indexPage(HttpSession session, Model model) {
        log.info("当前方法是: {}", "indexPage");
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser != null) {
//            return "index";
//        } else {
//            model.addAttribute("msg", "请重新登录");
//            return "login";
//        }
//        ValueOperations<String, String> operations = redisTemplate.opsForValue();
//        String s = operations.get("/index.html");
//        String s1 = operations.get("/sql");
//        model.addAttribute("indexCount", s);
//        model.addAttribute("sqlCount", s1);
        model.addAttribute("indexCount", 1);
        model.addAttribute("sqlCount", 1);
        return "index";
    }
}
