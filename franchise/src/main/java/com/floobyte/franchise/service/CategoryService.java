package com.floobyte.franchise.service;

import com.floobyte.franchise.model.Category;

import java.util.List;

public interface CategoryService {

    public Category createCategory(String name, Long userId) throws Exception;

    public List<Category> findCategoryByResturantId(Long id)throws Exception;

    public Category findCategoryById(Long id) throws Exception;

    public void deleteCategoryById(Long id) throws Exception;
}
