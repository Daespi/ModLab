package com.example.Models.Review.MAPPERS;

import com.example.Exceptions.BuildException;
import com.example.Models.Review.DTO.ReviewDTO;
import com.example.Models.Review.Entity.Review;

public class ReviewMapper {

    // Desde DTO → Entidad Review
    public static Review reviewFromDTO(ReviewDTO dto) throws BuildException {
        return Review.getInstance(
            dto.getRating(),
            dto.getComment(),
            dto.getProductId(),
            dto.getUserId()
        );
    }

    // Desde Entidad Review → DTO ReviewDTO
    public static ReviewDTO dtoFromReview(Review review) {
        return new ReviewDTO(
            review.getReviewId(),
            review.getUserId(),
            review.getProductId(),
            review.getRating(),
            review.getComment()
        );
    }
}
