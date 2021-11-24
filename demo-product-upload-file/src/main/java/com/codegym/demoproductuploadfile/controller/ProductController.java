package com.codegym.demoproductuploadfile.controller;


import com.codegym.demoproductuploadfile.model.Image;
import com.codegym.demoproductuploadfile.model.Product;
import com.codegym.demoproductuploadfile.model.ProductForm;
import com.codegym.demoproductuploadfile.model.ProductResponse;
import com.codegym.demoproductuploadfile.service.image.IImageService;
import com.codegym.demoproductuploadfile.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private IProductService productService;

    @Autowired
    private IImageService imageService;

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getAllProduct(@PageableDefault(size = 5) Pageable pageable, @RequestParam(required = false) String name) {
        List<Product> products = new ArrayList<>();
        if(name == null || name.equals("")) {
            products = productService.findAll();
        }else {
           Page<Product> product1s = productService.findAllByNameContaining(pageable, name);
           Page<ProductResponse> productResponses = product1s.se
        }
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product p : products) {
            List<Image> images = imageService.findAllByProductId(p.getId());
            productResponses.add(new ProductResponse(p.getId(), p.getName(), p.getCategory(), images ));
        }
        int pageNumber = pageable.getPageNumber();
        int totalPage = Math.round(productResponses.size()/5);
        PageRequest pageRequest = PageRequest.of(pageNumber, 5);
        Page<ProductResponse> productResponsePage = new P
        return new ResponseEntity<>(productResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        Product p = productService.findById(id);
        List<ProductResponse> productResponses = new ArrayList<>();
        List<Image> images = imageService.findAllByProductId(p.getId());
        productResponses.add(new ProductResponse(p.getId(), p.getName(), p.getCategory(),images ));
        return new ResponseEntity<>(productResponses.get(0), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> save(ProductForm productForm) {
        List<MultipartFile> multipartFiles = productForm.getImages();
        Product product = new Product();
        product.setName(productForm.getName());
        product.setCategory(productForm.getCategory());
        product =  productService.save(product);
        if(multipartFiles != null) {
            for(MultipartFile mf : multipartFiles) {
                if(mf != null) {
                    String fileName = mf.getOriginalFilename();
                    saveImage(fileName, product);
                    copyImage(mf, fileName);
                }
            }
        }
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }



    private void copyImage(MultipartFile mf, String fileName) {
        try {
            FileCopyUtils.copy(mf.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveImage(String fileName, Product product) {
        Image image = new Image();
        image.setFileName(fileName);
        image.setProduct(product);
        imageService.save(image);
    }
}
