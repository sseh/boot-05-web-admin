package com.trachoma.boot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trachoma.boot.bean.User;
import com.trachoma.boot.exception.UserTooManyException;
import com.trachoma.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

/**
 * @author trachoma
 * @create 2022-02-20 20:12
 */
@Controller
public class TableController {

    @Autowired
    public UserService userService;

    @GetMapping("/basic_table")
    public String basic_table() {
        int i = 10 / 0;
        return "table/basic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             RedirectAttributes ra) {
        userService.removeById(id);
        ra.addAttribute("pn", pn);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn", defaultValue = "1") Integer pageNo,
                                Model model) {

//        List<User> users = Arrays.asList(new User("zhangsan", "1231231"),
//                new User("lisi", "123123"),
//                new User("haha", "1312312"),
//                new User("hehe", "1312"));
//        model.addAttribute("users", users);
//
//        if (users.size() > 3) {
//            throw new UserTooManyException();
//        }
        List<User> userList = userService.list();
        Page<User> userPage = new Page<>(pageNo, 2);
        Page<User> page = userService.page(userPage, null);
        long pages = page.getPages();
        long size = page.getSize();
        long current = page.getCurrent();
        List<User> records = page.getRecords();
        long total = page.getTotal();
//        model.addAttribute("users", userList);
        model.addAttribute("page", page);
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table() {
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table() {
        return "table/editable_table";
    }
}
