package org.ashu.tech_trekker.service.impl;

import java.util.List;

import org.ashu.tech_trekker.model.Blog;
import org.ashu.tech_trekker.model.WriterInfo;
import org.ashu.tech_trekker.repository.BlogRepository;
import org.ashu.tech_trekker.repository.WriterInfoRepository;
import org.ashu.tech_trekker.service.TechTrekkerService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TechTrekkerServiceImpl implements TechTrekkerService {
    private final WriterInfoRepository writerRepository;
    private final BlogRepository blogrepository;

    @Override
    public void createWriter(WriterInfo info) {
        writerRepository.save(info);
    }
        @Override
        public void createBlog(Blog blog) {
        blogrepository.save(blog);
            
        }
        @Override
        public List<Blog> getBlogs() {
            return blogrepository.findAll(); // it gives all the data
        }
        @Override
        public Blog getBlogById(String id) {
           return blogrepository.findById(id).orElseThrow();
        }
    }

