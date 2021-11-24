package com.codegym.demoproductuploadfile.service.image;


import com.codegym.demoproductuploadfile.model.Image;
import com.codegym.demoproductuploadfile.service.IGeneralService;

import java.util.List;

public interface IImageService extends IGeneralService<Image> {
    List<Image> findAllByProductId(Long id);
}
