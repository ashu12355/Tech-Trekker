package org.ashu.tech_trekker.controller;

import java.io.Writer;

import org.ashu.tech_trekker.dto.WriterRequest;
import org.ashu.tech_trekker.mapper.WriterMapper;
import org.ashu.tech_trekker.model.WriterInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute WriterRequest request){
        var writerInfo = WriterMapper.convertRequest(request);
        System.out.println(writerInfo);
        return "signup";

    }

    
}
