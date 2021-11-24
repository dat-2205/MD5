package com.example.lesson8.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fileName;

    @ManyToOne
    private Product product;
}
