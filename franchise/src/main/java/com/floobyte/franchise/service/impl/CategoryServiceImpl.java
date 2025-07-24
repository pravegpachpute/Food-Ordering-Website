package com.floobyte.franchise.service.impl;

import com.floobyte.franchise.model.Category;
import com.floobyte.franchise.model.Resturant;
import com.floobyte.franchise.repository.CategoryRepository;
import com.floobyte.franchise.service.CategoryService;
import com.floobyte.franchise.service.ResturantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    public CategoryRepository categoryRepository;

    @Autowired
    private ResturantService resturantService;

    @Override
    public Category createCategory(String name, Long userId) throws Exception {
        Resturant resturant = resturantService.getResturantByUserId(userId);
        Category category = new Category();
        category.setName(name);
        category.setResturant(resturant);
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findCategoryByResturantId(Long id) throws Exception {
        Resturant resturant = resturantService.findResturantById(id);
        return categoryRepository.findByResturantId(id);
    }

    @Override
    public Category findCategoryById(Long id) throws Exception {
        Optional<Category>optionalCategory= categoryRepository.findById(id);

        if (optionalCategory.isEmpty()){
            throw new Exception("Category is Empty...");
        }
        return optionalCategory.get();
    }

    @Override
    public void deleteCategoryById(Long id) throws Exception {
    categoryRepository.deleteById(id);
    }

}







