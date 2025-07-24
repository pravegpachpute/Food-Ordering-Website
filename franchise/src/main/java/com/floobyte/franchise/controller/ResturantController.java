package com.floobyte.franchise.controller;

import com.floobyte.franchise.dto.RestorantDto;
import com.floobyte.franchise.model.Resturant;
import com.floobyte.franchise.model.User;
import com.floobyte.franchise.request.CreateResturantRequest;
import com.floobyte.franchise.service.ResturantService;
import com.floobyte.franchise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resturants")
public class ResturantController {

    @Autowired
    private ResturantService resturantService;

    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public ResponseEntity<List<Resturant>> searchResturant(

            @RequestHeader("Authorization") String jwt,
            @RequestParam String keyword
    ) throws Exception {
        User user = userService.findByUserJwtToken(jwt);

        List<Resturant> resturant = resturantService.searchResturant(keyword);
        return new ResponseEntity<>(resturant, HttpStatus.OK);
    }

    //Check
    @GetMapping()
    public ResponseEntity<List<Resturant>> getAllResturant(

            @RequestHeader("Authorization") String jwt

    ) throws Exception {
        User user = userService.findByUserJwtToken(jwt);

        List<Resturant> resturant = resturantService.getAllResturant();
        return new ResponseEntity<>(resturant, HttpStatus.OK);
    }

    //Check
    @GetMapping("/{id}")
    public ResponseEntity<Resturant> getResturantById(

            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id

    ) throws Exception {
        User user = userService.findByUserJwtToken(jwt);

        Resturant resturant = resturantService.findResturantById(id);
        return new ResponseEntity<>(resturant, HttpStatus.OK);
    }

    //Check
    @PutMapping("/{id}/add-favorites")
    public ResponseEntity<RestorantDto> addToFavorites(

            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id

    ) throws Exception {
        User user = userService.findByUserJwtToken(jwt);

        RestorantDto resturant = resturantService.addToFavorites(id, user);
        return new ResponseEntity<>(resturant, HttpStatus.OK);
    }
}
