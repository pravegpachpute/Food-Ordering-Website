package com.floobyte.franchise.controller;

import com.floobyte.franchise.model.Food;
import com.floobyte.franchise.model.Resturant;
import com.floobyte.franchise.model.User;
import com.floobyte.franchise.request.CreateFoodRequest;
import com.floobyte.franchise.service.FoodService;
import com.floobyte.franchise.service.ResturantService;
import com.floobyte.franchise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private ResturantService resturantService;

    //Serach Menu Items
    @GetMapping("/search")
    public ResponseEntity<List<Food>> searchFood(@RequestParam String name,
                                           @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findByUserJwtToken(jwt);

        List<Food> foods = foodService.searchFood(name);

        return new ResponseEntity<>(foods, HttpStatus.CREATED);
    }

    //menu resturant food
    //working in frontend(no check postman)
    @GetMapping("/resturant/{resturantId}")
    public ResponseEntity<List<Food>> getResturantsFood(
            @RequestParam boolean vegetarian,
            @RequestParam boolean nonveg,
            @RequestParam boolean seasonal,
            @RequestParam(required = false) String food_category,
            @PathVariable Long resturantId,
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findByUserJwtToken(jwt);

        List<Food> foods = foodService.getResturantsFood(resturantId,vegetarian,nonveg,seasonal,food_category);

        return new ResponseEntity<>(foods, HttpStatus.CREATED);
    }

}
