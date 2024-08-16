package org.ashu.tech_trekker.dto;

import org.springframework.web.multipart.MultipartFile;

public record WriterRequest(
    String writerName,
    String email,
    String password,
    String writerProfession,
    MultipartFile profilePicture
   
    ){
}

//here i get it from the form