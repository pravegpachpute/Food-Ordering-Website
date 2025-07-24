package com.floobyte.franchise.repository;

import com.floobyte.franchise.model.Food;
import com.floobyte.franchise.model.IngredientsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientsCategoryRepository extends JpaRepository<IngredientsCategory, Long> {

    List<IngredientsCategory> findByResturantId(Long resturantId);
}
