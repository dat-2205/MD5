package com.codegym.demoproductuploadfile.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Data
public class ProductForm {
    private Long id;

    private String name;

    private Category category;

    private List<MultipartFile> images;
    
    private MultipartFile file;

    public ProductForm(Long id, String name, Category category, List<MultipartFile> images) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.images = images;
    }
}
