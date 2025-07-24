package com.floobyte.franchise.repository;

import com.floobyte.franchise.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    public List<Category> findByResturantId(Long id);
    //find all categories with resturant.
}
