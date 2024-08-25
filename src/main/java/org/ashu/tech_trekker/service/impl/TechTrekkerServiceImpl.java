package org.ashu.tech_trekker.service.impl;

import java.util.List;

import org.ashu.tech_trekker.constant.BlogCategory;
import org.ashu.tech_trekker.model.Blog;
import org.ashu.tech_trekker.model.WriterInfo;
import org.ashu.tech_trekker.repository.BlogRepository;
import org.ashu.tech_trekker.repository.WriterInfoRepository;
import org.ashu.tech_trekker.service.FileService;
import org.ashu.tech_trekker.service.TechTrekkerService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TechTrekkerServiceImpl implements TechTrekkerService {
    private final WriterInfoRepository writerRepository;
    private final BlogRepository blogrepository;
    private final FileService fileService;

    @Override
    public void createWriter(WriterInfo info) {
        writerRepository.save(info);
    }
        @Override
        public void createBlog(Blog blog, MultipartFile file) {
            String fileName = fileService.uploadBlogBanner(file);
            blog.setBanner(fileName);
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

        @Override
        public byte[] getBanner(String blogId) {
            var blog = getBlogById(blogId);
            var banner = blog.getBanner();
            return fileService.getBlogBanner(banner);
        }
        @Override
        public List<Blog> getTop5Blogs() {
            return blogrepository.findTop5ByOrderByTitle();
        }
        @Override
        public List<Blog> limitedBlogOfCategory(BlogCategory category, int limit) {
        return blogrepository.findByCategory(category , PageRequest.of(0,limit));
        }
    }

