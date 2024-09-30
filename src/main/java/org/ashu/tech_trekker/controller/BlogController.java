package org.ashu.tech_trekker.controller;

import static org.ashu.tech_trekker.mapper.BlogMapper.*;

import java.util.List;

import org.ashu.tech_trekker.constant.BlogCategory;
import org.ashu.tech_trekker.dto.HomePageResponse;
import org.ashu.tech_trekker.dto.ViewAllResponse;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
@RequestMapping("/tech-trekker")
public class BlogController {
    private final TechTrekkerService service;

    @GetMapping({"/home"})
    public String home(Model model) {
       var recentBlogs = converBlogsToBasic(service.getTop5Blogs());
       var backendBlogs = converBlogsToBasic(service.limitedBlogOfCategory(BlogCategory.BACKEND,6));
       var frontendBlogs = converBlogsToBasic(service.limitedBlogOfCategory(BlogCategory.FRONTEND, 8));
       var databaseBlogs = converBlogsToBasic(service.limitedBlogOfCategory(BlogCategory.DATABASE, 6));

       var homePageResponse = new HomePageResponse();
       homePageResponse.setRecentBlogs(recentBlogs);
       homePageResponse.setFrontendBlogs(frontendBlogs);
       homePageResponse.setBackendBlogs(backendBlogs);
       homePageResponse.setDatabaseBlogs(databaseBlogs);
       
       model.addAttribute("response", homePageResponse);
        return "home";
    }

     @GetMapping("/view-all")
    public String viewAll(@RequestParam BlogCategory category,
            @RequestParam(required = false ,defaultValue = "1") int pageNum,
            @RequestParam(required = false) String searchTerm,
            Model model) {
                final int limit = 5;
                
                List<Blog> blogs;

                int totalBlogs;
                
                if(searchTerm == null) {
                    blogs = service.limitedBlogOfCategory(category,pageNum, limit);
                    totalBlogs =  service.countBlogs(category);
                } else {
                    blogs = service.blogsOfCategoryAndTitle(category, searchTerm, pageNum, limit);
                    totalBlogs =  service.countBlogsOfTitle(category,searchTerm);
                }


        // var blogs = service.limitedBlogOfCategory(category,pageNum, limit);
        var blogResponse = blogs.stream()
                .map(BlogMapper::convertBlogToResponse).toList();

    

        var viewAllResponse = new ViewAllResponse();
        viewAllResponse.setBlogs(blogResponse);
        viewAllResponse.setCurrentPage(pageNum);
        viewAllResponse.setTotalPage(getTotalPage(totalBlogs, limit));
        viewAllResponse.setSearchTerm(searchTerm);


        model.addAttribute("response", viewAllResponse);
        return "view-all";
    }
    @PostMapping("/view-all-search")
    public String viewAllSearch(@RequestParam BlogCategory category ,@RequestParam String searchTerm){
        if(searchTerm == null || searchTerm.isEmpty() || searchTerm.isBlank()){
            return "redirect:/tech-trekker/view-all?category=" +category;
        }

        return "redirect:/tech-trekker/view-all?category=" + category + "&searchTerm=" + searchTerm;
    }
    private int getTotalPage(int totalBlogs , int limit) {
        int result = totalBlogs % limit;
        return (result == 0) 
        ? (totalBlogs / limit) 
        : (totalBlogs /limit) + 1 ;
    }

     @PostMapping("/signup")
    public String signup(@ModelAttribute WriterRequest request){
        var writerInfo = WriterMapper.convertRequest(request);
        service.createWriter(writerInfo);
        return "redirect:/tech-trekker/home";

    }
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
   
  
    @GetMapping("/blog-details")
    public String blogDetails(@RequestParam String id, Model model) {
        var blog = service.getBlogById(id);
        model.addAttribute("blog",BlogMapper.convertBlogToResponse(blog));
        return "blog-details";

    }
   
   

}
