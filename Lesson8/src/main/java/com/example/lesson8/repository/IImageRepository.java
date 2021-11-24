package com.example.lesson8.repository;

import com.example.lesson8.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAllByProductId(Long id);
}
