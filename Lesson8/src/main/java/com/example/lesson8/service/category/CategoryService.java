package com.example.lesson8.service.category;

import com.example.lesson8.model.Category;
import com.example.lesson8.model.Image;
import com.example.lesson8.repository.ICategoryRepository;
import com.example.lesson8.repository.IImageRepository;
import com.example.lesson8.service.image.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.getById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
