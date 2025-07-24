package com.floobyte.franchise.service;

import com.floobyte.franchise.model.Category;
import com.floobyte.franchise.model.Food;
import com.floobyte.franchise.model.Resturant;
import com.floobyte.franchise.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {

    public Food createFood(CreateFoodRequest req, Category category, Resturant resturant);

    void deleteFood(Long foodId) throws Exception;

    public List<Food> getResturantsFood(Long resturantId,
                                        boolean isVegetarian,
                                        boolean isNonveg,
                                        boolean isSeasonal,
                                        String foodCategory);

    //keyword type anything.
    public List<Food> searchFood(String keyword);

    public Food findFoodById(Long foodId) throws Exception;

    //Food Available or Not(Owner can change status)
    public Food updateAvailibilityStatus(Long foodId) throws Exception;


}














