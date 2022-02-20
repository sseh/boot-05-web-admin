package com.trachoma.boot.controller;

import com.sun.org.apache.bcel.internal.generic.IFNONNULL;
import com.trachoma.boot.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @author trachoma
 * @create 2022-02-20 19:02
 */
@Slf4j
@Controller
public class IndexController {

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

        return "index";
    }
}
