package com.floobyte.franchise.controller;

import com.floobyte.franchise.model.Category;
import com.floobyte.franchise.model.User;
import com.floobyte.franchise.response.MessageResponse;
import com.floobyte.franchise.service.CategoryService;
import com.floobyte.franchise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    //Owner & Admin
    //check
    @PostMapping("/admin/category")
    public ResponseEntity<Category> createCategory(
            @RequestBody Category category ,
            @RequestHeader("Authorization") String jwt) throws Exception {
    User user = userService.findByUserJwtToken(jwt);

    Category createCategory = categoryService.createCategory(category.getName(), user.getId());

    return new ResponseEntity<>(createCategory, HttpStatus.CREATED);
    }

//  using both Customer and user or get all category perticular resturant
    //check
    @GetMapping("/category/resturant/{id}")
    public ResponseEntity<List<Category>> findCategoryByResturantId(
            @PathVariable Long id,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findByUserJwtToken(jwt);

        List<Category> categories = categoryService.findCategoryByResturantId(id);

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    //No Check
    @DeleteMapping("/category/delete/{id}")
    public ResponseEntity<MessageResponse> deleteCategory(@RequestHeader("Authorization") String jwt,
                                                          @PathVariable Long id) throws Exception {
        userService.findByUserJwtToken(jwt);

        categoryService.deleteCategoryById(id);
        MessageResponse response = new MessageResponse();
        response.setMessage("Category deleted Successfully...");
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

}
