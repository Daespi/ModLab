package com.example.Models.Review.MAPPERS;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.Exceptions.BuildException;
import com.example.Models.Review.DTO.ReviewDTO;
import com.example.Models.Review.Entity.Review;

public class ReviewMapper {
    // Formateador con el patrón que quieres para la fecha
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public static Review reviewFromDTO(ReviewDTO dto) throws BuildException {
        return Review.getInstance(
            dto.getRating(),
            dto.getComment(),
            dto.getReviewDate(),
            dto.getProductId(),
            dto.getUserId()
        );
    }

    // Desde entidad Review → a DTO (con fecha en formato String sin la Z)
    public static ReviewDTO dtoFromReview(Review review, String userId, String productId, LocalDateTime formattedDate) { // formateas la fecha aquí
        return new ReviewDTO(
            review.getReviewId(),
            userId,
            productId,
            review.getRating(),
            review.getComment(),
            formattedDate
        );
    }
}
