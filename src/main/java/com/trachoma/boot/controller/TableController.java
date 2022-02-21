package com.trachoma.boot.controller;

import com.trachoma.boot.bean.User;
import com.trachoma.boot.exception.UserTooManyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @author trachoma
 * @create 2022-02-20 20:12
 */
@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table() {
        int i = 10 / 0;
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model) {

        List<User> users = Arrays.asList(new User("zhangsan", "1231231"),
                new User("lisi", "123123"),
                new User("haha", "1312312"),
                new User("hehe", "1312"));
        model.addAttribute("users", users);

        if (users.size() > 3) {
            throw new UserTooManyException();
        }
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
