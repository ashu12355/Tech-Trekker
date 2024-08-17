package org.ashu.tech_trekker.mapper;

import org.ashu.tech_trekker.dto.BlogRequest;
import org.ashu.tech_trekker.dto.BlogResponse;
import org.ashu.tech_trekker.dto.HomePageResponse;
import org.ashu.tech_trekker.model.Blog;
import org.springframework.beans.BeanUtils;

public class BlogMapper  {
    public static Blog convertRequest(BlogRequest request){
        var blog = new Blog();
        BeanUtils.copyProperties(request, blog);
        return blog;
    }

    public static BlogResponse convertBlogToResponse(Blog blog){
        var response = new BlogResponse();
        BeanUtils.copyProperties(blog, response);
        return response;
    }

    public static HomePageResponse converBlogToHome(Blog blog) {
        var homePageResponse = new HomePageResponse();
        BeanUtils.copyProperties(blog, homePageResponse);
        return homePageResponse;

    }

}
