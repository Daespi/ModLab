package com.example.Models.Review.DTO;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "review", schema = "modlab")
public class ReviewDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int reviewId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "review_date", nullable = false)
    private LocalDateTime reviewDate;

    // Constructor vacío requerido por JPA
    public ReviewDTO() {}

    // Constructor completo usado en el mapper
    public ReviewDTO(
        int reviewId,
        String userId,
        int rating,
        String comment,
        LocalDateTime reviewDate
    ) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    public int getReviewId() {
        return reviewId;
    }

    public String getUserId() {
        return userId;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }
}
