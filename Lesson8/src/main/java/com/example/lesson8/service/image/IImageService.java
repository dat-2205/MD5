package com.example.lesson8.service.image;

import com.example.lesson8.model.Image;
import com.example.lesson8.service.IGeneralService;

import java.util.List;

public interface IImageService extends IGeneralService<Image> {
    List<Image> findAllByProductId(Long id);
}
