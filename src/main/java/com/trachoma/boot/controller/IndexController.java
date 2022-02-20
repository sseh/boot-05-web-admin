package com.trachoma.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author trachoma
 * @create 2022-02-20 19:02
 */
@Controller
public class IndexController {

    @GetMapping(value = {"/", "login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(String username, String password) {
        return "index";
    }
}
