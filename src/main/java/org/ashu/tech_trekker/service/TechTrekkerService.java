package org.ashu.tech_trekker.service;

import java.util.List;

import org.ashu.tech_trekker.model.Blog;
import org.ashu.tech_trekker.model.WriterInfo;

public interface TechTrekkerService {
    void createWriter(WriterInfo info);
    void createBlog(Blog blog);

    List<Blog> getBlogs();

    Blog getBlogById(String id);
    
}
