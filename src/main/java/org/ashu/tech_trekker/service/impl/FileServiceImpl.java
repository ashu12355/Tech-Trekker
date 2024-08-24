package org.ashu.tech_trekker.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

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
        return uploadImage(file, profileDir);
    }

    @Override
    public String uploadBlogBanner(MultipartFile file) {
        return uploadImage(file, bannerDir);
    }

    @Override
    public byte[] getProfilePicture(String fileName) {
       return getImage(profileDir, fileName);
    }

    @Override
    public byte[] getBlogBanner(String fileName) {
        return getImage(bannerDir, fileName);
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
    private String uploadImage(MultipartFile file , String dir) {
        if(!file.isEmpty()) {
            String originalName = file.getOriginalFilename();
            String customName = getCustomName(originalName);

            try{
                var fos =  new FileOutputStream(dir + File.separator + customName);
                fos.write(file.getBytes());
                fos.close();
                return customName;
            } catch(Exception e){
                throw new RuntimeException(e);
            }
        }
        throw new RuntimeException("Image Not found");
    }
    private byte[] getImage(String dir , String fileName){
        String location = dir + File.separator + fileName;
        try(var fis = new FileInputStream(location)){
            return fis.readAllBytes();
        }catch(Exception e) {
            throw new RuntimeException();
        }
    }
    private String getCustomName(String fileName) {
        String extension = fileName.substring(fileName.lastIndexOf("."));
        String customName = UUID.randomUUID().toString();

        return customName + extension;
    }
    
}
