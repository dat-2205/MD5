package com.example.lesson8.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Data
public class ProductForm {
    private Long id;

    private String name;

    private Date date;

    private Category category;

    private List<MultipartFile> images;

    public ProductForm(Long id, String name, Date date, Category category, List<MultipartFile> images) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.category = category;
        this.images = images;
    }
}
