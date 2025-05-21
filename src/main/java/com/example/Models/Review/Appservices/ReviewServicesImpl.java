package com.example.Models.Review.Appservices;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.Exceptions.BuildException;
import com.example.Exceptions.ServiceException;
import com.example.Models.Review.DTO.ReviewDTO;
import com.example.Models.Review.Entity.Review;
import com.example.Models.Review.MAPPERS.ReviewMapper;
import com.example.Models.Review.Persistence.ReviewRepository;
import com.example.Models.User.DTO.UserDTO;
import com.example.Models.User.Entity.User;
import com.example.Models.User.MAPPER.UserMapper;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.example.sharedkernel.appservices.serializers.Serializer;
import com.example.sharedkernel.appservices.serializers.Serializers;
import com.example.sharedkernel.appservices.serializers.SerializersCatalog;


@Service
public class ReviewServicesImpl implements ReviewServices {

    @Autowired
    private ReviewRepository reviewRepository;

    private final Serializer<ReviewDTO> serializer = SerializersCatalog.getInstance(Serializers.REVIEW_JSON);
    private final ObjectMapper objectMapper = new ObjectMapper();

    protected ReviewDTO getDTO(int reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    protected ReviewDTO getById(int reviewId) throws ServiceException {
        ReviewDTO dto = this.getDTO(reviewId);
        if (dto == null) {
            throw new ServiceException("Review with ID " + reviewId + " not found");
        }
        return dto;
    }

    protected ReviewDTO checkInputData(String json) throws ServiceException {
        try {
            ReviewDTO dto = this.serializer.deserialize(json, ReviewDTO.class);
            ReviewMapper.reviewFromDTO(dto); // Validación lógica
            return dto;
        } catch (BuildException e) {
            throw new ServiceException("Invalid review data: " + e.getMessage());
        }
    }

    protected ReviewDTO newReview(String json) throws ServiceException, BuildException {
        ReviewDTO dto = this.checkInputData(json);
        Review review = ReviewMapper.reviewFromDTO(dto);
        ReviewDTO reviewDTO = ReviewMapper.dtoFromReview(review);
        return reviewRepository.save(reviewDTO);
    }

    protected ReviewDTO updateReview(int reviewId, String json) throws ServiceException {
        this.getById(reviewId); // Verifica que existe
        ReviewDTO dto = this.checkInputData(json);
    
        return reviewRepository.save(new ReviewDTO(
            reviewId,
            dto.getUserId(),
            dto.getProductId(),  // ← FALTA ESTE CAMPO
            dto.getRating(),
            dto.getComment()
            ));
    }
    

    @Override
    public List<ReviewDTO> getByProductId(String productId) throws ServiceException {
        try {
            return reviewRepository.findByProductId(productId);
        } catch (Exception e) {
            throw new ServiceException("Error obteniendo reviews desde base de datos.");
        }
    }


    @Override
    public String getByIdToJson(int reviewId) throws ServiceException {
        return serializer.serialize(this.getById(reviewId));
    }

    @Override
    public String getByUserIdToJson(String userId) throws ServiceException {
        List<ReviewDTO> reviews = reviewRepository.findByUserId(userId);
        return serializer.serializeList(reviews);
    }

    @Override
    public String addFromJson(String reviewJson) throws ServiceException {
        try {
            return serializer.serialize(this.newReview(reviewJson));
        } catch (BuildException e) {
            throw new ServiceException("Invalid review data: " + e.getMessage());
        }
        
    }

    @Override
    public String updateOneFromJson(int reviewId, String reviewJson) throws ServiceException {
        return serializer.serialize(this.updateReview(reviewId, reviewJson));
    }

    @Override
    public void deleteById(int reviewId) throws ServiceException {
        this.getById(reviewId); // Lanza excepción si no existe
        reviewRepository.deleteById(reviewId);
    }
} 