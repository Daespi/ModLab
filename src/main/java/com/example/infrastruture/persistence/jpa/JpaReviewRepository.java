package com.example.infrastruture.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Models.Review.DTO.ReviewDTO;
import com.example.Models.Review.Persistence.ReviewRepository;

import jakarta.transaction.Transactional;

@Repository
public interface JpaReviewRepository extends JpaRepository<ReviewDTO, Integer>, ReviewRepository {

    Optional<ReviewDTO> findByReviewId(int reviewId);

    List<ReviewDTO> findByProductId(String productId);

    List<ReviewDTO> findByUserId(String userId);

    @Query("SELECT r FROM ReviewDTO r WHERE r.comment LIKE %:text%")
    List<ReviewDTO> findByCommentContaining(String text);

    @Query("SELECT count(r) FROM ReviewDTO r WHERE r.comment LIKE %:text%")
    Integer countByCommentContaining(String text);

    @Transactional
    ReviewDTO save(ReviewDTO review);

    @Transactional
    void deleteById(int reviewId);
}