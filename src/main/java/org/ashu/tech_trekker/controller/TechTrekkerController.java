package org.ashu.tech_trekker.controller;


import static org.ashu.tech_trekker.mapper.BlogMapper.*;
import org.ashu.tech_trekker.constant.BlogCategory;
import org.ashu.tech_trekker.dto.BlogRequest;
import org.ashu.tech_trekker.dto.HomePageResponse;
import org.ashu.tech_trekker.dto.WriterRequest;
import org.ashu.tech_trekker.mapper.BlogMapper;
import org.ashu.tech_trekker.mapper.WriterMapper;
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
        var recentBlogs = converBlogsToBasic(service.getTop5Blogs());
       var backendBlogs = converBlogsToBasic(service.limitedBlogOfCategory(BlogCategory.FRONTEND,6));
       var frontendBlogs = converBlogsToBasic(service.limitedBlogOfCategory(BlogCategory.BACKEND, 8));
       var databaseBlogs = converBlogsToBasic(service.limitedBlogOfCategory(BlogCategory.DATABASE, 6));

       var homePageResponse = new HomePageResponse();
       homePageResponse.setRecentBlogs(recentBlogs);
       homePageResponse.setBackendBlogs(backendBlogs);
       homePageResponse.setFrontendBlogs(frontendBlogs);
       homePageResponse.setDatabaseBlogs(databaseBlogs);
       
       model.addAttribute("response", homePageResponse);
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

        return "create-blog";
    }
    @GetMapping("/blog-details")
    public String blogDetails(@RequestParam String id, Model model) {
        var blog = service.getBlogById(id);
        model.addAttribute("blog",BlogMapper.convertBlogToResponse(blog));
        return "blog-details";

    }
    @GetMapping("/view-all")
    public String viewAll(@RequestParam BlogCategory category, Model model) {
        var blogs = service.limitedBlogOfCategory(category, 5);
        var blogResponse = blogs.stream().map(BlogMapper::convertBlogToResponse).toList();
        model.addAttribute("blogs", blogResponse);
        return "view-all";
    }

    
}
