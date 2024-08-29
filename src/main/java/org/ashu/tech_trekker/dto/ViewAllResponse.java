package org.ashu.tech_trekker.dto;

import java.util.List;

import lombok.Data;

@Data
public class ViewAllResponse {
    private String searchTerm;
    private List<BlogResponse> blogs;
    private int currentPage;
    private int totalPage;

}
