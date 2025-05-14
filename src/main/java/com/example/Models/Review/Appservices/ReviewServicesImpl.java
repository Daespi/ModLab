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

import com.example.sharedkernel.appservices.serializers.Serializer;
import com.example.sharedkernel.appservices.serializers.Serializers;
import com.example.sharedkernel.appservices.serializers.SerializersCatalog;


@Service
public class ReviewServicesImpl implements ReviewServices {

    @Autowired
    private ReviewRepository reviewRepository;

    private final Serializer<ReviewDTO> serializer = SerializersCatalog.getInstance(Serializers.REVIEW_JSON);

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

    protected ReviewDTO newReview(String json) throws ServiceException {
        ReviewDTO dto = this.checkInputData(json);
        return reviewRepository.save(dto);
    }

    protected ReviewDTO updateReview(int reviewId, String json) throws ServiceException {
        this.getById(reviewId);
        ReviewDTO dto = this.checkInputData(json);
        return reviewRepository.save(new ReviewDTO(
            reviewId,
            dto.getUserId(),
            dto.getRating(),
            dto.getComment(),
            dto.getReviewDate()
        ));
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
        return serializer.serialize(this.newReview(reviewJson));
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

