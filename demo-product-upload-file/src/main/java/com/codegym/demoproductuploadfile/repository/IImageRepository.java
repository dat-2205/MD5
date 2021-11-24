package com.codegym.demoproductuploadfile.repository;


import com.codegym.demoproductuploadfile.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAllByProductId(Long id);
}
