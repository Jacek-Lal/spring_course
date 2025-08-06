package com.jacek.dream_shops.repository;

import com.jacek.dream_shops.model.Category;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
