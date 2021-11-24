package com.codegym.demoproductuploadfile.repository;


import com.codegym.demoproductuploadfile.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
