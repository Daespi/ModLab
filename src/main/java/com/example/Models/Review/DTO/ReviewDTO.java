package com.example.Models.Review.DTO;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "review", schema = "modlab")
public class ReviewDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int reviewId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "product_id", nullable = false)
    private String productId;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "review_date", nullable = false)
    private LocalDateTime reviewDate;
 // Ahora como String

    // Constructor vacío requerido por JPA
    public ReviewDTO() {}

    // Constructor completo (actualizado para usar String en reviewDate)
    public ReviewDTO(
        int reviewId,
        String userId,
        String productId,
        int rating,
        String comment,
        LocalDateTime reviewDate // <-- cambiado aquí también
    ) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.productId = productId;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    // Getters
    public int getReviewId() {
        return reviewId;
    }

    public String getUserId() {
        return userId;
    }

    public String getProductId() {
        return productId;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getReviewDate() { // <-- actualizado a String
        return reviewDate;
    }
}
