package org.ashu.tech_trekker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TechTrekkerController {

    @GetMapping({"/","home"})
    public String home() {
        return "home";
    }
    
    @GetMapping("/create-blog")
    public String createBlog() {
        return "create-blog";
    }
    
}
