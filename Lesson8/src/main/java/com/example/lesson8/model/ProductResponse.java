package com.example.lesson8.model;

import lombok.Data;

import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Data
public class ProductResponse {
    private Long id;

    private String name;

    private Date date;

    private Category category;

    private List<Image> images;

    public ProductResponse(Long id, String name, Date date, Category category, List<Image> images) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.category = category;
        this.images = images;
    }
}
