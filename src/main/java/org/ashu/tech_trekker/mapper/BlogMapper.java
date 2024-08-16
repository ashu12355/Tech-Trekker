package org.ashu.tech_trekker.mapper;

import org.ashu.tech_trekker.dto.BlogRequest;
import org.ashu.tech_trekker.model.Blog;
import org.springframework.beans.BeanUtils;

public class BlogMapper  {
    public static Blog convertRequest(BlogRequest request){
        var blog = new Blog();
        BeanUtils.copyProperties(request, blog);
        return blog;
    }

}
