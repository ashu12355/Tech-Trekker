package org.ashu.tech_trekker.controller;

import org.ashu.tech_trekker.dto.BlogRequest;
import org.ashu.tech_trekker.mapper.BlogMapper;
import org.ashu.tech_trekker.service.TechTrekkerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@RequestMapping("/writter")
@Slf4j
public class WritterController {
    private final TechTrekkerService service;


    @GetMapping("/create-blog")
    public String createBlog() {
        return "create-blog";
    }
    @PostMapping("/create-blog")
    public String addBlog(@ModelAttribute BlogRequest request) {
       log.info("Blog data received: name={} description={}",request.title(),request.description());
    
        var blog = BlogMapper.convertRequest(request);
        service.createBlog(blog,request.banner());

        return "redirect:/tech-trekker/home";
    }
}
