package com.example.Models.Review.DTO;

public class ReviewDTO {
    private final int reviewId;
    private final int rating;
    private final String comment;
    private final String reviewDate;


    public ReviewDTO(int reviewId, int rating, String comment, String reviewDate) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }


    public int getReviewId() {
        return reviewId;
    }


    public int getRating() {
        return rating;
    }


    public String getComment() {
        return comment;
    }


    public String getReviewDate() {
        return reviewDate;
    }
    
}
