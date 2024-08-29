package org.ashu.tech_trekker.service;

import java.util.List;

import org.ashu.tech_trekker.constant.BlogCategory;
import org.ashu.tech_trekker.model.Blog;
import org.ashu.tech_trekker.model.WriterInfo;
import org.springframework.web.multipart.MultipartFile;

public interface TechTrekkerService {
    void createWriter(WriterInfo info);

    void createBlog(Blog blog, MultipartFile file);

    List<Blog> getBlogs();

    Blog getBlogById(String id);
    
    byte[] getBanner(String blogId);

    List<Blog> getTop5Blogs();

    List<Blog> limitedBlogOfCategory(BlogCategory category, int limit);
    List<Blog> limitedBlogOfCategory(BlogCategory category,int page ,int limit);

    int countBlogs(BlogCategory blogCategory);

    List<Blog> blogsOfCategoryAndTitle(BlogCategory category , String title,  int page , int limit);
    int countBlogsOfTitle(BlogCategory blogCategory , String title);
    
}
