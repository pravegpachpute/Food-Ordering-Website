package com.floobyte.franchise.repository;

import com.floobyte.franchise.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByResturantId(Long resturantId);

    @Query("SELECT AVG(r.stars) FROM Review r WHERE r.resturant.id = :resturantId")
    Double findAverageRatingByRestaurantId(@Param("resturantId") Long resturantId);

    Optional<Review> findByIdAndCustomerId(Long reviewId, Long customerId);
}
