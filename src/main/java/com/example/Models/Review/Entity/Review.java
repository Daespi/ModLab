package com.example.Models.Review.Entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.Exceptions.BuildException;
import com.example.Operations.Checker;

public class Review {

    protected int reviewId;
    protected String productId;  // agregar
    protected String userId;     // agregar
    protected int rating;
    protected String comment;
    protected LocalDateTime reviewDate;

    public Review() {
        this.reviewDate = LocalDateTime.now();
    }

    public static Review getInstance(int rating, String comment, LocalDateTime reviewDate, String productId, String userId) throws BuildException {
        String message = "";
        Review r = new Review();

        r.productId = productId;
        r.userId = userId;

        int resultRating = r.setRating(rating);
        if (resultRating != 0) {
            message += "El valor de rating es erróneo porque " + Checker.getErrorMessage(resultRating, 0, 0);
        }

        int resultComment = r.setComment(comment);
        if (resultComment != 0) {
            message += "El comentario no cumple con los requisitos porque " + Checker.getErrorMessage(resultComment, 1, 200);
        }

        if (!message.isEmpty()) {
            throw new BuildException(message);
        }

        r.reviewDate = reviewDate != null ? reviewDate : LocalDateTime.now();
        return r;
    }

    // getters y setters para productId y userId
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // resto igual...

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
        return reviewDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    public LocalDateTime getReviewDateAsLocalDateTime() {
        return reviewDate;
    }

    public int setRating(int rating) {
        if (Checker.maxValue(rating, 5) != 0) {
            return -5;
        }
        if (Checker.minValue(rating, 1) != 0) {
            return -7;
        }
        this.rating = rating;
        return 0;
    }

    public int setComment(String comment) {
        if (Checker.isNull(comment) != 0) {
            return -1;
        }
        if (Checker.minLength(1, comment) != 0) {
            return -2;
        }
        if (Checker.maxLenght(200, comment) != 0) {
            return -10;
        }
        this.comment = comment;
        return 0;
    }

    @Override
    public String toString() {
        return "Review [reviewId=" + getReviewId() + ", productId=" + getProductId() + ", userId=" + getUserId() + 
               ", rating=" + getRating() + ", comment=" + getComment() + ", reviewDate=" + getReviewDate() + "]";
    }
}
