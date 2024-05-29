package com.taraskina.eshop.repository;

import com.taraskina.eshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryrRepository extends JpaRepository<Category, Long> {
}
