package com.example.Models.Review.Persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Models.Review.DTO.ReviewDTO;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewDTO, Integer> {

    // Encuentra una reseña por ID
    Optional<ReviewDTO> findByReviewId(int reviewId);


    List<ReviewDTO> findByProductId(String productId);

    // Encuentra todas las reseñas hechas por un usuario
    List<ReviewDTO> findByUserId(String userId);

    // Cuenta las reseñas con cierto texto en el comentario
    Integer countByCommentContaining(String text);

    // Filtra por comentarios que contengan ciertas palabras
    List<ReviewDTO> findByCommentContaining(String text);
}
