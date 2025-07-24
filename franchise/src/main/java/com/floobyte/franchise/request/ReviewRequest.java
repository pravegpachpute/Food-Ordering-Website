package com.floobyte.franchise.request;

import lombok.Data;

@Data
public class ReviewRequest {

    private double stars; // rating 1 to 5
    private String feedback; // review
    private String foodQuality; //comment good,bad
    private Long resturantId;

    // getters & setters


    public ReviewRequest() {
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFoodQuality() {
        return foodQuality;
    }

    public void setFoodQuality(String foodQuality) {
        this.foodQuality = foodQuality;
    }

    public Long getResturantId() {
        return resturantId;
    }

    public void setResturantId(Long resturantId) {
        this.resturantId = resturantId;
    }
}
