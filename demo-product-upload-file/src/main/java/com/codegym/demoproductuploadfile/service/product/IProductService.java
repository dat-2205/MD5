package com.codegym.demoproductuploadfile.service.product;


import com.codegym.demoproductuploadfile.model.Product;
import com.codegym.demoproductuploadfile.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService extends IGeneralService<Product> {
    Page<Product> findAll(Pageable pageable);

    Page<Product> findAllByNameContaining(Pageable pageable, String name);

    List<Product> findAllByNameContaining(String name);
}
