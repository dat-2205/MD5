package com.codegym.demoproductuploadfile.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private Category category;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Image> images;
}
