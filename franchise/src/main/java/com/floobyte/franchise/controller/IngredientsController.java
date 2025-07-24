package com.floobyte.franchise.controller;

import com.floobyte.franchise.model.IngredientsCategory;
import com.floobyte.franchise.model.IngredientsItem;
import com.floobyte.franchise.request.IngredientsCategoryRequest;
import com.floobyte.franchise.request.IngredientsItemRequest;
import com.floobyte.franchise.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/ingredients")
public class IngredientsController {

    @Autowired
    private IngredientsService ingredientsService;

    //Create ingredient category
    //check
    @PostMapping("/category")
    public ResponseEntity<IngredientsCategory> createIngredientsCategory(
            @RequestBody IngredientsCategoryRequest req
            ) throws Exception {
        IngredientsCategory item = ingredientsService.createIngredientsCategory(req.getName(),
                req.getResturantId());
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    //create ingredint
    //not correct working
    @PostMapping
    public ResponseEntity<IngredientsItem> createIngredientsItem(
            @RequestBody IngredientsItemRequest req
    ) throws Exception {
        IngredientsItem item = ingredientsService.createIngredientsItem(req.getResturantId(),
                req.getName(), req.getCategoryId());
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    //Update Stock
    @PutMapping("/{id}/stock")
    public ResponseEntity<IngredientsItem> updateIngredientStock(
            @PathVariable Long id
    ) throws Exception {
        IngredientsItem item = ingredientsService.updateStock(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    //Ingredints of resturant
    //check working
    @GetMapping("/resturant/{id}")
    public ResponseEntity<List<IngredientsItem>> getResturantIngredients(
            @PathVariable Long id
    ) throws Exception {
        List<IngredientsItem> items = ingredientsService.findResturantsIngredients(id);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    //get ingredint category
    //not correct working
    @GetMapping("/resturant/{id}/category")
    public ResponseEntity<List<IngredientsCategory>> getResturantIngredientsCategory(
            @PathVariable Long id
    ) throws Exception {
        List<IngredientsCategory> items = ingredientsService.findIngredientsCategoryByResturantId(id);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

}
