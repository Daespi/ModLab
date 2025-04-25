package com.example.Models.Review.Entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.Exceptions.BuildException;
import com.example.Operations.Checker;

public class Review {

    protected int reviewId, rating;
    protected String comment;
    protected LocalDateTime reviewDate = LocalDateTime.now();


    public Review(){};


    public static Review getInstance(int rating, String comment) throws BuildException{


        String message = "";
        Review r = new Review();

        int resultRating = r.setRating(rating);
        if (resultRating != 0) {
            message += "El valor de rating es erroneo porque " + Checker.getErrorMessage(resultRating, 0, 0);
        }

        int resultComment = r.setComment(comment);
        if (resultComment != 0) {
            message += "El comentario no cumple con los requisitos porque " + Checker.getErrorMessage(resultComment, 1, 200);
        }

        if (message.length() < 0) {
            r = null;
            throw new BuildException(message);
        }
        
        return r;


    };

    public int getReviewId(){
        return reviewId;
    };

    public int getRating(){
        return rating;
    }

    public String getComment(){
        return comment;
    }

    public String getReviewDate() {
        return reviewDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    public int setRating(int rating){
        if (Checker.maxValue(rating, 5) != 0) {
            return -5;
        }
        if(Checker.minValue(rating, 1) !=0){
            return -7;
        }
        this.rating = rating;
        return 0;
    }

    public int setComment(String comment){
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
        return "Review [getReviewId()=" + getReviewId() + ", getRating()=" + getRating() + ", getComment()="
                + getComment() + ", getReviewDate()=" + getReviewDate() + "]";
    }
}
