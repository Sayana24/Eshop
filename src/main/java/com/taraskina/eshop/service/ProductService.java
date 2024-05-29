package com.taraskina.eshop.service.impl;

import com.taraskina.eshop.entity.Product;
import com.taraskina.eshop.repository.ProductRepository;
import com.taraskina.eshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(()->new RuntimeException());
    }

    @Override
    @Transactional
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
