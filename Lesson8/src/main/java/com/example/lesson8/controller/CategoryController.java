package com.example.lesson8.controller;

import com.example.lesson8.model.Category;
import com.example.lesson8.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;


    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

}
