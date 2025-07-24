package com.floobyte.franchise.controller;

import com.floobyte.franchise.model.Review;
import com.floobyte.franchise.model.User;
import com.floobyte.franchise.request.ReviewRequest;
import com.floobyte.franchise.service.UserService;
import com.floobyte.franchise.service.impl.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@PreAuthorize("hasRole('ROLE_CUSTOMER')")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserService userService;

    //P-Check
    @PostMapping("/reviews")
    public ResponseEntity<?> createReview(@RequestBody ReviewRequest reviewRequest,
                                          @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findByUserJwtToken(jwt);
        Review review = reviewService.createReview(reviewRequest, user.getId());
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    //p-check getall 1 resturant
    @GetMapping("/resturants/{resturantId}/reviews")
    public ResponseEntity<List<Review>> getRestaurantReviews(@PathVariable Long resturantId) {
        return ResponseEntity.ok(reviewService.getReviewsForRestaurant(resturantId));
    }
}
