package org.ashu.tech_trekker.service.impl;

import java.io.File;

import org.ashu.tech_trekker.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Value("${upload.file.profile}")
    private String profileDir;

    @Value("${upload.file.blog.banner}")
    private String bannerDir;

    @Override
    public void createProfileDirectory() {
       createDirectory(profileDir);
    }

    @Override
    public void createBlogDirectory() {
        createDirectory(bannerDir);
    }

    @Override
    public String uploadprofilePicture(MultipartFile file) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'uploadprofilePicture'");
    }

    @Override
    public String uploadBlogBanner(MultipartFile file) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'uploadBlogBanner'");
    }

    @Override
    public byte[] getProfilePicture(String fileName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProfilePicture'");
    }

    @Override
    public byte[] getBlogBanner(String fileName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBlogBanner'");
    }

    private void createDirectory(String dir) {
        File file = new File(dir);
        if(!file.exists()) {
            file.mkdir();

            log.info(dir+" created");
            return;
        }
        log.info(dir+" already Exists");
    }
    
}
