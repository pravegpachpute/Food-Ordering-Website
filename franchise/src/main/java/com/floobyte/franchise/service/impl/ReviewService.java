package com.floobyte.franchise.service.impl;

import com.floobyte.franchise.model.Resturant;
import com.floobyte.franchise.model.Review;
import com.floobyte.franchise.model.User;
import com.floobyte.franchise.repository.ResturantRepository;
import com.floobyte.franchise.repository.ReviewRepository;
import com.floobyte.franchise.repository.UserRepository;
import com.floobyte.franchise.request.ReviewRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {


    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResturantRepository resturantRepository;

    @Transactional
    public Review createReview(ReviewRequest reviewRequest, Long userId) {
        User customer = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Resturant restaurant = resturantRepository.findById(reviewRequest.getResturantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        Review review = new Review();
        review.setStars(reviewRequest.getStars());
        review.setFeedback(reviewRequest.getFeedback());
        review.setFoodQuality(reviewRequest.getFoodQuality());
        review.setCustomer(customer);
        review.setResturant(restaurant);

        return reviewRepository.save(review);
    }

    @Transactional(readOnly = true)
    public List<Review> getReviewsForRestaurant(Long resturantId) {
        return reviewRepository.findByResturantId(resturantId);
    }

    @Transactional(readOnly = true)
    public Double getAverageRatingForRestaurant(Long resturantId) {
        return reviewRepository.findAverageRatingByRestaurantId(resturantId);
    }
}
