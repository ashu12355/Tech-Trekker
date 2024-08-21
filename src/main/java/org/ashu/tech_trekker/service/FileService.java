package org.ashu.tech_trekker.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void createProfileDirectory();
    void createBlogDirectory();

    String uploadprofilePicture(MultipartFile file);
    String uploadBlogBanner(MultipartFile file);

    byte[] getProfilePicture(String fileName);
    byte[] getBlogBanner(String fileName);

}
