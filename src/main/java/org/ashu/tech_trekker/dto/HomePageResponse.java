package org.ashu.tech_trekker.dto;

import java.util.List;

import lombok.Data;

@Data
public class HomePageResponse {

     List<BasicBlogInfo> recentBlogs;
     List<BasicBlogInfo> backendBlogs;
     List<BasicBlogInfo> frontendBlogs;
     List<BasicBlogInfo> databaseBlogs;
     

}
