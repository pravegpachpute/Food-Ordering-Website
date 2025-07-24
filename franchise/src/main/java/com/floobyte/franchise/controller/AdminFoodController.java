package com.floobyte.franchise.controller;

import com.floobyte.franchise.model.Food;
import com.floobyte.franchise.model.Resturant;
import com.floobyte.franchise.model.User;
import com.floobyte.franchise.request.CreateFoodRequest;
import com.floobyte.franchise.response.MessageResponse;
import com.floobyte.franchise.service.FoodService;
import com.floobyte.franchise.service.ResturantService;
import com.floobyte.franchise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private ResturantService resturantService;

    //check
    @PostMapping
    public ResponseEntity<Food> createFood(@RequestBody CreateFoodRequest req,
                                           @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findByUserJwtToken(jwt);
        Resturant resturant = resturantService.getResturantByUserId(user.getId());
        Food food = foodService.createFood(req, req.getCategory(), resturant);
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }

    //delete Menu Item 
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteFood(@PathVariable Long id,
                                                      @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findByUserJwtToken(jwt);

        foodService.deleteFood(id);
        MessageResponse response = new MessageResponse();
        response.setMessage("Food deleted Successfully...");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Update Menu Items
    @PutMapping("/{id}")
    public ResponseEntity<Food> updateAvailibilityStatus(@PathVariable Long id,
                                           @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findByUserJwtToken(jwt);

        Food food = foodService.updateAvailibilityStatus(id);

        return new ResponseEntity<>(food, HttpStatus.OK);
    }
}






