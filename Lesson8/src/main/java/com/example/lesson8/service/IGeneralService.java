package com.example.lesson8.service;

import java.util.List;

public interface IGeneralService<T>{
    List<T> findAll();

    T findById(Long id);

    T save (T t);

    void deleteById(Long id);
}
