package com.example.lesson8.controller;

import com.example.lesson8.model.Image;
import com.example.lesson8.model.Product;
import com.example.lesson8.model.ProductForm;
import com.example.lesson8.model.ProductResponse;
import com.example.lesson8.service.image.IImageService;
import com.example.lesson8.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {


    @Autowired
    private IProductService productService;

    @Autowired
    private IImageService imageService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProduct() {
        List<Product> products = productService.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product p : products) {
            List<Image> images = imageService.findAllByProductId(p.getId());
            productResponses.add(new ProductResponse(p.getId(), p.getName(),p.getDate(), p.getCategory(),images ));
        }
        return new ResponseEntity<>(productResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        if(product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ProductResponse productResponse = new ProductResponse(product.getId(), product.getName(), product.getDate(), product.getCategory(), imageService.findAllByProductId(product.getId()));
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody ProductForm productForm) {
        List<MultipartFile> multipartFiles = productForm.getImages();
        for(MultipartFile mf : multipartFiles) {
            String fileName = mf.getOriginalFilename();
            FileCopyUtils.copy(mf.getBytes(), new File())
        }
    }
}
