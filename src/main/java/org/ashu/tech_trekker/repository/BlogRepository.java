package org.ashu.tech_trekker.repository;

import java.util.List;

import org.ashu.tech_trekker.model.Blog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.ashu.tech_trekker.constant.BlogCategory;


public interface BlogRepository extends JpaRepository<Blog,String> {
    List<Blog> findTop5ByOrderByTitle();
    List<Blog> findByCategory(BlogCategory category);
    List<Blog> findByCategory(BlogCategory category, Pageable pageable);
    long countBycategory(BlogCategory category);

    List<Blog> findByCategoryAndTitleContaining(BlogCategory category,String title, Pageable pageable);
    long countByCategoryAndTitleContaining(BlogCategory category , String title);

    
}
