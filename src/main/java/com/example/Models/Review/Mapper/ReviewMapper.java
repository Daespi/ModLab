package com.example.Models.Review.Mapper;

import com.example.Exceptions.BuildException;
import com.example.Models.Review.DTO.ReviewDTO;
import com.example.Models.Review.Entity.Review;

public class ReviewMapper {
    public static Review userFromDTO(ReviewDTO dto) throws BuildException {
        return Review.getInstance(
            dto.getRating(),
            dto.getComment()
        );
    }

    public static ReviewDTO dtoFromUser(Review review) {
        return new ReviewDTO(
            review.getReviewId(),
            review.getRating(),
            review.getComment(),
            review.getReviewDate()
        );
    }
}
