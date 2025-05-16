package com.example.Models.Review.MAPPERS;

import com.example.Exceptions.BuildException;
import com.example.Models.Review.DTO.ReviewDTO;
import com.example.Models.Review.Entity.Review;

public class ReviewMapper {

    public static Review reviewFromDTO(ReviewDTO dto) throws BuildException {
        return Review.getInstance(
            dto.getRating(),
            dto.getComment(),
            dto.getReviewDate()
        );
    }

    public static ReviewDTO dtoFromReview(Review review, String userId) {
        return new ReviewDTO(
            review.getReviewId(),   // ← este ya vendrá generado cuando se persista
            userId,
            review.getRating(),
            review.getComment(),
            review.getReviewDateAsLocalDateTime()
        );
    }
}