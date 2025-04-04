package com.example.Models.Review.Persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.Models.Review.DTO.ReviewDTO;


@Repository
public class ReviewRepository {
    public Optional<ReviewDTO> findById(int reviewId);

    public List<ReviewDTO> findByComment(String comment);

    public List<ReviewDTO> findByPartialComment(String comment);

    public Integer countByPartialComment(String title);

    public ReviewDTO save(ReviewDTO review);

    public void deleteById(int reviewId);

}
