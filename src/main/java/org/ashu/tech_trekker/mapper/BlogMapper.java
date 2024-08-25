package org.ashu.tech_trekker.mapper;

import java.util.ArrayList;
import java.util.List;

import org.ashu.tech_trekker.dto.BasicBlogInfo;
import org.ashu.tech_trekker.dto.BlogRequest;
import org.ashu.tech_trekker.dto.BlogResponse;
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

    public static List<BasicBlogInfo> converBlogsToBasic(List<Blog> blogs) {
        var list = new ArrayList<BasicBlogInfo>();

        for(Blog blog : blogs) {
        var basicBlogInfo = new BasicBlogInfo();
        BeanUtils.copyProperties(blog, basicBlogInfo);
        list.add(basicBlogInfo);
    }
    return list;
    }
}
