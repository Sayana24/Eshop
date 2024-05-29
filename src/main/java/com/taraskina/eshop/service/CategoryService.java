package com.taraskina.eshop.service;

import com.taraskina.eshop.entity.Category;
import com.taraskina.eshop.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService  {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


    @Transactional
    public Category save(Category category) {
        return categoryRepository.save(category);
    }


    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }


    @Transactional
    public Category update(Category category) {
        return categoryRepository.save(category);
    }


    @Transactional
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
