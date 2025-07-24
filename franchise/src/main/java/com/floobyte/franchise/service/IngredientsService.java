package com.floobyte.franchise.service;

import com.floobyte.franchise.model.IngredientsCategory;
import com.floobyte.franchise.model.IngredientsItem;

import java.util.List;

public interface IngredientsService {

    //Handle both IngredientsCategory and IngredientsItem here.
    //Inventory updates.

    public IngredientsCategory createIngredientsCategory(String name, Long resturantId) throws Exception;

    public IngredientsCategory findIngredientsCategoryById(Long id) throws Exception;

    public List<IngredientsCategory> findIngredientsCategoryByResturantId(Long id) throws Exception;

    public IngredientsItem createIngredientsItem(Long resturantId, String IngredientsName, Long categoryId)throws Exception;

    public List<IngredientsItem> findResturantsIngredients(Long resturantId);

    public IngredientsItem updateStock(Long id)throws Exception;


}
