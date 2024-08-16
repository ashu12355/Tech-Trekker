package org.ashu.tech_trekker.dto;

import org.springframework.web.multipart.MultipartFile;

public record BlogRequest (
    String title,
    String description,
    MultipartFile banner){

    }
