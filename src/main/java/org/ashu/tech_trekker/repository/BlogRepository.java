package org.ashu.tech_trekker.repository;

import org.ashu.tech_trekker.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,String> {
    
}
