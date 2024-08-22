package org.ashu.tech_trekker.controller;

import java.util.ArrayList;
import java.util.List;

import org.ashu.tech_trekker.dto.BlogRequest;
import org.ashu.tech_trekker.dto.BlogResponse;
import org.ashu.tech_trekker.dto.HomePageResponse;
import org.ashu.tech_trekker.dto.WriterRequest;
import org.ashu.tech_trekker.mapper.BlogMapper;
import org.ashu.tech_trekker.mapper.WriterMapper;
import org.ashu.tech_trekker.model.Blog;
import org.ashu.tech_trekker.service.TechTrekkerService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
public class TechTrekkerController {
    private final TechTrekkerService service;

    @GetMapping({"/","home"})
    public String home(Model model) {
        List<Blog> blogs = service.getBlogs();
        // List<HomePageResponse> details = blogs
        // .stream().map(BlogMapper :: converBlogToHome).toList();
        //or

        List<HomePageResponse> details = new ArrayList<>();
        for(Blog blog : blogs){
            details.add(BlogMapper.converBlogToHome(blog));
        }

        model.addAttribute("blogs", details);
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
        // System.out.println(writerInfo);
        service.createWriter(writerInfo);
        return "redirect:/home";

    }
    @PostMapping("/create-blog")
    public String addBlog(@ModelAttribute BlogRequest request) {
        // log.info("Blog data received: name={} description={}",request.title(),request.description());
    
        var blog = BlogMapper.convertRequest(request);
        service.createBlog(blog,request.banner());

        return "redirect:/home";
    }
    @GetMapping("/blog-details")
    public String blogDetails(@RequestParam String id, Model model) {
        var blog = service.getBlogById(id);
        model.addAttribute("blog",BlogMapper.convertBlogToResponse(blog));
        return "blog-details";

    }
}
