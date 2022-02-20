package com.trachoma.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author trachoma
 * @create 2022-02-20 22:35
 */
@Slf4j
@Controller
public class FormTestController {

    @GetMapping("/form_layouts")
    public String form_layouts() {
        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("userName") String userName,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息: email={}, userName={}, headerImg={}, photos={}",
                email, userName, headerImg.getSize(), photos.length);

        if (!headerImg.isEmpty()) {
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\cache\\" + originalFilename));
        }

        if (photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\cache\\" + originalFilename));
                }
            }
        }

        return "index";
    }
}
