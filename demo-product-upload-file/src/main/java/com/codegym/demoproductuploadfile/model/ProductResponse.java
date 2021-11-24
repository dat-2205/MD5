package com.codegym.demoproductuploadfile.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Data
public class ProductResponse {
    private Long id;

    private String name;

    private Category category;

    private List<Image> images;

    public ProductResponse(Long id, String name, Category category, List<Image> images) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.images = images;
    }
}
