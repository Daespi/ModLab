package com.example.Models.Review.Appservices;


import com.example.Exceptions.ServiceException;
import com.example.Models.Review.DTO.ReviewDTO;
import java.util.List;


public interface ReviewServices {

    String getByIdToJson(int reviewId) throws ServiceException;

    List<ReviewDTO> getByProductId(String productId) throws ServiceException;

    String getByUserIdToJson(String userId) throws ServiceException;

    String addFromJson(String reviewJson) throws ServiceException;

    String updateOneFromJson(int reviewId, String reviewJson) throws ServiceException;

    void deleteById(int reviewId) throws ServiceException;
}
