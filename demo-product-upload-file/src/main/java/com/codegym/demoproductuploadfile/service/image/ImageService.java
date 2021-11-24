package com.codegym.demoproductuploadfile.service.image;


import com.codegym.demoproductuploadfile.model.Image;
import com.codegym.demoproductuploadfile.repository.IImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService implements IImageService{
    @Autowired
    private IImageRepository imageRepository;

    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public Image findById(Long id) {
        return imageRepository.getById(id);
    }

    @Override
    public Image save(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public void deleteById(Long id) {
        imageRepository.deleteById(id);
    }

    @Override
    public List<Image> findAllByProductId(Long id) {
        return imageRepository.findAllByProductId(id);
    }
}
