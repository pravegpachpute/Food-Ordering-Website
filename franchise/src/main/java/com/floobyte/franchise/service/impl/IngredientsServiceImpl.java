package com.floobyte.franchise.service.impl;

import com.floobyte.franchise.model.IngredientsCategory;
import com.floobyte.franchise.model.IngredientsItem;
import com.floobyte.franchise.model.Resturant;
import com.floobyte.franchise.repository.IngredientsCategoryRepository;
import com.floobyte.franchise.repository.IngredientsItemRepository;
import com.floobyte.franchise.service.IngredientsService;
import com.floobyte.franchise.service.ResturantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientsServiceImpl implements IngredientsService {

    @Autowired
    private IngredientsItemRepository ingredientsItemRepository;

    @Autowired
    private IngredientsCategoryRepository ingredientsCategoryRepository;

    @Autowired
    private ResturantService resturantService;


    @Override
    public IngredientsCategory createIngredientsCategory(String name, Long resturantId) throws Exception {
        Resturant resturant = resturantService.findResturantById(resturantId);

        IngredientsCategory category = new IngredientsCategory();
        category.setResturant(resturant);
        category.setName(name);

        return ingredientsCategoryRepository.save(category);
    }

    @Override
    public IngredientsCategory findIngredientsCategoryById(Long id) throws Exception {
        Optional<IngredientsCategory> opt = ingredientsCategoryRepository.findById(id);

        if(opt.isEmpty()){
            throw new Exception("Ingredients Category is Empty...");
        }
        return opt.get();
    }

    @Override
    public List<IngredientsCategory> findIngredientsCategoryByResturantId(Long id) throws Exception {
        resturantService.findResturantById(id);
        return ingredientsCategoryRepository.findByResturantId(id);
    }

    @Override
    public IngredientsItem createIngredientsItem(Long resturantId, String ingredientsName, Long categoryId) throws Exception {
        Resturant resturant = resturantService.findResturantById(resturantId);
        IngredientsCategory category =findIngredientsCategoryById(categoryId);

        IngredientsItem item = new IngredientsItem();
        item.setName(ingredientsName);
        item.setResturant(resturant);
        item.setCategory(category);

        IngredientsItem ingredients = ingredientsItemRepository.save(item);
        category.getIngredients().add(ingredients);

        return ingredients;
    }

    @Override
    public List<IngredientsItem> findResturantsIngredients(Long resturantId) {
        return ingredientsItemRepository.findByResturantId(resturantId);
    }

    @Override
    public IngredientsItem updateStock(Long id) throws Exception {
        Optional<IngredientsItem> optionalIngredientsItem= ingredientsItemRepository.findById(id);

        if(optionalIngredientsItem.isEmpty()){
            throw new Exception("Ingredients not Found....");
        }
        IngredientsItem ingredientsItem = optionalIngredientsItem.get();
        ingredientsItem.setStock(!ingredientsItem.isStock());
        return ingredientsItemRepository.save(ingredientsItem);
    }
}

















